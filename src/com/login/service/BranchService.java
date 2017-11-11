/**
 * 
 */
package com.login.service;

import java.util.HashMap;
import java.util.List;

import com.login.dto.Branch;

/**
 * @author rathoras
 *
 */
public interface BranchService {
	public boolean addNewBranch(Branch branch);
	public boolean updateBranch(Branch branch);
	public int deleteBranch(String branchid);
	public List<Branch> getAllBranchDetails();
	public Branch getBranchDetails(String branchid);
	public List<Branch> getAllBranchId();
}
