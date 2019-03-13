package com.linkedin.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Email {
	private String handle;
	@JsonProperty(value="handle~")
	HandleDup Object;
	
	public String getHandle() {
		return handle;
	}
	public void setHandle(String handle) {
		this.handle = handle;
	}
	public HandleDup getObject() {
		return Object;
	}
	public void setObject(HandleDup object) {
		Object = object;
	}

}
