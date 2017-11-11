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
@Table(name="organization")
public class Organization implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -552275063633508426L;
	@Id
	@Column
	private String organizationid;
	@Column
	private String organizationname;
	@Column
	private String organizationnumber;
	@Column
	private String parentorganizationid;
	@Column
	private String portalhomepageid;
	@Column
	private String printqueueid;
	@Column
	private String smtptransportid;
	@Column
	private int userrequiredforesig;
	@Column
	private int cdotypeid;
	@Column
	private int changecount;
	@Column
	private String changehistoryid;
	@Column
	private int collectesigforallqualitytxns;
	@Column
	private String description;
	@Column
	private int iconid;
	@Column
	private int isfrozen;
	@Column
	private String notes;
	/**
	 * @return the organizationid
	 */
	public String getOrganizationid() {
		return organizationid;
	}
	/**
	 * @param organizationid the organizationid to set
	 */
	public void setOrganizationid(String organizationid) {
		this.organizationid = organizationid;
	}
	/**
	 * @return the organizationname
	 */
	public String getOrganizationname() {
		return organizationname;
	}
	/**
	 * @param organizationname the organizationname to set
	 */
	public void setOrganizationname(String organizationname) {
		this.organizationname = organizationname;
	}
	/**
	 * @return the organizationnumber
	 */
	public String getOrganizationnumber() {
		return organizationnumber;
	}
	/**
	 * @param organizationnumber the organizationnumber to set
	 */
	public void setOrganizationnumber(String organizationnumber) {
		this.organizationnumber = organizationnumber;
	}
	/**
	 * @return the parentorganizationid
	 */
	public String getParentorganizationid() {
		return parentorganizationid;
	}
	/**
	 * @param parentorganizationid the parentorganizationid to set
	 */
	public void setParentorganizationid(String parentorganizationid) {
		this.parentorganizationid = parentorganizationid;
	}
	/**
	 * @return the portalhomepageid
	 */
	public String getPortalhomepageid() {
		return portalhomepageid;
	}
	/**
	 * @param portalhomepageid the portalhomepageid to set
	 */
	public void setPortalhomepageid(String portalhomepageid) {
		this.portalhomepageid = portalhomepageid;
	}
	/**
	 * @return the printqueueid
	 */
	public String getPrintqueueid() {
		return printqueueid;
	}
	/**
	 * @param printqueueid the printqueueid to set
	 */
	public void setPrintqueueid(String printqueueid) {
		this.printqueueid = printqueueid;
	}
	/**
	 * @return the smtptransportid
	 */
	public String getSmtptransportid() {
		return smtptransportid;
	}
	/**
	 * @param smtptransportid the smtptransportid to set
	 */
	public void setSmtptransportid(String smtptransportid) {
		this.smtptransportid = smtptransportid;
	}
	/**
	 * @return the userrequiredforesig
	 */
	public int getUserrequiredforesig() {
		return userrequiredforesig;
	}
	/**
	 * @param userrequiredforesig the userrequiredforesig to set
	 */
	public void setUserrequiredforesig(int userrequiredforesig) {
		this.userrequiredforesig = userrequiredforesig;
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
	 * @return the changehistoryid
	 */
	public String getChangehistoryid() {
		return changehistoryid;
	}
	/**
	 * @param changehistoryid the changehistoryid to set
	 */
	public void setChangehistoryid(String changehistoryid) {
		this.changehistoryid = changehistoryid;
	}
	/**
	 * @return the collectesigforallqualitytxns
	 */
	public int getCollectesigforallqualitytxns() {
		return collectesigforallqualitytxns;
	}
	/**
	 * @param collectesigforallqualitytxns the collectesigforallqualitytxns to set
	 */
	public void setCollectesigforallqualitytxns(int collectesigforallqualitytxns) {
		this.collectesigforallqualitytxns = collectesigforallqualitytxns;
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
	 * @return the isfrozen
	 */
	public int getIsfrozen() {
		return isfrozen;
	}
	/**
	 * @param isfrozen the isfrozen to set
	 */
	public void setIsfrozen(int isfrozen) {
		this.isfrozen = isfrozen;
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
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
			
}
