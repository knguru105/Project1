package com.omniwyse.sms.utils;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers.DateDeserializer;

public class TeacherScheduleDTO {
	@JsonDeserialize(using = DateDeserializer.class)
	private Long periodfrom;
	@JsonDeserialize(using = DateDeserializer.class)
	private Long periodto;
	private String subjectname;
	private Long gradeid;
	private String sectionname;
	private Long gradenumber;
	private String syllabustype;
	private Long periodid;
	private String day;
	private Long classid;
	private Long teacherid;
	private Long subjectid;
	private Long classroomweekdayid;
	
	public Long getClassroomweekdayid() {
		return classroomweekdayid;
	}

	public void setClassroomweekdayid(Long classroomweekdayid) {
		this.classroomweekdayid = classroomweekdayid;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public Long getClassid() {
		return classid;
	}

	public void setClassid(Long classid) {
		this.classid = classid;
	}

	public Long getTeacherid() {
		return teacherid;
	}

	public void setTeacherid(Long teacherid) {
		this.teacherid = teacherid;
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

	public Long getPeriodid() {
		return periodid;
	}

	public void setPeriodid(Long periodid) {
		this.periodid = periodid;
	}

	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
	}

	public long getGradeid() {
		return gradeid;
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

	

	public Long getPeriodfrom() {
		return periodfrom;
	}

	public void setPeriodfrom(Long periodfrom) {
		this.periodfrom = periodfrom;
	}

	public Long getPeriodto() {
		return periodto;
	}

	public void setPeriodto(Long periodto) {
		this.periodto = periodto;
	}

	public void setGradeid(Long gradeid) {
		this.gradeid = gradeid;
	}

	public void setGradeid(long gradeid) {
		this.gradeid = gradeid;
	}

	public String getSectionname() {
		return sectionname;
	}

	public void setSectionname(String sectionname) {
		this.sectionname = sectionname;
	}

}
