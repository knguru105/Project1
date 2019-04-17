package com.omniwyse.sms.utils;

import java.util.Date;

public class ShowPeriods {

	private long id;
    private Date periodfrom;
    private Date periodto;
	private long subjectid;
	private Long classroomid;
	private Long classroomweekdayid;
	
	
	public Long getClassroomid() {
		return classroomid;
	}
	public void setClassroomid(Long classroomid) {
		this.classroomid = classroomid;
	}
	public Long getClassroomweekdayid() {
		return classroomweekdayid;
	}
	public void setClassroomweekdayid(Long classroomweekdayid) {
		this.classroomweekdayid = classroomweekdayid;
	}
	public long getSubjectid() {
		return subjectid;
	}
	public void setSubjectid(long subjectid) {
		this.subjectid = subjectid;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

    public Date getPeriodfrom() {
        return periodfrom;
    }

    public void setPeriodfrom(Date periodfrom) {
        this.periodfrom = periodfrom;
    }

    public Date getPeriodto() {
        return periodto;
    }

    public void setPeriodto(Date periodto) {
        this.periodto = periodto;
    }
	
}
