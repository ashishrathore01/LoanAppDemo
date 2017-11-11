/**
 * 
 */
package com.login.dao;

import java.util.List;

import com.login.dto.SalaryFrequency;

/**
 * @author rathoras
 *
 */
public interface SalaryFrequencyDAO {
	public int addSalaryFrequency(SalaryFrequency salaryFrequency);
	public int updateSalaryFrequency(SalaryFrequency salaryFrequency);
	public int deleteFrequency(String salaryFrequencyId);
	public List<SalaryFrequency> getAllSalaryFrequencyDetails();
	public SalaryFrequency getSalaryFrequencyDetails(String salaryFrequencyId);
	public List<SalaryFrequency> getAllSalaryFrequencyId();
}
