/**
 * 
 */
package com.login.dao;

import java.util.List;

import com.login.dto.Branch;

/**
 * @author rathoras
 *
 */
public interface BranchDAO {	
	public boolean addNewBranch(Branch branch);
	public int updateBranch(Branch branch);
	public int deleteBranch(String branchid);
	public List<Branch> getAllBranchDetails();
	public Branch getBranchDetails(String branchid);
	public List<Branch> getAllBranchId();
}
