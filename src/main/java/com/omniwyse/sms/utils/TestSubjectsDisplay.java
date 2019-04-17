package com.omniwyse.sms.utils;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers.DateDeserializer;

public class TestSubjectsDisplay {

    private Long id;
    private Long testid;
    private Long maxmarks;
    private Long marks;
    private String syllabus;
    private Long subjectid;
    @JsonDeserialize(using = DateDeserializer.class)
    private Date subjecttestdate;

    private String subjectname;
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTestid() {
        return testid;
    }

    public Date getSubjecttestdate() {
		return subjecttestdate;
	}

	public void setSubjecttestdate(Date subjecttestdate) {
		this.subjecttestdate = subjecttestdate;
	}

	public void setTestid(Long testid) {
        this.testid = testid;
    }

    public Long getMaxmarks() {
        return maxmarks;
    }

    public void setMaxmarks(Long maxmarks) {
        this.maxmarks = maxmarks;
    }

    public Long getMarks() {
        return marks;
    }

    public void setMarks(Long marks) {
        this.marks = marks;
    }

    public String getSyllabus() {
        return syllabus;
    }

    public void setSyllabus(String syllabus) {
        this.syllabus = syllabus;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
