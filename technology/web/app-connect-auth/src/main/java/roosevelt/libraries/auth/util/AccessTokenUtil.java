package roosevelt.libraries.auth.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpHeaders;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import roosevelt.libraries.auth.model.AccessToken;
import roosevelt.libraries.auth.service.IAuthService;
import roosevelt.libraries.vault.IVaultService;
import roosevelt.libraries.vault.RooseveltVaultService;
import roosevelt.libraries.vault.model.RooseveltAppRoleResponse;

public class AccessTokenUtil implements IAuthService {
	
	private Map<String, String> accessTokenMap = new ConcurrentHashMap<>();

	private AccessToken accessToken = null;
	private long accessTokenExpiresAt = -1L;
	private IVaultService vaultService;
	private Map<String, Object> vaultData = new HashMap<String, Object>();
	private boolean vaultEnabled;

	private String secureAuthUri;
	private String secureAuthScope;
	private String clientId;
	private String clientSecret;

	public AccessTokenUtil(String roleId, String secretId, String vaultDomain) throws KeyNotFoundException, IOException {
		this.clientId = "8744ea6aae59435faef2b32bec4c68b4";
		if (this.isVaultEnabled()) {
			this.vaultEnabled = true;
			this.vaultService = this.initializeVaultService();
			this.vaultData = initializeVaultData();
			
			this.clientId = String.valueOf(this.vaultData.get(CLIENT_ID_KEY));
			this.clientSecret = String.valueOf(this.vaultData.get(CLIENT_SECRET_KEY));
			
			this.secureAuthUri = readFromConfigFile(SECUREAUTH_SECTION, TOKEN_ENDPOINT_URI_KEY, "SecureAuth URL ");
			this.secureAuthScope = readFromConfigFile(SECUREAUTH_SECTION, SCOPE_KEY, "SecureAuth Scope ");
		}
	}

	public AccessToken getAccessToken() throws Exception {
		if (accessToken == null || System.currentTimeMillis() > accessTokenExpiresAt) {
			accessToken = generateAccessToken();
		}
		return accessToken;
	}

	@SuppressWarnings("unchecked")
	private AccessToken generateAccessToken()
			throws AuthUtilException, IOException, JsonParseException, JsonMappingException, ClientProtocolException,
			NoSuchAlgorithmException, KeyManagementException, KeyStoreException {
		
		final HttpUriRequest requestForAccessToken = this.vaultEnabled ? buildPostRequest()
				: new HttpGet(GET_SWAGGER_ACCESS_TOKEN);
		
		try (final CloseableHttpResponse response = createHttpClient().execute(requestForAccessToken)) {
			
			final Map<String, String> responseMap = new ObjectMapper()
					.readValue(EntityUtils.toString(response.getEntity()), Map.class);
			
			EntityUtils.consumeQuietly(response.getEntity());
			
			if (response.getStatusLine().getStatusCode() == 200) {
				
				final long expiresAfterSeconds = Long.valueOf(responseMap.get("expires_in"));
				
				accessTokenExpiresAt = System.currentTimeMillis() + (expiresAfterSeconds * 1000);
				
				String access_Token = responseMap.get("access_token");
				
				// LOGGER.info("Generated access token will expire at " + accessTokenExpiresAt);
				return new AccessToken(access_Token, accessTokenExpiresAt);
			}
			this.vaultData.clear();
			throw new RuntimeException("Unable to retrieve Access Token" + ", request: " + requestForAccessToken
					+ ", response: " + responseMap);
		}
	}

	private CloseableHttpClient createHttpClient()
			throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException {
		final TrustStrategy acceptingTrustStrategy = new TrustStrategy() {
			@Override
			public boolean isTrusted(final X509Certificate[] chain, final String authType) throws CertificateException {
				return true;
			}
		};
		return HttpClientBuilder.create()
				.setSSLContext(new SSLContextBuilder().loadTrustMaterial(null, acceptingTrustStrategy).build())
				.setSSLHostnameVerifier(new NoopHostnameVerifier()).build();
	}

	private final boolean isVaultEnabled() {
		try {
			return !"local".equalsIgnoreCase(readFromConfigFile(VAULT_SECTION, VAULT_DOMAIN_KEY, "Vault Domain "));
		} catch (final KeyNotFoundException e) {
			// LOGGER.warn("Vault domain not configured", e);
			return false;
		}
	}

	public String getCsrfToken(final String csrfTokenUrl) throws KeyManagementException, ClientProtocolException,
			NoSuchAlgorithmException, KeyStoreException, IOException, AuthUtilException {
		// LOGGER.debug("Fetching CSRF token from " + csrfTokenUrl);
		try (final CloseableHttpResponse response = createHttpClient().execute(new HttpGet(csrfTokenUrl))) {
			if (response.getStatusLine().getStatusCode() == 200) {
				return EntityUtils.toString(response.getEntity());
			}
			throw new RuntimeException("Unable to retrieve CSRF Token");
		}
	}

	private final IVaultService initializeVaultService() throws KeyNotFoundException, IOException {
		final String host = readFromConfigFile(VAULT_SECTION, VAULT_DOMAIN_KEY, "Vault Host ");
		final Integer port = Integer.parseInt(readFromConfigFile(VAULT_SECTION, VAULT_PORT_KEY, "Vault Port "));
		// final String vaultDomain = readFromConfigFile(VAULT_SECTION,
		// VAULT_DOMAIN_KEY, "Vault Domain ");
		final String roleId = readFromFile(VAULT_SECTION, ROLE_ID_FILE_KEY, "Role Id Location ");
		final String secretId = readFromFile(VAULT_SECTION, SECRET_ID_FILE_KEY, "Secret Id Location ");
		return new RooseveltVaultService(roleId, secretId, host, port);

	}

	private HttpPost buildPostRequest() throws AuthUtilException, IOException {
		final HttpPost httpPost = new HttpPost(this.secureAuthUri);
		final List<NameValuePair> parameters = new ArrayList<NameValuePair>();
		parameters.add(new BasicNameValuePair("grant_type", "client_credentials"));
		parameters.add(new BasicNameValuePair("scope", this.secureAuthScope));
		parameters.add(new BasicNameValuePair("client_id", this.clientId));
		parameters.add(new BasicNameValuePair("client_secret", this.clientSecret));
		httpPost.setHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_FORM_URLENCODED.getMimeType());
		httpPost.setEntity(new UrlEncodedFormEntity(parameters));
		return httpPost;
	}

	private String readFromConfigFile(final String section, final String key, final String fieldName)
			throws KeyNotFoundException {
		final String value = "";//ConfigFacility.getConfigFacility().getValue(section, key);  **************************
		// LOGGER.debug(section + key + " : " + StringUtils.isNotBlank(value));
		if (StringUtils.isEmpty(value)) {
			throw new KeyNotFoundException(fieldName + " is null or blank");
		}
		return value;
	}

	private final Map<String, Object> initializeVaultData() throws KeyNotFoundException {
		final String vaultPath = readFromConfigFile(VAULT_SECTION, VAULT_PATH_KEY, "");
		final RooseveltAppRoleResponse vaultResponse = this.vaultService.read(vaultPath);
		if (vaultResponse.hasError()) {
			this.vaultService = null;
			throw new SmsApplicationException(
					"Vault Error for path " + VAULT_SECTION + VAULT_PATH_KEY + " : " + vaultResponse.getErrorMessage());
		}

		return vaultResponse.getData();
	}

	private String readFromFile(final String section, final String key, final String fieldName)
			throws IOException, KeyNotFoundException {
		final String filePath = readFromConfigFile(section, key, fieldName);
		if (!FileUtilities.doesFileExist(filePath)) {
			throw new SmsApplicationException("File path does not exist " + section + key);
		}
		try (final BufferedReader reader = new BufferedReader(new FileReader(new File(filePath)))) {
			return StringUtils.trimToEmpty(reader.readLine());
		}
	}

	public String getClientId() {
		return this.clientId;
	}
}
