package com.omniwyse.sms.utils;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Table(name="academicyears")
public class AcademicYearsDTO {
	private Long id;
	private Long passingyear;
	private Date academicyearstarting;
	private Long academicyearstartdt;
	private Long academicyearenddt;
	private Date academicyearending;
	private long active;
	
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
	public Date getAcademicyearstarting() {
		return academicyearstarting;
	}
	public Long getAcademicyearstartdt() {
		return academicyearstartdt;
	}
	public void setAcademicyearstartdt(Long academicyearstartdt) {
		this.academicyearstartdt = academicyearstartdt;
	}
	public Long getAcademicyearenddt() {
		return academicyearenddt;
	}
	public void setAcademicyearenddt(Long academicyearenddt) {
		this.academicyearenddt = academicyearenddt;
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
