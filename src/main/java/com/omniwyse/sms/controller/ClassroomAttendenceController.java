package com.omniwyse.sms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.omniwyse.sms.models.AttendanceMode;
import com.omniwyse.sms.models.ClassroomAttendance;
import com.omniwyse.sms.services.ClassroomAttendenceService;
import com.omniwyse.sms.utils.ClassAttendenceTransferObject;
import com.omniwyse.sms.utils.ClassSectionTransferObject;
import com.omniwyse.sms.utils.Response;
import com.omniwyse.sms.utils.TeacherModuleDTO;

@RestController
@RequestMapping("/{tenantId}")
public class ClassroomAttendenceController {

	@Autowired
	private ClassroomAttendenceService service;

	@Autowired
	private Response response;

	// attendance
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_TEACHER')")
	@RequestMapping(value = "/attendance/mode", method = RequestMethod.POST, produces = "application/json")
	public List<TeacherModuleDTO> listOfTeacherSubjects(@PathVariable("tenantId") long tenantId,
			@RequestBody ClassSectionTransferObject moduleDTO) {

		return service.listTeacherAttendanceOption(tenantId, moduleDTO);
	}

	// list of students for the classroom attendance
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_TEACHER')")
	@RequestMapping(value = "/listofstudentsofclassroom", method = RequestMethod.POST, produces = "application/json")
	public ClassAttendenceTransferObject listStudentsofClassroom(@PathVariable("tenantId") long tenantId,
			@RequestBody ClassAttendenceTransferObject classattendancetransferobject) {

		return service.studentsList(tenantId, classattendancetransferobject);
	}

	// attendance report
	@PreAuthorize("hasAnyRole('ROLE_TEACHER')")
	@RequestMapping(value = "/recordattendance", method = RequestMethod.POST, produces = "application/json")

	public ResponseEntity<Response> getStudentsOfClassRoom(@PathVariable("tenantId") long tenantId,
			@RequestBody List<ClassAttendenceTransferObject> classattendancetransferobject) {

		int rowEffected = service.addingAttendanceStatus(tenantId, classattendancetransferobject);

		if (rowEffected > 0) {
			response.setStatus(200);
			response.setMessage("attendance recorded");
			response.setDescription("attendance record added successfuly");
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		} else if (rowEffected == -3) {
			response.setStatus(403);
			response.setMessage("Exception occured");
			response.setDescription("Exception occured please contact Backend Team");
			return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);

		} else {
			response.setStatus(400);
			response.setMessage(" attandance already taken");
			response.setDescription("attandance Record already exist");
			return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);

		}

	}

	@PreAuthorize("hasAnyRole('ROLE_TEACHER')")
	@RequestMapping(value = "/attendance/record/{classroomid}", method = RequestMethod.POST, produces = "application/json")

	public ResponseEntity<Response> saveAttendanceForClassRoom(@PathVariable("tenantId") long tenantId,
			@PathVariable("classroomid") long classroomid,
			@RequestBody List<ClassAttendenceTransferObject> classattendancetransferobject) {

		int rowEffected = service.saveAttendanceForClassroom(tenantId, classroomid, classattendancetransferobject);

		if (rowEffected > 0) {
			response.setStatus(200);
			response.setMessage("attendance recorded");
			response.setDescription("attendance record added successfuly");
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		} else if (rowEffected == -3) {
			response.setStatus(403);
			response.setMessage("Exception occured");
			response.setDescription("Exception occured please contact Backend Team");
			return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);

		} else {
			response.setStatus(400);
			response.setMessage(" attandance already taken");
			response.setDescription("attandance Record already exist");
			return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);

		}
	}

	@PreAuthorize("hasAnyRole('ROLE_TEACHER')")
	@RequestMapping(value = "/attendance/record/{classroomid}/{subjectid}", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Response> saveAttendanceForClassRoomAndSubject(@PathVariable("tenantId") long tenantId,
			@PathVariable("classroomid") long classroomid, 	@PathVariable("subjectid") long subjectid,
			@RequestBody List<ClassAttendenceTransferObject> classattendancetransferobject) {

		int rowEffected = service.saveAttendanceForClassroomAndSubject(tenantId, classroomid, subjectid,
				classattendancetransferobject);

		if (rowEffected > 0) {
			response.setStatus(200);
			response.setMessage("attendance recorded");
			response.setDescription("attendance record added successfuly");
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		} else if (rowEffected == -3) {
			response.setStatus(403);
			response.setMessage("Exception occured");
			response.setDescription("Exception occured please contact Backend Team");
			return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);

		} else {
			response.setStatus(400);
			response.setMessage(" attandance already taken");
			response.setDescription("attandance Record already exist");
			return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
		}
	}

	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_TEACHER')")
	@RequestMapping("/attendance/{id}")
	public List<ClassAttendenceTransferObject> getClassRoomAttendance(@PathVariable("tenantId") long tenantId,
			@PathVariable("id") long classroomid) {
		return service.getAttendanceForClassRoom(tenantId, classroomid);
	}

	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_TEACHER')")
	@RequestMapping("/attendance/{id}/{subjectid}")
	public List<ClassAttendenceTransferObject> getattendance(@PathVariable("tenantId") long tenantId,
			@PathVariable("id") long classroomid, @PathVariable("subjectid") long subjectid) {
		return service.getAttendance(tenantId, classroomid, subjectid);
	}

	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_TEACHER')")
	@RequestMapping("/listdates")
	public List<ClassroomAttendance> getdates(@PathVariable("tenantId") long tenantId) {
		return service.getdates(tenantId);
	}

	@Secured(value = { "" })
	@PreAuthorize("isAuthenticated()")
	@RequestMapping("/attendancemode")
	public List<AttendanceMode> lisAttendancemodes(@PathVariable("tenantId") long tenantId) {
		return service.listattendancemodes(tenantId);

	}

	// optional attendance mode status
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@RequestMapping(value = "/attendancemodestatus", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Response> setAttendanceModeStatus(@PathVariable("tenantId") long tenantId,
			@RequestBody ClassAttendenceTransferObject classattendancetransferobject) {

		String message = service.addingAttendanceStatus(tenantId, classattendancetransferobject);
		if (message.equals("updated")) {
			response.setStatus(200);
			response.setMessage("optional attendancemode added");
			response.setDescription("optional attendancemode added successfuly");
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		} else {
			response.setStatus(400);
			response.setMessage("already maintaining " + message + " attendance");
			response.setDescription("attendancemode " + message + " already exist");
			return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);

		}

	}

}
