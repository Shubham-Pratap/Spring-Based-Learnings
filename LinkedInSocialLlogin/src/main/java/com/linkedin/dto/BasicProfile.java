package com.linkedin.dto;

public class BasicProfile {
	LastName LastNameObject;
	FirstName FirstNameObject;
	ProfilePicture ProfilePictureObject;
	private String id;

	// Getter Methods

	public LastName getLastName() {
		return LastNameObject;
	}

	public FirstName getFirstName() {
		return FirstNameObject;
	}

	public ProfilePicture getProfilePicture() {
		return ProfilePictureObject;
	}

	public String getId() {
		return id;
	}

	// Setter Methods

	public void setLastName(LastName lastNameObject) {
		this.LastNameObject = lastNameObject;
	}

	public void setFirstName(FirstName firstNameObject) {
		this.FirstNameObject = firstNameObject;
	}

	public void setProfilePicture(ProfilePicture profilePictureObject) {
		this.ProfilePictureObject = profilePictureObject;
	}

	public void setId(String id) {
		this.id = id;
	}
}
