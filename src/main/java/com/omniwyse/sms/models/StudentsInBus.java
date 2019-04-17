package com.omniwyse.sms.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="bus_students")
public class StudentsInBus {
	long id; 
	private Long busid; 
	private long studentid;
	private Long routeid;
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Long getBusid() {
		return busid;
	}
	public void setBusid(Long busid) {
		this.busid = busid;
	}
	public long getStudentid() {
		return studentid;
	}
	public void setStudentid(long studentid) {
		this.studentid = studentid;
	}
	public Long getRouteid() {
		return routeid;
	}
	public void setRouteid(Long routeid) {
		this.routeid = routeid;
	} 
	

}
