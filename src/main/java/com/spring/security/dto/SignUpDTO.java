package com.spring.security.dto;

public class SignUpDTO {

	private String username;

	private CharSequence password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public CharSequence getPassword() {
		return password;
	}

	public void setPassword(CharSequence password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "SignUpDTO [username=" + username + ", password=" + password + "]";
	}

}
