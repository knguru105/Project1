package com.omniwyse.sms.utils;

public class ClassRoomStudents {

    private Long id;
	private String name;
	private String fathername;
	private String admissionnumber;
    private Long parentid;
    private boolean status = true;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFathername() {
        return fathername;
    }

    public void setFathername(String fathername) {
        this.fathername = fathername;
    }

    public String getAdmissionnumber() {
        return admissionnumber;
    }

    public void setAdmissionnumber(String admissionnumber) {
        this.admissionnumber = admissionnumber;
    }

    public Long getParentid() {
        return parentid;
    }

    public void setParentid(Long parentid) {
        this.parentid = parentid;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }


}
