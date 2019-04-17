package com.omniwyse.sms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.omniwyse.sms.models.Buses;
import com.omniwyse.sms.models.Routes;
import com.omniwyse.sms.models.Staff;
import com.omniwyse.sms.models.Stops;
import com.omniwyse.sms.models.Teachers;
import com.omniwyse.sms.services.TransportationService;
import com.omniwyse.sms.utils.BusSummeryDTO;
import com.omniwyse.sms.utils.Response;
import com.omniwyse.sms.utils.RoutesDTO;
import com.omniwyse.sms.utils.RoutesDisplayDTO;
import com.omniwyse.sms.utils.RoutesToStudents;
import com.omniwyse.sms.utils.StaffDTO;

@RestController
@RequestMapping("/{tenantId}")
public class TransportationController {
	@Autowired
	private TransportationService service;
	@Autowired
	private Response response;

	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@RequestMapping("/busregistration")
	public ResponseEntity<Response> busRegistration(@PathVariable("tenantId") long tenantId, @RequestBody Buses bus) {
		int rowEffected = service.busRegistration(tenantId, bus);
		if (rowEffected > 0) {
			response.setStatus(200);
			response.setMessage("Bus registration successfull");
			response.setDescription("bus registration successfull");
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		} else if (rowEffected == 0) {
			response.setStatus(400);
			response.setMessage("Bus number already registered");
			response.setDescription("Bus number already registered");
			return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
		} else if (rowEffected == 5) {
			response.setStatus(200);
			response.setMessage("Bus details updated successfully");
			response.setDescription("Bus details updated successfully");
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		} else {
			response.setStatus(400);
			response.setMessage("enter valid registration number");
			response.setDescription("enter valid registration number");
			return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
		}

	}

	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@RequestMapping("/staffregistration")
	public ResponseEntity<Response> addStaff(@PathVariable("tenantId") long tenantId, @RequestBody StaffDTO staffDTO) {
		int rowEffected = service.addStaff(tenantId, staffDTO);
		if (rowEffected > 0) {
			response.setStatus(200);
			response.setMessage("added successfully");
			response.setDescription("added successfully");
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		} else if (rowEffected == -5) {
			response.setStatus(200);
			response.setMessage("already registerd");
			response.setDescription("already registerd");
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		} else if (rowEffected == -10) {
			response.setStatus(200);
			response.setMessage("please enter license number");
			response.setDescription("please enter license number");
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		} else {
			response.setStatus(400);
			response.setMessage("try again");
			response.setDescription("try again");
			return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
		}

	}

	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@RequestMapping("/addstop")
	public ResponseEntity<Response> addStop(@PathVariable("tenantId") long tenantId, @RequestBody Stops stops) {
		int rowEffected = service.addStop(tenantId, stops);
		if (rowEffected > 0) {
			response.setStatus(200);
			response.setMessage("Stop added successfully");
			response.setDescription("Stop added successfully");
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		} else if (rowEffected == 5) {
			response.setStatus(200);
			response.setMessage("edited successfully");
			response.setDescription("edited successfully");
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		}else {
			response.setStatus(400);
			response.setMessage("stop already added");
			response.setDescription("stop already added");
			return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
		}

	}

	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@RequestMapping("/addbusdetails")
	public ResponseEntity<Response> addBusDetails(@PathVariable("tenantId") long tenantId,
			@RequestBody RoutesDTO routesDTO) {
		service.addBusDetails(tenantId, routesDTO);
			response.setStatus(200);
			response.setMessage("added successfully");
			response.setDescription("added successfully");
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		
	}

	

	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@RequestMapping("/buses")
	public List<Buses> buses(@PathVariable("tenantId") long tenantId) {
		return service.buses(tenantId);
	}

	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@RequestMapping("/stops")
	public List<Stops> stops(@PathVariable("tenantId") long tenantId) {
		return service.stops(tenantId);
	}

	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@RequestMapping("/staff")
	public List<StaffDTO> staff(@PathVariable("tenantId") long tenantId) {
		return service.staff(tenantId);
	}

	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@RequestMapping("/listingroutestostudents")
	public List<RoutesToStudents> listingRoutesToStudents(@PathVariable("tenantId") long tenantId) {
		return service.listingRoutestoStudents(tenantId);
	}

	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@RequestMapping("/routes")
	public List<RoutesDisplayDTO> routes(@PathVariable("tenantId") long tenantId) {
		return service.routes(tenantId);
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@RequestMapping("/addroute")
	public ResponseEntity<Response> addRoute(@PathVariable("tenantId") long tenantId,
			@RequestBody RoutesDTO routesDTO) {
		String message = service.addRoute(tenantId, routesDTO);
		if (message.equals("1")) {
			response.setStatus(200);
			response.setMessage("added successfully");
			response.setDescription("added successfully");
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		} else if (message.equals("0")) {
			response.setStatus(400);
			response.setMessage("route number assigned to another route");
			response.setDescription("route number assigned to another route");
			return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
		} else {
			response.setStatus(400);
			response.setMessage("please enter the route number: " + message);
			response.setDescription("please enter the route number: " + message);
			return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
		}

	}

	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@RequestMapping("/deletebus")
	public ResponseEntity<Response> deleteBus(@PathVariable("tenantId") long tenantId, @RequestBody Buses bus) {
		int rowEffected = service.deleteBus(tenantId, bus);
		if (rowEffected > 0) {
			response.setStatus(200);
			response.setMessage("deleted successfull");
			response.setDescription("deleted successfull");
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		} else {
			response.setStatus(400);
			response.setMessage("Bus is active don't delete");
			response.setDescription("Bus is active don't delete");
			return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
		}

	}

	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@RequestMapping("/deletestaff")
	public ResponseEntity<Response> deleteStaff(@PathVariable("tenantId") long tenantId,@RequestBody StaffDTO staffDTO) {
		service.deleteStaff(tenantId,staffDTO);
		response.setStatus(200);
		response.setMessage("deleted successfull");
		response.setDescription("deleted successfull");
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@RequestMapping("/deletestop")
	public ResponseEntity<Response> deleteStop(@PathVariable("tenantId") long tenantId,@RequestBody Stops stops) {
		service.stops(tenantId, stops);
		response.setStatus(200);
		response.setMessage("deleted successfull");
		response.setDescription("deleted successfull");
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@RequestMapping("/deleteroutes")
	public ResponseEntity<Response> deleteRoute(@PathVariable("tenantId") long tenantId,@RequestBody Routes route) {
		int rowEffected=service.deleteRoute(tenantId,route);
		if(rowEffected>0)
		{
		response.setStatus(200);
		response.setMessage("deleted successfull");
		response.setDescription("deleted successfull");
		return new ResponseEntity<Response>(response, HttpStatus.OK);
		}
		else
		{
			response.setStatus(400);
			response.setMessage("try again");
			response.setDescription("try again");
			return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
		}
	}


	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@RequestMapping("/bussummery")
	public List<BusSummeryDTO> busSummery(@PathVariable("tenantId") long tenantId) {
		return service.busSummery(tenantId);
	}

	

	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@RequestMapping("/bus/drivers")
	public List<Staff> busDrivers(@PathVariable("tenantId") long tenantId) {
		return service.busDrivers(tenantId);
	}
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@RequestMapping("/routes/buses")
	public List<Buses> routesBuses(@PathVariable("tenantId") long tenantId) {
		return service.routeBuses(tenantId);
	}

	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@RequestMapping("/bus/attenders")
	public List<Staff> busAttenders(@PathVariable("tenantId") long tenantId) {
		return service.busAttenders(tenantId);
	}

	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@RequestMapping("/bus/teachers")
	public List<Teachers> busTeachers(@PathVariable("tenantId") long tenantId) {
		return service.busTeachers(tenantId);
	}

}