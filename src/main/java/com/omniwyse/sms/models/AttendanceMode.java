package com.omniwyse.sms.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="school_attendance")
public class AttendanceMode {
	
	private Long id;
	private boolean status;
	
	private String attendance_type;

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getAttendance_type() {
		return attendance_type;
	}
	public void setAttendance_type(String attendance_type) {
		this.attendance_type = attendance_type;
	}
}
