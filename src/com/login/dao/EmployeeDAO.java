/**
 * 
 */
package com.login.dao;

import java.util.List;

import com.login.dto.Employee;

/**
 * @author rathoras
 *
 */
public interface EmployeeDAO {
	public boolean addNewEmployee(Employee employee);
	public int updateEmployee(Employee employee);
	public int deleteEmployee(String employeeid);
	public List<Employee> getAllEmployeeDetails();
	public Employee getEmployeeDetails(String employeeid);
}
