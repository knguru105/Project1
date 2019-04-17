package com.omniwyse.sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.omniwyse.sms.services.TeacherService;
import com.omniwyse.sms.utils.Response;
import com.omniwyse.sms.utils.TeachersDTO;

@RestController
@RequestMapping("/{tenantId}")
public class TeacherController {

	@Autowired
	private TeacherService service;

	@Autowired
	private Response response;

	private int rowEffected;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@RequestMapping(value = "/addteacher", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Response> addTeachers(@PathVariable("tenantId") long tenantId, @RequestBody TeachersDTO addTeacher) {

		rowEffected = service.addTeacher(tenantId, addTeacher);
		if(rowEffected==5){
			response.setStatus(400);
			response.setMessage("updated successfully");
			response.setDescription("updated successfully");
			return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
		} 
		else if (rowEffected > 0) {
			response.setStatus(202);
			response.setMessage("Teacher registration successfull");
			response.setDescription("Teacher registered successfuly");
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		} else if(rowEffected ==-1||rowEffected==-5){
			
			response.setStatus(400);
			response.setMessage("Email already Registered with another user");
			response.setDescription("Duplicate Email");
			return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
		} else if(rowEffected==-10){
			response.setStatus(400);
			response.setMessage("enter valid emailid");
			response.setDescription("enter valid emailid");
			return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
		} 
		else {
			response.setStatus(400);
			response.setMessage("try again");
			response.setDescription("try again"); 
			return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
		}
	}

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@RequestMapping(value = "/updateteacher", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Response> updateTeachers(@PathVariable("tenantId") long tenantId, @RequestBody TeachersDTO updateTeacher) {
		rowEffected = service.addTeacher(tenantId, updateTeacher);
		if (rowEffected > 0) {
			response.setStatus(202);
			response.setMessage("Teacher data updated");
			response.setDescription("Teacher data added successfuly");
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		} else {
			response.setStatus(400);
			response.setMessage("Teacher already Exists");
			response.setDescription("Teacher already Exists");
			return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
		}
	}
}