package com.omniwyse.sms.models;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="stops")
public class Stops {
	private long id; 
	private String stopname;
	private String landmark;
	private double lattitude;
	private double longitude;
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
	public double getLattitude() {
		return lattitude;
	}
	public void setLattitude(double lattitude) {
		this.lattitude = lattitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public String getStopname() {
		return stopname;
	}
	public void setStopname(String stopname) {
		this.stopname = stopname;
	}
	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	
}
