package com.omniwyse.sms.models;


import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Table(name = "classroom_periods")
public class ClassRoomPeriods {
	
    private Long id;

    private Long periodid;
    private Date periodfrom;
    private Date periodto;
    private Long classroomweekdayid;
    private Long classroomid;
    private long subjectid;


    public long getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(long subjectid) {
        this.subjectid = subjectid;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Long getPeriodid() {
		return periodid;
	}

	public void setPeriodid(Long periodid) {
		this.periodid = periodid;
	}

	public Long getClassroomweekdayid() {
        return classroomweekdayid;
    }

    public void setClassroomweekdayid(Long classroomweekdayid) {
        this.classroomweekdayid = classroomweekdayid;
    }

    public Long getClassroomid() {
        return classroomid;
    }

    public void setClassroomid(Long classroomid) {
        this.classroomid = classroomid;
    }

}
