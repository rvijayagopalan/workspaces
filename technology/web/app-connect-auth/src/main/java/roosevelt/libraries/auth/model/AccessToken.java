package roosevelt.libraries.auth.model;

import java.util.Calendar;

public class AccessToken {

	private String accessToken;
	private Long accessTokenExpiry;

	public AccessToken(String accessToken, Long accessTokenExpiry) {
		this.accessToken = accessToken;
		this.accessTokenExpiry = accessTokenExpiry;
	}

	public boolean isExpired() {
		//System.out.println(accessTokenExpiry - System.currentTimeMillis());
		//System.out.println(System.currentTimeMillis());
		
		//return this.accessTokenExpiry - System.currentTimeMillis() < 60000 ? true : false;
		
		return this.accessTokenExpiry - System.currentTimeMillis() < (28799737 - 10000) ? true : false;		
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public Long getAccessTokenExpiry() {
		return accessTokenExpiry;
	}

	public void setAccessTokenExpiry(Long accessTokenExpiry) {
		this.accessTokenExpiry = accessTokenExpiry;
	}
}