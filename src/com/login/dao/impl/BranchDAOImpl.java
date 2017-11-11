/**
 * 
 */
package com.login.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.login.dao.BranchDAO;
import com.login.db.utils.DBUtils;
import com.login.dto.Branch;
import com.login.dto.Employee;

/**
 * @author rathoras
 *
 */
public class BranchDAOImpl implements BranchDAO {
	private Session session;
	public boolean addNewBranch(Branch branch) {
		Transaction tx = null;
		String branchId = "";
		boolean flag;
		session = DBUtils.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();
			branchId = (String) session.save(branch);
			System.out.println("Value of employeeId " + branchId);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		if (!branchId.isEmpty()) {
			flag = true;
		} else {
			flag = false;
		}
		System.out.println("Value of Flag before sending " + flag);
		return flag;
	}

	public int updateBranch(Branch branch) {
		return 0;
	}

	public int deleteBranch(String branchid) {				
		Transaction tx = null;
		session = DBUtils.getSessionFactory().openSession();
		int result = 0;
		try {
			tx = session.beginTransaction();
			String hql = "DELETE Branch B WHERE B.branchid=:branchid";
			Query query = session.createQuery(hql);		
			query.setParameter("branchid", branchid);
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

	public List<Branch> getAllBranchDetails() {
		List<Branch> branchList = new ArrayList<Branch>();
		return branchList;
	}

	public List<Branch> getAllBranchId() {
		List<Branch> branchIds = new ArrayList<Branch>();
//		List<Branch> branchId = new ArrayList<Branch>();
		Transaction tx = null;
		session = DBUtils.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();
			String hql = "FROM Branch";
			Query query = session.createQuery(hql);
			branchIds = query.list();
/*			Iterator it = branchIds.iterator();			 
			while(it.hasNext())
			{
				Object o = (Object)it.next();
				Branch branch = (Branch)o;
				branchId.add(branch.getBranchid(),branch.getBranchname());
				System.out.println("Branch id and Branch Name in DAO Impl: " + branch.getBranchid() + " " + branch.getBranchname());
			}*/	
		} catch (HibernateException ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return branchIds;
	}
	
	public Branch getBranchDetails(String branchid) {
		Branch branch = new Branch();		
		Transaction tx = null;
		session = DBUtils.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();
			String hql = "FROM Branch B WHERE B.branchid=:branchid";
			Query query = session.createQuery(hql);
			query.setString("branchid", branchid);
			
			//employee = (Employee)query.list();
			branch = (Branch)query.uniqueResult();
			System.out.println("Branch Value is " + branch);
		} catch (HibernateException ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return branch;
	}
}
