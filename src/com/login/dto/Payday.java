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
@Table(name="payday")
public class Payday implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2380311222189390612L;
	
	@Id
	@Column
	private String payDayId;
	@Column
	private String payDayName;
	@Column
	private int minAmount;
	@Column
	private int maxAmount;
	@Column
	private int interestRate;
	@Column
	private int maxLoanDuration;
	@Column
	private int coolingOfPeriod;
	@Column
	private String description;
	@Column
	private String notes;
	/**
	 * @return the payDayId
	 */
	public String getPayDayId() {
		return payDayId;
	}
	/**
	 * @param payDayId the payDayId to set
	 */
	public void setPayDayId(String payDayId) {
		this.payDayId = payDayId;
	}
	/**
	 * @return the payDayName
	 */
	public String getPayDayName() {
		return payDayName;
	}
	/**
	 * @param payDayName the payDayName to set
	 */
	public void setPayDayName(String payDayName) {
		this.payDayName = payDayName;
	}
	/**
	 * @return the minAmount
	 */
	public int getMinAmount() {
		return minAmount;
	}
	/**
	 * @param minAmount the minAmount to set
	 */
	public void setMinAmount(int minAmount) {
		this.minAmount = minAmount;
	}
	/**
	 * @return the maxAmount
	 */
	public int getMaxAmount() {
		return maxAmount;
	}
	/**
	 * @param maxAmount the maxAmount to set
	 */
	public void setMaxAmount(int maxAmount) {
		this.maxAmount = maxAmount;
	}
	/**
	 * @return the interestRate
	 */
	public int getInterestRate() {
		return interestRate;
	}
	/**
	 * @param interestRate the interestRate to set
	 */
	public void setInterestRate(int interestRate) {
		this.interestRate = interestRate;
	}
	/**
	 * @return the maxLoanDuration
	 */
	public int getMaxLoanDuration() {
		return maxLoanDuration;
	}
	/**
	 * @param maxLoanDuration the maxLoanDuration to set
	 */
	public void setMaxLoanDuration(int maxLoanDuration) {
		this.maxLoanDuration = maxLoanDuration;
	}
	/**
	 * @return the coolingOfPeriod
	 */
	public int getCoolingOfPeriod() {
		return coolingOfPeriod;
	}
	/**
	 * @param coolingOfPeriod the coolingOfPeriod to set
	 */
	public void setCoolingOfPeriod(int coolingOfPeriod) {
		this.coolingOfPeriod = coolingOfPeriod;
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
