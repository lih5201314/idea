package com.jk.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jk.dao.CustomerDao;
import com.jk.model.Customer;
import com.jk.service.CustomerService;
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;

	public List<Customer> queryCustomer() throws Exception {
		//StringBuffer hql =new StringBuffer("from Customer c, Department d , Locations l,Locations l2  where  c.location_id=l.id and c.department_id=d.id and  l2.pid=l.id");
		StringBuffer hql =new StringBuffer("select new map(c.id as id,c.description as description,c.name as name,c.create_time as create_time,c.gj_time as gj_time ,c.phone as phone,l.name as dname ,c.department_id as department_id) FROM Customer c,Department d,Locations l where c.location_id = l.id and c.department_id = d.id");	
		return customerDao.queryCustomer(hql.toString());
	}

	public void addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customerDao.queryCustomer(customer);
	}


}
