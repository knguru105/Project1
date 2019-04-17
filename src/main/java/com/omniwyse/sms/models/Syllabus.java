package com.omniwyse.sms.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "syllabus")
public class Syllabus {

	private String syllabustype;
	private long id;
	private String description;

	public String getSyllabustype() {
		return syllabustype;
	}

	public void setSyllabustype(String syllabustype) {
		this.syllabustype = syllabustype;
	}

	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
		
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
