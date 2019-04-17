package com.omniwyse.sms.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dieselpoint.norm.Database;
import com.omniwyse.sms.models.AcademicYears;
import com.omniwyse.sms.models.GradeSubjects;
import com.omniwyse.sms.models.StatusTable;
import com.omniwyse.sms.models.TestCreate;
import com.omniwyse.sms.models.TestSyllabus;
import com.omniwyse.sms.models.TestType;
import com.omniwyse.sms.models.Testmode;
import com.omniwyse.sms.utils.TestSubjectsDisplay;
import com.omniwyse.sms.utils.TestSyllabusDTO;
import com.omniwyse.sms.utils.TestTransferObject;

@Service
public class TestService {

	@Autowired
    private com.omniwyse.sms.db.DatabaseRetrieval retrieve;

	private Database db;

	public int addTestType(long tenantId, TestType testtype) {
		String testtypename = testtype.getTesttype();
		db = retrieve.getDatabase(tenantId);

		List<TestType> records = db.where("testtype=?", testtypename).results(TestType.class);
		if (records.isEmpty()) {
			return db.insert(testtype).getRowsAffected();
		}
		return 0;
	}

	public int createTest(long tenantId, TestTransferObject testTransferObject) {
		TestCreate testcreate;
		TestSyllabus testsyllubus;

		String testtypename = testTransferObject.getTesttype();
		String testmode = testTransferObject.getTestmode();
		db = retrieve.getDatabase(tenantId);
		long gradeid = testTransferObject.getId();
		long academicyear = testTransferObject.getAcademicyear();
		long testtypeid = db.where("testtype=?", testtypename).results(TestType.class).get(0).getId();
		List<TestCreate> records = db.where("academicid=? and gradeid=? and testtypeid=?", academicyear, gradeid, testtypeid).results(TestCreate.class);
		if (records.isEmpty()) {
			long testmodeid = db.where("testmode=?", testmode).results(Testmode.class).get(0).getId();
			testcreate = new TestCreate();
			testcreate.setGradeid(gradeid);
			testcreate.setModeid(testmodeid);
			testcreate.setTesttypeid(testtypeid);
            testcreate.setStartdate(new Date(testTransferObject.getStartdt()));
            testcreate.setEnddate(new Date(testTransferObject.getEnddt()));
			testcreate.setMaxmarks(testTransferObject.getMaxmarks());
			testcreate.setAcademicid(academicyear);
			testcreate.setStatusid(db.where("status = ?", testTransferObject.getStatus()).results(StatusTable.class).get(0).getId());
			db.insert(testcreate).getRowsAffected();
			long testid = testcreate.getId();
			testsyllubus = new TestSyllabus();
			testsyllubus.setTestid(testid);
			List<GradeSubjects> subjectid = db.sql("select grade_subjects.subjectid from grade_subjects inner join subjects on grade_subjects.gradeid=? and grade_subjects.subjectid=subjects.id"
			        + " and subjects.istestable='true'",gradeid).results(GradeSubjects.class);
			for (GradeSubjects gradesubject : subjectid) {
				testsyllubus.setSubjectid(gradesubject.getSubjectid());
				db.insert(testsyllubus);
			}
			return 1;

		} else
			return 0;

	}

	public List<TestType> listtesttypes(long tenantId) {
		db = retrieve.getDatabase(tenantId);
		return db.sql("select * from test_type ").results(TestType.class);
	}

	public List<Testmode> listtestmodes(long tenantId) {
		db = retrieve.getDatabase(tenantId);
		return db.sql("select * from test_mode").results(Testmode.class);
	}

	public List<TestTransferObject> listAllTests(long tenantId) {

		db = retrieve.getDatabase(tenantId);

		return db.sql("select test_type.testtype, test_create.startdate, test_create.enddate, test_mode.testmode, test_create.maxmarks, "
						+ "status_table.status from test_type JOIN test_create ON test_type.id = test_create.testtypeid JOIN test_mode ON "
                        + "test_mode.id = test_create.modeid JOIN status_table ON status_table.id = test_create.statusid order by test_create.startdate, test_create.enddate desc").results(TestTransferObject.class);
	}

	public List<TestTransferObject> getListOfTests(long tenantId, TestTransferObject testtransferobject) {

		db = retrieve.getDatabase(tenantId);
		long gradeid = testtransferobject.getId();
//        long academicId = db.where("active=?", 1).results(AcademicYears.class).get(0).getId();
		List<TestTransferObject> testsdetails = db.sql("select test_create.gradeid, test_create.id,test_type.testtype,test_mode.testmode,test_create.startdate,test_create.enddate,test_create.maxmarks, status_table.status "
                        + "from test_create inner join test_mode on test_create.modeid=test_mode.id inner join test_type on test_create.testtypeid=test_type.id JOIN status_table ON status_table.id = test_create.statusid "
                        + "where test_create.gradeid = ? and test_create.academicid = ? order by test_create.startdate, test_create.enddate desc",gradeid, testtransferobject.getAcademicyear()).results(TestTransferObject.class);

		return testsdetails;
	}
	
	
    public List<TestSubjectsDisplay> getTestSubjectsDetails(long tenantId, TestTransferObject testtransferobject) {

        db = retrieve.getDatabase(tenantId);

        List<TestSubjectsDisplay> subjecttestsyllabus = db.sql("select test_syllabus.id,test_syllabus.maxmarks,test_syllabus.subjecttestdate,test_syllabus.testid,test_syllabus.subjectid,test_syllabus.syllabus,subjects.subjectname,st.status "
                + "from test_syllabus inner join subjects on test_syllabus.subjectid=subjects.id inner join test_create tc on tc.id = test_syllabus.testid inner join status_table st on tc.statusid = st.id "
                + "where test_syllabus.testid = ?",testtransferobject.getId()).results(TestSubjectsDisplay.class);

        return subjecttestsyllabus;
    }

	public List<TestTransferObject> getListOfTestsByParent(long tenantId, TestTransferObject testtransferobject) {

        db = retrieve.getDatabase(tenantId);
        long gradeid = testtransferobject.getId();
        long academicId = db.where("active=?", 1).results(AcademicYears.class).get(0).getId();
        List<TestTransferObject> testsdetails = db.sql("select test_create.gradeid, test_create.id,test_type.testtype,test_mode.testmode,test_create.startdate,test_create.enddate,test_create.maxmarks, status_table.status "
                + "from test_create inner join test_mode on test_create.modeid=test_mode.id inner join test_type on test_create.testtypeid=test_type.id JOIN status_table ON status_table.id = test_create.statusid "
                        + "where status_table.status != 'draft' and test_create.gradeid = ? and test_create.academicid = ? order by test_create.startdate, test_create.enddate desc",gradeid, academicId).results(TestTransferObject.class);

        long testid;
        for (TestTransferObject test : testsdetails) {
            testid = test.getId();

            List<TestSubjectsDisplay> subjecttestsyllabus = db.sql("select test_syllabus.id,test_syllabus.maxmarks,test_syllabus.testid,test_syllabus.subjectid,test_syllabus.syllabus,subjects.subjectname"
                    + " from test_syllabus  inner join subjects on test_syllabus.testid=? and test_syllabus.subjectid=subjects.id",testid).results(TestSubjectsDisplay.class);
            
            test.setSubjects(subjecttestsyllabus);
        }
        return testsdetails;

    }
	

	public List<TestSubjectsDisplay> getListOfTestSubjects(long tenantId, TestSubjectsDisplay testsubjectsdisplay) {
		long testid = testsubjectsdisplay.getId();
		db = retrieve.getDatabase(tenantId);

		return db.sql("select test_syllabus.id,test_syllabus.testid,test_syllabus.subjectid,test_syllabus.syllabus,subjects.subjectname from test_syllabus  inner join subjects on test_syllabus.testid=?"
		        + " and test_syllabus.subjectid=subjects.id",testid).results(TestSubjectsDisplay.class);
	}

    public int addorEditSyllabus(long tenantId, TestSyllabusDTO testSyllabusDTO) {
		db = retrieve.getDatabase(tenantId);
		
        long testid = testSyllabusDTO.getTestid();
        long subjectid = testSyllabusDTO.getSubjectid();

        TestSyllabus testSyllabus2 = db.where("testid=? and subjectid=?", testid, subjectid).results(TestSyllabus.class).get(0);
        testSyllabus2.setSyllabus(testSyllabusDTO.getSyllabus());
        testSyllabus2.setSubjecttestdate(new Date(testSyllabusDTO.getSubjecttestdt()));
        testSyllabus2.setMaxmarks(testSyllabusDTO.getMaxmarks());
		return db.update(testSyllabus2).getRowsAffected();
	}

	public List<TestTransferObject> getListOfTestStatus(long tenantId) {
		db = retrieve.getDatabase(tenantId);
		return db.sql("select id, status from status_table").results(TestTransferObject.class);
	}

	public int changeStatusOfTest(long tenantId, TestTransferObject data) {
		int rowEffected = 0;
		db = retrieve.getDatabase(tenantId);

		Long statusPreviousId = db.where("id = ? and gradeid = ?", data.getTestid(),
				data.getId()).results(TestCreate.class).get(0).getStatusid();
		Long closeStatusId = db.where("status = ?", "CLOSED").results(StatusTable.class).get(0).getId();
		/*
		 *  Hard coded and Id would be constant that is doneStatusId =
		 * 3 and closeStatusId = 4 because those are constants
		 */
		List<StatusTable> status = db.results(StatusTable.class);
		for (StatusTable newStatus : status) {

			if (statusPreviousId == (closeStatusId - 1)) {
				return rowEffected = db.sql("update test_create set statusid = ? where id = ?", closeStatusId, data.getTestid()).execute()
						.getRowsAffected();
			} else if (statusPreviousId == newStatus.getId()) {
				return rowEffected = db.sql("update test_create set statusid = ? where id = ?", newStatus.getId() + 1, data.getTestid()).execute()
						.getRowsAffected();
			}
		}
		return rowEffected;
	}

	
}
