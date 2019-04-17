package com.omniwyse.sms.utils;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers.DateDeserializer;

public class TableView {

	private String subjectname;
	private String day;
	private Long periodid;
	private Long period_number;

    @JsonDeserialize(using = DateDeserializer.class)
    private Date periodfrom;
    @JsonDeserialize(using = DateDeserializer.class)
    private Date periodto;

	public String getSubjectname() {
		return subjectname;
	}

	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
	}

	public String getDay() {
		return day;
	}

	public Long getPeriod_number() {
		return period_number;
	}

	public void setPeriod_number(Long period_number) {
		this.period_number = period_number;
	}

	public Long getPeriodid() {
		return periodid;
	}

	public void setPeriodid(Long periodid) {
		this.periodid = periodid;
	}

	public Date getPeriodto() {
		return periodto;
	}

	public void setDay(String day) {
		this.day = day;
	}

    public Date getPeriodfrom() {
        return periodfrom;
    }

    public void setPeriodfrom(Date periodfrom) {
        this.periodfrom = periodfrom;
    }

  

    public void setPeriodto(Date periodto) {
        this.periodto = periodto;
    }


}
