package com.spring.social.springSocial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.linkedin.api.LinkedInProfileFull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.spring.social.springSocial.model.UserInfo;
import com.spring.social.springSocial.services.LinkedInService;

@Controller
public class LinkedInController {

	@Autowired
	private LinkedInService linkedInService;
	
	@GetMapping(value="/linkedinlogin")
	public RedirectView linkedinlogin() {
		RedirectView redirectView = new RedirectView();
		String url = linkedInService.linkedinlogin();
		redirectView.setUrl(url);
		return redirectView;
	}
	
	@GetMapping(value="/linkedin")
	public String linkedin(@RequestParam("code") String code) {
		String accessToken = linkedInService.getLinkedInAccessToken(code);
		return "redirect:/linkedinprofiledata/"+accessToken;
	}
	
	@GetMapping(value = "/linkedinprofiledata/{accessToken:.+}")
	public String linkedinprofiledata(@PathVariable String accessToken, Model model) {
		LinkedInProfileFull user = linkedInService.getlinkedinUserProfile(accessToken);
		UserInfo userInfo = new UserInfo(user.getFirstName(),user.getLastName(),user.getEmailAddress(),user.getProfilePictureUrl());
		model.addAttribute("user", userInfo);
		return "view/userprofile";
	}
}
