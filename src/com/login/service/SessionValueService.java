/**
 * 
 */
package com.login.service;

import com.login.dto.SessionValues;

/**
 * @author rathoras
 *
 */
public interface SessionValueService {
	public boolean addSessionValue(SessionValues sessionValue);
	public boolean updateSessionValue(SessionValues sessionValue);
}
