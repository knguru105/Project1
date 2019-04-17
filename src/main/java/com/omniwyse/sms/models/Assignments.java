package com.omniwyse.sms.models;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "assignments")
public class Assignments {

	private Long id;
	private Long subjectid;
	private Long lessonsid;
	private Long classroomid;

	private String assignmentname;
	private String tags;

	private Date dateofassigned;
	private Date assignmentduedate;

	private boolean publishassignment;
	
	private Long assignment_type_id;
	private String instructions;
    private String path;
    private String  imagepath;
    private String video_path;
    private int marks;
    private boolean credit;

    
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

	public boolean isPublishassignment() {
		return publishassignment;
	}

	public void setPublishassignment(boolean publishassignment) {
		this.publishassignment = publishassignment;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getAssignmentname() {
		return assignmentname;
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getLessonsid() {
		return lessonsid;
	}

	public void setLessonsid(Long lessonsid) {
		this.lessonsid = lessonsid;
	}

	public void setAssignmentname(String assignmentname) {
		this.assignmentname = assignmentname;
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

	public Long getClassroomid() {
		return classroomid;
	}

	public void setClassroomid(Long classroomid) {
		this.classroomid = classroomid;
	}

	public Long getSubjectid() {
		return subjectid;
	}

	public void setSubjectid(Long subjectid) {
		this.subjectid = subjectid;
	}

}
