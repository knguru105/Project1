package com.omniwyse.sms.models;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "classroom_attendance")
public class ClassroomAttendance {
	
	private Long id;
	private Long studentid;
	private Long classroomid;
	
	private Long attendancestatus;
	private Long subjectid;
	
	private Date dateofattendance;

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getStudentid() {
		return studentid;
	}

	public void setStudentid(Long studentid) {
		this.studentid = studentid;
	}

	public Long getClassroomid() {
		return classroomid;
	}

	public void setClassroomid(Long classroomid) {
		this.classroomid = classroomid;
	}

	public Long getAttendancestatus() {
		return attendancestatus;
	}

	public void setAttendancestatus(Long attendancestatus) {
		this.attendancestatus = attendancestatus;
	}

	public Long getSubjectid() {
		return subjectid;
	}

	public void setSubjectid(Long subjectid) {
		this.subjectid = subjectid;
	}

	public Date getDateofattendance() {
		return dateofattendance;
	}

	public void setDateofattendance(Date dateofattendance) {
		this.dateofattendance = dateofattendance;
	}
	
}