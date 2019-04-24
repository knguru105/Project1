package com.omniwyse.sms.controller;

import java.util.List;

import javax.management.InstanceAlreadyExistsException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.omniwyse.sms.models.Question;
import com.omniwyse.sms.services.QuestionService;
import com.omniwyse.sms.utils.QuestionDTO;
import com.omniwyse.sms.utils.Response;

@RestController
@RequestMapping("/{tenantId}")
public class QuestionController {

		@Autowired
		private QuestionService service;
	
		@Autowired
		private Response response;

	
		@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_TEACHER')")
		@RequestMapping("/ws/questions/list")
		public List<Question> listingquestions(@PathVariable("tenantId") long tenantId) {
	
			List<Question> list = service.getQuestionList(tenantId);
	
			return list;
		}
		@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_TEACHER')")
		@RequestMapping("/ws/questions/add")
		public ResponseEntity<Response>addworksheet1(@PathVariable("tenantId") long tenantId, @RequestBody QuestionDTO questionDTO)
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
				  
			  
		}
		/*//Still working
		@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_TEACHER')")
		@RequestMapping("/ws/questions/add/{worksheetid}")
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
	*/
		 //fetching questions using question id
		  @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_TEACHER')")
		    @RequestMapping(value="/ws/questions/{questionid}", method = RequestMethod.GET, produces = "application/json")
		    public List<Question> getListOfQuestionsUsingId(@PathVariable("tenantId") long tenantId, 
		    		@PathVariable("questionid") long questionId ) {
		        return service.getListOfQuestionsUsingId(tenantId, questionId);
		    }
		  
		  
		  //accessing questiontype using question id
		  @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_TEACHER')")
		   @RequestMapping(value="/ws/questions/{questionid}/questiontype", method = RequestMethod.GET, produces = "application/json")
		   public List<QuestionDTO> getQuestionTypeByQuestionId(@PathVariable("tenantId") long tenantId, 
		    @PathVariable("questionid") long questionid ) {
		       return service.getQuestionTypeByQuestionId(tenantId, questionid);
		   }
		  //accessing mcqs by question id 
		  @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_TEACHER')")
		   @RequestMapping(value="/ws/question/{questionid}/mcq_option", method = RequestMethod.GET, produces = "application/json")
		   public List<QuestionDTO> getMcqByQuestionId(@PathVariable("tenantId") long tenantId, 
		    @PathVariable("questionid") long questionid ) {
		       return service.getMcqByQuestionId(tenantId, questionid);
		   }

}
