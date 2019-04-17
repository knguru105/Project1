package com.omniwyse.sms.utils;


public class TimeTableDataTransferObject {

	private Long id;
    private Long classroomweekdayid;
	private Long period_number;
    private Long periodid;
    private Long subjectid;
    private String subjectname;
    
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getClassroomweekdayid() {
		return classroomweekdayid;
	}
	public void setClassroomweekdayid(Long classroomweekdayid) {
		this.classroomweekdayid = classroomweekdayid;
	}
    public Long getPeriod_number() {
		return period_number;
	}
	public void setPeriod_number(Long period_number) {
		this.period_number = period_number;
	}
	public Long getPeriodid() {
		return periodid;
	}
	public void setPeriodid(Long periodid) {
		this.periodid = periodid;
	}
	public Long getSubjectid() {
		return subjectid;
	}
	public void setSubjectid(Long subjectid) {
		this.subjectid = subjectid;
	}
	public String getSubjectname() {
		return subjectname;
	}
	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
	}
	
}
