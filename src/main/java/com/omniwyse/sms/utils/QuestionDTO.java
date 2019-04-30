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
	private Long id,w_id, q_id;
	
	//field of Mcq_table
	private Long mcq_id, mcq_order;
	private String mcq_description;
	
	
	//field of images table
	private Long image_id, Image_for_id;
	private String image_name, Image_path,Image_class;
	
	//field of question_images table
	private Long imageid;

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Long getImage_id() {
		return image_id;
	}

	public void setImage_id(Long image_id) {
		this.image_id = image_id;
	}

	public Long getImage_for_id() {
		return Image_for_id;
	}

	public void setImage_for_id(Long image_for_id) {
		Image_for_id = image_for_id;
	}

	public String getImage_name() {
		return image_name;
	}

	public void setImage_name(String image_name) {
		this.image_name = image_name;
	}

	public String getImage_path() {
		return Image_path;
	}

	public void setImage_path(String image_path) {
		Image_path = image_path;
	}

	public String getImage_class() {
		return Image_class;
	}

	public void setImage_class(String image_class) {
		Image_class = image_class;
	}

	public Long getImageid() {
		return imageid;
	}

	public void setImageid(Long imageid) {
		this.imageid = imageid;
	}
	
	
	

	
	
		
	
}
