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
@Table(name="salaryfrequency")
public class SalaryFrequency implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5444066533143252514L;
	
	@Id
	@Column
	private String salaryFrequencyId;
	@Column
	private String salaryFrequencyName;
	@Column
	private String description;
	@Column
	private String notes;
	/**
	 * @return the salaryFrequencyId
	 */
	public String getSalaryFrequencyId() {
		return salaryFrequencyId;
	}
	/**
	 * @param salaryFrequencyId the salaryFrequencyId to set
	 */
	public void setSalaryFrequencyId(String salaryFrequencyId) {
		this.salaryFrequencyId = salaryFrequencyId;
	}
	/**
	 * @return the salaryFrequencyName
	 */
	public String getSalaryFrequencyName() {
		return salaryFrequencyName;
	}
	/**
	 * @param salaryFrequencyName the salaryFrequencyName to set
	 */
	public void setSalaryFrequencyName(String salaryFrequencyName) {
		this.salaryFrequencyName = salaryFrequencyName;
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
