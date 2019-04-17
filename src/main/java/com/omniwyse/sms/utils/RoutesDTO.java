package com.omniwyse.sms.utils;

import java.util.List;

public class RoutesDTO {
	private long id;
	private long busid;
	private List<String> stops;
	private String routename;
	private String distance;
	private long routeid;
	private long driverid;
	private long attenderid;
	private long teacherid;
	private long studentid;
	private boolean active;
	private String busnumber;
	private long numberofstops;

	public long getBusid() {
		return busid;
	}

	public void setBusid(long busid) {
		this.busid = busid;
	}

	

	public List<String> getStops() {
		return stops;
	}

	public String getBusnumber() {
		return busnumber;
	}

	public void setBusnumber(String busnumber) {
		this.busnumber = busnumber;
	}

	public long getNumberofstops() {
		return numberofstops;
	}

	public void setNumberofstops(long numberofstops) {
		this.numberofstops = numberofstops;
	}

	public void setStops(List<String> stops) {
		this.stops = stops;
	}

	

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public long getRouteid() {
		return routeid;
	}

	public String getRoutename() {
		return routename;
	}

	public void setRoutename(String routename) {
		this.routename = routename;
	}

	public void setRouteid(long routeid) {
		this.routeid = routeid;
	}

	public long getStudentid() {
		return studentid;
	}

	public long getDriverid() {
		return driverid;
	}

	public void setDriverid(long driverid) {
		this.driverid = driverid;
	}

	public long getAttenderid() {
		return attenderid;
	}

	public void setAttenderid(long attenderid) {
		this.attenderid = attenderid;
	}

	public long getTeacherid() {
		return teacherid;
	}

	public void setTeacherid(long teacherid) {
		this.teacherid = teacherid;
	}

	public void setStudentid(long studentid) {
		this.studentid = studentid;
	}

	public long getId() {
		return id;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public void setId(long id) {
		this.id = id;
	}

}
