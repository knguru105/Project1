package com.omniwyse.sms.models;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "test_syllabus")
public class TestSyllabus {

	private Long id;
	private Long testid;
	private Long subjectid;
	private Long maxmarks;
	private Date subjecttestdate;

	private String syllabus;

	@Id
	@GeneratedValue
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

	public Long getMaxmarks() {
		return maxmarks;
	}

	public void setMaxmarks(Long maxmarks) {
		this.maxmarks = maxmarks;
	}

	public String getSyllabus() {
		return syllabus;
	}

	public void setSyllabus(String syllabus) {
		this.syllabus = syllabus;
	}

}
