package com.omniwyse.sms.services;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.dieselpoint.norm.Database;
import com.omniwyse.sms.db.DBFactory;
import com.omniwyse.sms.db.DatabaseRetrieval;
import com.omniwyse.sms.ischool.S3BucketService;
import com.omniwyse.sms.models.Degreeofdifficulty;
import com.omniwyse.sms.models.Grades;
import com.omniwyse.sms.models.Subjects;
import com.omniwyse.sms.models.Tenants;
import com.omniwyse.sms.models.Worksheets;
import com.omniwyse.sms.utils.WorkSheetsDTO;
import com.omniwyse.sms.utils.WorkSheetsDTOOut;

@Service
public class WorksheetService {

	@Autowired
	private S3BucketService s3Service;

	@Autowired
	private DBFactory dbfactory;

	@Autowired
	private DatabaseRetrieval retrive;

	private Database db;

	public List<WorkSheetsDTOOut> mySchoolWorksheets(long tenantId, WorkSheetsDTO worksheets) {

		db = retrive.getDatabase(tenantId);
		String subjectname = worksheets.getSubjectname();
		long gradeid =db.where("gradenumber=?",worksheets.getId()).results(Grades.class).get(0).getId();
		String level = worksheets.getDegreeofdifficulty();

		String query = "select worksheets.id,worksheets.worksheetname, worksheets.createdby, worksheets.description,"
				+ " worksheets.gradeid, worksheets.worksheetpath,worksheets.tags ,subjects.subjectname, degreeofdifficulty.degreeofdifficulty"
				+ " from worksheets JOIN subjects ON subjects.id = worksheets.subjectid"
				+ " JOIN degreeofdifficulty ON degreeofdifficulty.id = worksheets.degreeofdifficultyid";

		// if all are null call get method
		if (subjectname == null && gradeid == 0 && level == null) {

			return getListSchoolWorksheets(tenantId);

		} else if (subjectname != null && gradeid == 0 && level == null) {

			long subjectid = db.where("subjectname = ?", subjectname).results(Subjects.class).get(0).getId();

			return db.sql(query + " where subjects.subjectid = ?", subjectid).results(WorkSheetsDTOOut.class);

		} else if (subjectname != null && gradeid != 0 && level == null) {

			long subjectid = db.where("subjectname = ?", subjectname).results(Subjects.class).get(0).getId();

			return db.sql(query + " where subjects.subjectid = ? and worksheets.gradeid = ?", subjectid, gradeid)
					.results(WorkSheetsDTOOut.class);
		} else if (subjectname != null && gradeid != 0 && level != null) {

			long subjectid = db.where("subjectname = ?", subjectname).results(Subjects.class).get(0).getId();
			long levelid = db.where("worksheets.degreeofdifficulty = ?", level).results(Degreeofdifficulty.class).get(0)
					.getId();

			return db.sql(
					query + " where subjects.subjectid = ? and worksheets.gradeid = ? and worksheets.degreeofdifficultyid = ?",
					subjectid, gradeid, levelid).results(WorkSheetsDTOOut.class);
		} else if (subjectname == null && gradeid != 0 && level == null) {

			return db.sql(query + " where gradeid = ?", gradeid).results(WorkSheetsDTOOut.class);
		} else if (subjectname == null && gradeid != 0 && level != null) {

			long levelid = db.where("worksheets.degreeofdifficulty = ?", level).results(Degreeofdifficulty.class).get(0)
					.getId();
			return db.sql(query + " where worksheets.gradeid = ? and worksheets.degreeofdifficultyid = ?", gradeid,
					levelid).results(WorkSheetsDTOOut.class);
		} else if (subjectname == null && gradeid == 0 && level != null) {

			long levelid = db.where("worksheets.degreeofdifficulty = ?", level).results(Degreeofdifficulty.class).get(0)
					.getId();

			return db.sql(query + " where worksheets.degreeofdifficultyid = ?", levelid).results(WorkSheetsDTOOut.class);
		} else {
			return null;
		}

	}

	public List<WorkSheetsDTOOut> getListSchoolWorksheets(long tenantId) {

		db = retrive.getDatabase(tenantId);

		String query = "select worksheets.id,worksheets.worksheetname, worksheets.createdby, worksheets.description,"
				+ " worksheets.gradeid, worksheets.worksheetpath,worksheets.tags ,subjects.subjectname, degreeofdifficulty.degreeofdifficulty"
				+ " from worksheets JOIN subjects ON subjects.id = worksheets.subjectid"
				+ " JOIN degreeofdifficulty ON degreeofdifficulty.id = worksheets.degreeofdifficultyid";

		return db.sql(query).results(WorkSheetsDTOOut.class);
	}

	@SuppressWarnings("deprecation")
	public int uploadNewSheet(long tenantId, WorkSheetsDTO worksheets) {

		try {
			Database schoolDb = dbfactory.getSchoolDb();
			String bucketName = schoolDb.where("id = ?", tenantId).results(Tenants.class).get(0).getDbname();
			bucketName += ".school";
			AmazonS3Client s3Client = new AmazonS3Client(new ProfileCredentialsProvider());
			db = retrive.getDatabase(tenantId);

			if (!s3Client.doesBucketExist(bucketName)) {
				s3Service.creatinBucketInS3(s3Client, bucketName);
			}
			// String[] paths = worksheets.getFilePath();
			/// for (String filePath : paths) {
			File file = new File(worksheets.getFilePath());
			long gradeNumber = db.where("id = ?", worksheets.getGradeid()).results(Grades.class).get(0)
					.getGradenumber();
			String subjectname = worksheets.getSubjectname();
			String level = worksheets.getDegreeofdifficulty();
			String defaultPath = "https://s3-us-west-1.amazonaws.com/";
			String filePath = bucketName + "/" + gradeNumber + "/" + subjectname + "/" + level;
			s3Client.putObject(new PutObjectRequest(filePath, worksheets.getWorksheetname(), file)
					.withCannedAcl(CannedAccessControlList.PublicRead));
			createNewSheet(tenantId, worksheets, defaultPath + filePath + "/" + worksheets.getWorksheetname());
			// }
			return 0;
		} catch (Exception e) {
			return -1;
		}
	}

	private int createNewSheet(long tenantId, WorkSheetsDTO worksheets, String filePath) {

		int rowEffected = 0;
		db = retrive.getDatabase(tenantId);
		Worksheets sheet = new Worksheets();
		sheet.setWorksheetname(worksheets.getWorksheetname());
		sheet.setWorksheetpath(filePath);
		if (!db.where("worksheetpath = ?", filePath).results(Worksheets.class).isEmpty()) {
			return 0;
		}
		sheet.setCreatedby(worksheets.getCreatedby());

		long degreeofdifficultyid = db.where("degreeofdifficulty = ?", worksheets.getDegreeofdifficulty())
				.results(Degreeofdifficulty.class).get(0).getId();
		long subjectid = db.where("subjectname = ?", worksheets.getSubjectname()).results(Subjects.class).get(0)
				.getId();

		sheet.setDegreeofdifficultyid(degreeofdifficultyid);
		sheet.setDescription(worksheets.getDescription());
		sheet.setGradeid(worksheets.getGradeid());
		sheet.setSubjectid(subjectid);
		sheet.setTags(worksheets.getTags());

		rowEffected = db.insert(sheet).getRowsAffected();

		return rowEffected;
	}

	public List<WorkSheetsDTO> listDifficulty(long tenantId) {

		db = retrive.getDatabase(tenantId);

		return db.sql("select * from degreeofdifficulty").results(WorkSheetsDTO.class);
	}
}
