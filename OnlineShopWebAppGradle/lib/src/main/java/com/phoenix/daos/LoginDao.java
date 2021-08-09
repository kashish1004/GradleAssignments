package com.phoenix.daos;
import java.util.List;
import com.phoenix.data.User;
/* Author kashish.jain@stltech.in
 * Creation Date - 09-07-2021
 * Version - 2.0
 * Copyright - Sterlite Technologies Ltd.
 */
public interface LoginDao {
	User getUserbyId(String username);
	List<User> getAllUsers(); 
	void insert(User user);
	void update(User user);
	void delete(User user);
}