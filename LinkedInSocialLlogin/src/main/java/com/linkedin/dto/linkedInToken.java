package com.linkedin.dto;

public class linkedInToken {
	private String access_token;
	private long expires_in;

	// Getter Methods

	public String getAccess_token() {
		return access_token;
	}

	public long getExpires_in() {
		return expires_in;
	}

	// Setter Methods

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public void setExpires_in(long expires_in) {
		this.expires_in = expires_in;
	}
}
