package com.phoenix.web.models;
/* Author kashish.jain@stltech.in
 * Creation Date - 06-07-2021
 * Version - 1.0
 * Copyright - Sterlite Technologies Ltd.
 */
import com.phoenix.data.User;
import com.phoenix.services.LoginService;
import com.phoenix.services.LoginServiceImpl;
import com.phoenix.web.exceptions.UserNotFoundException;

public class LoginBean {
	private String username;
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
	public boolean isValid() {
		
		User user = new User();
		LoginService login = new LoginServiceImpl();
		try {
			user = login.findUserById(username);
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(user!=null && password.equals(user.getPassword()))
			return true;
		else
			return false;
	}
}
