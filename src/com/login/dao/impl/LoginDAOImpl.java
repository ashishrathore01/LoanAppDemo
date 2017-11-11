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

import com.login.dao.LoginDAO;
import com.login.db.utils.DBUtils;
import com.login.dto.Employee;
import com.login.dto.User;

/**
 * @author rathoras
 *
 */
public class LoginDAOImpl implements LoginDAO {
		
	private Session session;
	public boolean userLoginDAO(String userName, String password, String role){
		
		return true;
	}
	public boolean userRegistrationDAO(User user) {
		return true;
	}
	public List<User> getAllUserDetails() {
		List<User> listUser = new ArrayList<User>();
		return listUser;
	}
	public User getUserDetails(String username){
		User user = new User();
		return user;
	}

	public boolean userAuthentication(String username, String password) {
		Transaction tx = null;
		session = DBUtils.getSessionFactory().openSession();
		List<Employee> listUser = new ArrayList<Employee>();
		try {
			tx = session.beginTransaction();
			String hql = "select employeename from Employee where employeename= :employeeName and password= :employeePassword";
			Query query = session.createQuery(hql);
			query.setParameter("employeeName", username);
			query.setParameter("employeePassword", password);
			listUser = (List<Employee>)query.list();
			System.out.println("Before Catch " + listUser.size());
		} catch (HibernateException ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		} finally {
			session.close();
		}
		if(listUser.size() > 0) {
			return true;
		} else {
			return false;
		}		
	}	
}