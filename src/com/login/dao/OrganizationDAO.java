/**
 * 
 */
package com.login.dao;

import java.util.List;

import com.login.dto.Organization;

/**
 * @author rathoras
 *
 */
public interface OrganizationDAO {
	public boolean addNewOrganization(Organization organization);
	public boolean updateOrganization(Organization organization);
	public int deleteOrganization(String organizationid);
	public List<Organization> getAllOrganizationDetails();
	public Organization getOrganizationDetails(String organizationid);
	public List<Organization> getAllOrganizationId();
}
