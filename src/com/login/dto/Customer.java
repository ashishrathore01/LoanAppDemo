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
@Table(name="customer")
public class Customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1010915656339683745L;
	
	@Id
	@Column
	private String customerId;
	@Column
	private String firstName;
	@Column
	private String middleName;
	@Column
	private String lastName;
	@Column
	private String dob;
	@Column
	private String license;
	@Column
	private String expiry;
	@Column
	private String province;
	@Column
	private String phone;
	@Column
	private String address;
	@Column
	private String bankName;
	@Column
	private String branchName;	
	@Column
	private String instituteNumber;
	@Column
	private String accountNumber;
	@Column
	private String bankAddress;
	@Column
	private String employerName;
	@Column
	private String employerPhone;	
	@Column
	private String supervisorPhone;
	@Column
	private String employerAddress;
	@Column
	private String salaryFrequency;	
	
	/**
	 * @return the customerId
	 */
	public String getCustomerId() {
		return customerId;
	}
	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the middleName
	 */
	public String getMiddleName() {
		return middleName;
	}
	/**
	 * @param middleName the middleName to set
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the dob
	 */
	public String getDob() {
		return dob;
	}
	/**
	 * @param dob the dob to set
	 */
	public void setDob(String dob) {
		this.dob = dob;
	}
	/**
	 * @return the license
	 */
	public String getLicense() {
		return license;
	}
	/**
	 * @param license the license to set
	 */
	public void setLicense(String license) {
		this.license = license;
	}
	/**
	 * @return the expiry
	 */
	public String getExpiry() {
		return expiry;
	}
	/**
	 * @param expiry the expiry to set
	 */
	public void setExpiry(String expiry) {
		this.expiry = expiry;
	}
	/**
	 * @return the province
	 */
	public String getProvince() {
		return province;
	}
	/**
	 * @param province the province to set
	 */
	public void setProvince(String province) {
		this.province = province;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the bankName
	 */
	public String getBankName() {
		return bankName;
	}
	/**
	 * @param bankName the bankName to set
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	/**
	 * @return the branchNumber
	 */
	public String getBranchName() {
		return branchName;
	}
	/**
	 * @param branchNumber the branchNumber to set
	 */
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	/**
	 * @return the instituteNumber
	 */
	public String getInstituteNumber() {
		return instituteNumber;
	}
	/**
	 * @param instituteNumber the instituteNumber to set
	 */
	public void setInstituteNumber(String instituteNumber) {
		this.instituteNumber = instituteNumber;
	}
	/**
	 * @return the accountNumber
	 */
	public String getAccountNumber() {
		return accountNumber;
	}
	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	/**
	 * @return the bankAddress
	 */
	public String getBankAddress() {
		return bankAddress;
	}
	/**
	 * @param bankAddress the bankAddress to set
	 */
	public void setBankAddress(String bankAddress) {
		this.bankAddress = bankAddress;
	}
	/**
	 * @return the salaryFrequency
	 */
	public String getSalaryFrequency() {
		return salaryFrequency;
	}
	/**
	 * @param salaryFrequency the salaryFrequency to set
	 */
	public void setSalaryFrequency(String salaryFrequency) {
		this.salaryFrequency = salaryFrequency;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	/**
	 * @return the employerName
	 */
	public String getEmployerName() {
		return employerName;
	}
	/**
	 * @param employerName the employerName to set
	 */
	public void setEmployerName(String employerName) {
		this.employerName = employerName;
	}
	/**
	 * @return the employerPhone
	 */
	public String getEmployerPhone() {
		return employerPhone;
	}
	/**
	 * @param employerPhone the employerPhone to set
	 */
	public void setEmployerPhone(String employerPhone) {
		this.employerPhone = employerPhone;
	}
	/**
	 * @return the supervisorPhone
	 */
	public String getSupervisorPhone() {
		return supervisorPhone;
	}
	/**
	 * @param supervisorPhone the supervisorPhone to set
	 */
	public void setSupervisorPhone(String supervisorPhone) {
		this.supervisorPhone = supervisorPhone;
	}
	/**
	 * @return the employerAddress
	 */
	public String getEmployerAddress() {
		return employerAddress;
	}
	/**
	 * @param employerAddress the employerAddress to set
	 */
	public void setEmployerAddress(String employerAddress) {
		this.employerAddress = employerAddress;
	}	
}