package com.omniwyse.sms.utils;

public class HolidaysDTO {

	 private long id;
    private Long fromdate;
    private Long todate;
    private String occassion;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getFromdate() {
        return fromdate;
    }

    public void setFromdate(Long fromdate) {
        this.fromdate = fromdate;
    }

    public Long getTodate() {
        return todate;
    }

    public void setTodate(Long todate) {
        this.todate = todate;
    }

    public String getOccassion() {
        return occassion;
    }

    public void setOccassion(String occassion) {
        this.occassion = occassion;
    }

}
