package com.omniwyse.sms.services;

import java.io.File;
import java.util.List;import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.dieselpoint.norm.Database;
import com.dieselpoint.norm.Transaction;
import com.omniwyse.sms.db.DBFactory;
import com.omniwyse.sms.db.DatabaseRetrieval;
import com.omniwyse.sms.ischool.S3BucketService;
import com.omniwyse.sms.models.Grades;
import com.omniwyse.sms.models.House;
import com.omniwyse.sms.models.Images;
import com.omniwyse.sms.models.Question;
import com.omniwyse.sms.models.Question_Images;
import com.omniwyse.sms.models.Tenants;
import com.omniwyse.sms.models.Worksheet1_question;
import com.omniwyse.sms.models.Worksheets;
import com.omniwyse.sms.utils.QuestionDTO;
import com.omniwyse.sms.utils.WorkSheetsDTO;


@Service
public class QuestionService {

	@Autowired
	private com.omniwyse.sms.db.DatabaseRetrieval database;
	
	public Database db;

	@Autowired
	private DatabaseRetrieval retrive;
	
	@Autowired
	private S3BucketService s3Service;

	@Autowired
	private DBFactory dbfactory;
	
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
		 	  question.setContext(questionDTO.getContext());
		 	  
		 	  int rowEffected = db.update(question).getRowsAffected();
		 	  
		 	  Worksheet1_question wid=new Worksheet1_question();
		 	  wid.setW_id(questionDTO.getW_id());
		 	  wid.setQ_id(questionDTO.getQuestionid());
		 	  
		 	 db.update(wid).getRowsAffected();
		      
		      System.out.println("Records update successfully");
		      return rowEffected;
		  }
		   
		  @SuppressWarnings("deprecation")
			public int uploadNewImages(long tenantId, QuestionDTO imagesDTO) {

				try {
					Database schoolDb = dbfactory.getSchoolDb();
					String bucketName = schoolDb.where("id = ?", tenantId).results(Tenants.class).get(0).getDbname();
					bucketName += ".school";
					AmazonS3Client s3Client = new AmazonS3Client(new ProfileCredentialsProvider());
					db = retrive.getDatabase(tenantId);

					if (!s3Client.doesBucketExist(bucketName)) {
						s3Service.creatinBucketInS3(s3Client, bucketName);
					}
					// String[] paths = worksheets.getFilePath();
					/// for (String filePath : paths) {
					File file = new File(imagesDTO.getImage_path());
					/*long gradeNumber = db.where("id = ?", imagesDTO.getGradeid()).results(Grades.class).get(0)
							.getGradenumber();
					String subjectname = imagesDTO.getSubjectname();*/
					String defaultPath = "C:\\Users\\GK\\Desktop\\images";
					String filePath = bucketName;
					s3Client.putObject(new PutObjectRequest(filePath, imagesDTO.getImage_name(), file)
							.withCannedAcl(CannedAccessControlList.PublicRead));
					attachImagesByQuestion(tenantId, imagesDTO, defaultPath + filePath + "/" + imagesDTO.getImage_name());
					// }
					return 0;
				} catch (Exception e) 
				{
					return -1;
				}
			}
		 public int attachImagesByQuestion(long tenantId,QuestionDTO imagesDTO,String imagepath)
		 {
			 db = database.getDatabase(tenantId);
			 int rowEffected=0;
			 Long questionid=imagesDTO.getQuestionid();
			 Images img = new Images();
			 img.setImage_name(imagesDTO.getImage_name());
			 img.setImage_path(imagepath);
			 if (!db.where("Image_path = ?", imagepath).results(Images.class).isEmpty()) {
					return 0;
				}
			 img.setImage_for_id(imagesDTO.getImage_for_id());
			 img.setImage_class(imagesDTO.getImage_class());
			 
			 rowEffected = db.insert(img).getRowsAffected();
			 
			 Question_Images question_images = new Question_Images();
			 question_images.setImageid(img.getImage_id());
			 question_images.setQuestionid(questionid);
			 
			 db.insert(question_images).getRowsAffected();;
			 
			 return rowEffected;
			 
		 }

  	 
	}
	
