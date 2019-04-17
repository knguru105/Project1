package com.omniwyse.sms.models;



import javax.persistence.*;

@Entity
@Table(name="question_type")

public class QuestionType {
	
	
	private Long qtype_id;
	private String qtype;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getQtype_id() {
		return qtype_id;
	}
	public void setQtype_id(Long qtype_id) {
		this.qtype_id = qtype_id;
	}
	public String getQtype() {
		return qtype;
	}
	public void setQtype(String qtype) {
		this.qtype = qtype;
	}
	


}