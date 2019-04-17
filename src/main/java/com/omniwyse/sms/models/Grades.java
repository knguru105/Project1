package com.omniwyse.sms.models;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
		
@Table(name = "grades")
public class Grades  {

	private long id;
	private long gradenumber;
	private String gradename;
	private Date createdon;
	private Date modifiedon;
	private String syllabustype;

	
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

	public long getGradenumber() {
		return gradenumber;
	}

	public void setGradenumber(long gradenumber) {
		this.gradenumber = gradenumber;
	}

	public String getGradename() {
		return gradename;
	}

	public void setGradename(String gradename) {
		this.gradename = gradename;
	}

	public String getSyllabustype() {
		return syllabustype;
	}

	public void setSyllabustype(String syllabustype) {
		this.syllabustype = syllabustype;
	}

}
