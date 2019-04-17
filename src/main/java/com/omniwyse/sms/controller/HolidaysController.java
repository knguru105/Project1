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

import com.omniwyse.sms.models.Holidays;
import com.omniwyse.sms.services.HolidaysService;
import com.omniwyse.sms.utils.HolidaysDTO;
import com.omniwyse.sms.utils.Response;

@RestController
@RequestMapping(value = "/{tenantId}")
public class HolidaysController {
	@Autowired
	private HolidaysService service;

	@Autowired
	private Response response;

	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@RequestMapping(value = "/postholiday", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Response> postHoliday(@PathVariable("tenantId") long tenantId,@RequestBody HolidaysDTO holidaysdto) {

        int rowEffected = service.postHoliday(holidaysdto, tenantId);
		if (rowEffected > 0) {
			response.setStatus(200);
			response.setMessage("posted");
			response.setDescription("posted successfuly");
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		} else {
			response.setStatus(400);
            response.setMessage("already holiday posted");
            response.setDescription("already holiday exist with same date or inbetween the dates posted");
			return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
		}

	}

	@Secured(value = { "" })
	@PreAuthorize("isAuthenticated()")
	@RequestMapping("/holidays")
	public List<Holidays> listOfHolidays(@PathVariable("tenantId") long tenantId) {

		List<Holidays> list = service.listOfHolidays(tenantId);
		return list;

	}

	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
   	@RequestMapping("/editholiday")
    public ResponseEntity<Response> editHoliday(@PathVariable("tenantId") long tenantId, @RequestBody Holidays holidays) {

        service.editHoliday(holidays, tenantId);
		response.setStatus(200);
		response.setMessage("updated");
		response.setDescription("updated successfuly");
		return new ResponseEntity<Response>(response, HttpStatus.OK);

	}
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")	
	@RequestMapping("/deleteholiday")
	public ResponseEntity<Response> deleteHoliday(@PathVariable("tenantId") long tenantId,@RequestBody Holidays holiday) {

		service.deleteHoliday(holiday,tenantId);

		response.setStatus(200);
		response.setMessage("deleted");
		response.setDescription("deleted successfuly");
		return new ResponseEntity<Response>(response, HttpStatus.OK);

	}

}
