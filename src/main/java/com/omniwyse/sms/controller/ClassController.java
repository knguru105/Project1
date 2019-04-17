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
import org.springframework.web.bind.annotation.RestController;

import com.omniwyse.sms.services.ClassService;
import com.omniwyse.sms.utils.ClassSectionTransferObject;
import com.omniwyse.sms.utils.Response;

@RestController
@RequestMapping("/{tenantId}")
public class ClassController {
	@Autowired
	private ClassService service;

	@Autowired
	private Response response;

	@PostMapping
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@RequestMapping("/createclass")
	public ResponseEntity<Response> creatingClass(@PathVariable("tenantId") long tenantId, @RequestBody ClassSectionTransferObject createclass) {

		int rowEffected = service.createClass(tenantId, createclass);

		if (rowEffected > 0) {
			response.setStatus(201);
			response.setMessage(" ClassRoom created");
			response.setDescription("ClassRoom created");
			return new ResponseEntity<Response>(response, HttpStatus.CREATED);
		} else if (rowEffected == 0) {
			response.setStatus(400);
			response.setMessage("Not a Registered Teacher or assigned to some other class");
			response.setDescription("Not a Registered Teacher or assigned to some other class");
			return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
		} else if (rowEffected == -5) {
			response.setStatus(400);
			response.setMessage("Not a valid grade");
			response.setDescription("Not a valid grade you can't create classroom");
			return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
		} else {
			response.setStatus(400);
			response.setMessage("ClassRoom already exist");
			response.setDescription("ClassRoom already exist");
			return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@RequestMapping("/updateclassteacher")
	public ResponseEntity<Response> updateClassTeachers(@PathVariable("tenantId") long tenantId, @RequestBody ClassSectionTransferObject createclass) {

		int rowEffected = service.updateClassTeacher(tenantId, createclass);

		if (rowEffected > 0) {
			response.setStatus(200);
			response.setMessage("Class Teacher updated");
			response.setDescription("Class Teacher updated successfuly");
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		} else {
			response.setStatus(400);
			response.setMessage("Teacher already assigned");
			response.setDescription("Teacher assigned as other class Teacher");
			return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
		}
	}

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @RequestMapping("/classrooms/{academicYearId}/{syllabusType}")
    public List<ClassSectionTransferObject> listSubjectTeac(@PathVariable("tenantId") long tenantId, @PathVariable("academicYearId") long academicYearId, @PathVariable("syllabusType") String syllabusType)  {
//        long academicyearid = classtransferobject.getAcademicid();
//        String syllabustype = classtransferobject.getSyllabustype();
        return service.getClassRoomsByYearAndSyllabustype(tenantId, academicYearId, syllabusType);
    }

}