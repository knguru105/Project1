package com.omniwyse.sms.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="assignment_types")
public class AssignmentType {
	
	private Long id;
	
	private int assignmentnumber;
	
	private String assignmentname;
	
	private String shortcode;

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getAssignmentnumber() {
		return assignmentnumber;
	}

	public void setAssignmentnumber(int assignmentnumber) {
		this.assignmentnumber = assignmentnumber;
	}

	public String getAssignmentname() {
		return assignmentname;
	}

	public void setAssignmentname(String assignmentname) {
		this.assignmentname = assignmentname;
	}

	public String getShortcode() {
		return shortcode;
	}

	public void setShortcode(String shortcode) {
		this.shortcode = shortcode;
	}

}
