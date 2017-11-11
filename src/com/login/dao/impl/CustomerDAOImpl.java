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
import org.hibernate.criterion.Projections;
import com.login.dao.CustomerDAO;
import com.login.db.utils.DBUtils;
import com.login.dto.Customer;

/**
 * @author rathoras
 *
 */
public class CustomerDAOImpl implements CustomerDAO {
	private Session session;

	public boolean addNewCustomer(Customer customer) {
		Transaction tx = null;
		String customerId = "";
		boolean flag;
		session = DBUtils.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();
			customerId = (String) session.save(customer);
			System.out.println("Value of employeeId " + customerId);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		if (!customerId.isEmpty()) {
			flag = true;
		} else {
			flag = false;
		}
		System.out.println("Value of Flag before sending " + flag);
		return flag;
	}

	public int updateCustomer(Customer customer) {
		return 0;
	}

	public int deleteCustomer(String customerId) {
		Transaction tx = null;
		session = DBUtils.getSessionFactory().openSession();
		int result = 0;
		try {
			tx = session.beginTransaction();
			String hql = "DELETE Branch B WHERE B.branchid=:branchid";
			Query query = session.createQuery(hql);
			query.setParameter("branchid", customerId);
			// query.setString("employeeid", employeeid);

			// employee = (Employee)query.list();
			result = query.executeUpdate();
			System.out.println("Branch Value is " + result);
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

	public List<Customer> getAllCustomerDetails() {
		List<Customer> customerList = new ArrayList<Customer>();
		return customerList;
	}

	public List<Customer> getAllCustomerList() {
		List<Customer> customerList = new ArrayList<Customer>();
		Transaction tx = null;
		session = DBUtils.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();
			String hql = "FROM Customer";
			Query query = session.createQuery(hql);
			customerList = query.list();
		} catch (HibernateException ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return customerList;
	}

	public Customer getCustomerDetails(String customerId) {
		Customer customer = new Customer();
		Transaction tx = null;
		session = DBUtils.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();
			String hql = "FROM Customer C WHERE C.customerId=:customerId";
			Query query = session.createQuery(hql);
			query.setString("customerId", customerId);

			// employee = (Employee)query.list();
			customer = (Customer) query.uniqueResult();
			System.out.println("Customer Value is " + customer);
		} catch (HibernateException ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return customer;
	}

	@SuppressWarnings("unchecked")
	@org.springframework.transaction.annotation.Transactional
	public List<Customer> list(Integer offset, Integer maxResults) {
		return DBUtils.getSessionFactory().openSession().createCriteria(Customer.class).setFirstResult(offset != null ? offset : 0)
				.setMaxResults(maxResults != null ? maxResults : 10).list();
	}

	public Long count() {
		return (Long) DBUtils.getSessionFactory().openSession().createCriteria(Customer.class).setProjection(Projections.rowCount())
				.uniqueResult();
	}

}
