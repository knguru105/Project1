package com.omniwyse.sms.utils;



public class QuestionDTO {

	
	private Long  questionid,gradeid,subjectid,status_id,degreeofdifficultyid,correctAnswer;
	private String questionDescription;
	private Long questiontype_id;
	private String context;
	
	//fields of question_type table
	private Long qtype_id;
	private String qtype;
	
	//fields of grade table
	private Long gradenumber;
	private String gradename,syllabustype;
	
	public String getSyllabustype() {
		return syllabustype;
	}

	public void setSyllabustype(String syllabustype) {
		this.syllabustype = syllabustype;
	}

	//fields of subject table
	private String subjectname;
	
	//fields of status table
	private String description;
		
	//field of degree of difficulty table
	private String degreeofdifficulty;
	
	//field of worksheet_question table
	private Long id,w_id, q_id;
		
	//field of Mcq_table
	private Long mcq_id, mcq_order;
	private String mcq_description;
			
			
	//field of images table
	private Long image_id, image_for_id;
	private String image_name, image_path,image_class;
			
	//field of question_images table
	private Long imageid;
		
	//field of MultipleChoice_Image table
	private Long mcqid, imageorder;
		
	
	public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getDegreeofdifficulty() {
			return degreeofdifficulty;
		}

		public void setDegreeofdifficulty(String degreeofdifficulty) {
			this.degreeofdifficulty = degreeofdifficulty;
		}

	
	
	
	public Long getMcqid() {
		return mcqid;
	}

	public void setMcqid(Long mcqid) {
		this.mcqid = mcqid;
	}

	public Long getImageorder() {
		return imageorder;
	}

	public void setImageorder(Long imageorder) {
		this.imageorder = imageorder;
	}

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public void setMcq_id(Long mcq_id) {
		this.mcq_id = mcq_id;
	}

	public Long getMcq_order() {
		return mcq_order;
	}

	public void setMcq_order(Long mcq_order) {
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
		return image_for_id;
	}

	public void setImage_for_id(Long image_for_id) {
		this.image_for_id = image_for_id;
	}

	public String getImage_name() {
		return image_name;
	}

	public void setImage_name(String image_name) {
		this.image_name = image_name;
	}

	public String getImage_path() {
		return image_path;
	}

	public void setImage_path(String image_path) {
		this.image_path = image_path;
	}

	public String getImage_class() {
		return image_class;
	}

	public void setImage_class(String image_class) {
		this.image_class = image_class;
	}

	public Long getImageid() {
		return imageid;
	}

	public void setImageid(Long imageid) {
		this.imageid = imageid;
	}

	
	public Long getStatus_id() {
		return status_id;
	}

	public void setStatus_id(Long status_id) {
		this.status_id = status_id;
	}

	public Long getDegreeofdifficultyid() {
		return degreeofdifficultyid;
	}

	public void setDegreeofdifficultyid(Long degreeofdifficultyid) {
		this.degreeofdifficultyid = degreeofdifficultyid;
	}
	public Long getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(Long correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	
	
}