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

import com.login.dao.PaydayDAO;
import com.login.db.utils.DBUtils;
import com.login.dto.Employee;
import com.login.dto.Payday;

/**
 * @author rathoras
 *
 */
public class PaydayDAOImpl implements PaydayDAO {
	private Session session;

	public int addNewPayday(Payday payday) {
		Transaction tx = null;
		String paydayId = "";
		int flag = 0;
		Session session = DBUtils.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();
			System.out.println("Payday value is " + payday);
			paydayId = (String)session.save(payday);
			System.out.println("Value of PaydayId " + paydayId);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		if (!paydayId.isEmpty()) {
			flag = 1;
		}
		System.out.println("Value of Flag before sending " + flag);
		return flag;
	}

	public int updatePayday(Payday payday) {	
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

	public int deletePayday(String paydayId) {
		Employee employee = new Employee();		
		Transaction tx = null;
		session = DBUtils.getSessionFactory().openSession();
		int result = 0;
		try {
			tx = session.beginTransaction();
			String hql = "DELETE Payday P WHERE P.payDayId=:paydayId";
			Query query = session.createQuery(hql);		
			query.setParameter("paydayId", paydayId);
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

	public List<Payday> getAllPaydayDetails() {
		List<Payday> paydayList = new ArrayList<Payday>();
		session = DBUtils.getSessionFactory().openSession();
		try {
			String hql = "FROM Payday";
			Query query = session.createQuery(hql);
			paydayList = query.list();
			System.out.println("Before Catch " + paydayList.size());
		} catch (HibernateException ex) {			
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return paydayList;
	}

	public Payday getPaydayDetails(String paydayId) {
		Payday payday = new Payday();		
		Transaction tx = null;
		session = DBUtils.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();
			String hql = "FROM Payday P WHERE P.payDayId=:payDayId";
			Query query = session.createQuery(hql);
			query.setString("payDayId", paydayId);
			
			//employee = (Employee)query.list();
			payday = (Payday)query.uniqueResult();
			System.out.println("Employee Value is " + payday);
		} catch (HibernateException ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return payday;
	}
	
	public List<Payday> getAllPaydayId() {
		return new ArrayList<Payday>();
	}
}
