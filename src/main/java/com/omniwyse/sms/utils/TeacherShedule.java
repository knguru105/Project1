package com.omniwyse.sms.utils;

import java.util.List;

public class TeacherShedule {
private String day;
private Long id;
private List<TeacherScheduleDTO> teacherScheduleDTO;
public String getDay() {
	return day;
}
public void setDay(String day) {
	this.day = day;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public List<TeacherScheduleDTO> getTeacherScheduleDTO() {
	return teacherScheduleDTO;
}
public void setTeacherScheduleDTO(List<TeacherScheduleDTO> teacherScheduleDTO) {
	this.teacherScheduleDTO = teacherScheduleDTO;
}


	
	
}
