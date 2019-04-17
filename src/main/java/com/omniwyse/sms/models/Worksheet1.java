package com.omniwyse.sms.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="worksheets1")
public class Worksheet1 {

	private Long w_id, gradeid, subjectid, status_id;
	private String  worksheet_name, createdby,worksheet_path;
	private Date createdon, modifiedon;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
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

	
	


}