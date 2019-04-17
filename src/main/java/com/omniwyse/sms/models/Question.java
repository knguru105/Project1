package com.omniwyse.sms.models;

import javax.persistence.*;

@Entity
@Table(name="questions")

public class Question  {
	
	
	
	private Long  questionid,gradeid,subjectid;
	private String questionDescription;
	private Long questiontype_id;
	private String context;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getQuestionid() {
		return questionid;
	}
	public void setQuestionid(Long questionid) {
		this.questionid = questionid;
	}
	public Long getGradeid() {
		return gradeid;
	}
	public void setGradeid(Long gradeid) {
		this.gradeid = gradeid;
	}
	public Long getSubjectid() {
		return subjectid;
	}
	public void setSubjectid(Long subjectid) {
		this.subjectid = subjectid;
	}
	public String getQuestionDescription() {
		return questionDescription;
	}
	public void setQuestionDescription(String questionDescription) {
		this.questionDescription = questionDescription;
	}
	public Long getQuestiontype_id() {
		return questiontype_id;
	}
	public void setQuestiontype_id(Long questiontype_id) {
		this.questiontype_id = questiontype_id;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	
	
	
	
	
	
	
	

}