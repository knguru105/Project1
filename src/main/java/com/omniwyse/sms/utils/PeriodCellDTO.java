package com.omniwyse.sms.utils;

public class PeriodCellDTO {
	private Long periodid;
	private Long subjectid;
	private Long weekdayid;
	private Long classroomid;
	public Long getPeriodid() {
		return periodid;
	}
	public void setPeriodid(Long periodid) {
		this.periodid = periodid;
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
	public Long getWeekdayid() {
		return weekdayid;
	}
	public void setWeekdayid(Long weekdayid) {
		this.weekdayid = weekdayid;
	}

}
