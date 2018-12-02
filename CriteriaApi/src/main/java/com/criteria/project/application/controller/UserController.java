package com.criteria.project.application.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.criteria.project.application.domain.SearchCriteria;
import com.criteria.project.application.entity.User;
import com.criteria.project.application.repository.IUserDAO;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private IUserDAO api;

	@RequestMapping(method = RequestMethod.GET, value = "/hello")
	public String sayHello() {
		return "Hello!";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/criteria")
	@ResponseBody
	public List<User> findAll(@RequestParam(value = "search", required = false) String search) {
		List<SearchCriteria> params = new ArrayList<SearchCriteria>();
		if (search != null) {
			Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?),");
			Matcher matcher = pattern.matcher(search + ",");
			while (matcher.find()) {
				params.add(new SearchCriteria(matcher.group(1), matcher.group(2), matcher.group(3)));
			}
		}
		return api.searchUser(params);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/save")
	public String saveEntity(@RequestBody User user) {
		api.save(user);
		return "Saved Successfully!";
	}
}

