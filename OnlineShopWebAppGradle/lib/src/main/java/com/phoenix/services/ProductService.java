package com.phoenix.services;
/* Author kashish.jain@stltech.in
 * Creation Date - 06-07-2021
 * Version - 1.0
 * Copyright - Sterlite Technologies Ltd.
 */
import java.util.List;
import com.phoenix.data.Product;
import com.phoenix.web.exceptions.ProductNotFoundException;
import com.phoenix.web.exceptions.ServiceException;

public interface ProductService {
	List<Product> findAll() throws ServiceException;
	Product findProductById(int id) throws ProductNotFoundException;
	void add(Product product) throws ServiceException;
	void edit(Product product) throws ServiceException;
	void remove(Product product) throws ServiceException;
	List<Product> findByName(String name) throws ServiceException;
	List<Product> findByBrand(String brand) throws ServiceException;
	List<Product> findByPrice(float price) throws ServiceException;
	List<Product> findByPriceRange(float minprice,float maxprice) throws ServiceException;
	List<Product> findByNameAndBrand(String name,String brand) throws ServiceException;
	List<Product> findByNameAndPrice(String name,float price) throws ServiceException;
	List<Product> findByBrandAndPrice(String brand,float price) throws ServiceException;
	List<Product> sortByName(List<Product> products) throws ServiceException;
	List<Product> sortByBrand(List<Product> products) throws ServiceException;
	List<Product> sortByPrice(List<Product> products) throws ServiceException;
	List<Product> sortByPriceDesc(List<Product> products) throws ServiceException;
}
