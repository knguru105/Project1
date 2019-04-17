package com.omniwyse.sms.models;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="buses")
public class Buses {
	private long id ;
	private String busnumber; 
	private String busname;
	private String modelnumber; 
	private String color; 
	private long noofseats; 
	private String bustype;
	private Date manufacturingdate; 
	private String companyname; 
	private boolean active;
	private Date joindate; 
	private String registrationnumber; 
	private Date createdon;
	private Date modifiedon;
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
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}
		
	public void setId(long id) {
		this.id = id;
	}
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getBusnumber() {
		return busnumber;
	}
	
	public void setBusnumber(String busnumber) {
		this.busnumber = busnumber;
	}
	public String getBusname() {
		return busname;
	}
	public void setBusname(String busname) {
		this.busname = busname;
	}
	public String getModelnumber() {
		return modelnumber;
	}
	public void setModelnumber(String modelnumber) {
		this.modelnumber = modelnumber;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public long getNoofseats() {
		return noofseats;
	}
	public void setNoofseats(long noofseats) {
		this.noofseats = noofseats;
	}
	public String getBustype() {
		return bustype;
	}
	public void setBustype(String bustype) {
		this.bustype = bustype;
	}
	public Date getManufacturingdate() {
		return manufacturingdate;
	}
	public void setManufacturingdate(Date manufacturingdate) {
		this.manufacturingdate = manufacturingdate;
	}
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	public Date getJoindate() {
		return joindate;
	}
	public void setJoindate(Date joindate) {
		this.joindate = joindate;
	}
	public String getRegistrationnumber() {
		return registrationnumber;
	}
	public void setRegistrationnumber(String registrationnumber) {
		this.registrationnumber = registrationnumber;
	}
	
		
}
