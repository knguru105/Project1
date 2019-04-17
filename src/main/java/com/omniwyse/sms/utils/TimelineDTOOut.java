package com.omniwyse.sms.utils;

import java.util.Date;
import java.util.List;

public class TimelineDTOOut {

	private Long id;
	private Long publish;

	private String assignmentname;
	private String worksheetname;
	private String lessondescription;
	private String subjectname;
	private String tags;
	private String status;
	private String lessonname;

	private Date lessonstartdate;
	private Date assignmentduedate;
	private Date worksheetduedate;
	private Date datefrom;
	private Date dateto;
	private Date notificationdate;

	private List<WorkSheetsDTOOut> worksheets;
	private List<AssignmentDTOOut> assignments;

	private boolean publishtimeline;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPublish() {
		return publish;
	}

	public void setPublish(Long publish) {
		this.publish = publish;
	}

	public String getAssignmentname() {
		return assignmentname;
	}

	public void setAssignmentname(String assignmentname) {
		this.assignmentname = assignmentname;
	}

	public String getWorksheetname() {
		return worksheetname;
	}

	public void setWorksheetname(String worksheetname) {
		this.worksheetname = worksheetname;
	}

	public String getLessondescription() {
		return lessondescription;
	}

	public void setLessondescription(String lessondescription) {
		this.lessondescription = lessondescription;
	}

	public String getSubjectname() {
		return subjectname;
	}

	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLessonname() {
		return lessonname;
	}

	public void setLessonname(String lessonname) {
		this.lessonname = lessonname;
	}

	public Date getLessonstartdate() {
		return lessonstartdate;
	}

	public void setLessonstartdate(Date lessonstartdate) {
		this.lessonstartdate = lessonstartdate;
	}

	public Date getAssignmentduedate() {
		return assignmentduedate;
	}

	public void setAssignmentduedate(Date assignmentduedate) {
		this.assignmentduedate = assignmentduedate;
	}

	public Date getWorksheetduedate() {
		return worksheetduedate;
	}

	public void setWorksheetduedate(Date worksheetduedate) {
		this.worksheetduedate = worksheetduedate;
	}

	public Date getDatefrom() {
		return datefrom;
	}

	public void setDatefrom(Date datefrom) {
		this.datefrom = datefrom;
	}

	public Date getDateto() {
		return dateto;
	}

	public void setDateto(Date dateto) {
		this.dateto = dateto;
	}

	public Date getNotificationdate() {
		return notificationdate;
	}

	public void setNotificationdate(Date notificationdate) {
		this.notificationdate = notificationdate;
	}

	public List<WorkSheetsDTOOut> getWorksheets() {
		return worksheets;
	}

	public void setWorksheets(List<WorkSheetsDTOOut> worksheets) {
		this.worksheets = worksheets;
	}

	public List<AssignmentDTOOut> getAssignments() {
		return assignments;
	}

	public void setAssignments(List<AssignmentDTOOut> assignments) {
		this.assignments = assignments;
	}

	public boolean isPublishtimeline() {
		return publishtimeline;
	}

	public void setPublishtimeline(boolean publishtimeline) {
		this.publishtimeline = publishtimeline;
	}

}
