/**
 * 
 */
package com.login.service;

import java.util.List;

import com.login.dto.Customer;

/**
 * @author rathoras
 *
 */
public interface CustomerService {
	public boolean addNewCustomer(Customer customer);
	public List<Customer> getAllCustomerList();
	/*public int updateCustomer(Customer customer);
	public int deleteCustomer(String customerId);
	public List<Customer> getAllCustomerDetails();*/
	public Customer getCustomerDetails(String customerId);
	//public List<Customer> getAllCustomerId();
	public List<Customer> list(Integer offset, Integer maxResults);
	public Long count();
}
