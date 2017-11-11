/**
 * 
 */
package com.login.dao;

import java.util.List;

import com.login.dto.User;

/**
 * @author rathoras
 *
 */
public interface LoginDAO {	
	public boolean userLoginDAO(String userName, String password, String role);
	public boolean userRegistrationDAO(User user);
	public List<User> getAllUserDetails();
	public User getUserDetails(String username);
	public boolean userAuthentication(String username,String password);
}
