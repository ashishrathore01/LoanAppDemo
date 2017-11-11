/**
 * 
 */
package com.login.dto;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author rathoras
 *
 */
@Entity
@Table(name="sessionvalues")
public class SessionValues implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4939299660884288869L;	
	@Id
	@Column
	private String employeeid;	
	@Column
	private int application;
	@Column
	private int changecount;
	@Column
	private int client;
	@Column
	private int enterpriseiconid;
	@Column
	private int branchiconid;
	@Column
	private String branchid;
	@Column
	private int locationiconid;
	@Column
	private int workcenterid;
	@Column
	private String operationid;
	@Column
	private int isfrozen;
	@Column
	private int cdotypeid;
	@Column
	private String resourceid;
	@Column
	private String workstationid;
	@Column
	private String computerresourceid;
	@Column
	private Date loginTime;
	@Column
	private Date logoutTime;
	/**
	 * @return the employeeid
	 */
	public String getEmployeeid() {
		return employeeid;
	}
	/**
	 * @param employeeid the employeeid to set
	 */
	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
	}
	/**
	 * @return the application
	 */
	public int getApplication() {
		return application;
	}
	/**
	 * @param application the application to set
	 */
	public void setApplication(int application) {
		this.application = application;
	}
	/**
	 * @return the changecount
	 */
	public int getChangecount() {
		return changecount;
	}
	/**
	 * @param changecount the changecount to set
	 */
	public void setChangecount(int changecount) {
		this.changecount = changecount;
	}
	/**
	 * @return the client
	 */
	public int getClient() {
		return client;
	}
	/**
	 * @param client the client to set
	 */
	public void setClient(int client) {
		this.client = client;
	}
	/**
	 * @return the enterpriseiconid
	 */
	public int getEnterpriseiconid() {
		return enterpriseiconid;
	}
	/**
	 * @param enterpriseiconid the enterpriseiconid to set
	 */
	public void setEnterpriseiconid(int enterpriseiconid) {
		this.enterpriseiconid = enterpriseiconid;
	}
	/**
	 * @return the branchiconid
	 */
	public int getBranchiconid() {
		return branchiconid;
	}
	/**
	 * @param branchiconid the branchiconid to set
	 */
	public void setBranchiconid(int branchiconid) {
		this.branchiconid = branchiconid;
	}
	/**
	 * @return the branchid
	 */
	public String getBranchid() {
		return branchid;
	}
	/**
	 * @param branchid the branchid to set
	 */
	public void setBranchid(String branchid) {
		this.branchid = branchid;
	}
	/**
	 * @return the locationiconid
	 */
	public int getLocationiconid() {
		return locationiconid;
	}
	/**
	 * @param locationiconid the locationiconid to set
	 */
	public void setLocationiconid(int locationiconid) {
		this.locationiconid = locationiconid;
	}
	/**
	 * @return the workcenterid
	 */
	public int getWorkcenterid() {
		return workcenterid;
	}
	/**
	 * @param workcenterid the workcenterid to set
	 */
	public void setWorkcenterid(int workcenterid) {
		this.workcenterid = workcenterid;
	}
	/**
	 * @return the operationid
	 */
	public String getOperationid() {
		return operationid;
	}
	/**
	 * @param operationid the operationid to set
	 */
	public void setOperationid(String operationid) {
		this.operationid = operationid;
	}
	/**
	 * @return the isfrozen
	 */
	public int isIsfrozen() {
		return isfrozen;
	}
	/**
	 * @param isfrozen the isfrozen to set
	 */
	public void setIsfrozen(int isfrozen) {
		this.isfrozen = isfrozen;
	}
	/**
	 * @return the cdotypeid
	 */
	public int getCdotypeid() {
		return cdotypeid;
	}
	/**
	 * @param cdotypeid the cdotypeid to set
	 */
	public void setCdotypeid(int cdotypeid) {
		this.cdotypeid = cdotypeid;
	}
	/**
	 * @return the resourceid
	 */
	public String getResourceid() {
		return resourceid;
	}
	/**
	 * @param resourceid the resourceid to set
	 */
	public void setResourceid(String resourceid) {
		this.resourceid = resourceid;
	}
	/**
	 * @return the workstationid
	 */
	public String getWorkstationid() {
		return workstationid;
	}
	/**
	 * @param workstationid the workstationid to set
	 */
	public void setWorkstationid(String workstationid) {
		this.workstationid = workstationid;
	}
	/**
	 * @return the computerresourceid
	 */
	public String getComputerresourceid() {
		return computerresourceid;
	}
	/**
	 * @param computerresourceid the computerresourceid to set
	 */
	public void setComputerresourceid(String computerresourceid) {
		this.computerresourceid = computerresourceid;
	}	
	/**
	 * @return the loginTime
	 */
	public Date getLoginTime() {
		return loginTime;
	}
	/**
	 * @param loginTime the loginTime to set
	 */
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
	/**
	 * @return the logoutTime
	 */
	public Date getLogoutTime() {
		return logoutTime;
	}
	/**
	 * @param logoutTime the logoutTime to set
	 */
	public void setLogoutTime(Date logoutTime) {
		this.logoutTime = logoutTime;
	}
	/**
	 * @return the isfrozen
	 */
	public int getIsfrozen() {
		return isfrozen;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}	
}
