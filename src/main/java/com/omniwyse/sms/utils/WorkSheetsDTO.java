package com.omniwyse.sms.utils;

public class WorkSheetsDTO {

	private Long id;
	private Long gradeid;
	private Long dateofassigned;
	private Long duedate;
	private Long worksheetduedate;
	private Long worksheetid;
	private String lessonname;
	private String worksheetname;
	private String degreeofdifficulty;
	private String subjectname;
	private String tags;
	private String description;
	private String worksheetpath;
	private String filePath;

	private byte[] worksheet;
	private String createdby;
	private boolean publishworksheet;

	private boolean isworksheetfromLibrary;
	
	public boolean isIsworksheetfromLibrary() {
		return isworksheetfromLibrary;
	}

	public void setIsworksheetfromLibrary(boolean isworksheetfromLibrary) {
		this.isworksheetfromLibrary = isworksheetfromLibrary;
	}

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

	public Long getDateofassigned() {
		return dateofassigned;
	}

	public void setDateofassigned(Long dateofassigned) {
		this.dateofassigned = dateofassigned;
	}

	public Long getDuedate() {
		return duedate;
	}

	public void setDuedate(Long duedate) {
		this.duedate = duedate;
	}

	public Long getWorksheetduedate() {
		return worksheetduedate;
	}

	public void setWorksheetduedate(Long worksheetduedate) {
		this.worksheetduedate = worksheetduedate;
	}

	public Long getWorksheetid() {
		return worksheetid;
	}

	public void setWorksheetid(Long worksheetid) {
		this.worksheetid = worksheetid;
	}

	public String getLessonname() {
		return lessonname;
	}

	public void setLessonname(String lessonname) {
		this.lessonname = lessonname;
	}

	public String getWorksheetname() {
		return worksheetname;
	}

	public void setWorksheetname(String worksheetname) {
		this.worksheetname = worksheetname;
	}

	public String getDegreeofdifficulty() {
		return degreeofdifficulty;
	}

	public void setDegreeofdifficulty(String degreeofdifficulty) {
		this.degreeofdifficulty = degreeofdifficulty;
	}

	public String getSubjectname() {
		return subjectname;
	}

	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getWorksheetpath() {
		return worksheetpath;
	}

	public void setWorksheetpath(String worksheetpath) {
		this.worksheetpath = worksheetpath;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public byte[] getWorksheet() {
		return worksheet;
	}

	public void setWorksheet(byte[] worksheet) {
		this.worksheet = worksheet;
	}

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public boolean isPublishworksheet() {
		return publishworksheet;
	}

	public void setPublishworksheet(boolean publishworksheet) {
		this.publishworksheet = publishworksheet;
	}

}