package com.spring.social.springSocial.model;

public class UserInfo {
	private String firstName;
	private String lastName;
	private String emailid;
	private String imageUrl;
	
	public UserInfo() {
		
	}
	public UserInfo(String firstName, String lastName, String emailid, String imageUrl) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailid = emailid;
		this.imageUrl = imageUrl;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
}
