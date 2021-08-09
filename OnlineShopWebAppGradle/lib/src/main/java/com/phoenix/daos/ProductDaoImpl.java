package com.phoenix.daos;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.phoenix.data.Product;
/* Author kashish.jain@stltech.in
 * Creation Date - 09-07-2021
 * Version - 2.0
 * Copyright - Sterlite Technologies Ltd.
 */
public class ProductDaoImpl implements ProductDao {
	
	private static Session session;
	static {
		Configuration cfg = new Configuration().configure();
		SessionFactory factory = cfg.buildSessionFactory();
		session = factory.openSession();
		System.out.println("Oracle Connection Established");
	}
	
	@Override
	public Product getProductbyId(int id) {
		// TODO Auto-generated method stub
		return session.get(Product.class, id);
	}
	
	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return session.createQuery("from Product").getResultList();
	}
	
	@Override
	public void insert(Product product) {
		// TODO Auto-generated method stub
		Transaction txn = session.beginTransaction();
		session.save(product);
		txn.commit();
	}
	
	@Override
	public void update(Product product) {
		// TODO Auto-generated method stub
		Transaction txn = session.beginTransaction();
		session.update(product);
		txn.commit();
	}
	
	@Override
	public void delete(Product product) {
		// TODO Auto-generated method stub
		Transaction txn = session.beginTransaction();
		session.delete(product);
		txn.commit();
	}
}