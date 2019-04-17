package com.omniwyse.sms.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dieselpoint.norm.Database;
import com.omniwyse.sms.models.Diary;
import com.omniwyse.sms.utils.DiaryDTO;

@Service
public class DiaryService {

	@Autowired
	private com.omniwyse.sms.db.DatabaseRetrieval database;

	public Database db;

	public int addEntry(long tenantId, DiaryDTO diaryDTO) {
		db = database.getDatabase(tenantId);

		int rowEffected = 0;
		Diary diary = new Diary();
		Date entrydate = new Date(diaryDTO.getEntryDate());

		diary.setTag(diaryDTO.getTag());
		diary.setDescription(diaryDTO.getDescription());
		diary.setEntrydate(entrydate);
		diary.setLessonname(diaryDTO.getLessonname());
		diary.setClassroomid(diaryDTO.getClassroomid());
		
			diary.setSubjectid(diaryDTO.getSubjectid());
		
		rowEffected = db.insert(diary).getRowsAffected();

		return rowEffected;
	}

	public int updateEntry(long tenantId, DiaryDTO diaryDTO) {
		db = database.getDatabase(tenantId);

		int rowEffected = 0;
		Diary diary = new Diary();
		Date entrydate = new Date(diaryDTO.getEntryDate());

		diary.setId(diaryDTO.getId());
		diary.setTag(diaryDTO.getTag());
		diary.setDescription(diaryDTO.getDescription());
		diary.setEntrydate(entrydate);
		diary.setLessonname(diaryDTO.getLessonname());
		diary.setClassroomid(diaryDTO.getClassroomid());
		diary.setSubjectid(diaryDTO.getSubjectid());

		rowEffected = db.update(diary).getRowsAffected();

		return rowEffected;
	}

	public List<Diary> listInformation(long tenantId, DiaryDTO diaryDTO) {
		db = database.getDatabase(tenantId);
		List<Diary> diarylist = null;
		if (diaryDTO.getSubjectid() == null) {
			diarylist = db.sql("select * from diary where classroomid = ?", diaryDTO.getClassroomid())
					.results(Diary.class);
		}
		else {
		diarylist = db.sql("select * from diary where classroomid = ? and subjectid = ? ", diaryDTO.getClassroomid(),
				diaryDTO.getSubjectid()).results(Diary.class);
		}

		return diarylist;
	}

}
