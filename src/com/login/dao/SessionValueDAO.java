/**
 * 
 */
package com.login.dao;

import com.login.dto.SessionValues;

/**
 * @author rathoras
 *
 */
public interface SessionValueDAO {
	public boolean addSessionValue(SessionValues sessionValue);		
	public boolean updateSessionValue(SessionValues sessionValue);
}
