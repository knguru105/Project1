package com.omniwyse.sms.utils;

public class RoutesDisplayDTO {
	private String stops;
	private String routename;
	private String distance;
	private String busnumber;
	private Long busid;
	private long numberofstops;
	private Long id;
	private String registrationnumber;
	public String getStops() {
		return stops;
	}
	public String getRegistrationnumber() {
		return registrationnumber;
	}
	public void setRegistrationnumber(String registrationnumber) {
		this.registrationnumber = registrationnumber;
	}
	public void setStops(String stops) {
		this.stops = stops;
	}
	public String getRoutename() {
		return routename;
	}
	public void setRoutename(String routename) {
		this.routename = routename;
	}
	public String getDistance() {
		return distance;
	}
	
	public Long getBusid() {
		return busid;
	}
	public void setBusid(Long busid) {
		this.busid = busid;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setDistance(String distance) {
		this.distance = distance;
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
	

}
