package com.omniwyse.sms.models;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "ischollworksheets_assigned")
public class Ischollworksheetsassigned {

	private Long id;
	private Long classroomid;
	private Long lessonsid;
	private Long subjectid;
    private Long worksheetid;
	private Date dateofassigned;
	private Date worksheetduedate;

	private String worksheetname;
	private String publishworksheet;
	private String vendor;
	private String worksheetpath;

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public Long getWorksheetid() {
		return worksheetid;
	}

	public void setWorksheetid(Long worksheetid) {
		this.worksheetid = worksheetid;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getClassroomid() {
		return classroomid;
	}

	public void setClassroomid(Long classroomid) {
		this.classroomid = classroomid;
	}

	public Long getLessonsid() {
		return lessonsid;
	}

	public void setLessonsid(Long lessonsid) {
		this.lessonsid = lessonsid;
	}

	public Long getSubjectid() {
		return subjectid;
	}

	public void setSubjectid(Long subjectid) {
		this.subjectid = subjectid;
	}

	public Date getDateofassigned() {
		return dateofassigned;
	}

	public void setDateofassigned(Date dateofassigned) {
		this.dateofassigned = dateofassigned;
	}

	public Date getWorksheetduedate() {
		return worksheetduedate;
	}

	public void setWorksheetduedate(Date worksheetduedate) {
		this.worksheetduedate = worksheetduedate;
	}

	public String getWorksheetname() {
		return worksheetname;
	}

	public void setWorksheetname(String worksheetname) {
		this.worksheetname = worksheetname;
	}

	public String getPublishworksheet() {
		return publishworksheet;
	}

	public void setPublishworksheet(String publishworksheet) {
		this.publishworksheet = publishworksheet;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getWorksheetpath() {
		return worksheetpath;
	}

	public void setWorksheetpath(String worksheetpath) {
		this.worksheetpath = worksheetpath;
	}

}