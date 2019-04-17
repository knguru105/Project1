package com.omniwyse.sms.ischool;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dieselpoint.norm.Database;
import com.omniwyse.sms.models.ClassRoom;
import com.omniwyse.sms.utils.WorkSheetsDTO;
import com.omniwyse.sms.utils.WorkSheetsDTOOut;

@Service
public class IschoolWorksheetsLibrary {

	public List<WorkSheetsDTOOut> listingLibraryWorksheets(WorkSheetsDTO worksheets, Database db) {

		String subjectname = worksheets.getSubjectname();
		Long gradeid = worksheets.getGradeid();
		String level = worksheets.getDegreeofdifficulty();

		if (worksheets.getId() != null && gradeid == null) {
			//gradeid = db.where("id =", worksheets.getId()).results(ClassRoom.class).get(0).getGradeid();
			gradeid = db.where("gradenumber=?", worksheets.getId()).results(IschoolGrades.class)
					.get(0).getId();
		}
		String query = "select ischool_worksheets.id,ischool_worksheets.worksheetname, ischool_worksheets.createdby, ischool_worksheets.gradeid, "
				+ "ischool_worksheets.worksheetpath,ischool_worksheets.tags , ischool_subjects.subjectname, ischool_degreeofdifficulty.degreeofdifficulty "
				+ "from ischool_worksheets JOIN ischool_subjects ON ischool_subjects.id = ischool_worksheets.subjectid"
				+ "	JOIN ischool_degreeofdifficulty ON ischool_degreeofdifficulty.id = ischool_worksheets.degreeofdifficultyid";

		if (subjectname == null && gradeid == 0 && level == null) {

			return listingAllWorksheets(db);

		} else if (subjectname != null && gradeid == 0 && level == null) {

			long subjectid = db.where("subjectname = ?", subjectname).results(IschoolSubjects.class).get(0).getId();

			return db.sql(query + " where ischool_subjects.subjectid = ?", subjectid).results(WorkSheetsDTOOut.class);

		} else if (subjectname != null && gradeid != 0 && level == null) {

			long subjectid = db.where("subjectname = ?", subjectname).results(IschoolSubjects.class).get(0).getId();

			return db.sql(query + " where ischool_subjects.subjectid = ? and ischool_worksheets.gradeid = ?", subjectid,
					gradeid).results(WorkSheetsDTOOut.class);
		} else if (subjectname != null && gradeid != 0 && level != null) {

			long subjectid = db.where("subjectname = ?", subjectname).results(IschoolSubjects.class).get(0).getId();
			long levelid = db.where("ischool_degreeofdifficulty.degreeofdifficulty = ?", level)
					.results(IschoolLevelsOfDifficulty.class).get(0).getId();

			return db.sql(
					query + " where ischool_subjects.subjectid = ? and ischool_worksheets.gradeid = ? and ischool_worksheets.degreeofdifficultyid = ?",
					subjectid, gradeid, levelid).results(WorkSheetsDTOOut.class);
		} else if (subjectname == null && gradeid != 0 && level == null) {

			return db.sql(query + " where ischool_worksheets.gradeid = ?", gradeid).results(WorkSheetsDTOOut.class);
		} else if (subjectname == null && gradeid != 0 && level != null) {

			long levelid = db.where("ischool_worksheets.degreeofdifficulty = ?", level)
					.results(IschoolLevelsOfDifficulty.class).get(0).getId();
			return db.sql(
					query + " where ischool_worksheets.gradeid = ? and ischool_worksheets.degreeofdifficultyid = ?",
					gradeid, levelid).results(WorkSheetsDTOOut.class);
		} else if (subjectname == null && gradeid == 0 && level != null) {

			long levelid = db.where("ischool_worksheets.degreeofdifficulty = ?", level)
					.results(IschoolLevelsOfDifficulty.class).get(0).getId();

			return db.sql(query + " where ischool_worksheets.degreeofdifficultyid = ?", levelid)
					.results(WorkSheetsDTOOut.class);
		} else {
			return null;
		}

	}

	public List<WorkSheetsDTOOut> listingAllWorksheets(Database db2) {

		String query = "select ischool_worksheets.worksheetname, ischool_worksheets.createdby, ischool_worksheets.gradeid, "
				+ "ischool_worksheets.worksheetpath,ischool_worksheets.tags , ischool_subjects.subjectname, ischool_degreeofdifficulty.degreeofdifficulty "
				+ "from ischool_worksheets JOIN ischool_subjects ON ischool_subjects.id = ischool_worksheets.subjectid"
				+ "	JOIN ischool_degreeofdifficulty ON ischool_degreeofdifficulty.id = ischool_worksheets.degreeofdifficultyid";

		return db2.sql(query).results(WorkSheetsDTOOut.class);
	}
}
