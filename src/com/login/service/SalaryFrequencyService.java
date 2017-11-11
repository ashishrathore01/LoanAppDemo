/**
 * 
 */
package com.login.service;

import java.util.List;

import com.login.dto.SalaryFrequency;

/**
 * @author rathoras
 *
 */
public interface SalaryFrequencyService {
	public int addNewSalaryFrequency(SalaryFrequency salaryFrequency);
	public int updateSalaryFrequency(SalaryFrequency salaryFrequency);
	public int deleteSalaryFrequency(String salaryFrequencyId);
	public List<SalaryFrequency> getAllSalaryFrequencyDetails();
	public SalaryFrequency getSalaryFrequencyDetails(String salaryFrequencyId);
	public List<SalaryFrequency> getAllSalaryFrequencyId();
}
