package roosevelt.libraries.auth.service;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import roosevelt.libraries.auth.model.AccessToken;
import roosevelt.libraries.auth.util.AuthUtilException;

public class SwaggerAuthService implements IAuthService {
	
	public SwaggerAuthService() {
		
	}
	
	@SuppressWarnings("unchecked")
	public AccessToken generateAccessToken()
			throws AuthUtilException, IOException, JsonParseException, JsonMappingException, ClientProtocolException,
			NoSuchAlgorithmException, KeyManagementException, KeyStoreException {
		
		final HttpUriRequest requestForAccessToken = new HttpGet(GET_SWAGGER_ACCESS_TOKEN);
		
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
			//this.vaultData.clear();
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

}
