package roosevelt.libraries.auth.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import roosevelt.libraries.auth.util.FileUtils;
import roosevelt.libraries.auth.util.KeyNotFoundException;

public class RooseveltAuthService extends AbstractAuthService {

	private Logger logger = LoggerFactory.getLogger(RooseveltAuthService.class);
	
	private static RooseveltAuthService accessTokenUtil = new RooseveltAuthService();
	
	private AuthServiceVaultClient authServiceVaultClient;
	
    private Properties properties = new Properties();
	
	public static RooseveltAuthService getInstance(Logger logger) {
		
		synchronized(accessTokenUtil) {
			if(null == accessTokenUtil) {
				accessTokenUtil = new RooseveltAuthService();
				accessTokenUtil.setLogger(logger);
			}		
		}
		
		return accessTokenUtil;
	}
	
	public String getAccessToken(String VAULT_PATH_CLIENT_ID, String VAULT_PATH_CLIENT_SECRET, String SCOPE) {
		return getAccessToken(getAuthData(VAULT_PATH_CLIENT_ID));
	}

	public String getAccessToken(String VAULT_PATH_CLIENT_ID, String VAULT_PATH_CLIENT_SECRET, String SCOPE, String secureAuthURI) {
		return getAccessToken(getAuthData(VAULT_PATH_CLIENT_ID));
	}
	
	private Map<String, Object> getAuthData(String VAULT_PATH_CLIENT_ID) {
		Map<String, Object> authDataMap = new HashMap<>();
		
		authDataMap.put(APP_KEY, VAULT_PATH_CLIENT_ID);
		
        this.properties.putAll(FileUtils.getInstance().readPropsFromPath("application-local.properties"));
        
        System.out.println(this.properties.keySet());
	
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

	public void log(String message, Exception e) {
		logger.trace("RooseveltAccessToken ", message, e);
		logger.debug("RooseveltAccessToken ", message, e);
		logger.info("RooseveltAccessToken ", message, e);
		logger.warn("RooseveltAccessToken ", message, e);
		logger.error("RooseveltAccessToken ", message, e);
	}
}