package com.linkedin.controllers;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.linkedin.dto.BasicProfile;
import com.linkedin.dto.Email;
import com.linkedin.dto.EmailProfile;
import com.linkedin.dto.User;
import com.linkedin.dto.linkedInToken;

@RestController
public class LinkedInController {

	@RequestMapping(value = "/getURl", method = RequestMethod.GET)
	public String GetUrl() {
		return "https://www.linkedin.com/oauth/v2/authorization?response_type=code&client_id=81fvrfdbgy9yyn&redirect_uri=https://dev.wideroe.no&scope=r_liteprofile,r_emailaddress";
	}

	@RequestMapping(value = "/getAccessToken", method = RequestMethod.GET)
	public User GetAccessToken() {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("grant_type", "authorization_code");
		map.add("code",
				"AQQVmNbG0cqAsGkclqE1k0fX-VA5mI3dT9BbY98UaeQdrMuye8isZC2JGbFo_sFAfTpo5ZUO2ktm2MKPdM5HyJSuFXehplWiP34X8pfylIvsLEXGTFhsp_7cDWQMJAJjTCHoeYnZIZO9FfS0UjmtYpdB9kvlX-zkJpAKFTk5fP5tA0b76CGE31hjvznjbQ");
		map.add("redirect_uri", "https://dev.wideroe.no");
		map.add("client_id", "81fvrfdbgy9yyn");
		map.add("client_secret", "eUIz8op4KAtaJ4vK");
		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
		ResponseEntity<linkedInToken> response = restTemplate
				.postForEntity("https://www.linkedin.com/oauth/v2/accessToken", request, linkedInToken.class);
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("https://api.linkedin.com/v2/me")
				.queryParam("oauth2_access_token", response.getBody().getAccess_token());
		HttpEntity<BasicProfile> response1 = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null,BasicProfile.class);
		
		builder = UriComponentsBuilder.fromHttpUrl("https://api.linkedin.com/v2/emailAddress")
				.queryParam("oauth2_access_token", response.getBody().getAccess_token())
				.queryParam("q", "members")
				.queryParam("projection", "(elements*(handle~))");
		HttpEntity<EmailProfile> response2 = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null,EmailProfile.class);
		User user = new User();
		user.setFirstname(response1.getBody().getFirstName().getLocalized().getEn_US());
		user.setLastname(response1.getBody().getLastName().getLocalized().getEn_US());
		user.setEmail(response2.getBody().getElements().get(0).getObject().getEmailAddress());
		return user;
	}
}
