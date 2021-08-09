package com.phoenix.daos;
import java.util.List;
import com.phoenix.data.Product;

/* Author kashish.jain@stltech.in
 * Creation Date - 09-07-2021
 * Version - 2.0
 * Copyright - Sterlite Technologies Ltd.
 */
public interface ProductDao {
	Product getProductbyId(int id);
	List<Product> getAllProducts();
	void insert(Product product);
	void update(Product product);
	void delete(Product product);
}
