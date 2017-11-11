/**
 * 
 */
package com.login.controller;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.login.dao.impl.BranchDAOImpl;
import com.login.db.utils.DBUtils;
import com.login.dto.Branch;
import com.login.dto.User;


/**
 * @author rathoras
 *
 */
public class Demo {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		/*Calendar date = Calendar.getInstance();
		System.out.println(date.getTime());
				
		List<Branch> branchIds = new ArrayList<Branch>();
		List<String> branchId = new ArrayList<String>();
		Transaction tx = null;
		Session session = DBUtils.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();
			String hql = "FROM Branch";
			Query query = session.createQuery(hql);
			branchIds = query.list();
			Iterator it = branchIds.iterator();			 
			while(it.hasNext())
			{
				Object o = (Object)it.next();
				Branch branch = (Branch)o;
				branchId.add(branch.getBranchid());
				System.out.println("Product id : " + branch.getBranchid());
			}	
		} catch (HibernateException ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		} finally {
			session.close();
		}
	*/	
		/*	System.out.println("Unique Value is " + demo.generateRandom("1201"));
		System.out.println("Unique Value is " + demo.generateRandom("1202"));
		System.out.println("Unique Value is " + demo.generateRandom("1203"));*/
/*		User user = new User();
		user.setUsername("ashish");
		user.setPassword("ashish");
		user.setRole("operator");*/
		
		//String i = demo.addEmployee(user);
		//System.out.println("Record Inserted " + i);
//		listUser1 = demo.getAllEmployee();
//		for (User user1 : listUser1) {
	/*		System.out.println("Name " + user1.getUsername());
			System.out.println("Name " + user1.getPassword());
			System.out.println("Name " + user1.getRole());*/
	/*	}
		System.out.println("List of User " + listUser1.toString());*/
		
	}		
	
	public String addEmployee(User user){
		Transaction tx = null;
		String employeeId="";
		Session session = DBUtils.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();
			employeeId = (String)session.save(user);
			tx.commit();
		} catch(HibernateException e) {
			if(tx!=null) tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}					
		return employeeId;
	}
		


	    public String getEncryptedPassword(String password)
	    {
	        StringBuffer sb = new StringBuffer();
	    	try {	    			    
	        MessageDigest md = MessageDigest.getInstance("SHA-256");
	        md.update(password.getBytes());
	        byte byteData[] = md.digest();
	        //convert the byte to hex format method 1
	        for (int i = 0; i < byteData.length; i++) {
	         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
	        }
	    	}catch (Exception ex) {
	    		ex.printStackTrace();
	    	}
	    	return sb.toString();
	    }	
}