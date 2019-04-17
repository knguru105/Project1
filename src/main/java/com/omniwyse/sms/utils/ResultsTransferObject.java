package com.omniwyse.sms.utils;

import java.util.Date;
import java.util.List;

public class ResultsTransferObject {
    
    private Long id;
    private Long academicyear;
    private Long marks;
    private Long classid;
    private Long admissionnumber;
    private Long gradeid;
    private Long subjectid;
    private Long testid;
    private Long studentid;
    private Long maxmarks;
    private Long startdt;

    private String syllabustype;
    private String gradename;
    private String sectionname;
    private String testtype;
    private String testmode;
    private String subjectname;
    private String name;
    private String resultorgrade;
    private String status;

    private Date startdate;

	private List<StudentSubjectMarks> studentsubjectmarks;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAcademicyear() {
        return academicyear;
    }

    public void setAcademicyear(Long academicyear) {
        this.academicyear = academicyear;
    }

    public Long getMarks() {
        return marks;
    }

    public void setMarks(Long marks) {
        this.marks = marks;
    }

    public Long getClassid() {
        return classid;
    }

    public void setClassid(Long classid) {
        this.classid = classid;
    }

    public Long getAdmissionnumber() {
        return admissionnumber;
    }

    public void setAdmissionnumber(Long admissionnumber) {
        this.admissionnumber = admissionnumber;
    }

    public Long getGradeid() {
        return gradeid;
    }

    public void setGradeid(Long gradeid) {
        this.gradeid = gradeid;
    }

    public Long getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(Long subjectid) {
        this.subjectid = subjectid;
    }

    public Long getTestid() {
        return testid;
    }

    public void setTestid(Long testid) {
        this.testid = testid;
    }

    public Long getStudentid() {
        return studentid;
    }

    public void setStudentid(Long studentid) {
        this.studentid = studentid;
    }

    public Long getMaxmarks() {
        return maxmarks;
    }

    public void setMaxmarks(Long maxmarks) {
        this.maxmarks = maxmarks;
    }

    public Long getStartdt() {
        return startdt;
    }

    public void setStartdt(Long startdt) {
        this.startdt = startdt;
    }

    public String getSyllabustype() {
        return syllabustype;
    }

    public void setSyllabustype(String syllabustype) {
        this.syllabustype = syllabustype;
    }

    public String getGradename() {
        return gradename;
    }

    public void setGradename(String gradename) {
        this.gradename = gradename;
    }

    public String getSectionname() {
        return sectionname;
    }

    public void setSectionname(String sectionname) {
        this.sectionname = sectionname;
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

    public String getSubjectname() {
        return subjectname;
    }

    public void setSubjectname(String subjectname) {
        this.subjectname = subjectname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResultorgrade() {
        return resultorgrade;
    }

    public void setResultorgrade(String resultorgrade) {
        this.resultorgrade = resultorgrade;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public List<StudentSubjectMarks> getStudentsubjectmarks() {
        return studentsubjectmarks;
    }

    public void setStudentsubjectmarks(List<StudentSubjectMarks> studentsubjectmarks) {
        this.studentsubjectmarks = studentsubjectmarks;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
	
}
