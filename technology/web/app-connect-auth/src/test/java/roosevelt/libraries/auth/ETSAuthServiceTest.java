package roosevelt.libraries.auth;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import roosevelt.libraries.auth.service.ETSAuthService;

public class ETSAuthServiceTest {
	
	ETSAuthService authService = null;
	
	@Before
	public void setUp() {
		System.out.println("SetUp");
		
		authService = ETSAuthService.getInstance(null);
	}
	
	@After
	public void cleanUp() {
		System.out.println("CleanUp");
	}

	public void testGetAccessToken() {
		System.out.println("Start ETS Access Token");
		
		authService.getAccessToken("AppKey1", "SecretKey", "VaultDomain", null);
		
		authService.getAccessToken("AppKey2", "SecretKey", "VaultDomain", null);
		
		try {
			Thread.sleep(5000L);
			System.out.println(authService.getAccessToken("AppKey1", "SecretKey", "VaultDomain", null));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		try {
			Thread.sleep(6000L);
			System.out.println(authService.getAccessToken("AppKey1", "SecretKey", "VaultDomain", null));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		authService.getAccessToken("AppKey2", "SecretKey", "VaultDomain", null);
	}
}