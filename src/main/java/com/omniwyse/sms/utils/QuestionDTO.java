package com.omniwyse.sms.utils;



public class QuestionDTO {

	
	private Long  questionid,gradeid,subjectid;
	private String questionDescription;
	private Long questiontype_id;
	private String context;
	
	//fields of question_type table
	private Long qtype_id;
	private String qtype;
	
	//fields of grade table
	private Long gradenumber;
	private String gradename;
	
	//fields of subject table
	private String subjectname;
	
	//field of worksheet_question table
	private Long w_id, q_id;
	
	//field of Mcq_table
	private Long mcq_id, mcq_order;
	private String mcq_description;

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

	public Long getGradenumber() {
		return gradenumber;
	}

	public void setGradenumber(Long gradenumber) {
		this.gradenumber = gradenumber;
	}

	public String getGradename() {
		return gradename;
	}

	public void setGradename(String gradename) {
		this.gradename = gradename;
	}

	public String getSubjectname() {
		return subjectname;
	}

	
	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
	}

	public Long getW_id() {
		return w_id;
	}

	public void setW_id(Long w_id) {
		this.w_id = w_id;
	}

	public Long getQ_id() {
		return q_id;
	}

	public void setQ_id(Long q_id) {
		this.q_id = q_id;
	}

	public Long getMcq_id() {
		return mcq_id;
	}

	public void setMcq_id(long mcq_id) {
		this.mcq_id = mcq_id;
	}

	public Long getMcq_order() {
		return mcq_order;
	}

	public void setMcq_order(long mcq_order) {
		this.mcq_order = mcq_order;
	}

	public String getMcq_description() {
		return mcq_description;
	}

	public void setMcq_description(String mcq_description) {
		this.mcq_description = mcq_description;
	}
	
	
	

	
	
		
	
}
