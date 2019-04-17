package com.omniwyse.sms.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dieselpoint.norm.Database;
import com.omniwyse.sms.Application;
import com.omniwyse.sms.db.DatabaseRetrieval;
import com.omniwyse.sms.models.AcademicYears;
import com.omniwyse.sms.models.Syllabus;
import com.omniwyse.sms.utils.MainMenusDTO;

@Service
public class MainMenusService {

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    @Autowired
    private DatabaseRetrieval retrieve;

    private Database db;

    public MainMenusDTO getAllAcademicsandBoards(long tenantId) {
        LOGGER.info(" : getting all Academics and Education Boards for Config module.");

        db = retrieve.getDatabase(tenantId);
        
        MainMenusDTO academicsandboards = new MainMenusDTO();

        List<AcademicYears> academicslist = db.results(AcademicYears.class);
        List<Syllabus> boardslist = db.results(Syllabus.class);
        academicsandboards.setAcademics(academicslist);
        academicsandboards.setBoards(boardslist);

        return academicsandboards;
    }

}
