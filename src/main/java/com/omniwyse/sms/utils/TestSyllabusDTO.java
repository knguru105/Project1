package com.omniwyse.sms.utils;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers.DateDeserializer;

public class TestSyllabusDTO {
	private Long id;
	private Long testid;
	private Long subjectid;
	private Long maxmarks;
    @JsonDeserialize(using = DateDeserializer.class)
	private Date subjecttestdate;
	private Long subjecttestdt;
	private String syllabus;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Long getSubjecttestdt() {
		return subjecttestdt;
	}
	public void setSubjecttestdt(Long subjecttestdt) {
		this.subjecttestdt = subjecttestdt;
	}
	public void setSubjectid(Long subjectid) {
		this.subjectid = subjectid;
	}
	public Long getMaxmarks() {
		return maxmarks;
	}
	public void setMaxmarks(Long maxmarks) {
		this.maxmarks = maxmarks;
	}
	public Date getSubjecttestdate() {
		return subjecttestdate;
	}
	public void setSubjecttestdate(Date subjecttestdate) {
		this.subjecttestdate = subjecttestdate;
	}
	public String getSyllabus() {
		return syllabus;
	}
	public void setSyllabus(String syllabus) {
		this.syllabus = syllabus;
	}


}
