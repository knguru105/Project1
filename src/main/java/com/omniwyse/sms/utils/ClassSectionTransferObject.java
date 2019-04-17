package com.omniwyse.sms.utils;

public class ClassSectionTransferObject {

	private Long id;
	private Long gradeid;
	private Long classteacherid;
	private Long academicid;
	private Long gradenumber;
	private Long syllabusid;

	private String sectionname;
	private String syllabustype;
	private String teachername;
	private String subjectname;
	private String gradename;
	private Long period_type_id;

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

	public Long getClassteacherid() {
		return classteacherid;
	}

	public void setClassteacherid(Long classteacherid) {
		this.classteacherid = classteacherid;
	}

	public Long getAcademicid() {
		return academicid;
	}

	public void setAcademicid(Long academicid) {
		this.academicid = academicid;
	}

	public Long getGradenumber() {
		return gradenumber;
	}

	public void setGradenumber(Long gradenumber) {
		this.gradenumber = gradenumber;
	}

	public String getSectionname() {
		return sectionname;
	}

	public void setSectionname(String sectionname) {
		this.sectionname = sectionname;
	}

	public String getSyllabustype() {
		return syllabustype;
	}

	public void setSyllabustype(String syllabustype) {
		this.syllabustype = syllabustype;
	}

	public String getTeachername() {
		return teachername;
	}

	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}

	public String getSubjectname() {
		return subjectname;
	}

	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
	}

	public String getGradename() {
		return gradename;
	}

	public void setGradename(String gradename) {
		this.gradename = gradename;
	}

	public Long getSyllabusid() {
		return syllabusid;
	}

	public void setSyllabusid(Long syllabusid) {
		this.syllabusid = syllabusid;
	}

	public Long getPeriod_type_id() {
		return period_type_id;
	}

	public void setPeriod_type_id(Long period_type_id) {
		this.period_type_id = period_type_id;
	}
}