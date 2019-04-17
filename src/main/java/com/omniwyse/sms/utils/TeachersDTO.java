package com.omniwyse.sms.utils;

public class TeachersDTO {
	private String teachername;
	private String middlename;
	private String lname;
	private String bloodgroup;
	private String contactnumber;
	private String emailid, address;
	private String qualification;
	private String about;
	private String subjects;
	private Long  dateofbirth;
	private Long dateofjoining;
	private String gender;
	private String password;
	private long id;
	private long noofperiods;
	private String role;
	private String maritalstatus;
	
	public String getMaritalstatus() {
		return maritalstatus;
	}
	public void setMaritalstatus(String maritalstatus) {
		this.maritalstatus = maritalstatus;
	}
	public String getMiddlename() {
		return middlename;
	}
	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}
	
	public String getBloodgroup() {
		return bloodgroup;
	}
	public void setBloodgroup(String bloodgroup) {
		this.bloodgroup = bloodgroup;
	}

	public long getId() {
		return id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getNoofperiods() {
		return noofperiods;
	}
	public void setNoofperiods(long noofperiods) {
		this.noofperiods = noofperiods;
	}
	public String getTeachername() {
		return teachername;
	}
	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getContactnumber() {
		return contactnumber;
	}
	public void setContactnumber(String contactnumber) {
		this.contactnumber = contactnumber;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public String getSubjects() {
		return subjects;
	}
	public void setSubjects(String subjects) {
		this.subjects = subjects;
	}
	
	public Long getDateofbirth() {
		return dateofbirth;
	}
	public void setDateofbirth(Long dateofbirth) {
		this.dateofbirth = dateofbirth;
	}
	public Long getDateofjoining() {
		return dateofjoining;
	}
	public void setDateofjoining(Long dateofjoining) {
		this.dateofjoining = dateofjoining;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


}
