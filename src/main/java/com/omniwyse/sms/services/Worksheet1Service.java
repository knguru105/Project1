package com.omniwyse.sms.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dieselpoint.norm.Database;
import com.omniwyse.sms.db.DatabaseRetrieval;
import com.omniwyse.sms.models.Degreeofdifficulty;
import com.omniwyse.sms.models.Grades;
import com.omniwyse.sms.models.House;
import com.omniwyse.sms.models.Parents;
import com.omniwyse.sms.models.Students;
import com.omniwyse.sms.models.Subjects;
import com.omniwyse.sms.models.Worksheet1;
import com.omniwyse.sms.models.Worksheet1_status;
import com.omniwyse.sms.utils.AssignmentDTO;
import com.omniwyse.sms.utils.StudentTransferObject;
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
			String query = "select worksheet1.w_id,worksheet1.worksheet_name,worksheet1.worksheet_path,grades.gradename,grades.syllabustype,"
					+ "subjects.subjectname,status.description,degreeofdifficulty.degreeofdifficulty "
					+ "from worksheets1 worksheet1 left join grades grades on worksheet1.gradeid=grades.id left join subjects subjects on worksheet1.subjectid=subjects.subjectid left join "
					+ "worksheet1_status status on worksheet1.status_id=status.id left join "
					+ "degreeofdifficulty degreeofdifficulty on worksheet1.degreeofdifficultyid=degreeofdifficulty.id";
			list = db.sql(query + " where worksheet1.w_id = ?", worksheetId).results(Worksheet1DTO.class);
			return list;
		}
		
		
		/*get Questions details by worksheet ID*/
		 public List<Worksheet1DTO> getQuestionsByWorksheetId(long tenantId, Long worksheetId) {
		 db = retrive.getDatabase(tenantId);
		 List<Worksheet1DTO> list = null;
		 String query = "select worksheet1.worksheet_name,worksheet1.worksheet_path, question.questionDescription, question.context,question.questiontype_id "
		 	+ "from worksheets1 worksheet1 left join worksheet1_question wquestion on worksheet1.w_id=wquestion.w_id left join questions question"
		 	+ " on question.questionid=wquestion.q_id";
		 list = db.sql(query + " where worksheet1.w_id = ?", worksheetId).results(Worksheet1DTO.class);
		 return list;
		 }
		 
		
		 /* public int addWorksheet1(long tenantId, Worksheet1DTO worksheetDTO) 
		  {
			  db = database.getDatabase(tenantId);
		 
		  
		  long gradeid = worksheetDTO.getGradeid();
		  long subjectid = worksheetDTO.getSubjectid();
		  long statusid = worksheetDTO.getStatus_id();
		  long degreeofdifficultyid=worksheetDTO.getDegreeofdifficultyid();
		
		  Worksheet1 worksheet = new Worksheet1();
		  
		  long gradeid1 = db.where("id=?",gradeid).results(Grades.class).get(0).getId();
		  
		 
		  long subjectid1 =	db.where("id=?",subjectid).results(Subjects.class).get(0).getId();
		  
		  long statusid1 =db.where("id=?",statusid).results(Worksheet1_status.class).get(0).getId();
		  
		  long degreeofdifficultyid1 =db.where("id=?",degreeofdifficultyid).results(Degreeofdifficulty.class).get(0).getId();
		  
		  
		  
		  worksheet.setW_id(worksheetDTO.getW_id());
		  worksheet.setWorksheet_name(worksheetDTO.getWorksheet_name());
		  worksheet.setGradeid(gradeid1);
		  worksheet.setSubjectid(subjectid1);
		  worksheet.setStatus_id(statusid1);
		  worksheet.setDegreeofdifficultyid(degreeofdifficultyid1);
		  worksheet.setWorksheet_path(worksheetDTO.getWorksheet_path());
		  worksheet.setCreatedby(worksheetDTO.getCreatedby());
		  worksheet.setCreatedon(worksheetDTO.getCreatedon());
		  worksheet.setModifiedon(worksheetDTO.getModifiedon());
		  
		  return db.insert(worksheet).getRowsAffected();
		  }
*/		
		 public int addWorksheet1(long tenantId, Worksheet1DTO worksheetDTO) 
		 {
			  db = database.getDatabase(tenantId);
			  Worksheet1 worksheet = new Worksheet1();
			  
			  worksheet.setWorksheet_name(worksheetDTO.getWorksheet_name());
			  worksheet.setGradeid(worksheetDTO.getGradeid());
			  worksheet.setSubjectid(worksheetDTO.getSubjectid());
			  worksheet.setStatus_id(worksheetDTO.getStatus_id());
			  worksheet.setDegreeofdifficultyid(worksheetDTO.getDegreeofdifficultyid());
			  worksheet.setWorksheet_path(worksheetDTO.getWorksheet_path());
			  worksheet.setCreatedby(worksheetDTO.getCreatedby());
			  worksheet.setCreatedon(worksheetDTO.getCreatedon());
			  worksheet.setModifiedon(worksheetDTO.getModifiedon());
			  
			  return db.insert(worksheet).getRowsAffected();
		  }
	 	
		 public int updateWorksheet(Worksheet1DTO updateWorksheet, long tenantId) {
			 
			 db = retrive.getDatabase(tenantId); 
			 
			 Worksheet1 work= new Worksheet1();
			 work.setW_id(updateWorksheet.getW_id());
			 work.setWorksheet_name(updateWorksheet.getWorksheet_name());
			 work.setGradeid(updateWorksheet.getGradeid());
			 work.setSubjectid(updateWorksheet.getSubjectid());
			 work.setStatus_id(updateWorksheet.getStatus_id());
			 work.setDegreeofdifficultyid(updateWorksheet.getDegreeofdifficultyid());
			 work.setWorksheet_path(updateWorksheet.getWorksheet_path());
			 work.setCreatedby(updateWorksheet.getCreatedby());
			 work.setCreatedon(updateWorksheet.getCreatedon());
			 work.setModifiedon(updateWorksheet.getModifiedon());
			 int rowEffected = db.update(work).getRowsAffected();
			 
			 return rowEffected;
			 
		 }
				
		 
		/* public String updateStudent(StudentTransferObject updateStudent, long tenantId) {
				db = retrive.getDatabase(tenantId);
				List<Grades> grade = db
						.where("gradename=? and syllabustype=?", updateStudent.getGradename(), updateStudent.getSyllabustype())
						.results(Grades.class);
				Parents parent = db.where("id=?", updateStudent.getParentid()).results(Parents.class).get(0);
				parent.setFathername(updateStudent.getFathername());
				parent.setMothername(updateStudent.getMothername());
				parent.setContactnumber(updateStudent.getContactnumber());
				parent.setAddress(updateStudent.getParentaddress());
				db.update(parent);
				Students students = new Students();
				students.setId(updateStudent.getId());
				students.setParentid(updateStudent.getParentid());
				long houseid = db.where("housename=?", updateStudent.getHousename()).results(House.class).get(0).getId();
				students.setGradeid(grade.get(0).getId());
				students.setHouseid(houseid);
				students.setName(updateStudent.getName());
				students.setMiddlename(updateStudent.getMiddlename());
				students.setLastname(updateStudent.getLastname());
				students.setGender(updateStudent.getGender());
				students.setHeight(updateStudent.getHeight());
				students.setWeight(updateStudent.getWeight());
				students.setEmailid(updateStudent.getEmailid());
				students.setBloodgroup(updateStudent.getBloodgroup());
				students.setDateofbirth(new Date(updateStudent.getDob()));
				students.setDateofjoining(new Date(updateStudent.getDoj()));
				students.setAddress(updateStudent.getAddress());
				students.setAdmissionnumber(updateStudent.getAdmissionnumber());
				int rowEffected = db.update(students).getRowsAffected();
				if (rowEffected > 0) {
					return assignStudentsToBus(tenantId, updateStudent.getRoutename(), updateStudent.getId());
				} else
					return "-10";
			}
*/
}
