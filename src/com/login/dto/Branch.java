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
@Table(name = "branch")
public class Branch implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4134061372593618727L;
	@Id
	@Column
	private String branchid;
	@Column
	private String branchname;
	@Column
	private String branchaddress;
	@Column
	private int branchphone;
	@Column
	private int branchfax;
	@Column
	private int iconid;
	@Column
	private int isfrozen;
	@Column
	private float maxtimesincemsgsretrived;
	@Column
	private String mfgcalendarid;
	@Column
	private String notes;
	@Column
	private String organizationid;
	@Column
	private String printqueueid;
	@Column
	private String reportheading;
	@Column
	private int requirelocation;
	@Column
	private int retentiondays;
	@Column
	private String smtptransportid;
	@Column
	private String trainingreqgroupid;
	@Column
	private String wipmsgdefmgrid;
	@Column
	private int canreopenloan;
	@Column
	private int canreopencc;
	@Column
	private int certexpirydays;
	@Column
	private String certnotokstatusid;
	@Column
	private String certokstatusid;
	@Column
	private String concatenationcharacter;
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
	 * @return the branchname
	 */
	public String getBranchname() {
		return branchname;
	}
	/**
	 * @param branchname the branchname to set
	 */
	public void setBranchname(String branchname) {
		this.branchname = branchname;
	}
	/**
	 * @return the branchaddress
	 */
	public String getBranchaddress() {
		return branchaddress;
	}
	/**
	 * @param branchaddress the branchaddress to set
	 */
	public void setBranchaddress(String branchaddress) {
		this.branchaddress = branchaddress;
	}
	/**
	 * @return the branchphone
	 */
	public int getBranchphone() {
		return branchphone;
	}
	/**
	 * @param branchphone the branchphone to set
	 */
	public void setBranchphone(int branchphone) {
		this.branchphone = branchphone;
	}
	/**
	 * @return the branchfax
	 */
	public int getBranchfax() {
		return branchfax;
	}
	/**
	 * @param branchfax the branchfax to set
	 */
	public void setBranchfax(int branchfax) {
		this.branchfax = branchfax;
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
	 * @return the maxtimesincemsgsretrived
	 */
	public float getMaxtimesincemsgsretrived() {
		return maxtimesincemsgsretrived;
	}
	/**
	 * @param maxtimesincemsgsretrived the maxtimesincemsgsretrived to set
	 */
	public void setMaxtimesincemsgsretrived(float maxtimesincemsgsretrived) {
		this.maxtimesincemsgsretrived = maxtimesincemsgsretrived;
	}
	/**
	 * @return the mfgcalendarid
	 */
	public String getMfgcalendarid() {
		return mfgcalendarid;
	}
	/**
	 * @param mfgcalendarid the mfgcalendarid to set
	 */
	public void setMfgcalendarid(String mfgcalendarid) {
		this.mfgcalendarid = mfgcalendarid;
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
	 * @return the reportheading
	 */
	public String getReportheading() {
		return reportheading;
	}
	/**
	 * @param reportheading the reportheading to set
	 */
	public void setReportheading(String reportheading) {
		this.reportheading = reportheading;
	}
	/**
	 * @return the requirelocation
	 */
	public int getRequirelocation() {
		return requirelocation;
	}
	/**
	 * @param requirelocation the requirelocation to set
	 */
	public void setRequirelocation(int requirelocation) {
		this.requirelocation = requirelocation;
	}
	/**
	 * @return the retentiondays
	 */
	public int getRetentiondays() {
		return retentiondays;
	}
	/**
	 * @param retentiondays the retentiondays to set
	 */
	public void setRetentiondays(int retentiondays) {
		this.retentiondays = retentiondays;
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
	 * @return the trainingreqgroupid
	 */
	public String getTrainingreqgroupid() {
		return trainingreqgroupid;
	}
	/**
	 * @param trainingreqgroupid the trainingreqgroupid to set
	 */
	public void setTrainingreqgroupid(String trainingreqgroupid) {
		this.trainingreqgroupid = trainingreqgroupid;
	}
	/**
	 * @return the wipmsgdefmgrid
	 */
	public String getWipmsgdefmgrid() {
		return wipmsgdefmgrid;
	}
	/**
	 * @param wipmsgdefmgrid the wipmsgdefmgrid to set
	 */
	public void setWipmsgdefmgrid(String wipmsgdefmgrid) {
		this.wipmsgdefmgrid = wipmsgdefmgrid;
	}
	/**
	 * @return the canreopenloan
	 */
	public int getCanreopenloan() {
		return canreopenloan;
	}
	/**
	 * @param canreopenloan the canreopenloan to set
	 */
	public void setCanreopenloan(int canreopenloan) {
		this.canreopenloan = canreopenloan;
	}
	/**
	 * @return the canreopencc
	 */
	public int getCanreopencc() {
		return canreopencc;
	}
	/**
	 * @param canreopencc the canreopencc to set
	 */
	public void setCanreopencc(int canreopencc) {
		this.canreopencc = canreopencc;
	}
	/**
	 * @return the certexpirydays
	 */
	public int getCertexpirydays() {
		return certexpirydays;
	}
	/**
	 * @param certexpirydays the certexpirydays to set
	 */
	public void setCertexpirydays(int certexpirydays) {
		this.certexpirydays = certexpirydays;
	}
	/**
	 * @return the certnotokstatusid
	 */
	public String getCertnotokstatusid() {
		return certnotokstatusid;
	}
	/**
	 * @param certnotokstatusid the certnotokstatusid to set
	 */
	public void setCertnotokstatusid(String certnotokstatusid) {
		this.certnotokstatusid = certnotokstatusid;
	}
	/**
	 * @return the certokstatusid
	 */
	public String getCertokstatusid() {
		return certokstatusid;
	}
	/**
	 * @param certokstatusid the certokstatusid to set
	 */
	public void setCertokstatusid(String certokstatusid) {
		this.certokstatusid = certokstatusid;
	}
	/**
	 * @return the concatenationcharacter
	 */
	public String getConcatenationcharacter() {
		return concatenationcharacter;
	}
	/**
	 * @param concatenationcharacter the concatenationcharacter to set
	 */
	public void setConcatenationcharacter(String concatenationcharacter) {
		this.concatenationcharacter = concatenationcharacter;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}			
}
