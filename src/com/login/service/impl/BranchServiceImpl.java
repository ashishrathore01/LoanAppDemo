/**
 * 
 */
package com.login.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.login.dao.impl.BranchDAOImpl;
import com.login.dto.Branch;
import com.login.service.BranchService;

/**
 * @author rathoras
 *
 */
public class BranchServiceImpl implements BranchService{
	@Autowired
	private BranchDAOImpl branchDAO;
	
	public boolean addNewBranch(Branch branch) {
		return branchDAO.addNewBranch(branch);
	}
	public boolean updateBranch(Branch branch) {
		return true;
	}
	public int deleteBranch(String branchid) {
		return branchDAO.deleteBranch(branchid);
	}
	public List<Branch> getAllBranchDetails() {
		List<Branch> branchList = new ArrayList<Branch>();
		return branchList;
	}
	public Branch getBranchDetails(String branchid) {		
		return branchDAO.getBranchDetails(branchid);
	}
	
	public List<Branch> getAllBranchId() {
		System.out.println("Hello inside Servicre Impl");
		return branchDAO.getAllBranchId();
	}
}
