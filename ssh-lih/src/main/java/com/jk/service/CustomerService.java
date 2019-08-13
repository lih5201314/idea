package com.jk.service;

import java.util.List;

import com.jk.model.Customer;

public interface CustomerService {

	List<Customer> queryCustomer() throws Exception;

	void addCustomer(Customer customer2);

	

}
