package com.omniwyse.sms.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="staff_role")
public class StaffRole {
private long id;
private String role;
@Id
@GeneratedValue
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}

}
