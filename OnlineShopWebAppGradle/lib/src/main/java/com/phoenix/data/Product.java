package com.phoenix.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/* Author kashish.jain@stltech.in
 * Creation Date - 09-07-2021
 * Version - 2.0
 * Copyright - Sterlite Technologies Ltd.
 */
//POJO class
@Entity
@Table(name = "products")
public class Product {
	@Id
	@GeneratedValue(generator = "increment")
	private int id;
	private String brand;
	private String name;
	private float price;
	public Product() {
		// TODO Auto-generated constructor stub
	}
	public Product(int id, String brand, String name, float price) {
		this.id = id;
		this.brand = brand;
		this.name = name;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}	
}
