package com.omniwyse.sms.utils;

import java.util.Date;

public class PeriodTypesDTO {

	private Long id;

	private TimeDTO fromtime;
	
	private TimeDTO totime;

	private String name;

	private Long numberofperiods;

	private boolean isDefault;

	private Date createdOn;
	private Date modifiedOn;

	public boolean isDefault() {
		return isDefault;
	}

	public void setDefault_value(boolean value) {
		this.isDefault = value;
	}

	

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public TimeDTO getFromtime() {
		return fromtime;
	}

	public void setFromtime(TimeDTO fromtime) {
		this.fromtime = fromtime;
	}

	public TimeDTO getTotime() {
		return totime;
	}

	public void setTotime(TimeDTO totime) {
		this.totime = totime;
	}

	public Date getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getNumberofperiods() {
		return numberofperiods;
	}

	

	public void setDefault(boolean isDefault) {
		this.isDefault = isDefault;
	}

	public void setNumberofperiods(Long numberofperiods) {
		this.numberofperiods = numberofperiods;
	}

}
