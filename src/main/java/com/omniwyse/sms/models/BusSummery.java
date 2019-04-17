package com.omniwyse.sms.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="bus_summery")
public class BusSummery {
	private long id; 
	private long busid;
	private Long routeid; 
	private long noofstudents;
	private Long driverid;
	private Long attenderid;
	private Long  teacherid;
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	
	public long getBusid() {
		return busid;
	}
	public void setBusid(long busid) {
		this.busid = busid;
	}
	public Long getRouteid() {
		return routeid;
	}
	public void setRouteid(Long routeid) {
		this.routeid = routeid;
	}
		public long getNoofstudents() {
		return noofstudents;
	}
	public void setNoofstudents(long noofstudents) {
		this.noofstudents = noofstudents;
	}
		public Long getDriverid() {
		return driverid;
	}
	public void setDriverid(Long driverid) {
		this.driverid = driverid;
	}
	public Long getAttenderid() {
		return attenderid;
	}
	public void setAttenderid(Long attenderid) {
		this.attenderid = attenderid;
	}
	public Long getTeacherid() {
		return teacherid;
	}
	public void setTeacherid(Long teacherid) {
		this.teacherid = teacherid;
	}
		
	
}
