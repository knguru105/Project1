package com.omniwyse.sms.utils;

import java.util.List;

import com.omniwyse.sms.models.AcademicYears;
import com.omniwyse.sms.models.Syllabus;

public class MainMenusDTO {

    private List<AcademicYears> academics;
    private List<Syllabus> boards;

    public List<AcademicYears> getAcademics() {
        return academics;
    }

    public void setAcademics(List<AcademicYears> academics) {
        this.academics = academics;
    }

    public List<Syllabus> getBoards() {
        return boards;
    }

    public void setBoards(List<Syllabus> boards) {
        this.boards = boards;
    }
    


}
