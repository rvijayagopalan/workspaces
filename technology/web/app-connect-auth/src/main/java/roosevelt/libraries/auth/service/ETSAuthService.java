package roosevelt.libraries.auth.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import roosevelt.libraries.auth.util.KeyNotFoundException;

public class ETSAuthService extends AbstractAuthService {

	private Logger logger = Logger.getLogger(ETSAuthService.class);	
	
	private static ETSAuthService accessTokenUtil = new ETSAuthService();
	
	private AuthServiceVaultClient authServiceVaultClient;
		
	public static ETSAuthService getInstance(Logger logger) {
		
		synchronized(accessTokenUtil) {
			if(null == accessTokenUtil) {
				accessTokenUtil = new ETSAuthService();
				accessTokenUtil.setLogger(logger);
			}		
		}
		
		return accessTokenUtil;
	}
	
	public String getAccessToken(String vaultPathClientId, String vaultPathForClientSecret, String scope, String secureAuthURL) { 
		return getAccessToken(getAuthData(vaultPathClientId));
	}
	
	private Map<String, Object> getAuthData(String VAULT_PATH_CLIENT_ID) {
		Map<String, Object> authDataMap = new HashMap<>();
		
		authDataMap.put(APP_KEY, VAULT_PATH_CLIENT_ID);
		
		try {
			authServiceVaultClient = new AuthServiceVaultClient();
		} catch (KeyNotFoundException | IOException e) {
			e.printStackTrace();
		}
		
		authDataMap.put(CLIENT_ID_KEY, null);
		authDataMap.put(CLIENT_SECRET_KEY, null);
		
		authDataMap.put(TOKEN_ENDPOINT_URI_KEY, null);
		authDataMap.put(SCOPE_KEY, null);
		
		return authDataMap;
	}
	
	private void setLogger(Logger logger) {
		if (null != logger) {
			this.logger = logger;
		}
	}	
	
	public void log(String message) {
		logger.info("Logging from Auth Access Token !!!  " + " -> " + message);
	}

	public void log(String message, Exception e) {
		logger.info("Logging from Auth Access Token !!!  " + " -> " + message, e);
	}
}