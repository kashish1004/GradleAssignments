package com.phoenix.daos;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.phoenix.data.User;
/* Author kashish.jain@stltech.in
 * Creation Date - 05-07-2021
 * Version - 2.0
 * Copyright - Sterlite Technologies Ltd.
 */
public class LoginDaoImpl implements LoginDao {
	
	private static Session session;
	static {
		Configuration cfg = new Configuration().configure();
		SessionFactory factory = cfg.buildSessionFactory();
		session = factory.openSession();
		System.out.println("Oracle Connection Established");
	}
	
	@Override
	public User getUserbyId(String username) {
		// TODO Auto-generated method stub
		return session.get(User.class, username);
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		Query query = session.createQuery("from User");
		return query.getResultList();
	}

	@Override
	public void insert(User user) {
		// TODO Auto-generated method stub
		Transaction txn = session.beginTransaction();
		session.save(user);
		txn.commit();
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		Transaction txn = session.beginTransaction();
		session.update(user);
		txn.commit();
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		Transaction txn = session.beginTransaction();
		session.delete(user);
		txn.commit();
	}
	
}

