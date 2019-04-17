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

import com.omniwyse.sms.models.PeriodTypes;
import com.omniwyse.sms.models.Periods;
import com.omniwyse.sms.models.WeekDays;
import com.omniwyse.sms.services.TimeTableService;
import com.omniwyse.sms.utils.PeriodCellDTO;
import com.omniwyse.sms.utils.PeriodDTO;
import com.omniwyse.sms.utils.PeriodTypesDTO;
import com.omniwyse.sms.utils.Response;
import com.omniwyse.sms.utils.TimetableDTO;

@RestController
@RequestMapping("/{tenantId}")
public class TimeTableController {

	@Autowired
	private TimeTableService service;

	@Autowired
	private Response response;

	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@RequestMapping("/tt/periodcell")
	public ResponseEntity<Response> addClassPeriod(@PathVariable("tenantId") long tenantId,
			@RequestBody PeriodCellDTO periodCellDTO) {
		int rowEffected = service.createClassPeriods(tenantId,periodCellDTO);
		if (rowEffected > 0) {
			response.setStatus(202);
			response.setMessage("period added");
			response.setDescription("success");
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		} else if (rowEffected == -3) {
			response.setStatus(403);
			response.setMessage("Exception occured");
			response.setDescription("Exception");
			return new ResponseEntity<Response>(response, HttpStatus.FORBIDDEN);

		} else {

			response.setStatus(400);
			response.setMessage("record existed with same Time");
			response.setDescription("record existed");
			return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
		}
	}

	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_TEACHER')")
	@RequestMapping("/tt/weekdays")
	public List<WeekDays> getWeekDays(@PathVariable("tenantId") long tenantId) {
		return service.getAllDays(tenantId);
	}

	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@RequestMapping("/tt/periodtype")
	public ResponseEntity<Response> addPeriodType(@PathVariable("tenantId") long tenantId,
			@RequestBody PeriodTypesDTO periodTypesDTO) {
		int rowEffected = service.addPeriodType(tenantId, periodTypesDTO);
		if (rowEffected > 0) {
			response.setStatus(200);
			response.setMessage("added successfully");
			response.setDescription("success");
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		} else if (rowEffected == 0) {
			response.setStatus(202);
			response.setMessage("Period type with name: " + periodTypesDTO.getName() + " already Exist");
			response.setDescription("Period type with name already Exist");
			return new ResponseEntity<Response>(response, HttpStatus.ACCEPTED);

		} else {
			response.setStatus(400);
			response.setMessage("Please provide valid data");
			response.setDescription("Please provide valid data");
			return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
		}
	}

	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@RequestMapping(value="/tt/periodtypes",method = RequestMethod.GET)
	public List<PeriodTypes> listPeriods(@PathVariable("tenantId") long tenantId) {
		return service.getPeriodTypeList(tenantId);

	}
	
	
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@RequestMapping(value="/tt/periodslist",method = RequestMethod.GET)
	public List<Periods> listAllPeriods(@PathVariable("tenantId") long tenantId) {
		return service.getPeriodsList(tenantId);

	}


	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@RequestMapping("/tt/period")
	public ResponseEntity<Response> addPeriod(@PathVariable("tenantId") long tenantId,
			@RequestBody PeriodDTO periodDTO) {
		int rowEffected = service.addPeriod(tenantId, periodDTO);
		if (rowEffected > 0) {
			response.setStatus(200);
			response.setMessage("added successfully");
			response.setDescription("success");
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		} else if (rowEffected == -5) {
			response.setStatus(202);
			response.setDescription("Period with that time already Exist");
			return new ResponseEntity<Response>(response, HttpStatus.ACCEPTED);

		} else {
			response.setStatus(202);
			response.setMessage("all period timings already added,there is no more periods");
			response.setDescription("all period timings already added,there is no more periods");
			return new ResponseEntity<Response>(response, HttpStatus.ACCEPTED);

		}
	}

	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_TEACHER')")
	@RequestMapping("/tt/periods/{classroomid}")
	public TimetableDTO listPeriods(@PathVariable("tenantId") Long tenantId,
			@PathVariable("classroomid") Long classroomid) {
		return service.listPeriods(tenantId, classroomid);
	}

	
}