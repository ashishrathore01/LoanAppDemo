/**
 * 
 */
package com.login.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.login.dao.impl.LoginDAOImpl;
import com.login.dao.impl.SessionValueDAOImpl;
import com.login.db.utils.DBUtils;
import com.login.dto.SessionValues;
import com.login.dto.User;
import com.login.service.LoginService;

/**
 * @author rathoras
 *
 */
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginDAOImpl loginDAO;
	@Autowired
	private SessionValueDAOImpl sessionValueDAO;
	public boolean userLoginService(String userName, String password, String role) {
		return true;
	}

	public boolean userRegistrationService(User user) {
		return true;
	}

	public List<User> getAllUserDetails() {
		List<User> listUser = new ArrayList<User>();
		Transaction tx = null;
		Session session = DBUtils.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();
			listUser = (List<User>) session.createQuery("FROM User").list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listUser;
	}

	public List<User> getUserDetails(String username) {
		List<User> listUser = new ArrayList<User>();
		Transaction tx = null;
		Session session = DBUtils.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();
			listUser = (List<User>) session.createQuery("FROM User").list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listUser;
	}

	public boolean userAuthentication(String username,String password){
		System.out.println("Inside Login Service 1");
		if(loginDAO.userAuthentication(username, password)) {			
			System.out.println("Inside Login Service 2");
			return true;			
		} else {
			return false;
		}			
	}

	public User getEmployeeById(int empId) {
		User user = new User();
		Transaction tx = null;
		Session session = DBUtils.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();
			user = (User) session.get(User.class, empId);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return user;
	}
}
