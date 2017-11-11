/**
 * 
 */
package com.login.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.login.dao.EmployeeDAO;
import com.login.db.utils.DBUtils;
import com.login.dto.Branch;
import com.login.dto.Employee;

/**
 * @author rathoras
 *
 */
public class EmployeeDAOImpl implements EmployeeDAO {
	private Session session;
	public boolean addNewEmployee(Employee employee) {
		Transaction tx = null;
		String employeeid = "";
		boolean flag;
		Session session = DBUtils.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();
			employeeid = (String)session.save(employee);
			System.out.println("Value of employeeId " + employeeid);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		if (!employeeid.isEmpty()) {
			flag = true;
		} else {
			flag = false;
		}
		System.out.println("Value of Flag before sending " + flag);
		return flag;
	}

	public int updateEmployee(Employee employee) {	
		Transaction tx = null;
		session = DBUtils.getSessionFactory().openSession();
		int result = 0;
		try {
			tx = session.beginTransaction();
			String hql = "DELETE Employee E WHERE E.employeeid=:employeeid";
			Query query = session.createQuery(hql);		
			//query.setParameter("employeeid", employeeid);
//			query.setString("employeeid", employeeid);
			
			//employee = (Employee)query.list();
			result = query.executeUpdate();
			System.out.println("Employee Value is " + result);
			tx.commit();
		} catch (HibernateException ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}

	public int deleteEmployee(String employeeid) {
		Employee employee = new Employee();		
		Transaction tx = null;
		session = DBUtils.getSessionFactory().openSession();
		int result = 0;
		try {
			tx = session.beginTransaction();
			String hql = "DELETE Employee E WHERE E.employeeid=:employeeid";
			Query query = session.createQuery(hql);		
			query.setParameter("employeeid", employeeid);
//			query.setString("employeeid", employeeid);
			
			//employee = (Employee)query.list();
			result = query.executeUpdate();
			System.out.println("Employee Value is " + result);
			tx.commit();
		} catch (HibernateException ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}

	public List<Employee> getAllEmployeeDetails() {
		List<Employee> employeeList = new ArrayList<Employee>();
		session = DBUtils.getSessionFactory().openSession();
		try {
			String hql = "FROM Employee";
			Query query = session.createQuery(hql);
			employeeList = query.list();
			System.out.println("Before Catch " + employeeList.size());
		} catch (HibernateException ex) {			
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return employeeList;
	}

	public Employee getEmployeeDetails(String employeeid) {
		Employee employee = new Employee();		
		Transaction tx = null;
		session = DBUtils.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();
			String hql = "FROM Employee E WHERE E.employeeid=:employeeid";
			Query query = session.createQuery(hql);
			query.setString("employeeid", employeeid);
			
			//employee = (Employee)query.list();
			employee = (Employee)query.uniqueResult();
			System.out.println("Employee Value is " + employee);
		} catch (HibernateException ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return employee;
	}
}
