/**
 * 
 */
package com.login.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author rathoras
 *
 */
@Entity
@Table(name="employee")
public class Employee implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -995025785842696367L;
	@Id
	@Column
	private String employeeid;
	@Column
	private String employeename;
	@Column
	private int allowoverrideofsessionvalues;	
	@Column
	private int canlogin;
	@Column
	private int changecount;
	@Column
	private String changestatusid;
	@Column
	private String description;
	@Column
	private String fullname;
	@Column
	private int iconid;
	@Column
	private String menudefinitionid;
	@Column
	private String sessionvaluesid;
	@Column
	private String usercomment;
	@Column
	private String languagedictionaryid;
	@Column
	private String terminologydictionaryid;
	@Column
	private String historyviewid;
	@Column
	private String notes;
	@Column
	private int cdotypeid;
	@Column
	private String esigrolegroupid;
	@Column
	private String trainingplanid;
	@Column
	private String emailaddress;
	@Column
	private String uiportalprofileid;
	@Column
	private String primaryorganizationid;
	@Column
	private String branchid;
	@Column
	private String portalmenudefinitionid;
	@Column
	private int mdallowmultiplesignin;
	@Column
	private String password;
	
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
	 * @return the employeename
	 */
	public String getEmployeename() {
		return employeename;
	}
	/**
	 * @param employeename the employeename to set
	 */
	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}
	/**
	 * @return the allowoverrideofsessionvalues
	 */
	public int getAllowoverrideofsessionvalues() {
		return allowoverrideofsessionvalues;
	}
	/**
	 * @param allowoverrideofsessionvalues the allowoverrideofsessionvalues to set
	 */
	public void setAllowoverrideofsessionvalues(int allowoverrideofsessionvalues) {
		this.allowoverrideofsessionvalues = allowoverrideofsessionvalues;
	}
	/**
	 * @return the canlogin
	 */
	public int getCanlogin() {
		return canlogin;
	}
	/**
	 * @param canlogin the canlogin to set
	 */
	public void setCanlogin(int canlogin) {
		this.canlogin = canlogin;
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
	 * @return the changestatusid
	 */
	public String getChangestatusid() {
		return changestatusid;
	}
	/**
	 * @param changestatusid the changestatusid to set
	 */
	public void setChangestatusid(String changestatusid) {
		this.changestatusid = changestatusid;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the fullname
	 */
	public String getFullname() {
		return fullname;
	}
	/**
	 * @param fullname the fullname to set
	 */
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	/**
	 * @return the iconid
	 */
	public int getIconid() {
		return iconid;
	}
	/**
	 * @param iconid the iconid to set
	 */
	public void setIconid(int iconid) {
		this.iconid = iconid;
	}
	/**
	 * @return the menudefinitionid
	 */
	public String getMenudefinitionid() {
		return menudefinitionid;
	}
	/**
	 * @param menudefinitionid the menudefinitionid to set
	 */
	public void setMenudefinitionid(String menudefinitionid) {
		this.menudefinitionid = menudefinitionid;
	}
	/**
	 * @return the sessionvaluesid
	 */
	public String getSessionvaluesid() {
		return sessionvaluesid;
	}
	/**
	 * @param sessionvaluesid the sessionvaluesid to set
	 */
	public void setSessionvaluesid(String sessionvaluesid) {
		this.sessionvaluesid = sessionvaluesid;
	}
	/**
	 * @return the usercomment
	 */
	public String getUsercomment() {
		return usercomment;
	}
	/**
	 * @param usercomment the usercomment to set
	 */
	public void setUsercomment(String usercomment) {
		this.usercomment = usercomment;
	}
	/**
	 * @return the languagedictionaryid
	 */
	public String getLanguagedictionaryid() {
		return languagedictionaryid;
	}
	/**
	 * @param languagedictionaryid the languagedictionaryid to set
	 */
	public void setLanguagedictionaryid(String languagedictionaryid) {
		this.languagedictionaryid = languagedictionaryid;
	}
	/**
	 * @return the terminologydictionaryid
	 */
	public String getTerminologydictionaryid() {
		return terminologydictionaryid;
	}
	/**
	 * @param terminologydictionaryid the terminologydictionaryid to set
	 */
	public void setTerminologydictionaryid(String terminologydictionaryid) {
		this.terminologydictionaryid = terminologydictionaryid;
	}
	/**
	 * @return the historyviewid
	 */
	public String getHistoryviewid() {
		return historyviewid;
	}
	/**
	 * @param historyviewid the historyviewid to set
	 */
	public void setHistoryviewid(String historyviewid) {
		this.historyviewid = historyviewid;
	}
	/**
	 * @return the notes
	 */
	public String getNotes() {
		return notes;
	}
	/**
	 * @param notes the notes to set
	 */
	public void setNotes(String notes) {
		this.notes = notes;
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
	 * @return the esigrolegroupid
	 */
	public String getEsigrolegroupid() {
		return esigrolegroupid;
	}
	/**
	 * @param esigrolegroupid the esigrolegroupid to set
	 */
	public void setEsigrolegroupid(String esigrolegroupid) {
		this.esigrolegroupid = esigrolegroupid;
	}
	/**
	 * @return the trainingplanid
	 */
	public String getTrainingplanid() {
		return trainingplanid;
	}
	/**
	 * @param trainingplanid the trainingplanid to set
	 */
	public void setTrainingplanid(String trainingplanid) {
		this.trainingplanid = trainingplanid;
	}
	/**
	 * @return the emailaddress
	 */
	public String getEmailaddress() {
		return emailaddress;
	}
	/**
	 * @param emailaddress the emailaddress to set
	 */
	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}
	/**
	 * @return the uiportalprofileid
	 */
	public String getUiportalprofileid() {
		return uiportalprofileid;
	}
	/**
	 * @param uiportalprofileid the uiportalprofileid to set
	 */
	public void setUiportalprofileid(String uiportalprofileid) {
		this.uiportalprofileid = uiportalprofileid;
	}
	/**
	 * @return the primaryorganizationid
	 */
	public String getPrimaryorganizationid() {
		return primaryorganizationid;
	}
	/**
	 * @param primaryorganizationid the primaryorganizationid to set
	 */
	public void setPrimaryorganizationid(String primaryorganizationid) {
		this.primaryorganizationid = primaryorganizationid;
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
	 * @return the portalmenudefinitionid
	 */
	public String getPortalmenudefinitionid() {
		return portalmenudefinitionid;
	}
	/**
	 * @param portalmenudefinitionid the portalmenudefinitionid to set
	 */
	public void setPortalmenudefinitionid(String portalmenudefinitionid) {
		this.portalmenudefinitionid = portalmenudefinitionid;
	}
	/**
	 * @return the mdallowmultiplesignin
	 */
	public int getMdallowmultiplesignin() {
		return mdallowmultiplesignin;
	}
	/**
	 * @param mdallowmultiplesignin the mdallowmultiplesignin to set
	 */
	public void setMdallowmultiplesignin(int mdallowmultiplesignin) {
		this.mdallowmultiplesignin = mdallowmultiplesignin;
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
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
