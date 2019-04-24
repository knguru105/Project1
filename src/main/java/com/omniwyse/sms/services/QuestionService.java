package com.omniwyse.sms.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dieselpoint.norm.Database;
import com.dieselpoint.norm.Transaction;
import com.omniwyse.sms.db.DatabaseRetrieval;
import com.omniwyse.sms.models.Grades;
import com.omniwyse.sms.models.Question;
import com.omniwyse.sms.models.QuestionType;
import com.omniwyse.sms.models.Subjects;
import com.omniwyse.sms.models.Worksheet1;
import com.omniwyse.sms.models.Worksheet1_question;
import com.omniwyse.sms.utils.QuestionDTO;


@Service
public class QuestionService {

	@Autowired
	private com.omniwyse.sms.db.DatabaseRetrieval database;
	
	public Database db;

	@Autowired
	private DatabaseRetrieval retrive;
	
			public List<Question> getQuestionList(long tenantId) {
		
				db = retrive.getDatabase(tenantId);
		
				return db.sql("select * from questions").results(Question.class);
			}
	
		  //getting list of questions using question id
			public List<Question> getListOfQuestionsUsingId(long tenantId, Long questionId) {
			db = retrive.getDatabase(tenantId);
			List<Question> list = null;
			String query = "select * from  questions";///*"select questions.questionDescription, questions.questiontype_id, questions.gradeid, questions.subjectid, questions.context questions.Worksheet_id from
			list = db.sql(query + " where questions.questionid = ?", questionId  ).results(Question.class);
			return list;
			}
		 
		 	//get questionType by question ID
		 	public List<QuestionDTO> getQuestionTypeByQuestionId(long tenantId, Long questionId) {
			  db = retrive.getDatabase(tenantId);
			  List<QuestionDTO> list = null;
			  String query = "select question.questionDescription,question.context,questiontype.qtype "
			  		+ "from questions question  left join question_type questiontype "
			  		+ "on question.questiontype_id=questiontype.qtype_id ";
			  list = db.sql(query + " where question.questionid = ?", questionId).results(QuestionDTO.class);
			  return list;
			  }
		  
		  
		//get MCQ by question ID
		  public List<QuestionDTO> getMcqByQuestionId(long tenantId, Long questionId) {
			  db = retrive.getDatabase(tenantId);
			  List<QuestionDTO> list = null;
			  String query = "select question.questionDescription,question.context,mcq.mcq_order,mcq.mcq_description "
			  		+ "from questions question  left join multiple_choice mcq "
			  		+ "on question.questionid=mcq.questionid ";
			  list = db.sql(query + " where question.questionid = ?", questionId).results(QuestionDTO.class);
			  return list;
			  }
		  
		
		  public int addQuestion(long tenantId, QuestionDTO questionDTO) 
		  {
			  
		  db = database.getDatabase(tenantId);
		  long gradeid = questionDTO.getGradeid();
		  long subjectid = questionDTO.getSubjectid();
		  long questiontypeid = questionDTO.getQuestiontype_id();
		
		  long gradeid1 = db.where("id=?",gradeid).results(Grades.class).get(0).getId();
		  long subjectid1 =	db.where("id=?",subjectid).results(Subjects.class).get(0).getId();
		  long questiontypeid1 =db.where("qtype_id=?",questiontypeid).results(QuestionType.class).get(0).getQtype_id();
		  
		  
		  Question question = new Question();
		  question.setQuestionid(questionDTO.getQuestionid());;
		  question.setQuestionDescription(questionDTO.getQuestionDescription());
		  question.setQuestiontype_id(questiontypeid1);
		  question.setGradeid(gradeid1);
		  question.setSubjectid(subjectid1);
		  question.setContext(questionDTO.getContext());
		  
		  return db.insert(question).getRowsAffected();
		  }
	

		/*  //adding questions using worksheet id 
		  public int addQuestionUsingByWorksheet1Id(long tenantId,QuestionDTO questionDTO,long worksheetid)
	 	  {
			 	  db = database.getDatabase(tenantId);
			 	 
			 	  Transaction transaction = db.startTransaction();
			 	  long gradeid = questionDTO.getGradeid();
			 	  long subjectid = questionDTO.getSubjectid();
			 	  long questiontypeid = questionDTO.getQuestiontype_id();
			 	  long questionid=questionDTO.getQuestionid();
			 	  
			 	  long gradeid1 = db.where("id=?",gradeid).results(Grades.class).get(0).getId();
			 	  long subjectid1 = db.where("id=?",subjectid).results(Subjects.class).get(0).getId();
			 	  long questiontypeid1 =db.where("qtype_id=?",questiontypeid).results(QuestionType.class).get(0).getQtype_id();
			 	  
			 	  long worksheetId1= db.where("w_id=?",worksheetid).results(Worksheet1.class).get(0).getW_id();
			      long worksheetId= db.where("w_id=?",worksheetId1).results(Worksheet1_question.class).get(0).getW_id();
			       
			      long questionId=	db.where("q_id=?",questionid).results(Worksheet1_question.class).get(0).getQ_id();
			      long questionId1=	db.where("questionid=?",questionId).results(Question.class).get(0).getQuestionid();
			 	  //long worksheetId1= db.where("w_id=?",worksheetid).results(Worksheet1.class).get(0).getW_id();
			 	  
			      //question.setQuestionid(questionDTO.getQuestionid());
			 	  Worksheet1_question wid=new Worksheet1_question();
			 	  wid.setW_id(worksheetId);
			 	  wid.setQ_id(questionId1);
			 	  db.transaction(transaction).insert(wid).getRowsAffected();
			      
			 	 
			 	
			 	  Question question = new Question();
				  question.setQuestionid(questionDTO.getQuestionid());
			 	  //question.setQuestionid(questionId);
			 	  question.setQuestionDescription(questionDTO.getQuestionDescription());
			 	  question.setQuestiontype_id(questiontypeid1);
			 	  question.setGradeid(gradeid1);
			 	  question.setSubjectid(subjectid1);
			 	  question.setContext(questionDTO.getContext());
			 	  
			 	  int rowEffected = db.transaction(transaction).insert(question).getRowsAffected();
			      transaction.commit();
			      System.out.println("Records saved successfully");
			      return rowEffected;
	 	  }
  	 */
		  
		  //adding questions using worksheet id 
		 /* public int addQuestionUsingByWorksheet1Id(long tenantId,QuestionDTO questionDTO,long worksheetid)
	 	  {
			 	  db = database.getDatabase(tenantId);
			 	 
			 	  Transaction transaction = db.startTransaction();
			 	  long gradeid = questionDTO.getGradeid();
			 	  long subjectid = questionDTO.getSubjectid();
			 	  long questiontypeid = questionDTO.getQuestiontype_id();
			 	  worksheetid=questionDTO.getW_id();
			 	  long questionId=questionDTO.getQ_id();
			 	  
			 	  //question field
			 	  long gradeid1 = db.where("id=?",gradeid).results(Grades.class).get(0).getId();
			 	  long subjectid1 = db.where("id=?",subjectid).results(Subjects.class).get(0).getId();
			 	  long questiontypeid1 =db.where("qtype_id=?",questiontypeid).results(QuestionType.class).get(0).getQtype_id();
			 	  
			 	  //worksheet_question Field
			 	 long worksheetId1= db.where("w_id=?",worksheetid).results(Worksheet1_question.class).get(0).getW_id();
			 	 long questionId1=	db.where("q_id=?",questionId).results(Worksheet1_question.class).get(0).getQ_id();
			        
			 	  Worksheet1_question work=new Worksheet1_question();
			 	  work.setId(questionDTO.getId());
			 	  work.setW_id(worksheetId1);
			 	  work.setQ_id(questionId1);
			 	  db.transaction(transaction).insert(work).getRowsAffected();
			 	  
			      Question question = new Question();
			      
				  question.setQuestionid(questionDTO.getQuestionid());
			 	  question.setQuestionDescription(questionDTO.getQuestionDescription());
			 	  question.setQuestiontype_id(questiontypeid1);
			 	  question.setGradeid(gradeid1);
			 	  question.setSubjectid(subjectid1);
			 	  question.setContext(questionDTO.getContext());
			 	  
			 	  int rowEffected = db.transaction(transaction).insert(question).getRowsAffected();
			      transaction.commit();
			      System.out.println("Records saved successfully");
			      return rowEffected;
	 	  }
  	 */
	}
	
