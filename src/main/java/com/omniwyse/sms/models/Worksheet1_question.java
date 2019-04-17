package com.omniwyse.sms.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="worksheet1_question")
public class Worksheet1_question {

	private Long id, w_id, q_id;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	@JoinColumn(name = "w_id")
	public Long getW_id() {
		return w_id;
	}

	public void setW_id(Long w_id) {
		this.w_id = w_id;
	}
	@JoinColumn(name = "q_id")
	public Long getQ_id() {
		return q_id;
	}

	public void setQ_id(Long q_id) {
		this.q_id = q_id;
	}
	
	
	
	
}
