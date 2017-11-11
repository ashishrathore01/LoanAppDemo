/**
 * 
 */
package com.login.dao;

import java.util.List;

import com.login.dto.Payday;

/**
 * @author rathoras
 *
 */
public interface PaydayDAO {
	public int addNewPayday(Payday payday);
	public int updatePayday(Payday payday);
	public int deletePayday(String paydayId);
	public List<Payday> getAllPaydayDetails();
	public Payday getPaydayDetails(String paydayId);
	public List<Payday> getAllPaydayId();
}
