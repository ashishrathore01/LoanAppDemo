/**
 * 
 */
package com.login.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.login.dao.impl.OrganizationDAOImpl;
import com.login.dto.Organization;
import com.login.service.OrganizationService;

/**
 * @author rathoras
 *
 */
public class OrganizationServiceImpl implements OrganizationService{
	@Autowired
	private OrganizationDAOImpl organizationDAO;
	
	public boolean addNewOrganization(Organization organization) {		
		return organizationDAO.addNewOrganization(organization);
	}
	
	public boolean updateOrganization(Organization organization) {
		return true;
	}
	
	public int deleteOrganization(String organizationid) {
		return organizationDAO.deleteOrganization(organizationid);
	}
	
	public List<Organization> getAllOrganizationDetails() {
		List<Organization> organizationsList = new ArrayList<Organization>();
		return organizationsList;
	}
	
	public Organization getOrganizationDetails(String organizationid) {				
		return organizationDAO.getOrganizationDetails(organizationid);
	}
	
	public List<Organization> getAllOrganizationId() {
		System.out.println("Hello inside Servicre Impl");
		return organizationDAO.getAllOrganizationId();
	}
}
