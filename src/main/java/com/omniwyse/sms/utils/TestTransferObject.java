package com.omniwyse.sms.utils;

import java.util.Date;
import java.util.List;

public class TestTransferObject {


    private Long id;
    private Long gradeid;
    private Long maxmarks;
    private Long academicyear;
    private Long startdt;
    private Long enddt;
    private Long testid;
    private Long subjectid;
    private Date subjecttestdate;
    private String testtype;
    private String testmode;
    private List<TestSubjectsDisplay> subjects;
    private String syllabus;
    private String status;
    private Date startdate;
    private Date enddate;
    private Date academic;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getSubjecttestdate() {
		return subjecttestdate;
	}

	public void setSubjecttestdate(Date subjecttestdate) {
		this.subjecttestdate = subjecttestdate;
	}

	public Long getGradeid() {
        return gradeid;
    }

    public void setGradeid(Long gradeid) {
        this.gradeid = gradeid;
    }

    public Long getMaxmarks() {
        return maxmarks;
    }

    public void setMaxmarks(Long maxmarks) {
        this.maxmarks = maxmarks;
    }

    public Long getAcademicyear() {
        return academicyear;
    }

    public void setAcademicyear(Long academicyear) {
        this.academicyear = academicyear;
    }


    public Long getTestid() {
        return testid;
    }

    public void setTestid(Long testid) {
        this.testid = testid;
    }

    public Long getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(Long subjectid) {
        this.subjectid = subjectid;
    }

    public String getTesttype() {
        return testtype;
    }

    public void setTesttype(String testtype) {
        this.testtype = testtype;
    }

    public String getTestmode() {
        return testmode;
    }

    public void setTestmode(String testmode) {
        this.testmode = testmode;
    }

    public List<TestSubjectsDisplay> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<TestSubjectsDisplay> subjects) {
        this.subjects = subjects;
    }

    public String getSyllabus() {
        return syllabus;
    }

    public void setSyllabus(String syllabus) {
        this.syllabus = syllabus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getStartdt() {
        return startdt;
    }

    public void setStartdt(Long startdt) {
        this.startdt = startdt;
    }

    public Long getEnddt() {
        return enddt;
    }

    public void setEnddt(Long enddt) {
        this.enddt = enddt;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public Date getAcademic() {
        return academic;
    }

    public void setAcademic(Date academic) {
        this.academic = academic;
    }
	


}

