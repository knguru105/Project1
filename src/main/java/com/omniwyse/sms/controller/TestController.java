package com.omniwyse.sms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.omniwyse.sms.models.TestType;
import com.omniwyse.sms.models.Testmode;
import com.omniwyse.sms.services.TestService;
import com.omniwyse.sms.utils.Response;
import com.omniwyse.sms.utils.TestSubjectsDisplay;
import com.omniwyse.sms.utils.TestSyllabusDTO;
import com.omniwyse.sms.utils.TestTransferObject;

@RestController
@RequestMapping("/{tenantId}")
public class TestController {

	@Autowired
	private TestService service;

	@Autowired
	private Response response;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@RequestMapping(value = "/addtesttype", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Response> addTestType(@PathVariable("tenantId") long tenantId,@RequestBody TestType testtype) {
		int rowEffected = service.addTestType(tenantId, testtype);
		if (rowEffected > 0) {
			response.setStatus(202);
			response.setMessage("testtype added");
			response.setDescription("testtype  added successfuly");
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		} else {

			response.setStatus(400);
			response.setMessage("testtype already added");
			response.setDescription("testtype already exists in records");
			return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
		}
	}

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@RequestMapping("/listtesttype")
	public List<TestType> listTestType(@PathVariable("tenantId") long tenantId) {
		return service.listtesttypes(tenantId);

	}

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@RequestMapping("/listtestmode")
	public List<Testmode> listTestmode(@PathVariable("tenantId") long tenantId) {
		return service.listtestmodes(tenantId);

	}

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@RequestMapping("/listalltests")
	public List<TestTransferObject> listTests(@PathVariable("tenantId") long tenantId) {
		return service.listAllTests(tenantId);

	}

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@RequestMapping(value = "/createtest", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Response> createTest(@PathVariable("tenantId") long tenantId,@RequestBody TestTransferObject testcreate) {
		int rowEffected = service.createTest(tenantId, testcreate);
		if (rowEffected > 0) {
			response.setStatus(202);
			response.setMessage("test scheduled");
			response.setDescription("test scheduled successfuly");
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		} else {

			response.setStatus(400);
			response.setMessage("test already scheduled");
			response.setDescription("test already scheduled");
			return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
		}
	}

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_TEACHER','ROLE_PARENT')")
	@RequestMapping(value = "/listtests", method = RequestMethod.POST, produces = "application/json")
	public List<TestTransferObject> getListOfTests(@PathVariable("tenantId") long tenantId, @RequestBody TestTransferObject testcreate){
		List<TestTransferObject> tests= service.getListOfTests(tenantId, testcreate);

        return tests;
	}
    
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_TEACHER','ROLE_PARENT')")
    @RequestMapping(value = "/testsubjectdetails", method = RequestMethod.POST, produces = "application/json")
    public List<TestSubjectsDisplay> getListOfTestsubjects(@PathVariable("tenantId") long tenantId,
            @RequestBody TestTransferObject testcreate) {
        List<TestSubjectsDisplay> tests = service.getTestSubjectsDetails(tenantId, testcreate);

        return tests;
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_TEACHER','ROLE_PARENT')")
    @RequestMapping(value = "/listtestsbystudent", method = RequestMethod.POST, produces = "application/json")
    public List<TestTransferObject> getListOfTestsByParent(@PathVariable("tenantId") long tenantId,@RequestBody TestTransferObject testcreate) {
        List<TestTransferObject> tests = service.getListOfTestsByParent(tenantId, testcreate);
        if (tests.isEmpty()) {
            return null;
        }
        return tests;

    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_TEACHER')")
	@RequestMapping(value = "/listtestsubjects", method = RequestMethod.POST, produces = "application/json")
	public List<TestSubjectsDisplay> getListOfTestSubjects(@PathVariable("tenantId") long tenantId, @RequestBody TestSubjectsDisplay testsubjectsdisplay) {
		return service.getListOfTestSubjects(tenantId, testsubjectsdisplay);

	}
	
	

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_TEACHER')")
    @RequestMapping(value = "/addoreditsyllabus", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Response> addSyllabus(@PathVariable("tenantId") long tenantId, @RequestBody TestSyllabusDTO testSyllabusDTO) {
        int rowEffected = service.addorEditSyllabus(tenantId, testSyllabusDTO);
		if(rowEffected > 0){
		response.setStatus(202);
		response.setMessage("syllubs added successfully");
		response.setDescription("syllabus added successfuly");
		return new ResponseEntity<Response>(response, HttpStatus.OK);
		} 
		else {
			return new ResponseEntity<Response>(response,HttpStatus.BAD_REQUEST);
		}

	}

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_TEACHER')")
    @RequestMapping(value = "/liststatusoftests", method = RequestMethod.GET, produces = "application/json")
    public List<TestTransferObject> listingTypesOfStatus(@PathVariable("tenantId") long tenantId){
    	
    	return service.getListOfTestStatus(tenantId);
    }
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_TEACHER')")
    @RequestMapping(value = "/changeteststatus", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Response> changeTestStatus(@PathVariable("tenantId") long tenantId, @RequestBody TestTransferObject data) {
        int rowEffected = service.changeStatusOfTest(tenantId, data);
		if(rowEffected > 0){
		response.setStatus(202);
		response.setMessage("Status changed successfully");
		response.setDescription("Test Status Changed");
		return new ResponseEntity<Response>(response, HttpStatus.OK);
		} 
		else {
			response.setStatus(400);
			response.setMessage("Failed to change status");
			response.setDescription("unable to change");			
			return new ResponseEntity<Response>(response,HttpStatus.BAD_REQUEST);
		}

	}
}
