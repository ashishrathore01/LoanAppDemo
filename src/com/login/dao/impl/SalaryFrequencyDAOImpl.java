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

import com.login.dao.SalaryFrequencyDAO;
import com.login.db.utils.DBUtils;
import com.login.dto.Employee;
import com.login.dto.SalaryFrequency;

/**
 * @author rathoras
 *
 */
public class SalaryFrequencyDAOImpl  implements SalaryFrequencyDAO {
	private Session session;
	public int addSalaryFrequency(SalaryFrequency salaryFrequency) {
		Transaction tx = null;
		String salaryFrequencyId = "";
		int flag = 0;
		session = DBUtils.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();
			System.out.println("Salary  Frequency is " + salaryFrequency);
			salaryFrequencyId = (String)session.save(salaryFrequency);
			System.out.println("Salary Frequency " + salaryFrequencyId);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		if (!salaryFrequencyId.isEmpty()) {
			flag = 1;
		}
		System.out.println("Value of Flag before sending " + flag);
		return flag;
	}
	public int updateSalaryFrequency(SalaryFrequency salaryFrequency) {
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
	public int deleteFrequency(String salaryFrequencyId) {
		Employee employee = new Employee();		
		Transaction tx = null;
		session = DBUtils.getSessionFactory().openSession();
		int result = 0;
		try {
			tx = session.beginTransaction();
			String hql = "DELETE SalaryFrequency SF WHERE SF.salaryFrequencyId=:salaryFrequencyId";
			Query query = session.createQuery(hql);		
			query.setParameter("salaryFrequencyId", salaryFrequencyId);
//			query.setString("employeeid", employeeid);
			
			//employee = (Employee)query.list();
			result = query.executeUpdate();
			System.out.println("Payday Value is " + result);
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
	public List<SalaryFrequency> getAllSalaryFrequencyDetails() {
		List<SalaryFrequency> salaryFrequencyList = new ArrayList<SalaryFrequency>();
		session = DBUtils.getSessionFactory().openSession();
		try {
			String hql = "FROM SalaryFrequency";
			Query query = session.createQuery(hql);
			salaryFrequencyList = query.list();
			System.out.println("Before Catch " + salaryFrequencyList.size());
		} catch (HibernateException ex) {			
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return salaryFrequencyList;
	}
	public SalaryFrequency getSalaryFrequencyDetails(String salaryFrequencyId) {
		SalaryFrequency salaryFrequency = new SalaryFrequency();		
		Transaction tx = null;
		session = DBUtils.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();
			String hql = "FROM SalaryFrequency SF WHERE SF.salaryFrequencyId=:salaryFrequencyId";
			Query query = session.createQuery(hql);
			query.setString("salaryFrequencyId", salaryFrequencyId);
			
			//employee = (Employee)query.list();
			salaryFrequency = (SalaryFrequency)query.uniqueResult();
			System.out.println("Employee Value is " + salaryFrequency);
		} catch (HibernateException ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return salaryFrequency;
	}
	public List<SalaryFrequency> getAllSalaryFrequencyId() {
		return new ArrayList<SalaryFrequency>();
	}
}
