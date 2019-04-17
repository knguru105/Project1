package com.omniwyse.sms.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="worksheets1_tags")
public class Worksheet1Tags {

	
	private Long tagid, w_id;
	private String tags;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	public Long getTagid() {
		return tagid;
	}
	public void setTagid(Long tagid) {
		this.tagid = tagid;
	}
	public Long getW_id() {
		return w_id;
	}
	public void setW_id(Long w_id) {
		this.w_id = w_id;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}

	
	
	
}
