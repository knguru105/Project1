package com.omniwyse.sms.models;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name ="periods")
public class Periods {
	
	private Long id;
	
	private Long period_type_id;
	
	private Long period_number;
	
	private Long periodfrom;
	
	private Long periodto;

	private Date createdOn;
    private Date modifiedOn;
    
	
    
    @Id
    @GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Long getPeriod_type_id() {
		return period_type_id;
	}

	public void setPeriod_type_id(Long period_type_id) {
		this.period_type_id = period_type_id;
	}

	public Long getPeriod_number() {
		return period_number;
	}

	public void setPeriod_number(Long period_number) {
		this.period_number = period_number;
	}

	public Long getPeriodfrom() {
		return periodfrom;
	}

	public void setPeriodfrom(Long periodfrom) {
		this.periodfrom = periodfrom;
	}

	public Long getPeriodto() {
		return periodto;
	}

	public void setPeriodto(Long periodto) {
		this.periodto = periodto;
	}

	
	
}