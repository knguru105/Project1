package com.omniwyse.sms.models;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "lessons")
public class Lessons {

	private Long id;
	private Long subjectid;
	private Long classroomid;

	private String lessondescription;
	private String lessonname;
	private String status;

	private Date lessonstartdate;

	private boolean publishtimeline;

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isPublishtimeline() {
		return publishtimeline;
	}

	public void setPublishtimeline(boolean publishtimeline) {
		this.publishtimeline = publishtimeline;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getLessonstartdate() {
		return lessonstartdate;
	}

	public void setLessonstartdate(Date lessonstartdate) {
		this.lessonstartdate = lessonstartdate;
	}

	public String getLessonname() {
		return lessonname;
	}

	public void setLessonname(String lessonname) {
		this.lessonname = lessonname;
	}

	public String getLessondescription() {
		return lessondescription;
	}

	public void setLessondescription(String lessondescription) {
		this.lessondescription = lessondescription;
	}

	public Long getSubjectid() {
		return subjectid;
	}

	public void setSubjectid(Long subjectid) {
		this.subjectid = subjectid;
	}

	public Long getClassroomid() {
		return classroomid;
	}

	public void setClassroomid(Long classroomid) {
		this.classroomid = classroomid;
	}

}
