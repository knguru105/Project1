package com.omniwyse.sms.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="addresses")
public class StaffAddresses {
	private long id ;
	private String doornumber;
	private String line1;	
	private String line2; 	
	private String village; 
	private String city; 	
	private String district; 
	private String state;	
	private long pin;
	private long staffid;
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDoornumber() {
		return doornumber;
	}
	public void setDoornumber(String doornumber) {
		this.doornumber = doornumber;
	}
	public String getLine1() {
		return line1;
	}
	public void setLine1(String line1) {
		this.line1 = line1;
	}
	public String getLine2() {
		return line2;
	}
	public void setLine2(String line2) {
		this.line2 = line2;
	}
	public String getVillage() {
		return village;
	}
	public void setVillage(String village) {
		this.village = village;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	public long getPin() {
		return pin;
	}
	public void setPin(long pin) {
		this.pin = pin;
	}
	public long getStaffid() {
		return staffid;
	}
	public void setStaffid(long staffid) {
		this.staffid = staffid;
	}
	
	
	
}
