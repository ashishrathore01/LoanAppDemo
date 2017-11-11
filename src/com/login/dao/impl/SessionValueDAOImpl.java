/**
 * 
 */
package com.login.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.login.dao.SessionValueDAO;
import com.login.db.utils.DBUtils;
import com.login.dto.SessionValues;

/**
 * @author rathoras
 *
 */
public class SessionValueDAOImpl implements SessionValueDAO {
	public boolean addSessionValue(SessionValues sessionValue) {
		Transaction tx = null;
		String sessionId = "";
		boolean flag;
		Session session = DBUtils.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();
			session.saveOrUpdate(sessionValue);			
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		if (!sessionId.isEmpty()) {
			flag = true;
		} else {
			flag = false;
		}
		System.out.println("Value of Flag before sending " + flag);
		return flag;
	}
		
	public boolean updateSessionValue(SessionValues sessionValue) {
		Transaction tx = null;
		String sessionId = "";
		boolean flag;
		Session session = DBUtils.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();
			Query query = session.createQuery("UPDATE SessionValues S set S.logoutTime = :logoutTime WHERE S.employeeid=:employeeid");			
			query.setString("employeeid", sessionValue.getEmployeeid());
			query.setDate("logoutTime", sessionValue.getLogoutTime());
			query.executeUpdate();
			//session.update(sessionValue);			
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		if (!sessionId.isEmpty()) {
			flag = true;
		} else {
			flag = false;
		}
		System.out.println("Value of Flag before sending " + flag);
		return flag;
	}
}
