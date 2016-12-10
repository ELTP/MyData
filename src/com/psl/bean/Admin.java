package com.psl.bean;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.sun.istack.internal.NotNull;

@Component(value="admin")
public class Admin {
	@NotEmpty
	private String username;
	
	@NotEmpty
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
