package com.omniwyse.sms.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "classrooms")
public class ClassRoom {

    private Long id;
    private Long gradeid;
    private Long classteacherid;
    private Long academicid;
    private String sectionname;
    private Long period_type_id;

    @Id
    @GeneratedValue
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

    public String getSectionname() {
        return sectionname;
    }

    public Long getPeriod_type_id() {
		return period_type_id;
	}

	public void setPeriod_type_id(Long period_type_id) {
		this.period_type_id = period_type_id;
	}

	public void setSectionname(String sectionname) {
        this.sectionname = sectionname;
    }

}