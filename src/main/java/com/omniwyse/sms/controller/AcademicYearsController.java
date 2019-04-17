package com.omniwyse.sms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.omniwyse.sms.models.AcademicYears;
import com.omniwyse.sms.services.AcademisYearsService;
import com.omniwyse.sms.utils.AcademicYearsDTO;
import com.omniwyse.sms.utils.Response;
@RestController
@RequestMapping("/{tenantId}")
public class AcademicYearsController {
	@Autowired
	private AcademisYearsService service;

	@Autowired
	private Response response;
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@RequestMapping("/addacademicyear")
	public ResponseEntity<Response> addacademicyear(@PathVariable("tenantId") long tenantId, @RequestBody AcademicYearsDTO academicyears) {

		int rowEffected = service.addAcademicYears(tenantId, academicyears);
		if (rowEffected == 0) {
			response.setStatus(400);
			response.setMessage("academic year alredy exist");
			response.setDescription("academicyear already exist");
			return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
		} else if (rowEffected == 1) {
			response.setStatus(200);
			response.setMessage("added or updated successfully");
			response.setDescription("added or updated successfully");
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		}  else if (rowEffected == -5) {
			response.setStatus(400);
			response.setMessage("already another academic year is active,please make it inactive");
			response.setDescription("already another academic year is active,please make it inactive");
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		}
		else {
			response.setStatus(200);
			response.setMessage("updated success fully");
			response.setDescription("updated successfuly");
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		}
		}
//	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@PreAuthorize("isAuthenticated()")
	@RequestMapping("/academicyear")
	public List<AcademicYears> getacademicyear(@PathVariable("tenantId") long tenantId) {

		return service.getAcademicYears(tenantId);

	}
}
