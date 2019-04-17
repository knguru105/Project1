package com.omniwyse.sms.utils;

public class PeriodDTO {

private Long id;
	
	private long period_type_id;
	
	
	private TimeDTO periodfrom;
	
	private TimeDTO periodto;
	
	private Long period_number;
	
	
    public Long getId() {
		return id;
	}


    public void setId(Long id) {
		this.id = id;
	}



	public long getPeriod_type_id() {
		return period_type_id;
	}



	public void setPeriod_type_id(long period_type_id) {
		this.period_type_id = period_type_id;
	}


	public Long getPeriod_number() {
		return period_number;
	}

	public TimeDTO getPeriodfrom() {
		return periodfrom;
	}


	public void setPeriodfrom(TimeDTO periodfrom) {
		this.periodfrom = periodfrom;
	}


	public TimeDTO getPeriodto() {
		return periodto;
	}


	public void setPeriodto(TimeDTO periodto) {
		this.periodto = periodto;
	}


	public void setPeriod_number(Long period_number) {
		this.period_number = period_number;
	}



	
	}
