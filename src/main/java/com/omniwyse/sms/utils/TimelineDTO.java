package com.omniwyse.sms.utils;

import java.util.List;

public class TimelineDTO {

	private Long id;
	private Long classRoomId;
	private Long subjectId;
	private Long notificationdate;
	private Long lessonstartdate;
	private Long datefrom;
	private Long dateto;
	private Long assignmentduedate;
	private Long worksheetduedate;
	private Long publish;

	private boolean publishtimeline;

	private List<WorkSheetsDTO> worksheets;
	private List<AssignmentDTO> assignments;

	private String lessonname;

	private String status;
	private String assignmentname;
	private String worksheetname;
	private String lessondescription;
	private String subjectname;
	private String tags;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getNotificationdate() {
		return notificationdate;
	}

	public void setNotificationdate(Long notificationdate) {
		this.notificationdate = notificationdate;
	}

	public Long getLessonstartdate() {
		return lessonstartdate;
	}

	public void setLessonstartdate(Long lessonstartdate) {
		this.lessonstartdate = lessonstartdate;
	}

	public Long getDatefrom() {
		return datefrom;
	}

	public void setDatefrom(Long datefrom) {
		this.datefrom = datefrom;
	}

	public Long getDateto() {
		return dateto;
	}

	public void setDateto(Long dateto) {
		this.dateto = dateto;
	}

	public Long getAssignmentduedate() {
		return assignmentduedate;
	}

	public void setAssignmentduedate(Long assignmentduedate) {
		this.assignmentduedate = assignmentduedate;
	}

	public Long getWorksheetduedate() {
		return worksheetduedate;
	}

	public void setWorksheetduedate(Long worksheetduedate) {
		this.worksheetduedate = worksheetduedate;
	}

	public Long getPublish() {
		return publish;
	}

	public void setPublish(Long publish) {
		this.publish = publish;
	}

	public boolean isPublishtimeline() {
		return publishtimeline;
	}

	public void setPublishtimeline(boolean publishtimeline) {
		this.publishtimeline = publishtimeline;
	}

	public List<WorkSheetsDTO> getWorksheets() {
		return worksheets;
	}

	public void setWorksheets(List<WorkSheetsDTO> worksheets) {
		this.worksheets = worksheets;
	}

	public List<AssignmentDTO> getAssignments() {
		return assignments;
	}

	public void setAssignments(List<AssignmentDTO> assignments) {
		this.assignments = assignments;
	}

	public String getLessonname() {
		return lessonname;
	}

	public void setLessonname(String lessonname) {
		this.lessonname = lessonname;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public Long getClassRoomId() {
		return classRoomId;
	}

	public void setClassRoomId(Long classRoomId) {
		this.classRoomId = classRoomId;
	}

	public Long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}

}