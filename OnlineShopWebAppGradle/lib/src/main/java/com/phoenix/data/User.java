package com.phoenix.data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/* Author kashish.jain@stltech.in
 * Creation Date - 09-07-2021
 * Version - 2.0
 * Copyright - Sterlite Technologies Ltd.
 */
//POJO class
@Entity
@Table(name = "login")
public class User {
	@Id
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
	
}
