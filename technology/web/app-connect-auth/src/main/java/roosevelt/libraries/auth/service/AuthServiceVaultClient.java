package roosevelt.libraries.auth.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import roosevelt.libraries.auth.util.KeyNotFoundException;
import roosevelt.libraries.auth.util.SmsApplicationException;
import roosevelt.libraries.vault.IVaultService;
import roosevelt.libraries.vault.RooseveltVaultService;
import roosevelt.libraries.vault.model.RooseveltAppRoleResponse;

public class AuthServiceVaultClient {	
	
	private IVaultService vaultService;
	
	private Map<String, Object> vaultData = new HashMap<String, Object>();
	
	public AuthServiceVaultClient() throws KeyNotFoundException, IOException {
		
		if (isVaultEnabled()) {
			this.vaultService = this.initializeVaultService();
			this.vaultData = initializeVaultData();
			
			//this.clientId = String.valueOf(this.vaultData.get(CLIENT_ID_KEY));
			//this.clientSecret = String.valueOf(this.vaultData.get(CLIENT_SECRET_KEY));
			
			//this.secureAuthUri = readFromConfigFile(SECUREAUTH_SECTION, TOKEN_ENDPOINT_URI_KEY, "SecureAuth URL ");
			//this.secureAuthScope = readFromConfigFile(SECUREAUTH_SECTION, SCOPE_KEY, "SecureAuth Scope ");
		}		
	}
	
	private final IVaultService initializeVaultService() throws KeyNotFoundException, IOException {
		//final String host = readFromConfigFile(VAULT_SECTION, VAULT_DOMAIN_KEY, "Vault Host ");
		///final Integer port = Integer.parseInt(readFromConfigFile(VAULT_SECTION, VAULT_PORT_KEY, "Vault Port "));
		// final String vaultDomain = readFromConfigFile(VAULT_SECTION,
		// VAULT_DOMAIN_KEY, "Vault Domain ");
		//final String roleId = readFromFile(VAULT_SECTION, ROLE_ID_FILE_KEY, "Role Id Location ");
		//final String secretId = readFromFile(VAULT_SECTION, SECRET_ID_FILE_KEY, "Secret Id Location ");
		//return new RooseveltVaultService(roleId, secretId, host, port);
		return null;

	}
	
	private final Map<String, Object> initializeVaultData() throws KeyNotFoundException {
		//final String vaultPath = readFromConfigFile(VAULT_SECTION, VAULT_PATH_KEY, "");
		//final RooseveltAppRoleResponse vaultResponse = this.vaultService.read(vaultPath);
		//if (vaultResponse.hasError()) {
		//	this.vaultService = null;
		//	throw new SmsApplicationException(
		//			"Vault Error for path " + VAULT_SECTION + VAULT_PATH_KEY + " : " + vaultResponse.getErrorMessage());
		//}

		//return vaultResponse.getData();
		return new HashMap<String, Object>();
	}
	
	public static final boolean isVaultEnabled() {
		//try {
			//return !"local".equalsIgnoreCase(readFromConfigFile(VAULT_SECTION, VAULT_DOMAIN_KEY, "Vault Domain "));
		//} catch (final KeyNotFoundException e) {
			// LOGGER.warn("Vault domain not configured", e);
		//	return false;
		//}
		return false;
	}
}