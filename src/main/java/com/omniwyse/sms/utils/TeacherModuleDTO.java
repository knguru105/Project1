package com.omniwyse.sms.utils;

public class TeacherModuleDTO {

	private Long id;
	private Long gradeid;
	private Long gradenumber;

	private String subjectname;
	private Long subjectid;

	private String sectionname;
	private String syllabustype;
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getGradeid() {
		return gradeid;
	}

	public void setGradeid(Long gradeid) {
		this.gradeid = gradeid;
	}

	public Long getGradenumber() {
		return gradenumber;
	}

	public void setGradenumber(Long gradenumber) {
		this.gradenumber = gradenumber;
	}
	
	public String getSyllabustype() {
		return syllabustype;
	}
	public void setSyllabustype(String syllabustype) {
		this.syllabustype = syllabustype;
	}
	public String getSubjectname() {
		return subjectname;
	}

	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
	}

	public String getSectionname() {
		return sectionname;
	}

	public void setSectionname(String sectionname) {
		this.sectionname = sectionname;
	}


	public Long getSubjectid() {
		return subjectid;
	}


	public void setSubjectid(Long subjectid) {
		this.subjectid = subjectid;
	}

}
