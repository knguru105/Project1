package com.omniwyse.sms.utils;

import java.util.List;

import com.omniwyse.sms.models.PeriodTypes;
import com.omniwyse.sms.models.Periods;

public class TimetableDTO {

	private PeriodTypes periodTypes;
	private List<Periods> periods;
	private List<TimeTableView> timeTableView;
	
	

	public List<Periods> getPeriods() {
		return periods;
	}

	public void setPeriods(List<Periods> periods) {
		this.periods = periods;
	}

	public PeriodTypes getPeriodTypes() {
		return periodTypes;
	}

	public void setPeriodTypes(PeriodTypes periodTypes) {
		this.periodTypes = periodTypes;
	}

	public List<TimeTableView> getTimeTableView() {
		return timeTableView;
	}

	public void setTimeTableView(List<TimeTableView> timeTableView) {
		this.timeTableView = timeTableView;
	}

	



}
