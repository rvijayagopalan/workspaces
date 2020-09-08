package roosevelt.libraries.auth;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import roosevelt.libraries.auth.service.RooseveltAuthService;

public class RooseveltAuthServiceTest {

	private RooseveltAuthService authService = null;
	
	@Before
	public void setUp() {
		System.out.println("SetUp");		
		authService = RooseveltAuthService.getInstance(null);
	}
	
	@After
	public void cleanUp() {
		authService = null;
		System.out.println("CleanUp");		
	}

	@Test
	public void testGetAccessToken() {
		System.out.println("Start Roosevelt Access Token");
		
		authService.getAccessToken("AppKey1", "SecretKey", "VaultDomain", null);
		
		authService.getAccessToken("AppKey2", "SecretKey", "VaultDomain", null);
		
		try {
			Thread.sleep(5000L);
			authService.getAccessToken("AppKey1", "SecretKey", "VaultDomain", null);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		try {
			Thread.sleep(6000L);
			authService.getAccessToken("AppKey1", "SecretKey", "VaultDomain", null);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		authService.getAccessToken("AppKey2", "SecretKey", "VaultDomain", null);
	}
}