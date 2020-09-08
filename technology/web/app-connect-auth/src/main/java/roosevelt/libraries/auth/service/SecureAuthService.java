package roosevelt.libraries.auth.service;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpHeaders;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
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

import com.fasterxml.jackson.databind.ObjectMapper;

import roosevelt.libraries.auth.model.AccessToken;
import roosevelt.libraries.auth.util.AuthUtilException;

public class SecureAuthService implements IAuthService{

	private String secureAuthURI;
	private String secureAuthScope;
	private String clientId;
	private String clientSecret;

	public SecureAuthService(Map<String, Object> secureAuthData) {
		this.secureAuthScope = (String) secureAuthData.get(SCOPE_KEY);
		this.clientId = (String) secureAuthData.get(CLIENT_ID_KEY);
		this.clientSecret = (String) secureAuthData.get(CLIENT_SECRET_KEY);
		this.secureAuthURI = (String) secureAuthData.get("SECURE_AUTH_URI");
	}
	
	public AccessToken generateAccessToken() throws KeyManagementException, ClientProtocolException,
			NoSuchAlgorithmException, KeyStoreException, IOException {

		final HttpUriRequest requestForAccessToken = buildPostRequest();

		try (final CloseableHttpResponse response = createHttpClient().execute(requestForAccessToken)) {

			final Map<String, String> responseMap = new ObjectMapper()
					.readValue(EntityUtils.toString(response.getEntity()), Map.class);

			EntityUtils.consumeQuietly(response.getEntity());

			if (response.getStatusLine().getStatusCode() == 200) {

				final long expiresAfterSeconds = Long.valueOf(responseMap.get("expires_in"));

				long accessTokenExpiresAt = System.currentTimeMillis() + (expiresAfterSeconds * 1000);

				String access_Token = responseMap.get("access_token");

				// LOGGER.info("Generated access token will expire at " + accessTokenExpiresAt);
				return new AccessToken(access_Token, accessTokenExpiresAt);
			}
			// this.vaultData.clear();
			throw new RuntimeException("Unable to retrieve Access Token" + ", request: " + requestForAccessToken
					+ ", response: " + responseMap);
		}

	}

	private HttpPost buildPostRequest() throws AuthUtilException, IOException {
		final HttpPost httpPost = new HttpPost(this.secureAuthURI);
		final List<NameValuePair> parameters = new ArrayList<NameValuePair>();
		parameters.add(new BasicNameValuePair("grant_type", "client_credentials"));
		parameters.add(new BasicNameValuePair("scope", this.secureAuthScope));
		parameters.add(new BasicNameValuePair("client_id", this.clientId));
		parameters.add(new BasicNameValuePair("client_secret", this.clientSecret));
		httpPost.setHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_FORM_URLENCODED.getMimeType());
		httpPost.setEntity(new UrlEncodedFormEntity(parameters));
		return httpPost;
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

	public static void main(String[] args) {
	}
}