package com.omniwyse.sms.models;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "diary")
public class Diary {

    private Long id;
    private String tag;
    private Date entrydate;
    private String description;

    private Long classroomid;
    private Long subjectid;
    private String lessonname;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Date getEntrydate() {
        return entrydate;
    }

    public void setEntrydate(Date entrydate) {
        this.entrydate = entrydate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getClassroomid() {
        return classroomid;
    }

    public void setClassroomid(Long classroomid) {
        this.classroomid = classroomid;
    }

    public Long getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(Long subjectid) {
        this.subjectid = subjectid;
    }

    public String getLessonname() {
        return lessonname;
    }

    public void setLessonname(String lessonname) {
        this.lessonname = lessonname;
    }

    @Override
    public String toString() {
        return "Diary [id=" + id + ", tag=" + tag + ", entrydate=" + entrydate + ", description=" + description
                + ", classroomid=" + classroomid + ", subjectid=" + subjectid + ", lessonname=" + lessonname + "]";
    }

}
