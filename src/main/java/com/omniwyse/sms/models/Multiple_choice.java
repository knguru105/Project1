package com.omniwyse.sms.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="multiple_choice")
public class Multiple_choice {

	
	private Long mcq_id, mcq_order, questionid;
	private Long mcq_description;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getMcq_id() {
		return mcq_id;
	}
	public void setMcq_id(Long mcq_id) {
		this.mcq_id = mcq_id;
	}
	public Long getMcq_order() {
		return mcq_order;
	}
	public void setMcq_order(Long mcq_order) {
		this.mcq_order = mcq_order;
	}
	public Long getQuestionid() {
		return questionid;
	}
	public void setQuestionid(Long questionid) {
		this.questionid = questionid;
	}
	public Long getMcq_description() {
		return mcq_description;
	}
	public void setMcq_description(Long mcq_description) {
		this.mcq_description = mcq_description;
	}
	
	
	
	
	
}
