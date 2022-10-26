package com.user.securiry.service;

public interface SecurityService {
	
	public String findLoggedInUsername();

	 public void autoLogin(String username, String password);
}
