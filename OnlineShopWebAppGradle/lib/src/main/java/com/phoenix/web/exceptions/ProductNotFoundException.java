package com.phoenix.web.exceptions;
/* Author kashish.jain@stltech.in
 * Creation Date - 06-07-2021
 * Version - 1.0
 * Copyright - Sterlite Technologies Ltd.
 */
public class ProductNotFoundException extends Exception {
	private String errorMessage;
	public ProductNotFoundException(String errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}
	
}
