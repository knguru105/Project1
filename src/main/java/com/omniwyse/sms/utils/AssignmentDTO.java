package com.omniwyse.sms.utils;

import java.util.Date;

public class AssignmentDTO {

	private Long id;
	private Long assignedid;
	private Date dateofassigned;
	private Date assignmentduedate;

	private String subjectname;
	private String lessonname;
	private String assignmentname;
	private String tags;

	private boolean publishassignment;
	
	private Long assignment_type_id;
	private String instructions;
    private String path;
    private String  imagepath;
    private String video_path;
    private int marks;
    private boolean credit;
	
	public Long getId() {
		return id;
	}

	public Long getAssignment_type_id() {
		return assignment_type_id;
	}

	public void setAssignment_type_id(Long assignment_type_id) {
		this.assignment_type_id = assignment_type_id;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getImagepath() {
		return imagepath;
	}

	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}

	public String getVideo_path() {
		return video_path;
	}

	public void setVideo_path(String video_path) {
		this.video_path = video_path;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public boolean isCredit() {
		return credit;
	}

	public void setCredit(boolean credit) {
		this.credit = credit;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAssignedid() {
		return assignedid;
	}

	public void setAssignedid(Long assignedid) {
		this.assignedid = assignedid;
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

	public Date getDateofassigned() {
		return dateofassigned;
	}

	public void setDateofassigned(Date dateofassigned) {
		this.dateofassigned = dateofassigned;
	}

	public Date getAssignmentduedate() {
		return assignmentduedate;
	}

	public void setAssignmentduedate(Date assignmentduedate) {
		this.assignmentduedate = assignmentduedate;
	}
}