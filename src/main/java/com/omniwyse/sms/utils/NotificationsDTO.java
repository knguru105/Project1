package com.omniwyse.sms.utils;

import java.util.Date;

public class NotificationsDTO {

	private Long id;
	private Long status;
	private Long userid;
	private Long classid;
	
	private Date notificationdate;
	
	private String notificationname;
	private String description;
	private String publishedby;
	private String actioncode;
	private String parentactionrequired;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public Long getClassid() {
		return classid;
	}

	public void setClassid(Long classid) {
		this.classid = classid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNotificationname() {
		return notificationname;
	}

	public void setNotificationname(String notificationname) {
		this.notificationname = notificationname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getNotificationdate() {
		return notificationdate;
	}

	public void setNotificationdate(Date notificationdate) {
		this.notificationdate = notificationdate;
	}

	public String getPublishedby() {
		return publishedby;
	}

	public void setPublishedby(String publishedby) {
		this.publishedby = publishedby;
	}

	public String getActioncode() {
		return actioncode;
	}

	public void setActioncode(String actioncode) {
		this.actioncode = actioncode;
	}

	public String getParentactionrequired() {
		return parentactionrequired;
	}

	public void setParentactionrequired(String parentactionrequired) {
		this.parentactionrequired = parentactionrequired;
	}

}
