package com.omniwyse.sms.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.omniwyse.sms.models.ClassRoom;
import com.omniwyse.sms.services.StudentsDateOfBirthService;
import com.omniwyse.sms.utils.DateOfBirthDTO;

@RestController
@RequestMapping("/{tenantId}")
public class StudentsDateOfBirthController {

	@Autowired
	StudentsDateOfBirthService studentsDateOfBirthService;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_TEACHER')")
	@RequestMapping("/birthday/classteacher")
	public List<DateOfBirthDTO> getClassStudentsBirthDay(@PathVariable("tenantId") long tenantId,@RequestBody DateOfBirthDTO dateOfBirthDTO) {
		return studentsDateOfBirthService.getClassStudentsBirthDay(dateOfBirthDTO,tenantId);

	}

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_TEACHER')")
	@RequestMapping("/today/classsubjectteacher")
	public List<DateOfBirthDTO> getClassSubjectsStudentsBirthDay(@PathVariable("tenantId") long tenantId,@RequestBody DateOfBirthDTO dateOfBirthDTO) {
    	Date dateNow = new Date();
		SimpleDateFormat dateformatJava = new SimpleDateFormat("dd-MM-yyyy");
		String date_to_string = dateformatJava.format(dateNow);
    	
    	return studentsDateOfBirthService.getClassSubjectsStudentsBirthDay(dateOfBirthDTO,tenantId,date_to_string);
	}

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_TEACHER')")
   	@RequestMapping("/tomorrow/classsubjectteacher")
   	public List<DateOfBirthDTO> getClassSubjectsStudentsBirthDayTomorrow(@PathVariable("tenantId") long tenantId,@RequestBody DateOfBirthDTO dateOfBirthDTO) {
    	Date dt = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(dt);
		c.add(Calendar.DATE, 1);
		dt = c.getTime();
		SimpleDateFormat dateformatJava = new SimpleDateFormat("dd-MM-yyyy");
		String date_to_string = dateformatJava.format(dt);
    	return studentsDateOfBirthService.getClassSubjectsStudentsBirthDay(dateOfBirthDTO,tenantId,date_to_string);
   	}

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_TEACHER')")
	@RequestMapping("/birthday/today")
    
	public List<DateOfBirthDTO> getStudentsBirthDays(@PathVariable("tenantId") long tenantId) {
    	Date dateNow = new Date();
		SimpleDateFormat dateformatJava = new SimpleDateFormat("dd-MM-yyyy");
		String date_to_string = dateformatJava.format(dateNow);
		date_to_string = "%" + date_to_string.substring(3, 5) + "-" + date_to_string.substring(0, 2)+"%";
		return studentsDateOfBirthService.getStudentsBirthDays(tenantId,date_to_string);

	}
	
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_TEACHER')")
   	@RequestMapping("/birthday/tomorrow")
   	public List<DateOfBirthDTO> getStudentsBirthDaysTomorrow(@PathVariable("tenantId") long tenantId) {
    	Date dateNow = new Date();
		SimpleDateFormat dateformatJava = new SimpleDateFormat("dd-MM-yyyy");
		String date_to_string = dateformatJava.format(dateNow);
		date_to_string = "%" + date_to_string.substring(3, 5)+ "-" + (date_to_string.substring(0, 2)+1)+"%";
   		return studentsDateOfBirthService.getStudentsBirthDays(tenantId,date_to_string);

   	}
   	
   
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_TEACHER')")
	@RequestMapping("/birthday/myclassstudentstoday")
	public List<DateOfBirthDTO> getBirthDaysOfMyClassStudents(@PathVariable("tenantId") long tenantId,@RequestBody ClassRoom classRoom) {
		return studentsDateOfBirthService.getBirthDaysOfMyClassStudents(classRoom,tenantId);

	}

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_TEACHER')")
	@RequestMapping("/birthday/myclassstudentstomorrow")
	public List<DateOfBirthDTO> getTomorrowBirthDaysOfMyClassStudents(@PathVariable("tenantId") long tenantId,@RequestBody ClassRoom classRoom) {
		return studentsDateOfBirthService.getTomorrowBirthDaysOfMyClassStudents(classRoom,tenantId);

	}
}
