package com.jk.action;

import java.util.Date;
import java.util.List;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.jk.model.Customer;
import com.jk.service.CustomerService;
import com.opensymphony.xwork2.ModelDriven;




/*@Namespace("/")*/
@Action("customerAction")
@Results({
	
	@Result(name="show",location="/show.jsp"),
	@Result(name="list",location="/list.jsp")
})
public class CustomerAction extends  BaseAction   implements ModelDriven<Customer>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5007935643511462092L;

	
	
	@Autowired
	private CustomerService customerService;
	
	
	private Customer customer;
	

	private String  name;
	private Customer customer2=new Customer();
	private  Integer  id;
	private  String description;
	
	private  Integer location_id;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private  Date create_time;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private  Date gj_time;
	private  String phone;
	private  Integer department_id;
	

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}





	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public Customer getModel() {
		// TODO Auto-generated method stub
		return customer;
	}


	public CustomerService getCustomerService() {
		return customerService;
	}


	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Integer getLocation_id() {
		return location_id;
	}


	public void setLocation_id(Integer location_id) {
		this.location_id = location_id;
	}


	public Date getCreate_time() {
		return create_time;
	}


	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}


	public Date getGj_time() {
		return gj_time;
	}


	public void setGj_time(Date gj_time) {
		this.gj_time = gj_time;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public Integer getDepartment_id() {
		return department_id;
	}


	public void setDepartment_id(Integer department_id) {
		this.department_id = department_id;
	}


	public String queryCustomer() throws Exception{
		
		List <Customer> queryCustomerlist=customerService.queryCustomer();		
		String jsonStringWithDateFormat = JSON.toJSONStringWithDateFormat( queryCustomerlist,"yyyy-MM-dd");
		
		super.writeJson(queryCustomerlist);
		return "show";
		
	}
	public String queryCustomer2() throws Exception{
		
		List <Customer> queryCustomerlist=customerService.queryCustomer();		
		String jsonStringWithDateFormat = JSON.toJSONStringWithDateFormat( queryCustomerlist,"yyyy-MM-dd");
		//String s = JSON.toJSONStringWithDateFormat(0,"yyyy-MM-dd HH:mm:ss",SerializerFeature.DisableCircularReferenceDetect);
		super.writeJson(queryCustomerlist);
		return "list";
		
	}
	
	public void addCustomer( ){
		
		Customer customer3 = new Customer();
		customer3.setCreate_time(create_time);
		customer3.setDepartment_id(department_id);
		customer3.setGj_time(gj_time);
		customer3.setLocation_id(location_id);
		customer3.setName(name);
		customer3.setPhone(phone);
		customer3.setDescription(description);
		
		customerService.addCustomer(customer3);
	}
	

}
