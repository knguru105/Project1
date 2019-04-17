package com.omniwyse.sms.models;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Table(name="academicyears")
public class AcademicYears {
	private Long id;
	private Long passingyear;
	private Date academicyearstarting;
	private Date academicyearending;
	private long active;
	private Date createdon;
	private Date modifiedon;

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getPassingyear() {
		return passingyear;
	}
	public void setPassingyear(Long passingyear) {
		this.passingyear = passingyear;
	}
	public Date getCreatedon() {
		return createdon;
	}
	public void setCreatedon(Date createdon) {
		this.createdon = createdon;
	}
	public Date getModifiedon() {
		return modifiedon;
	}
	public void setModifiedon(Date modifiedon) {
		this.modifiedon = modifiedon;
	}
	public Date getAcademicyearstarting() {
		return academicyearstarting;
	}
	public void setAcademicyearstarting(Date academicyearstarting) {
		this.academicyearstarting = academicyearstarting;
	}
	public Date getAcademicyearending() {
		return academicyearending;
	}
	public void setAcademicyearending(Date academicyearending) {
		this.academicyearending = academicyearending;
	}
	public long getActive() {
		return active;
	}
	public void setActive(long active) {
		this.active = active;
	}

}