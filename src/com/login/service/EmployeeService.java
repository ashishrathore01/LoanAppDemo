/**
 * 
 */
package com.login.service;

import java.util.List;

import com.login.dto.Branch;
import com.login.dto.Employee;
import com.login.dto.Payday;

/**
 * @author rathoras
 *
 */
public interface EmployeeService {
	public boolean addNewEmployee(Employee employee);
	public boolean updateEmployee(Employee employee);
	public int deleteEmployee(String employeeid);
	public List<Employee> getAllEmployeeDetails();
	public List<String> getAllEmployeeID();
	public Employee getEmployeeDetails(String employeeid);	
}
