/**
 * 
 */
package com.login.service;

import java.util.List;

import com.login.dto.User;

/**
 * @author rathoras
 *
 */
public interface LoginService {
	public boolean userLoginService(String userName, String password, String role);
	public boolean userRegistrationService(User user);
	public List<User> getAllUserDetails();
	public List<User> getUserDetails(String username);
	public boolean userAuthentication(String username,String password);
}