package com.omniwyse.sms.utils;

import java.util.List;

import com.omniwyse.sms.models.Students;

public class BusSummeryDTO {;

	private String busnumber;
	private String drivername;
	private String licensenumber;
	private long drivercontactnumber;
	private String attendername;
	private long attendercontactnumber;
	private String teachername;
	private String teachercontactnumber;
	private long noofseats;
	private String routename;
	private long noofstudents;
	private String stops;
	private long numberofstudents;
	private long numberofstops;
	List<Students> students;
	private Long busid;
	public String getBusnumber() {
		return busnumber;
	}
	public long getNumberofstops() {
		return numberofstops;
	}
	public long getNoofseats() {
		return noofseats;
	}
	public void setNoofseats(long noofseats) {
		this.noofseats = noofseats;
	}
	public void setNumberofstops(long numberofstops) {
		this.numberofstops = numberofstops;
	}
	public void setBusnumber(String busnumber) {
		this.busnumber = busnumber;
	}
	
	public long getNoofstudents() {
		return noofstudents;
	}
	public void setNoofstudents(long noofstudents) {
		this.noofstudents = noofstudents;
	}
	public Long getBusid() {
		return busid;
	}
	public void setBusid(Long busid) {
		this.busid = busid;
	}
	public String getDrivername() {
		return drivername;
	}
	public long getAttendercontactnumber() {
		return attendercontactnumber;
	}
	public void setAttendercontactnumber(long attendercontactnumber) {
		this.attendercontactnumber = attendercontactnumber;
	}
	
	public String getTeachercontactnumber() {
		return teachercontactnumber;
	}
	public void setTeachercontactnumber(String teachercontactnumber) {
		this.teachercontactnumber = teachercontactnumber;
	}
	public long getDrivercontactnumber() {
		return drivercontactnumber;
	}
	public void setDrivername(String drivername) {
		this.drivername = drivername;
	}
	public String getLicensenumber() {
		return licensenumber;
	}
	public void setLicensenumber(String licensenumber) {
		this.licensenumber = licensenumber;
	}
	
	public void setDrivercontactnumber(long l) {
		this.drivercontactnumber = l;
	}
	public String getAttendername() {
		return attendername;
	}
	public void setAttendername(String attendername) {
		this.attendername = attendername;
	}
	
	public String getTeachername() {
		return teachername;
	}
	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}
	
	public String getRoutename() {
		return routename;
	}
	public void setRoutename(String routename) {
		this.routename = routename;
	}
	public String getStops() {
		return stops;
	}
	public void setStops(String stops) {
		this.stops = stops;
	}
	public long getNumberofstudents() {
		return numberofstudents;
	}
	public void setNumberofstudents(long numberofstudents) {
		this.numberofstudents = numberofstudents;
	}
	public List<Students> getStudents() {
		return students;
	}
	public void setStudents(List<Students> students) {
		this.students = students;
	}
	

}
