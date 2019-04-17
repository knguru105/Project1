package com.omniwyse.sms.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.annotation.security.PermitAll;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dieselpoint.norm.DbException;
import com.omniwyse.sms.models.Clients;
import com.omniwyse.sms.models.Tenants;
import com.omniwyse.sms.services.LoginService;
import com.omniwyse.sms.services.MainService;
import com.omniwyse.sms.services.RegistrationService;
import com.omniwyse.sms.services.TenantService;
import com.omniwyse.sms.utils.LoginResponse;
import com.omniwyse.sms.utils.Response;
import com.omniwyse.sms.utils.ResultsTransferObject;
import com.omniwyse.sms.utils.Users;

@RestController
public class MainController {
	private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);

	@Autowired
	MainService mainservice;

	@Autowired
	private RegistrationService registrationService;

	@Autowired
	private LoginResponse response;

	@Autowired
	LoginService service;

	@PermitAll
	@RequestMapping(value = "/tenant/for/{domain}")
	public @ResponseBody Tenants getTenant(@PathVariable("domain") String domain, HttpServletRequest request,
			HttpServletResponse response) {
		// String url = null;
		// try {
		// url = new URL(request.getRequestURL().toString()).toString();
		// } catch (MalformedURLException e) {
		// e.printStackTrace();
		// }
		// String user[] = url.split("/");
		// return mainservice.getTenant(user[user.length - 1]);
		return mainservice.getTenant(domain);
	}

	@PermitAll
	@RequestMapping(value = "/tenant/login", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<LoginResponse> login(@RequestParam("code") String code, @RequestBody Clients clients) {

		Tenants tenant = mainservice.getTenantBySchoolCode(code);
		if (tenant == null) {
			response.setStatus(401);
			response.setDescription("School Code not found");
			return new ResponseEntity<LoginResponse>(response, HttpStatus.OK);
		}
		LoginResponse userDetails = service.getUser(clients, tenant.getId());
		response.setUserId(userDetails.getUserId());
		response.setUsername(userDetails.getUsername());
		response.setUserrole(userDetails.getUserrole());
		response.setStatus(200);
		response.setDescription("success");
		response.setTenant(tenant);
		return new ResponseEntity<LoginResponse>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/tenant/register", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Response> register(@RequestBody Users users) {

		Response registerResponse = new Response();
		int result = registrationService.registration(users);
		if (result > 0) {
			registerResponse.setStatus(200);
			registerResponse.setMessage("registration successful");
			registerResponse.setDescription("registrstion completed");
			return new ResponseEntity<Response>(registerResponse, HttpStatus.ACCEPTED);
		} else {
			registerResponse.setStatus(400);
			registerResponse.setMessage("already exist");
			registerResponse.setDescription("already exist");
			return new ResponseEntity<Response>(registerResponse, HttpStatus.BAD_REQUEST);
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
