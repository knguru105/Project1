package com.omniwyse.sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.omniwyse.sms.services.MainMenusService;
import com.omniwyse.sms.utils.MainMenusDTO;

@RestController
@RequestMapping("/{tenantId}")
public class MainMenusController {

	@Autowired
	private MainMenusService mainmenusservice;

	@Secured(value = { "" })
    @PreAuthorize("isAuthenticated()")
	@RequestMapping("/academicsandboards")
	public MainMenusDTO getAllAcademicsandBoards(@PathVariable("tenantId") long tenantId) {
		return mainmenusservice.getAllAcademicsandBoards(tenantId);
	}

}
