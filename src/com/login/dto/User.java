/**
 * 
 */
package com.login.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;

/**
 * @author rathoras
 *
 */
@Entity
@Table(name="user")
@Scope("session")
public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2295393432244445696L;

	@Id
	@Column(name="username")
	String username;
	
	@Column(name="password")
	String password;
	
	@Column(name="role")
	String role;

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}	
}