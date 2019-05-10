package com.omniwyse.sms.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.omniwyse.sms.models.Multiple_choice;
import com.omniwyse.sms.models.Question;
import com.omniwyse.sms.models.QuestionType;
import com.omniwyse.sms.services.QuestionService;
import com.omniwyse.sms.utils.QuestionDTO;
import com.omniwyse.sms.utils.Response;
import com.omniwyse.sms.utils.WorkSheetsDTO;
import com.omniwyse.sms.utils.Worksheet1DTO;

@RestController
@RequestMapping("/{tenantId}/ws/questions")
public class QuestionController {

		@Autowired
		private QuestionService service;
	
		@Autowired
		private Response response;

	
		@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_TEACHER')")
		@RequestMapping("/list")
		public List<Question> listingquestions(@PathVariable("tenantId") long tenantId) {
	
			List<Question> list = service.getQuestionList(tenantId);
	
			return list;
		}
		/*inserting question details through questions id
		@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_TEACHER')")
		@RequestMapping("/ws/questions/add")
		public ResponseEntity<Response>addQuestion(@PathVariable("tenantId") long tenantId, @RequestBody QuestionDTO questionDTO)
		{
			  int rowEffected = 0;
			  rowEffected = service.addQuestion(tenantId, questionDTO);
			  
			  if (rowEffected >= 0) 
			  {
				  response.setStatus(200);
				  response.setMessage("added successfully");
				  response.setDescription("added successfully");
				  return new ResponseEntity<Response>(response, HttpStatus.OK); 
				  }
			  else
			  {
				  response.setStatus(400);
				  response.setMessage("question not added");
				  response.setDescription("question not added");
				  return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
				  }
				  
			  
		}*/
		/*inserting question details through worksheet id*/
		@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_TEACHER')")
		@RequestMapping("/add/{worksheetid}")
		public ResponseEntity<Response> addQuestionUsingByWorksheet1Id(@PathVariable("tenantId") long tenantId, @RequestBody QuestionDTO questionDTO,
				@PathVariable("worksheetid") long worksheetid)
		{
			  int rowEffected = 0;
			  rowEffected = service.addQuestionUsingByWorksheet1Id(tenantId, questionDTO,worksheetid);
			  
			  if (rowEffected >= 0) 
			  {
				  response.setStatus(200);
				  response.setMessage("added successfully");
				  response.setDescription("added successfully");
				  return new ResponseEntity<Response>(response, HttpStatus.OK); 
				  }
			  else
			  {
				  response.setStatus(400);
				  response.setMessage("question not added");
				  response.setDescription("question not added");
				  return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
				  }
				  
			
		}
		
		@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_TEACHER')")
		@RequestMapping(value = "/update", method = RequestMethod.PUT, produces = "application/json")
		public ResponseEntity<Response> updateWorksheet(@PathVariable("tenantId") long tenantId,
				@RequestBody QuestionDTO updateQuestion) {

	 		int rowEffected = 0;
	 		rowEffected= service.updateQuestion(tenantId,updateQuestion);
			
	 		if (rowEffected >= 0) 
			  {
				  response.setStatus(200);
				  response.setMessage("updateQuestion successfully");
				  response.setDescription("updateQuestion successfully");
				  return new ResponseEntity<Response>(response, HttpStatus.OK); 
				  }
			  else
			  {
				  response.setStatus(400);
				  response.setMessage("question not update");
				  response.setDescription("question not update");
				  return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
				  }
			 
		 	}
	
			// list of grades_subject details by questions
			@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_TEACHER')")
		    @RequestMapping(value="/listof_grades_subjects_status", method = RequestMethod.GET, produces = "application/json")
		    public List<QuestionDTO> getListOfGradesSubjectsByQuestions(@PathVariable("tenantId") long tenantId){
		 		
		        return service.getListOfGradesSubjectsByQuestions(tenantId);
		    }
		 	
			/* List of worksheets1 table by id through grades,subjects,status table*/
		 	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_TEACHER')")
		    @RequestMapping(value="/listof_grades_subjects_status/{questionid}", method = RequestMethod.GET, produces = "application/json")
		    public List<QuestionDTO> getListOfGradesSubjectsByQuestionsId(@PathVariable("tenantId") long tenantId,@PathVariable("questionid") long questionId ){
		 		
		        return service.getListOfGradesSubjectsByQuestionsId(tenantId, questionId);
		    }
		 	
		 	/* List of QuestionAnswer */
		 	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_TEACHER')")
		    @RequestMapping(value="/answer", method = RequestMethod.GET, produces = "application/json")
		    public List<QuestionDTO> getQuestionAnswers(@PathVariable("tenantId") long tenantId){
		 		
		        return service.QuestionAnswers(tenantId);
		    }
		 	
		 	/* List of QuestionAnswer by question id */
		 	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_TEACHER')")
		    @RequestMapping(value="/answer/{questionid}", method = RequestMethod.GET, produces = "application/json")
		    public List<QuestionDTO> getQuestionAnswersByQuestionId(@PathVariable("tenantId") long tenantId,@PathVariable("questionid") long questionId){
		 		
		        return service.getQuestionAnswersByQuestionId(tenantId,questionId);
		    }
		 //fetching questions using question id
		  @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_TEACHER')")
		    @RequestMapping(value="/{questionid}", method = RequestMethod.GET, produces = "application/json")
		    public List<Question> getListOfQuestionsUsingId(@PathVariable("tenantId") long tenantId, 
		    		@PathVariable("questionid") long questionId ) {
		        return service.getListOfQuestionsUsingId(tenantId, questionId);
		    }
		  
		  
		  //accessing questiontype using question id
		  @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_TEACHER')")
		   @RequestMapping(value="/{questionid}/questiontype", method = RequestMethod.GET, produces = "application/json")
		   public List<QuestionDTO> getQuestionTypeByQuestionId(@PathVariable("tenantId") long tenantId, 
		    @PathVariable("questionid") long questionid ) {
		       return service.getQuestionTypeByQuestionId(tenantId, questionid);
		   }
		  //accessing mcqs by question id 
		  @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_TEACHER')")
		   @RequestMapping(value="/{questionid}/mcq_option", method = RequestMethod.GET, produces = "application/json")
		   public List<QuestionDTO> getMcqByQuestionId(@PathVariable("tenantId") long tenantId, 
		    @PathVariable("questionid") long questionid ) {
		       return service.getMcqByQuestionId(tenantId, questionid);
		   }
		  
		 	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_TEACHER')")
			@RequestMapping("/multiplechoice/list")
			public List<Multiple_choice> getMultipleChoice(@PathVariable("tenantId") long tenantId) {
		
				List<Multiple_choice> list = service.getMultipleChoice(tenantId);
		
				return list;
			}
		  	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_TEACHER')")
			@RequestMapping("/multiplechoice/add")
			public ResponseEntity<Response>addMultipleChoice(@PathVariable("tenantId") long tenantId, @RequestBody QuestionDTO multipleChoice)
			{
				  int rowEffected = 0;
				  rowEffected = service.addMultipleChoice(tenantId, multipleChoice);
				  
				  if (rowEffected >= 0) 
				  {
					  response.setStatus(200);
					  response.setMessage("added successfully");
					  response.setDescription("added successfully");
					  return new ResponseEntity<Response>(response, HttpStatus.OK); 
					  }
				  else
				  {
					  response.setStatus(400);
					  response.setMessage("multipleChoice not added");
					  response.setDescription("multipleChoice not added");
					  return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
					  }
					  
				  
			}
		  	
		  	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_TEACHER')")
			@RequestMapping(value = "/multiplechoice/update", method = RequestMethod.PUT, produces = "application/json")
			public ResponseEntity<Response> updateMultipleChoice(@PathVariable("tenantId") long tenantId,
					@RequestBody QuestionDTO multipleChoice) {

		 		int rowEffected = 0;
		 		rowEffected= service.updateMultipleChoice(tenantId,multipleChoice);
				
		 		if (rowEffected >= 0) 
				  {
					  response.setStatus(200);
					  response.setMessage("updateMultipleChoice successfully");
					  response.setDescription("updateMultipleChoice successfully");
					  return new ResponseEntity<Response>(response, HttpStatus.OK); 
					  }
				  else
				  {
					  response.setStatus(400);
					  response.setMessage("updateMultipleChoice not update");
					  response.setDescription("updateMultipleChoice not update");
					  return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
					  }
				 
			 	}
		  
		  	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_TEACHER')")
			@RequestMapping("/questiontype/list")
			public List<QuestionType> getQuestionType(@PathVariable("tenantId") long tenantId) {
		
				List<QuestionType> list = service.getQuestionType(tenantId);
		
				return list;
			}
		  	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_TEACHER')")
			@RequestMapping("/questiontype/add")
			public ResponseEntity<Response>addQuestionType(@PathVariable("tenantId") long tenantId, @RequestBody QuestionDTO questionType)
			{
				  int rowEffected = 0;
				  rowEffected = service.addQuestionType(tenantId, questionType);
				  
				  if (rowEffected >= 0) 
				  {
					  response.setStatus(200);
					  response.setMessage("added successfully");
					  response.setDescription("added successfully");
					  return new ResponseEntity<Response>(response, HttpStatus.OK); 
					  }
				  else
				  {
					  response.setStatus(400);
					  response.setMessage("questionType not added");
					  response.setDescription("questionType not added");
					  return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
				   }
					  
				  
			}
		  	
		  	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_TEACHER')")
			@RequestMapping(value = "/questiontype/update", method = RequestMethod.PUT, produces = "application/json")
			public ResponseEntity<Response> updateQuestionType(@PathVariable("tenantId") long tenantId,
					@RequestBody QuestionDTO questionType) {

		 		int rowEffected = 0;
		 		rowEffected= service.updateQuestionType(tenantId,questionType);
				
		 		if (rowEffected >= 0) 
				  {
					  response.setStatus(200);
					  response.setMessage("updateQuestionType successfully");
					  response.setDescription("updateQuestionType successfully");
					  return new ResponseEntity<Response>(response, HttpStatus.OK); 
					  }
				  else
				  {
					  response.setStatus(400);
					  response.setMessage("updateQuestionType not update");
					  response.setDescription("updateQuestionType not update");
					  return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
					  }
				 
			 	}
		  

		  	
		  	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_TEACHER')")
			@PostMapping("/multiplechoice/uploadimage")
			public ResponseEntity<Response> uploadNewImagesByMultipleChoice(@PathVariable("tenantId") long tenantId, @RequestBody QuestionDTO imagesDTO) {

				int rowEffected = service.uploadNewImagesByMultipleChoice(tenantId, imagesDTO);

				if (rowEffected >= 0) {
					response.setStatus(200);
					response.setMessage("Image Uploaded");
					response.setDescription("Image Uploaded successfuly");
					return new ResponseEntity<Response>(response, HttpStatus.OK);
				} else {

					response.setStatus(400);
					response.setMessage("Image Not Uploaded");
					response.setDescription("Not Uploaded");
					return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
				}

			}
		  	
		  	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_TEACHER')")
			@PostMapping("/uploadimage")
			public ResponseEntity<Response> uploadNewImages(@PathVariable("tenantId") long tenantId, @RequestBody QuestionDTO imagesDTO) {

				int rowEffected = service.uploadNewImages(tenantId, imagesDTO);

				if (rowEffected >= 0) {
					response.setStatus(200);
					response.setMessage("Image Uploaded");
					response.setDescription("Image Uploaded successfuly");
					return new ResponseEntity<Response>(response, HttpStatus.OK);
				} else {

					response.setStatus(400);
					response.setMessage("Image Not Uploaded");
					response.setDescription("Not Uploaded");
					return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
				}

			}

}
