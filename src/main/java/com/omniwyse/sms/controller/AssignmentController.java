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

import com.omniwyse.sms.models.AssignmentType;
import com.omniwyse.sms.models.Assignments;
import com.omniwyse.sms.services.AssignmentService;
import com.omniwyse.sms.utils.AssignmentDTO;
import com.omniwyse.sms.utils.AssignmentDTOOut;
import com.omniwyse.sms.utils.Response;
import com.omniwyse.sms.utils.TimelineDTO;

@RestController
@RequestMapping("/{tenantId}")
public class AssignmentController {

    @Autowired
    private AssignmentService assignmentService;

    @Autowired
    private Response response;
    
    
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_TEACHER')")
	@RequestMapping(value = "/assignments/types", method = RequestMethod.POST, produces = "application/json")

	public ResponseEntity<Response> addAssignmentType(@PathVariable("tenantId") long tenantId,
			@RequestBody AssignmentType assignmentType) {

		int rowEffected = assignmentService.addAssignmentType(tenantId, assignmentType);
		if (rowEffected == 1) {
			response.setStatus(200);
			response.setMessage("AssignmentType added successfuly");
			response.setDescription("AssignmentType added successfuly");
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		} else {
			response.setStatus(202);
			response.setMessage("AssignmentType already Exist");
			response.setDescription("AssignmentType already Exist");
			return new ResponseEntity<Response>(response, HttpStatus.ACCEPTED);
		}
	}
	
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_TEACHER')")
	@RequestMapping(value = "/assignments/types", method = RequestMethod.GET, produces = "application/json")

	public List<AssignmentType> addAssignmentType(@PathVariable("tenantId") long tenantId) {
		return assignmentService.getAssignmentTypeList(tenantId);
	}    
    
    
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_TEACHER')")
    @RequestMapping("/assignments/assign")
    public ResponseEntity<Response> assignmentAssigning(@PathVariable("tenantId") long tenantId,
            @RequestBody AssignmentDTO assigning) {

        int rowEffected = assignmentService.assignAssignment(tenantId, assigning);
        if (rowEffected > 0) {
            response.setStatus(200);
            response.setMessage("Assigned successfuly");
            response.setDescription("Assigned successfuly");
            return new ResponseEntity<Response>(response, HttpStatus.OK);
        } else {
            response.setStatus(400);
            response.setMessage("failed to assign");
            response.setDescription("failed to assign to class");
            return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_TEACHER')")
    @RequestMapping("/assignments/delete")
    public ResponseEntity<Response> deleteAssignedAssignment(@PathVariable("tenantId") long tenantId,
            @RequestBody Assignments data) {
        int rowEffected = assignmentService.deleteAssignedAssignment(data, tenantId);
        if (rowEffected > 0) {
            response.setStatus(200);
            response.setMessage("deleted successfuly");
            response.setDescription("deleted successfuly");
            return new ResponseEntity<Response>(response, HttpStatus.OK);
        } else {
            response.setStatus(400);
            response.setMessage("try again");
            response.setDescription("try again");
            return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
        }

    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_TEACHER')")
    @RequestMapping(value="/assignments/classroom/{classroomid}", method = RequestMethod.GET, produces = "application/json")
    public List<AssignmentDTO> getAssignmentForClassRoom(@PathVariable("tenantId") long tenantId, 
    		@PathVariable("classroomid") long classRoomId ) {
        return assignmentService.getAssignmentForClassRoom(tenantId, classRoomId);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_TEACHER')")
    @RequestMapping(value = "/assignments/classroom/{classroomid}/{subjectid}", method = RequestMethod.GET, produces = "application/json")
    public List<AssignmentDTO> getAssignmentsListForSubject(@PathVariable("tenantId") long tenantId, 
    		@PathVariable("classroomid") long classRoomId, @PathVariable("subjectid") long subjectId
          ) {
        return assignmentService.getAssignmentsForClassRoomAndSubject(tenantId, classRoomId, subjectId);
    }

}
