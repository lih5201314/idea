package com.jk.dao;

import java.util.List;

import com.jk.model.Customer;

public interface CustomerDao {

	List<Customer> queryCustomer(String hql) throws Exception;

	void queryCustomer(Customer customer);

	//void delCustomer(StringBuffer hql);

	
}
