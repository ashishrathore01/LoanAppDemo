/**
 * 
 */
package com.login.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.login.dao.impl.SalaryFrequencyDAOImpl;
import com.login.dto.SalaryFrequency;
import com.login.service.SalaryFrequencyService;

/**
 * @author rathoras
 *
 */
public class SalaryFrequencyServiceImpl  implements SalaryFrequencyService {
	
	@Autowired
	private SalaryFrequencyDAOImpl salaryFrequencyDAO;
	
	public int addNewSalaryFrequency(SalaryFrequency salaryFrequency) {
		return salaryFrequencyDAO.addSalaryFrequency(salaryFrequency);
	}
	public int updateSalaryFrequency(SalaryFrequency salaryFrequency) {
		return 0;
	}
	public int deleteSalaryFrequency(String salaryFrequencyId) {
		return salaryFrequencyDAO.deleteFrequency(salaryFrequencyId);
	}
	public List<SalaryFrequency> getAllSalaryFrequencyDetails() {
		return salaryFrequencyDAO.getAllSalaryFrequencyDetails();
	}
	public SalaryFrequency getSalaryFrequencyDetails(String salaryFrequencyId) {
		return salaryFrequencyDAO.getSalaryFrequencyDetails(salaryFrequencyId);
	}
	public List<SalaryFrequency> getAllSalaryFrequencyId() {
		return salaryFrequencyDAO.getAllSalaryFrequencyDetails();
	}	
}
