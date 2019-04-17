package com.omniwyse.sms.utils;



import java.util.Date;
import java.util.List;

import com.omniwyse.sms.models.ClassroomAttendance;

public class ClassAttendenceTransferObject {

	private long id;
	private String name;
	private Date dateofattendance;
	private long attendancestatus;
	private long gradeid;
	private String sectionname;
	private long noofstudents;
	private long noofpresents;
	private long noofabsents;
	private String subjectname;
	private long subjectid;

	private String attendance_type;
	private long classroomid;
	public long getClassroomid() {
		return classroomid;
	}

	public void setClassroomid(long classroomid) {
		this.classroomid = classroomid;
	}

	public String getAttendance_type() {
		return attendance_type;
	}

	public void setAttendance_type(String attendance_type) {
		this.attendance_type = attendance_type;
	}

	public String getSubjectname() {
		return subjectname;
	}

	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
	}

	private List<StudentTransferObject> students;
	private List<ClassroomAttendance> studentattendance;
	private List<ClassRoomStudents> studentsOfClassRoom;
	
	public long getNoofstudents() {
		return noofstudents;
	}

	public void setNoofstudents(long noofstudents) {
		this.noofstudents = noofstudents;
	}

	public long getNoofpresents() {
		return noofpresents;
	}

	public void setNoofpresents(long noofpresents) {
		this.noofpresents = noofpresents;
	}

	public long getNoofabsents() {
		return noofabsents;
	}

	public void setNoofabsents(long noofabsents) {
		this.noofabsents = noofabsents;
	}

	public List<StudentTransferObject> getStudents() {
		return students;
	}

	public void setStudents(List<StudentTransferObject> students) {
		this.students = students;
	}

	public long getGradeid() {
		return gradeid;
	}

	public void setGradeid(long gradeid) {
		this.gradeid = gradeid;
	}

	public String getSectionname() {
		return sectionname;
	}

	public void setSectionname(String sectionname) {
		this.sectionname = sectionname;
	}


	public List<ClassRoomStudents> getStudentsOfClassRoom() {
		return studentsOfClassRoom;
	}

	public void setStudentsOfClassRoom(List<ClassRoomStudents> studentsOfClassRoom) {
		this.studentsOfClassRoom = studentsOfClassRoom;
	}

	
	public List<ClassroomAttendance> getStudentattendance() {
		return studentattendance;
	}

	public void setStudentattendance(List<ClassroomAttendance> studentattendance) {
		this.studentattendance = studentattendance;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public long getAttendancestatus() {
		return attendancestatus;
	}

	public void setAttendancestatus(long attendancestatus) {
		this.attendancestatus = attendancestatus;
	}

	
	public long getId() {
		return id;
	}

	public Date getDateofattendance() {
		return dateofattendance;
	}

	public void setDateofattendance(Date date) {
		this.dateofattendance = date;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getSubjectid() {
		return subjectid;
	}

	public void setSubjectid(long subjectid) {
		this.subjectid = subjectid;
	}

}