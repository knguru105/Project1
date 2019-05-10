package com.omniwyse.sms.services;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dieselpoint.norm.Database;
import com.dieselpoint.norm.Transaction;
import com.omniwyse.sms.db.DatabaseRetrieval;
import com.omniwyse.sms.models.Images;
import com.omniwyse.sms.models.MultipleChoice_Image;
import com.omniwyse.sms.models.Multiple_choice;
import com.omniwyse.sms.models.Question;
import com.omniwyse.sms.models.QuestionType;
import com.omniwyse.sms.models.Question_Images;
import com.omniwyse.sms.models.Worksheet1_question;
import com.omniwyse.sms.utils.QuestionDTO;
import com.omniwyse.sms.utils.Worksheet1DTO;


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
			  String query = "select question.questionid,question.questionDescription,question.context,questiontype.qtype "
			  		+ "from questions question  left join question_type questiontype "
			  		+ "on question.questiontype_id=questiontype.qtype_id ";
			  list = db.sql(query + " where question.questionid = ?", questionId).results(QuestionDTO.class);
			  return list;
			  }
		  
		 // list of grades_subject details by questions
			public List<QuestionDTO> getListOfGradesSubjectsByQuestions(long tenantId) {
				db = retrive.getDatabase(tenantId);
				List<QuestionDTO> list = null;
				String query = "select questions.questionid,questions.gradeid,questions.subjectid,questions.status_id,"
						+ "questions.degreeofdifficultyid,questions.questionDescription,questions.context,grades.gradename,grades.syllabustype,"
						+ "subjects.subjectname,status.description,degreeofdifficulty.degreeofdifficulty "
						+ "from questions questions left join grades grades on questions.gradeid=grades.id left join subjects subjects on questions.subjectid=subjects.subjectid left join "
						+ "worksheet1_status status on questions.status_id=status.id left join "
						+ "degreeofdifficulty degreeofdifficulty on questions.degreeofdifficultyid=degreeofdifficulty.id "
						+ "order by questions.questionid";
				list = db.sql(query).results(QuestionDTO.class);
				return list;
			}
			 // list of grades_subject details by questions id
			public List<QuestionDTO> getListOfGradesSubjectsByQuestionsId(long tenantId,Long questionId) {
				db = retrive.getDatabase(tenantId);
				List<QuestionDTO> list = null;
				String query = "select question.questionid,question.gradeid,question.subjectid,question.status_id,\n" + 
						"question.degreeofdifficultyid,question.questionDescription,question.context,grades.gradename,grades.syllabustype,\n" + 
						"subjects.subjectname,status.description,degreeofdifficulty.degreeofdifficulty\n" + 
						"from questions question left join grades grades on question.gradeid=grades.id left join subjects subjects \n" + 
						"on question.subjectid=subjects.subjectid left join worksheet1_status status\n" + 
						"on question.status_id=status.id left join degreeofdifficulty degreeofdifficulty\n" + 
						"on question.degreeofdifficultyid=degreeofdifficulty.id";
				list = db.sql(query + " where question.questionid = ?", questionId).results(QuestionDTO.class);
				return list;
			}			
			
		//QuestionAnswer
			public List<QuestionDTO> QuestionAnswers(long tenantId) {
				db = retrive.getDatabase(tenantId);
				List<QuestionDTO> list = null;
				String query = "select question.questionid,question.questionDescription,question.correctAnswer,mcq.mcq_order,mcq.mcq_description,questiontype.qtype"
						+ " from questions question left join multiple_choice mcq on question.questionid=mcq.questionid left join question_type questiontype"
						+ " on question.questiontype_id=questiontype.qtype_id group by question.questionid order by question.questionid";
				list = db.sql(query).results(QuestionDTO.class);
				return list;
			}	
			
			//QuestionAnswer by question id
			public List<QuestionDTO> getQuestionAnswersByQuestionId(long tenantId,long questionId) {
				db = retrive.getDatabase(tenantId);
				List<QuestionDTO> list = null;
				String query = "select question.questionid,question.questionDescription,question.correctAnswer,mcq.mcq_order,mcq.mcq_description,questiontype.qtype"
						+ " from questions question left join multiple_choice mcq on question.questionid=mcq.questionid left join question_type questiontype"
						+ " on question.questiontype_id=questiontype.qtype_id ";
				list = db.sql(query + "where question.questionid = ? group by question.questionid",questionId).results(QuestionDTO.class);
				return list;
			}	
		//get MCQ by question ID
		  public List<QuestionDTO> getMcqByQuestionId(long tenantId, Long questionId) {
			  db = retrive.getDatabase(tenantId);
			  List<QuestionDTO> list = null;
			  String query = "select question.questionid,question.questionDescription,question.context,mcq.mcq_order,mcq.mcq_description "
			  		+ "from questions question  left join multiple_choice mcq "
			  		+ "on mcq.questionid = question.questionid";
			  list = db.sql(query + " where question.questionid = ?", questionId).results(QuestionDTO.class);
			  return list;
			  }
		  
		
		/*  public int addQuestion(long tenantId, QuestionDTO questionDTO) 
		  {
			  
		  db = database.getDatabase(tenantId);
		 
		  Question question = new Question();
		 
		  question.setQuestionDescription(questionDTO.getQuestionDescription());
		  question.setQuestiontype_id(questionDTO.getQuestiontype_id());
		  question.setGradeid(questionDTO.getGradeid());
		  question.setSubjectid(questionDTO.getSubjectid());
		  question.setContext(questionDTO.getContext());
		  
		  return db.insert(question).getRowsAffected();
		  }*/
	
		  public int addQuestionUsingByWorksheet1Id(long tenantId,QuestionDTO questionDTO,long worksheetid)
	 	  {
			   db = database.getDatabase(tenantId);
			 	 
			 	  Transaction transaction = db.startTransaction();
			 	 
			 	  
			      Question question = new Question();
				  question.setQuestionDescription(questionDTO.getQuestionDescription());
			 	  question.setQuestiontype_id(questionDTO.getQuestiontype_id());
			 	  question.setGradeid(questionDTO.getGradeid());
			 	  question.setSubjectid(questionDTO.getSubjectid());
			 	  question.setStatus_id(questionDTO.getStatus_id());
			 	  question.setDegreeofdifficultyid(questionDTO.getDegreeofdifficultyid());
			 	  question.setContext(questionDTO.getContext());
			 	  
			 	  question.setCorrectAnswer(questionDTO.getCorrectAnswer());
			 	  			 	  
			 	  int rowEffected = db.transaction(transaction).insert(question).getRowsAffected();
			 	  
			 	  Worksheet1_question wid=new Worksheet1_question();
			 	  wid.setW_id(worksheetid);
			 	  wid.setQ_id(question.getQuestionid());
			 	  
			 	  db.transaction(transaction).insert(wid).getRowsAffected();
			      transaction.commit();
			      System.out.println("Records saved successfully");
			      return rowEffected;
			      
			      
	 	  }
		  
		  public int updateQuestion(long tenantId,QuestionDTO questionDTO)
		  { 
			  db = database.getDatabase(tenantId);
			 	 
		 	 // Transaction transaction = db.startTransaction();
		 	 //long worksheetid = db.where("w_id=?",questionDTO.getW_id()).results(Worksheet1_question.class).get(0).getW_id();//db.where("housename=?", updateStudent.getHousename()).results(House.class).get(0).getId();
		 	 //long questionid = db.where("q_id=?",questionDTO.getQ_id()).results(Worksheet1_question.class).get(0).getQ_id();
		      Question question = new Question();
		      question.setQuestionid(questionDTO.getQuestionid());
			  question.setQuestionDescription(questionDTO.getQuestionDescription());
		 	  question.setQuestiontype_id(questionDTO.getQuestiontype_id());
		 	  question.setGradeid(questionDTO.getGradeid());
		 	  question.setSubjectid(questionDTO.getSubjectid());
		 	  question.setStatus_id(questionDTO.getStatus_id());
		 	  question.setDegreeofdifficultyid(questionDTO.getDegreeofdifficultyid());
		 	  question.setContext(questionDTO.getContext());
		 	  question.setCorrectAnswer(questionDTO.getCorrectAnswer());
		 	  
		 	  int rowEffected = db.update(question).getRowsAffected();
		 	  
		 	  Worksheet1_question wid=new Worksheet1_question();
		 	  wid.setW_id(questionDTO.getW_id());
		 	  wid.setQ_id(questionDTO.getQuestionid());
		 	  
		 	 db.update(wid).getRowsAffected();
		      
		      System.out.println("Records update successfully");
		      return rowEffected;
		  }
		  
		  public List<QuestionType> getQuestionType(long tenantId) {
				
				db = retrive.getDatabase(tenantId);
		
				return db.sql("select * from question_type").results(QuestionType.class);
			}
		  public int addQuestionType(long tenantId, QuestionDTO questionType)
		  {
			  db = database.getDatabase(tenantId);
			  
			  QuestionType type = new QuestionType();
			  type.setQtype(questionType.getQtype());
			  int rowEffected = db.insert(type).getRowsAffected();
			  System.out.println("QuestionType inserted successfully");
			  return rowEffected;
			  
		  }
		  
		  
		  public int updateQuestionType(long tenantId,QuestionDTO questionType)
		  {
			  db = database.getDatabase(tenantId);
			  
			  QuestionType type = new QuestionType();
			  type.setQtype_id(questionType.getQtype_id());
			  type.setQtype(questionType.getQtype());
			  int rowEffected = db.update(type).getRowsAffected();
			  System.out.println("QuestionType updated successfully");
			  return rowEffected;
		  }
		  
		  public List<Multiple_choice> getMultipleChoice(long tenantId) {
				
				db = retrive.getDatabase(tenantId);
		
				return db.sql("select * from multiple_choice").results(Multiple_choice.class);
			}
		  public int addMultipleChoice(long tenantId, QuestionDTO multipleChoice) 
		  {
			  
		  db = database.getDatabase(tenantId);
		 
		  Multiple_choice choice = new Multiple_choice();
		
		  choice.setMcq_order(multipleChoice.getMcq_order());
		  choice.setMcq_description(multipleChoice.getMcq_description());
		  choice.setQuestionid(multipleChoice.getQuestionid());
		  int rowEffected= db.insert(choice).getRowsAffected();
		  System.out.println("Records added successfully");
		  return rowEffected;
		  }
		  
		  
		  public int updateMultipleChoice(long tenantId, QuestionDTO multipleChoice) 
		  {
			  
		  db = database.getDatabase(tenantId);
		 
		  Multiple_choice choice = new Multiple_choice();
		  choice.setMcq_id(multipleChoice.getMcq_id());
		  choice.setMcq_order(multipleChoice.getMcq_order());
		  choice.setMcq_description(multipleChoice.getMcq_description());
		  choice.setQuestionid(multipleChoice.getQuestionid());
		  int rowEffected= db.update(choice).getRowsAffected();
		  System.out.println("Records Updated successfully");
		  return rowEffected;
		  }
		  
		  
		  
		  @SuppressWarnings("deprecation")
			public int uploadNewImages(long tenantId, QuestionDTO imagesDTO) {
				try {
					 Path path = Paths.get("C:\\Users\\GK\\Desktop\\Images\\New");
				        Files.createDirectories(path);
				        int width = 963;    
				        int height = 640; 
				        BufferedImage image = null;
				        File defaultpath = null;
				        File filetpath = null;
				        String name;
				        String imagepath = null;

					    try{
					          defaultpath = new File("C:\\Users\\GK\\Desktop\\Images"); 
					          File[] fList = defaultpath.listFiles();
	
					          for (File file : fList)
					          {
					              if (file.isFile())
					              {
					            	 name = file.getName();
					             
							          image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
							          image = ImageIO.read(file);
							          System.out.println("Reading complete.");
							        
							          filetpath = new File("C:\\Users\\GK\\Desktop\\Images\\New\\"+name); 
							          imagepath = filetpath.getPath();
							          ImageIO.write(image,"jpeg", filetpath);
							          System.out.println("Writing complete.");
							          attachImagesByQuestion(tenantId, imagesDTO,imagepath);
					              }
					           }
					          
					        }
				        catch(IOException e){
				          System.out.println("Error: "+e);
				        }
				        
					

				return 0;
			} catch (Exception e) {
				return -1;
			}
		}
			
		 public int attachImagesByQuestion(long tenantId,QuestionDTO imagesDTO,String imagepath)
		 {
			 db = database.getDatabase(tenantId);
			 Transaction transaction= db.startTransaction();
			 int rowEffected=0;
			 Long questionid=imagesDTO.getQuestionid();
			 Images img = new Images();
			 img.setImage_name(imagesDTO.getImage_name());
			 img.setImage_path(imagepath);
			 if (db.where("image_path = ?", imagepath).results(Images.class).isEmpty()) {
				 img.setImage_for_id(imagesDTO.getImage_for_id());
				 img.setImage_class(imagesDTO.getImage_class());
				 
				 rowEffected = db.transaction(transaction).insert(img).getRowsAffected();
				 
				 Question_Images question_images = new Question_Images();
				 question_images.setImageid(img.getImage_id());
				 question_images.setQuestionid(questionid);
				 
				 db.transaction(transaction).insert(question_images).getRowsAffected();
				 transaction.commit();
				 return rowEffected;
				}
			 
			 return 0;
			 
		 }
		 
		 @SuppressWarnings("deprecation")
			public int uploadNewImagesByMultipleChoice(long tenantId, QuestionDTO imagesDTO) {
				try {
					 Path path = Paths.get("C:\\Users\\GK\\Desktop\\Images\\MultipleChoice");
				        Files.createDirectories(path);
				        int width = 963;    
				        int height = 640; 
				        BufferedImage image = null;
				        File defaultpath = null;
				        File filetpath = null;
				        String name;
				        String imagepath = null;

					    try{
					          defaultpath = new File("C:\\Users\\GK\\Desktop\\Images"); 
					          File[] fList = defaultpath.listFiles();
	
					          for (File file : fList)
					          {
					              if (file.isFile())
					              {
					            	 name = file.getName();
					             
							          image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
							          image = ImageIO.read(file);
							          System.out.println("Reading complete.");
							        
							          filetpath = new File("C:\\Users\\GK\\Desktop\\Images\\MultipleChoice\\"+name); 
							          imagepath = filetpath.getPath();
							          ImageIO.write(image,"jpeg", filetpath);
							          System.out.println("Writing complete.");
							          attachImagesByMultipleChoice(tenantId, imagesDTO,imagepath);
					              }
					           }
					          
					        }
				        catch(IOException e){
				          System.out.println("Error: "+e);
				        }
				        
					

				return 0;
			} catch (Exception e) {
				return -1;
			}
		}
			

		 public int attachImagesByMultipleChoice(long tenantId,QuestionDTO imagesDTO,String imagepath)
		 {
			 db = database.getDatabase(tenantId);
			 Transaction transaction= db.startTransaction();
			 int rowEffected=0;
			 
			 Images img = new Images();
			 Long mcqid= imagesDTO.getMcq_id();
			 img.setImage_name(imagesDTO.getImage_name());
			 img.setImage_path(imagepath);
			 if (db.where("image_path = ?", imagepath).results(Images.class).isEmpty()) {
				 img.setImage_for_id(imagesDTO.getImage_for_id());
				 img.setImage_class(imagesDTO.getImage_class());
				 
				 rowEffected = db.transaction(transaction).insert(img).getRowsAffected();
				 MultipleChoice_Image mul_images= new MultipleChoice_Image();
				 
				 mul_images.setMcqid(mcqid);
				 mul_images.setImageid(img.getImage_id());
				 mul_images.setImageorder(imagesDTO.getImageorder());
				 
				 db.transaction(transaction).insert(mul_images).getRowsAffected();
				 transaction.commit();
				 return rowEffected;
				}
			 
			 return 0;
			 
		 }
		 
		 
		 

  	 
	}
	
