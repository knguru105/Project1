package com.omniwyse.sms.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "classroom_testresult")
public class ClassroomTestResult {

    private Long id;
    private Long classid;
    private Long testid;
    private Long studentid;
    private String resultorgrade;


    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClassid() {
        return classid;
    }

    public void setClassid(Long classid) {
        this.classid = classid;
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

    public String getResultorgrade() {
        return resultorgrade;
    }

    public void setResultorgrade(String resultorgrade) {
        this.resultorgrade = resultorgrade;
    }


}
