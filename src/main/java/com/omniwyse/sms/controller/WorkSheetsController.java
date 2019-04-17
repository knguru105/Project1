package com.omniwyse.sms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.omniwyse.sms.services.WorksheetService;
import com.omniwyse.sms.utils.Response;
import com.omniwyse.sms.utils.WorkSheetsDTO;
import com.omniwyse.sms.utils.WorkSheetsDTOOut;

@RestController
@RequestMapping("/{tenantId}")
public class WorkSheetsController {

	@Autowired
	private WorksheetService service;

	@Autowired
	private Response response;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_TEACHER')")
	@GetMapping
	@RequestMapping("/listlevelsofdifficulty")
	public List<WorkSheetsDTO> listDifficultyLevels(@PathVariable("tenantId") long tenantId){
		
		return service.listDifficulty(tenantId);
	}
	
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_TEACHER')")
	@PostMapping
	@RequestMapping("/myschoolworksheets")
	public List<WorkSheetsDTOOut> listingAllWorkSheets(@PathVariable("tenantId") long tenantId, @RequestBody WorkSheetsDTO worksheets) {

		List<WorkSheetsDTOOut> list = service.mySchoolWorksheets(tenantId, worksheets);

		return list;
	}

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_TEACHER')")
	@GetMapping
	@RequestMapping("/listallschoolworksheets")
	public List<WorkSheetsDTOOut> listingAllWorkSheets(@PathVariable("tenantId") long tenantId){

		List<WorkSheetsDTOOut> list = service.getListSchoolWorksheets(tenantId);

		return list;
	}

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_TEACHER')")
	@RequestMapping("/uploadmyworksheet")
	public ResponseEntity<Response> uploadWorkSheet(@PathVariable("tenantId") long tenantId, @RequestBody WorkSheetsDTO worksheets) {

		int rowEffected = service.uploadNewSheet(tenantId, worksheets);

		if (rowEffected >= 0) {
			response.setStatus(200);
			response.setMessage("WorkSheet Uploaded");
			response.setDescription("WorkSheet Uploaded successfuly");
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		} else {

			response.setStatus(400);
			response.setMessage("Worksheet Not Uploaded");
			response.setDescription("Not Uploaded");
			return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
		}

	}
}