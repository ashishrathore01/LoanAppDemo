/**
 * 
 */
package com.login.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.login.dao.PaydayDAO;
import com.login.dao.impl.EmployeeDAOImpl;
import com.login.dao.impl.PaydayDAOImpl;
import com.login.dto.Employee;
import com.login.dto.Payday;
import com.login.service.PaydayService;

/**
 * @author rathoras
 *
 */
@Component
public class PaydayServiceImpl implements PaydayService {
	
	@Autowired
	private PaydayDAOImpl paydayDAO;
	
	public int addNewPayday(Payday payday) {
		return paydayDAO.addNewPayday(payday);		
	}
	
	public int updatePayday(Payday payday) {
		return 0;
	}
	
	public int deletePayday(String paydayId) {
		return paydayDAO.deletePayday(paydayId);
//		return true;
	}
	
	public List<Payday> getAllPaydayId() {		
		return paydayDAO.getAllPaydayDetails();
	}
	
	public List<Payday> getAllPaydayDetails() {
		return paydayDAO.getAllPaydayDetails();
		//return listEmployee;
	}
	
	public Payday getPaydayDetails(String paydayId) {
		return paydayDAO.getPaydayDetails(paydayId);		
	}		
}
