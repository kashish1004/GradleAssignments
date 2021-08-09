package com.phoenix.services;
/* Author kashish.jain@stltech.in
 * Creation Date - 06-07-2021
 * Version - 1.0
 * Copyright - Sterlite Technologies Ltd.
 */

import java.util.List;

import com.phoenix.data.User;
import com.phoenix.web.exceptions.ServiceException;
import com.phoenix.web.exceptions.UserAlreadyExistException;
import com.phoenix.web.exceptions.UserNotFoundException;

public interface LoginService {
	List<User> findAll() throws ServiceException;
	User findUserById(String username) throws UserNotFoundException;
	void add(User user) throws UserAlreadyExistException;
	void edit(User user) throws ServiceException;
	void remove(User user) throws ServiceException;
	String changePassword(User user) throws ServiceException;
}
