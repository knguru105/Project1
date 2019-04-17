package com.omniwyse.sms.utils;

import java.util.List;

public class TimeTableView {
	private Long id;
	private String day;
	private String classroomweekdayid;
	private List<TimeTableDataTransferObject> TimeTableDataTransferObject;
	
	
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public List<TimeTableDataTransferObject> getTimeTableDataTransferObject() {
		return TimeTableDataTransferObject;
	}
	public void setTimeTableDataTransferObject(List<TimeTableDataTransferObject> timeTableDataTransferObject) {
		TimeTableDataTransferObject = timeTableDataTransferObject;
	}
	public String getClassroomweekdayid() {
		return classroomweekdayid;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setClassroomweekdayid(String classroomweekdayid) {
		this.classroomweekdayid = classroomweekdayid;
	}
	
	
}
