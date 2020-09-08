package roosevelt.libraries.auth.service;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import roosevelt.libraries.auth.model.AccessToken;
import roosevelt.libraries.auth.util.AccessTokenUtil;
import roosevelt.libraries.auth.util.KeyNotFoundException;

public abstract class AbstractAuthService implements IAuthService {

	private Map<String, AccessToken> accessTokenMap = new ConcurrentHashMap<>();

	protected abstract void log(String message, Exception e);
	
	protected Map<String, AccessToken> getAccessTokenMap() {
		return accessTokenMap;
	}

	protected String getAccessToken(Map<String, Object> authData) {
		System.out.println("Token Map -> "+accessTokenMap);
		
		String appKey = (String)authData.get(APP_KEY);
		
		AccessToken accessToken = getAccessTokenMap().get(appKey);
		
		synchronized (appKey) {
			if (null == accessToken || accessToken.isExpired()) {
				//System.out.println("Token Expired or Not Available for "+ roleId);
				accessToken = retrieveAccessToken(authData);
				getAccessTokenMap().put(appKey, accessToken);
			}else {
				System.out.println("Token Available for "+ appKey);
			}
		}		
		
		System.out.println("Token Map -> "+accessTokenMap);

		return accessToken.getAccessToken();
	}

	private AccessToken retrieveAccessToken(Map<String, Object> authData) {
		AccessToken accessToken = null;

		try {			
			if(AuthServiceVaultClient.isVaultEnabled()) {
				accessToken = new SecureAuthService(authData).generateAccessToken();
			}else {
				System.out.println("getting token from Swagger");
				accessToken = new SwaggerAuthService().generateAccessToken();
			}
		} catch (IOException ioe) {
			log("Error Retrieving Access Token " + ioe.getMessage(), ioe);
		} catch (Exception e) {
			log("Error Retrieving Access Token " + e.getMessage(), e);
		}

		return accessToken;
	}
}