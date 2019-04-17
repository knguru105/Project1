package com.omniwyse.sms.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="worksheets_tags")
public class WorksheetsTags {

	private Long id;
	private String tags;
	private String worksheetid;
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public String getWorksheetid() {
		return worksheetid;
	}
	public void setWorksheetid(String worksheetid) {
		this.worksheetid = worksheetid;
	}
	
	
}
