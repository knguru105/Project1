package com.omniwyse.sms.models;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Table(name="staff")
public class Staff {
	private long id;
	private String firstname; 
	private String middlename; 
	private String lastname; 
	private String role;
	private long contactnumber; 
	private Date dateofbirth; 
	private Date dateofjoining; 
	private String licensenumber; 
	private Date licenseexpiredate; 
	private String mailid; 
	private String experience; 
	private String bloodgroup; 
	private String qualification; 
	private boolean active; 
	private Date createdon;
	private Date modifiedon;
	public Date getCreatedon() {
			return createdon;
	}
	public void setCreatedon(Date createdon) {
			this.createdon = createdon;
	}
	public Date getModifiedon() {
			return modifiedon;
	}
	public void setModifiedon(Date modifiedon) {
			this.modifiedon = modifiedon;
	}
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public Date getDateofjoining() {
		return dateofjoining;
	}
	public void setDateofjoining(Date dateofjoining) {
		this.dateofjoining = dateofjoining;
	}
	public String getLicensenumber() {
		return licensenumber;
	}
	public void setLicensenumber(String licensenumber) {
		this.licensenumber = licensenumber;
	}
	public Date getLicenseexpiredate() {
		return licenseexpiredate;
	}
	public void setLicenseexpiredate(Date licenseexpiredate) {
		this.licenseexpiredate = licenseexpiredate;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public String getBloodgroup() {
		return bloodgroup;
	}
	public void setBloodgroup(String bloodgroup) {
		this.bloodgroup = bloodgroup;
	}
			
	public String getFirstname() {
		return firstname;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getMiddlename() {
		return middlename;
	}
	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public long getContactnumber() {
		return contactnumber;
	}
	public void setContactnumber(long contactnumber) {
		this.contactnumber = contactnumber;
	}
	public Date getDateofbirth() {
		return dateofbirth;
	}
	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}
	public String getMailid() {
		return mailid;
	}
	public void setMailid(String mailid) {
		this.mailid = mailid;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
		
}
