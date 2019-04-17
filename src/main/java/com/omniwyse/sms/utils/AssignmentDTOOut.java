package com.omniwyse.sms.utils;

import java.util.Date;

public class AssignmentDTOOut {

	private Long id;

	private Date assignedid;
	private Date dateofassigned;
	private Date duedate;
	private Date assignmentduedate;

	private String subjectname;
	private String lessonname;
	private String assignmentname;
	private String tags;

	private boolean publishassignment;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getAssignedid() {
		return assignedid;
	}

	public void setAssignedid(Date assignedid) {
		this.assignedid = assignedid;
	}

	public Date getDateofassigned() {
		return dateofassigned;
	}

	public void setDateofassigned(Date dateofassigned) {
		this.dateofassigned = dateofassigned;
	}

	public Date getDuedate() {
		return duedate;
	}

	public void setDuedate(Date duedate) {
		this.duedate = duedate;
	}

	public Date getAssignmentduedate() {
		return assignmentduedate;
	}

	public void setAssignmentduedate(Date assignmentduedate) {
		this.assignmentduedate = assignmentduedate;
	}

	public String getSubjectname() {
		return subjectname;
	}

	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
	}

	public String getLessonname() {
		return lessonname;
	}

	public void setLessonname(String lessonname) {
		this.lessonname = lessonname;
	}

	public String getAssignmentname() {
		return assignmentname;
	}

	public void setAssignmentname(String assignmentname) {
		this.assignmentname = assignmentname;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public boolean isPublishassignment() {
		return publishassignment;
	}

	public void setPublishassignment(boolean publishassignment) {
		this.publishassignment = publishassignment;
	}

}
