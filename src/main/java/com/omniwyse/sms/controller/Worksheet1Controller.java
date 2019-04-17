package com.omniwyse.sms.controller;

import java.util.List;
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

import com.omniwyse.sms.models.Worksheet1;
import com.omniwyse.sms.services.Worksheet1Service;
import com.omniwyse.sms.utils.Response;
import com.omniwyse.sms.utils.Worksheet1DTO;

@RestController
@RequestMapping("/{tenantId}")
public class Worksheet1Controller {

		@Autowired
		private Worksheet1Service service;
		@Autowired
		private Response response;
		  
	
	 
	 	/* List of worksheets1*/
		@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_TEACHER')")
		@GetMapping
		@RequestMapping("/ws/worksheet/list")
		public List<Worksheet1> listingWorksheets(@PathVariable("tenantId") long tenantId){
	
			List<Worksheet1> list = service.getWorksheet1List(tenantId);
	
			return list;
		}
	
		/* List of worksheets1 table by id*/
		@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_TEACHER')")
		@RequestMapping(value="/ws/worksheet/{worksheetsId}", method = RequestMethod.GET, produces = "application/json")
		public List<Worksheet1> getListOfWorksheet1UsingId(@PathVariable("tenantId") long tenantId,@PathVariable("worksheetsId") long worksheetsId ){
	      
			return service.getListOfWorksheet1UsingId(tenantId, worksheetsId);
		}
	
		/* List of worksheets1 table by id through grades,subjects,status table*/
	 	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_TEACHER')")
	    @RequestMapping(value="/ws/worksheet/listof_grades_subjects_status/{worksheetsId}", method = RequestMethod.GET, produces = "application/json")
	    public List<Worksheet1DTO> getWorksheets1ById(@PathVariable("tenantId") long tenantId,@PathVariable("worksheetsId") long worksheetsId ){
	 		
	        return service.getWorksheetById(tenantId, worksheetsId);
	    }
	 	
	 	 //accessing question using worksheet id
	 	 @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_TEACHER')")
	 	 @RequestMapping(value="/ws/worksheet/{worksheetsId}/questions", method = RequestMethod.GET, produces = "application/json")
	 	 public List<Worksheet1DTO> getQuestionsByWorksheetId(@PathVariable("tenantId") long tenantId,@PathVariable("worksheetsId") long worksheetsId ){
	 		 
	 	      return service.getQuestionsByWorksheetId(tenantId, worksheetsId);
	 	 }
	 	 

	 	/* add worksheets1 Details*/
	 	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_TEACHER')")
	 	@RequestMapping("/ws/worksheet/add")
	 	public ResponseEntity<Response>addworksheet1(@PathVariable("tenantId") long tenantId, @RequestBody Worksheet1DTO worksheetDTO)
	 	{
		  int rowEffected = 0;
		  rowEffected = service.addWorksheet1(tenantId, worksheetDTO);
		  
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
			  response.setMessage("Worksheet not added");
			  response.setDescription("Worksheet not added");
			  return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
			  }
		 
	 	}
	  

	
}
