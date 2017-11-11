/**
 * 
 */
package com.login.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.login.dao.SessionValueDAO;
import com.login.dto.SessionValues;
import com.login.service.SessionValueService;

/**
 * @author rathoras
 *
 */
public class SessionValueServiceImpl implements SessionValueService {
	@Autowired
	private SessionValueDAO sessionValueDAO;
	
	public boolean addSessionValue(SessionValues sessionValue) {		
		return sessionValueDAO.addSessionValue(sessionValue);			
	}
	
	public boolean updateSessionValue(SessionValues sessionValue) {
		return sessionValueDAO.updateSessionValue(sessionValue);
	}
}
