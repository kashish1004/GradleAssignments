package com.phoenix.services;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.phoenix.daos.ProductDao;
import com.phoenix.daos.ProductDaoImpl;
import com.phoenix.data.Product;
import com.phoenix.web.exceptions.ProductNotFoundException;
import com.phoenix.web.exceptions.ServiceException;
/* Author kashish.jain@stltech.in
 * Creation Date - 09-07-2021
 * Version - 2.0
 * Copyright - Sterlite Technologies Ltd.
 */
public class ProductServiceImpl implements ProductService {
	
	private ProductDao productDao;
	public ProductServiceImpl() {
		// TODO Auto-generated constructor stub
		productDao = new ProductDaoImpl();
	}
	@Override
	public List<Product> findAll() throws ServiceException {
		return productDao.getAllProducts();
	}

	@Override
	public Product findProductById(int id) throws ProductNotFoundException {
		Product product =  productDao.getProductbyId(id);
		if(product!= null)
			return product;
		else
			throw new ProductNotFoundException("Sorry! Product not found");
	}

	@Override
	public void add(Product product) throws ServiceException {
		productDao.insert(product);
	}

	@Override
	public void edit(Product product) throws ServiceException {
		productDao.update(product);
	}

	@Override
	public void remove(Product product) throws ServiceException {
		productDao.delete(product);
	}

	@Override
	public List<Product> findByName(String name) throws ServiceException {
		// TODO Auto-generated method stub
		Product product = new Product();
		List<Product> productByName = new ArrayList<Product>();
		List<Product> products = findAll();
		for(Product pro:products) {
			if(pro.getName().equals(name))
				productByName.add(product);
		}
		return productByName;
	}

	@Override
	public List<Product> findByBrand(String brand) throws ServiceException {
		// TODO Auto-generated method stub
		Product product = new Product();
		List<Product> productByBrand = new ArrayList<Product>();
		List<Product> products = findAll();
		for(Product pro:products) {
			if(pro.getBrand().equals(brand))
				productByBrand.add(product);
		}
		return productByBrand;
	}

	@Override
	public List<Product> findByPrice(float price) throws ServiceException {
		// TODO Auto-generated method stub
		Product product = new Product();
		List<Product> productByPrice = new ArrayList<Product>();
		List<Product> products = findAll();
		for(Product pro:products) {
			if(pro.getPrice() == price)
				productByPrice.add(product);
		}
		return productByPrice;
	}

	@Override
	public List<Product> findByPriceRange(float minPrice, float maxPrice) throws ServiceException {
		// TODO Auto-generated method stub
		Product product = new Product();
		List<Product> productByPriceRange = new ArrayList<Product>();
		List<Product> products = findAll();
		for(Product pro:products) {
			if(pro.getPrice() >= minPrice && pro.getPrice() <= maxPrice)
				productByPriceRange.add(product);
		}
		return productByPriceRange;
	}

	@Override
	public List<Product> findByNameAndBrand(String name, String brand) throws ServiceException {
		// TODO Auto-generated method stub
		Product product = new Product();
		List<Product> productByNameAndBrand = new ArrayList<Product>();
		List<Product> products = findAll();
		for(Product pro:products) {
			if(pro.getBrand().equals(brand) && pro.getName().equals(name))
				productByNameAndBrand.add(product);
		}
		return productByNameAndBrand;
	}

	@Override
	public List<Product> findByNameAndPrice(String name, float price) throws ServiceException {
		// TODO Auto-generated method stub
		Product product = new Product();
		List<Product> productByNameAndPrice = new ArrayList<Product>();
		List<Product> products = findAll();
		for(Product pro:products) {
			if(pro.getPrice() == price && pro.getName().equals(name))
				productByNameAndPrice.add(product);
		}
		return productByNameAndPrice;
	}

	@Override
	public List<Product> findByBrandAndPrice(String brand, float price) throws ServiceException {
		// TODO Auto-generated method stub
		Product product = new Product();
		List<Product> productByBrandAndPrice = new ArrayList<Product>();
		List<Product> products = findAll();
		for(Product pro:products) {
			if(pro.getPrice() == price && pro.getBrand().equals(brand))
				productByBrandAndPrice.add(product);
		}
		return productByBrandAndPrice;
	}

	@Override
	public List<Product> sortByName(List<Product> products) throws ServiceException {
		// TODO Auto-generated method stub
		return products.stream().sorted(Comparator.comparing(Product::getName)).collect(Collectors.toList());
	}

	@Override
	public List<Product> sortByBrand(List<Product> products) throws ServiceException {
		// TODO Auto-generated method stub
		return products.stream().sorted(Comparator.comparing(Product::getBrand)).collect(Collectors.toList());
	}

	@Override
	public List<Product> sortByPrice(List<Product> products) throws ServiceException {
		// TODO Auto-generated method stub
		return products.stream().sorted(Comparator.comparing(Product::getPrice)).collect(Collectors.toList());
	}

	@Override
	public List<Product> sortByPriceDesc(List<Product> products) throws ServiceException {
		// TODO Auto-generated method stub
		return products.stream().sorted(Comparator.comparing(Product::getPrice).reversed()).collect(Collectors.toList());
	}

}
