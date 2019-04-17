package com.omniwyse.sms.models;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "test_create")
public class TestCreate {

	private Long id;
	private Long gradeid;
	private Long testtypeid;
	private Long modeid;
	private Long maxmarks;
	private Long academicid;
	private Long statusid;

	private Date startdate;
	private Date enddate;
	private Date createdon;
	private Date modifiedon;

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getGradeid() {
		return gradeid;
	}

	public void setGradeid(Long gradeid) {
		this.gradeid = gradeid;
	}

	public Long getTesttypeid() {
		return testtypeid;
	}

	public void setTesttypeid(Long testtypeid) {
		this.testtypeid = testtypeid;
	}

	public Long getModeid() {
		return modeid;
	}

	public void setModeid(Long modeid) {
		this.modeid = modeid;
	}

	public Long getMaxmarks() {
		return maxmarks;
	}

	public void setMaxmarks(Long maxmarks) {
		this.maxmarks = maxmarks;
	}

	public Long getAcademicid() {
		return academicid;
	}

	public void setAcademicid(Long academicid) {
		this.academicid = academicid;
	}

	public Long getStatusid() {
		return statusid;
	}

	public void setStatusid(Long statusid) {
		this.statusid = statusid;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

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

}
