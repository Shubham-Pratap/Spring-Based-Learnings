package com.spring.social.springSocial.services;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.social.linkedin.api.LinkedInProfileFull;

public interface LinkedInService {

	String linkedinlogin();

	String getLinkedInAccessToken(String code);

	LinkedInProfileFull getlinkedinUserProfile(String accessToken);
	
}
