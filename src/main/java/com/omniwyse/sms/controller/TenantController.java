package com.omniwyse.sms.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.annotation.security.PermitAll;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dieselpoint.norm.DbException;
import com.omniwyse.sms.Application;
import com.omniwyse.sms.models.Tenants;
import com.omniwyse.sms.services.TenantService;
import com.omniwyse.sms.utils.Response;
import com.omniwyse.sms.utils.ResultsTransferObject;

@RestController
@RequestMapping("/schools")
public class TenantController {

	private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

	@Autowired
	private TenantService service;

	@Autowired
	private Response response;

	@RequestMapping("/list")
	public List<Tenants> getAllTenants() {
		return service.getAllTenants();
	}

	@PermitAll
	@RequestMapping(value = "/register", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Response> registerSchool(@RequestBody Tenants addSchool) throws InvocationTargetException {

		java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
		addSchool.setDateofestablishment(date);
		addSchool.setStatusid(1);
		Integer register = null;
		try {
			LOGGER.info("Saving school......");
			register = service.saveSchool(addSchool);
		} catch (DbException de) {
			LOGGER.error(" saveSchool exception : " + de);
		}
		if (register == null || register == 0) {
			response.setStatus(400);
			response.setMessage("School not Registered");
			response.setDescription("Duplicate entry");
			return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
		} else {
			response.setStatus(202);
			response.setMessage("school Registered");
			response.setDescription("Success");
			return new ResponseEntity<Response>(response, HttpStatus.ACCEPTED);
		}
	}

	/**
	 * @deprecated
	 * @param resultstransferobject
	 * @return
	 */
	@RequestMapping(value = "/view", method = RequestMethod.POST, produces = "application/json")
	public List<ResultsTransferObject> viewTestResults(@RequestBody ResultsTransferObject resultstransferobject) {
		return null;
	}
}
