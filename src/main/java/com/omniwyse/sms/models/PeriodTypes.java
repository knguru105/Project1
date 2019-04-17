package com.omniwyse.sms.models;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "period_type")
public class PeriodTypes {
	
	private Long id;
	
	private String name;
	
	
	private Long fromtime;
    
	private Long totime;
	
	private Long numberofperiods;
	
	private boolean default_value;

	private Date createdOn;
   
	private Date modifiedOn;
    
	

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public Long getFromtime() {
		return fromtime;
	}

	public void setFromtime(Long fromtime) {
		this.fromtime = fromtime;
	}

	public Long getTotime() {
		return totime;
	}

	public void setTotime(Long totime) {
		this.totime = totime;
	}

	public Long getNumberofperiods() {
		return numberofperiods;
	}

	public void setNumberofperiods(Long numberofperiods) {
		this.numberofperiods = numberofperiods;
	}

	public boolean isDefault_value() {
		return default_value;
	}

	public void setDefault_value(boolean default_value) {
		this.default_value = default_value;
	}

	
}