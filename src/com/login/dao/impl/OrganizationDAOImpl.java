/**
 * 
 */
package com.login.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.login.dao.OrganizationDAO;
import com.login.db.utils.DBUtils;
import com.login.dto.Branch;
import com.login.dto.Organization;

/**
 * @author rathoras
 *
 */
public class OrganizationDAOImpl implements OrganizationDAO{
	private Session session;
	public boolean addNewOrganization(Organization organization) {
		Transaction tx = null;
		String organizationId = "";
		boolean flag;
		Session session = DBUtils.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();
			organizationId = (String)session.save(organization);
			System.out.println("Value of employeeId " + organizationId);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		if (!organizationId.isEmpty()) {
			flag = true;
		} else {
			flag = false;
		}
		System.out.println("Value of Flag before sending " + flag);
		return flag;
	}
	public boolean updateOrganization(Organization organization) {
		return true;
	}
	public int deleteOrganization(String organizationid) {
		Transaction tx = null;
		session = DBUtils.getSessionFactory().openSession();
		int result = 0;
		try {
			tx = session.beginTransaction();
			String hql = "DELETE Organization O WHERE O.organizationid=:organizationid";
			Query query = session.createQuery(hql);		
			query.setParameter("organizationid", organizationid);
//			query.setString("employeeid", employeeid);
			
			//employee = (Employee)query.list();
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
	public List<Organization> getAllOrganizationDetails() {
		List<Organization> organizationList = new ArrayList<Organization>();
		return organizationList;
	}
	public Organization getOrganizationDetails(String organizationid) {
		Organization organization = new Organization();
		Transaction tx = null;
		session = DBUtils.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();
			String hql = "FROM Organization O WHERE O.organizationid=:organizationid";
			Query query = session.createQuery(hql);
			query.setString("organizationid", organizationid);

			// employee = (Employee)query.list();
			organization = (Organization) query.uniqueResult();
			System.out.println("Branch Value is " + organization);
		} catch (HibernateException ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return organization;
	}
	
	public List<Organization> getAllOrganizationId() {
		List<Organization> organizationIds = new ArrayList<Organization>();
//		List<String> organizationId = new ArrayList<String>();
		Transaction tx = null;
		session = DBUtils.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();
			String hql = "FROM Organization";
			Query query = session.createQuery(hql);
			organizationIds = query.list();
			/*Iterator it = organizationIds.iterator();			 
			while(it.hasNext())
			{
				Object o = (Object)it.next();
				Organization organization = (Organization)o;
				organizationId.add(organization.getOrganizationid());
				System.out.println("Organization id in DAo Impl: " + organization.getOrganizationid());
			}*/	
		} catch (HibernateException ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return organizationIds;
	}
}