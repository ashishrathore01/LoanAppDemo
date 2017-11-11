/**
 * 
 */
package com.login.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.login.dao.impl.CustomerDAOImpl;
import com.login.dto.Customer;
import com.login.dto.Employee;
import com.login.service.CustomerService;

/**
 * @author rathoras
 *
 */
public class CustomerServiceImpl  implements CustomerService {
	@Autowired
	private CustomerDAOImpl customerDAO;
	
	public boolean addNewCustomer(Customer customer) {
		return customerDAO.addNewCustomer(customer);
	}
	
	public List<Customer> getAllCustomerList() {
		return customerDAO.getAllCustomerList();
	}
	
	public Customer getCustomerDetails(String customerId) {
		return customerDAO.getCustomerDetails(customerId);
	}
	
	public List<Customer> list(Integer offset, Integer maxResults){
		return customerDAO.list(offset, maxResults);
	}
	
	public Long count(){
		return customerDAO.count();
	}
}
