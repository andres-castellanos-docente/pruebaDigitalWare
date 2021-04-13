package co.prueba.digitalware.springboot.responses;

public class AuthResponse extends ResponseGeneral {
	private String type = "Bearer";
	private String token;
	private String username;

	public AuthResponse(String accessToken, String username) {
		this.token = accessToken;
		this.username = username;
	}

	public AuthResponse(String accessToken, String username, Integer responseCode) {
		this.token = accessToken;
		this.username = username;
		setResponseCode(responseCode);
	}

	public AuthResponse(String accessToken, String username,  Integer responseCode, String responseDescription) {
		this.token = accessToken;
		this.username = username;
		setResponseCode(responseCode);
		setResponseDescription(responseDescription);
	}

	public AuthResponse(String accessToken, String username, Integer responseCode, String responseDescription, Integer status) {
		this.token = accessToken;
		this.username = username;
		setResponseCode(responseCode);
		setResponseDescription(responseDescription);
		setStatus(status);
	}

	public String getTokenType() {
		return type;
	}

	public void setTokenType(String tokenType) {
		this.type = tokenType;
	}

	public String getAccessToken() {
		return token;
	}

	public void setAccessToken(String accessToken) {
		this.token = accessToken;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
