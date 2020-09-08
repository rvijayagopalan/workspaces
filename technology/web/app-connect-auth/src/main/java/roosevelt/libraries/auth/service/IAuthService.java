package roosevelt.libraries.auth.service;

public interface IAuthService {
	
	String APP_KEY = "appKey";
	String VAULT_SECTION = "Vault";
	String VAULT_HOST_KEY = "VAULT_HOST";
	String VAULT_PORT_KEY = "VAULT_PORT";
	String VAULT_DOMAIN_KEY = "VAULT_DOMAIN";
	String VAULT_PATH_KEY = "VAULT_PATH";
	String ROLE_ID_FILE_KEY = "ROLE_ID_FILE";
	String SECRET_ID_FILE_KEY = "SECRET_ID_FILE";
	String CLIENT_ID_KEY = "client_id";
	String CLIENT_SECRET_KEY = "client_secret";

	String SECUREAUTH_SECTION = "SecureAuth";
	String TOKEN_ENDPOINT_URI_KEY = "SECURE_AUTH_ENDPOINT_URI";
	String SCOPE_KEY = "SECURE_AUTH_SCOPE";
	
	/*
	 * As of September 2019, this URL returns access_token for DDMN_IVR_USER scope (Client Credential flow)
	 * and should only be used for Local development where Vault is not available.
	 */
	String GET_SWAGGER_ACCESS_TOKEN =
			//"https://cmorsapitrv7302.ddmi.intra.renhsc.com:8443/oidc-api-gateway/accesstoken/clientcred/DDMN_IVR_USER";
			"https://internal.test.nonprd.local-os/oidc-api-gateway/accesstoken/clientcred/DDMN_IVR_USER";
}