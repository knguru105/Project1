package com.omniwyse.sms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dieselpoint.norm.Database;
import com.omniwyse.sms.db.DatabaseRetrieval;
import com.omniwyse.sms.models.Grades;
import com.omniwyse.sms.models.Subjects;
import com.omniwyse.sms.models.Worksheet1;
import com.omniwyse.sms.models.Worksheet1_status;
import com.omniwyse.sms.utils.AssignmentDTO;
import com.omniwyse.sms.utils.Worksheet1DTO;
@Service
public class Worksheet1Service {

		@Autowired
		private com.omniwyse.sms.db.DatabaseRetrieval database;
		
		public Database db;
	
		@Autowired
		private DatabaseRetrieval retrive;
	
		
		
		public List<Worksheet1> getWorksheet1List(long tenantId) {
	
			db = retrive.getDatabase(tenantId);
	
			return db.sql("select * from worksheets1").results(Worksheet1.class);
		}
		
		public List<Worksheet1> getListOfWorksheet1UsingId(long tenantId, Long worksheetId) {
			db = retrive.getDatabase(tenantId);
			List<Worksheet1> list = null;
			String query = "select * from worksheets1";
			list = db.sql(query + " where worksheets1.w_id = ?", worksheetId  ).results(Worksheet1.class);
			return list;
			}
		
		
		
		public List<Worksheet1DTO> getWorksheetById(long tenantId, Long worksheetId) {
			db = retrive.getDatabase(tenantId);
			List<Worksheet1DTO> list = null;
			String query = "select worksheet1.w_id,worksheet1.worksheet_name,worksheet1.worksheet_path,grades.gradename,grades.syllabustype,subjects.subjectname,status.description "
					+ "from worksheets1 worksheet1 left join grades grades on worksheet1.gradeid=grades.id left join subjects subjects on worksheet1.subjectid=subjects.subjectid left join "
					+ "worksheet1_status status on worksheet1.status_id=status.id";
			list = db.sql(query + " where worksheet1.w_id = ?", worksheetId).results(Worksheet1DTO.class);
			return list;
		}
		
		
		//get Questions by worksheet ID
		 public List<Worksheet1DTO> getQuestionsByWorksheetId(long tenantId, Long worksheetId) {
		 db = retrive.getDatabase(tenantId);
		 List<Worksheet1DTO> list = null;
		 String query = "select worksheet1.worksheet_name,worksheet1.worksheet_path, question.questionDescription, question.context "
		 	+ "from worksheets1 worksheet1 left join worksheet1_question wquestion on worksheet1.w_id=wquestion.w_id left join questions question"
		 	+ " on question.questionid=wquestion.q_id";
		 list = db.sql(query + " where worksheet1.w_id = ?", worksheetId).results(Worksheet1DTO.class);
		 return list;
		 }
		 
		
		
		
		
		
		  public int addWorksheet1(long tenantId, Worksheet1DTO worksheetDTO) 
		  {
			  db = database.getDatabase(tenantId);
		 
		  
		  long gradeid = worksheetDTO.getGradeid();
		  long subjectid = worksheetDTO.getSubjectid();
		  long statusid = worksheetDTO.getStatus_id();
		
		  Worksheet1 worksheet = new Worksheet1();
		  
		  long gradeid1 = db.where("id=?",gradeid).results(Grades.class).get(0).getId();
		  
		 
		  long subjectid1 =	db.where("id=?",subjectid).results(Subjects.class).get(0).getId();
		  
		  long statusid1 =db.where("id=?",statusid).results(Worksheet1_status.class).get(0).getId();
		  
		  
		  
		  worksheet.setW_id(worksheetDTO.getW_id());
		  worksheet.setWorksheet_name(worksheetDTO.getWorksheet_name());
		  worksheet.setGradeid(gradeid1);
		  worksheet.setSubjectid(subjectid1);
		  worksheet.setStatus_id(statusid1);
		  worksheet.setWorksheet_path(worksheetDTO.getWorksheet_path());
		  worksheet.setCreatedby(worksheetDTO.getCreatedby());
		  worksheet.setCreatedon(worksheetDTO.getCreatedon());
		  worksheet.setModifiedon(worksheetDTO.getModifiedon());
		  
		  return db.insert(worksheet).getRowsAffected();
		  }
		
		 /* public String deleteStudent(String registrationNumber) {
			  for(int i=0; i<studentRecords.size(); i++)
			          {
			              Student stdn = studentRecords.get(i);
			              if(stdn.getRegistrationNumber().equals(registrationNumber)){
			                studentRecords.remove(i);//update the new record
			                return "Delete successful";
			              }
			          }
			  return "Delete un-successful";
			  }*/
		  
		  
		 /* public int DeleteWorksheet1(long tenantId, Worksheet1DTO worksheetDTO)
		  {
			  db = database.getDatabase(tenantId);
			  
		  }*/
	
}
