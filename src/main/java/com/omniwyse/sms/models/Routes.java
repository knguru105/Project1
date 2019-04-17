package com.omniwyse.sms.models;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "routes")
public class Routes {
	private long id;
	private String routename;
	private String stops;
	private String distance;
	private long numberofstops;
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

	public String getRoutename() {
		return routename;
	}

	public long getNumberofstops() {
		return numberofstops;
	}

	public void setNumberofstops(long numberofstops) {
		this.numberofstops = numberofstops;
	}

	public void setRoutename(String routename) {
		this.routename = routename;
	}

	public String getStops() {
		return stops;
	}

	public void setStops(String stops) {
		this.stops = stops;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

}
