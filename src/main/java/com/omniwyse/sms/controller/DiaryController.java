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

import com.omniwyse.sms.models.Diary;
import com.omniwyse.sms.services.DiaryService;
import com.omniwyse.sms.utils.DiaryDTO;
import com.omniwyse.sms.utils.Response;

@RestController
@RequestMapping("/{tenantid}")
public class DiaryController {

    @Autowired
    private Response response;
    
    @Autowired
    DiaryService diaryService;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_TEACHER')")
    @RequestMapping("/addentry")
    public ResponseEntity<Response> addEntry(@PathVariable("tenantid") long tenantId, @RequestBody DiaryDTO diaryDTO) {
        int rowEffected = 0;
        rowEffected = diaryService.addEntry(tenantId, diaryDTO);
        if (rowEffected > 0) {
            response.setStatus(202);
            response.setMessage("teacher assigned successfully");
            response.setDescription("teacher assigned successfully");
            return new ResponseEntity<Response>(response, HttpStatus.ACCEPTED);
        } else {
            response.setStatus(400);
            response.setMessage("same teacher already assigned");
            response.setDescription("same teacher already assigned");
            return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);

        }
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_TEACHER')")
    @RequestMapping("/updateentry")
    public ResponseEntity<Response> updateEntry(@PathVariable("tenantid") long tenantId, @RequestBody DiaryDTO diaryDTO) {
        int rowEffected = 0;
        rowEffected = diaryService.updateEntry(tenantId, diaryDTO);
        if (rowEffected > 0) {
            response.setStatus(202);
            response.setMessage("teacher assigned successfully");
            response.setDescription("teacher assigned successfully");
            return new ResponseEntity<Response>(response, HttpStatus.ACCEPTED);
        } else {
            response.setStatus(400);
            response.setMessage("same teacher already assigned");
            response.setDescription("same teacher already assigned");
            return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);

        }
    }
    
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_TEACHER')")
    @RequestMapping("/listinformation")
    public List<Diary> listInformation(@PathVariable("tenantid") long tenantId, @RequestBody DiaryDTO diaryDTO) {
        return diaryService.listInformation(tenantId, diaryDTO);
    }

}
