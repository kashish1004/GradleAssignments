package com.phoenix.services;
import java.util.List;
import com.phoenix.daos.LoginDao;
import com.phoenix.daos.LoginDaoImpl;
import com.phoenix.data.User;
import com.phoenix.web.exceptions.ServiceException;
import com.phoenix.web.exceptions.UserAlreadyExistException;
import com.phoenix.web.exceptions.UserNotFoundException;
/* Author kashish.jain@stltech.in
 * Creation Date - 09-07-2021
 * Version - 2.0
 * Copyright - Sterlite Technologies Ltd.
 */
public class LoginServiceImpl implements LoginService {
	
	private LoginDao loginDao;
	
	public LoginServiceImpl() {
		// TODO Auto-generated constructor stub
		loginDao = new LoginDaoImpl();
	}
	
	@Override
	public List<User> findAll() throws ServiceException {
		return loginDao.getAllUsers();
	}

	@Override
	public User findUserById(String username) throws UserNotFoundException {
		User user =  loginDao.getUserbyId(username);
		if(user!=null)
			return user;
		else
			throw new UserNotFoundException("Sorry! User Doesn't Exists");
	}

	@Override
	public void add(User user) throws UserAlreadyExistException {
		loginDao.insert(user);
	}

	@Override
	public void edit(User user) throws ServiceException {
		loginDao.update(user);
	}

	@Override
	public void remove(User user) throws ServiceException {
		loginDao.delete(user);
	}

	@Override
	public String changePassword(User user) throws ServiceException {
		loginDao.update(user);
		return "Password is changed";
	}

}
