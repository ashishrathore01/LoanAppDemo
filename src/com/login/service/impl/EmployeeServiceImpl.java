/**
 * 
 */
package com.login.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.login.dao.impl.EmployeeDAOImpl;
import com.login.dto.Branch;
import com.login.dto.Employee;
import com.login.service.EmployeeService;

/**
 * @author rathoras
 *
 */
@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeDAOImpl employeeDAO;
	
	public boolean addNewEmployee(Employee employee) {
		return employeeDAO.addNewEmployee(employee);		
	}
	
	public boolean updateEmployee(Employee employee) {
		return true;
	}
	
	public int deleteEmployee(String employeeid) {
		return employeeDAO.deleteEmployee(employeeid);
//		return true;
	}
	
	public List<String> getAllEmployeeID() {
		List<String> listIds = new ArrayList<String>();		
		if(employeeDAO.getAllEmployeeDetails().size() > 0) {
			for (Employee employee : employeeDAO.getAllEmployeeDetails()) {   
				listIds.add(employee.getEmployeeid());
			}
		}
		return listIds;
	}
	
	public List<Employee> getAllEmployeeDetails() {
		return employeeDAO.getAllEmployeeDetails();
		//return listEmployee;
	}
	
	public Employee getEmployeeDetails(String employeeid) {
		return employeeDAO.getEmployeeDetails(employeeid);		
	}
	
	
}
