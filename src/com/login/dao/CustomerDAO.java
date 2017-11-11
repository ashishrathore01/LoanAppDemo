/**
 * 
 */
package com.login.dao;

import java.util.List;

import com.login.dto.Branch;
import com.login.dto.Customer;

/**
 * @author rathoras
 *
 */
public interface CustomerDAO {
	public boolean addNewCustomer(Customer customer);
	public List<Customer> getAllCustomerList();
	/*public int updateCustomer(Customer customer);
	public int deleteCustomer(String customerId);
	public List<Customer> getAllCustomerDetails();
	public Customer getCustomerDetails(String customerId);
	public List<Customer> getAllCustomerId();*/
}
