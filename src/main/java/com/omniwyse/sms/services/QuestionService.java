package com.omniwyse.sms.services;

import java.util.List;import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dieselpoint.norm.Database;
import com.dieselpoint.norm.Transaction;
import com.omniwyse.sms.db.DatabaseRetrieval;
import com.omniwyse.sms.models.Question;
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
		 
		  Question question = new Question();
		 
		  question.setQuestionDescription(questionDTO.getQuestionDescription());
		  question.setQuestiontype_id(questionDTO.getQuestiontype_id());
		  question.setGradeid(questionDTO.getGradeid());
		  question.setSubjectid(questionDTO.getSubjectid());
		  question.setContext(questionDTO.getContext());
		  
		  return db.insert(question).getRowsAffected();
		  }
	
		  public int addQuestionUsingByWorksheet1Id(long tenantId,QuestionDTO questionDTO,long worksheetid)
	 	  {
			   db = database.getDatabase(tenantId);
			 	 
			 	  Transaction transaction = db.startTransaction();
			 	 
			 	  
			      Question question = new Question();
				  question.setQuestionDescription(questionDTO.getQuestionDescription());
			 	  question.setQuestiontype_id(questionDTO.getQuestiontype_id());
			 	  question.setGradeid(questionDTO.getGradeid());
			 	  question.setSubjectid(questionDTO.getSubjectid());
			 	  question.setContext(questionDTO.getContext());
			 	  
			 	  int rowEffected = db.transaction(transaction).insert(question).getRowsAffected();
			 	  
			 	  Worksheet1_question wid=new Worksheet1_question();
			 	  wid.setW_id(worksheetid);
			 	  wid.setQ_id(question.getQuestionid());
			 	  
			 	  db.transaction(transaction).insert(wid).getRowsAffected();
			      transaction.commit();
			      System.out.println("Records saved successfully");
			      return rowEffected;
			      
			      
	 	  }
		   
		 

  	 
	}
	
