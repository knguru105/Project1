package com.omniwyse.sms.utils;

import java.util.Date;

public class Worksheet1DTO {

	private Long w_id, gradeid, subjectid, status_id,degreeofdifficultyid;
	public Long getDegreeofdifficultyid() {
		return degreeofdifficultyid;
	}

	public void setDegreeofdifficultyid(Long degreeofdifficultyid) {
		this.degreeofdifficultyid = degreeofdifficultyid;
	}

	private String  worksheet_name, createdby,worksheet_path,questionDescription,context;
	private Date createdon, modifiedon;

	

	//fields of grade table
	private Long gradenumber;
	private String gradename;
	private String syllabustype;
	

	//fields of subject table
	private String subjectname;

	//fields of subject table
	private String description;
	
	//field of degreeofdifficulty table
	private String degreeofdifficulty;

	public Long getW_id() {
		return w_id;
	}

	public void setW_id(Long w_id) {
		this.w_id = w_id;
	}

	public Long getGradeid() {
		return gradeid;
	}

	public void setGradeid(Long gradeid) {
		this.gradeid = gradeid;
	}

	public Long getSubjectid() {
		return subjectid;
	}

	public void setSubjectid(Long subjectid) {
		this.subjectid = subjectid;
	}

	public Long getStatus_id() {
		return status_id;
	}

	public void setStatus_id(Long status_id) {
		this.status_id = status_id;
	}

	public String getWorksheet_name() {
		return worksheet_name;
	}

	public void setWorksheet_name(String worksheet_name) {
		this.worksheet_name = worksheet_name;
	}

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public String getWorksheet_path() {
		return worksheet_path;
	}

	public void setWorksheet_path(String worksheet_path) {
		this.worksheet_path = worksheet_path;
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

	public Long getGradenumber() {
		return gradenumber;
	}

	public void setGradenumber(Long gradenumber) {
		this.gradenumber = gradenumber;
	}

	public String getGradename() {
		return gradename;
	}

	public void setGradename(String gradename) {
		this.gradename = gradename;
	}

	public String getSubjectname() {
		return subjectname;
	}

	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public String getSyllabustype() {
		return syllabustype;
	}

	public void setSyllabustype(String syllabustype) {
		this.syllabustype = syllabustype;
	}

	public String getQuestionDescription() {
		return questionDescription;
	}

	public void setQuestionDescription(String questionDescription) {
		this.questionDescription = questionDescription;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getDegreeofdifficulty() {
		return degreeofdifficulty;
	}

	public void setDegreeofdifficulty(String degreeofdifficulty) {
		this.degreeofdifficulty = degreeofdifficulty;
	}
}
