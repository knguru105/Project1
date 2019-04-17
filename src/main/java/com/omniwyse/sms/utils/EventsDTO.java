package com.omniwyse.sms.utils;


public class EventsDTO {

    private long id;
    private Long eventdate;
    private String eventname;
    private String chiefguest;
    private String description;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getEventdate() {
        return eventdate;
    }

    public void setEventdate(Long eventdate) {
        this.eventdate = eventdate;
    }

    public String getEventname() {
        return eventname;
    }

    public void setEventname(String eventname) {
        this.eventname = eventname;
    }

    public String getChiefguest() {
        return chiefguest;
    }

    public void setChiefguest(String chiefguest) {
        this.chiefguest = chiefguest;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
