
package com.omniwyse.sms.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dieselpoint.norm.Database;
import com.dieselpoint.norm.Transaction;
import com.omniwyse.sms.db.DBFactory;
import com.omniwyse.sms.db.DatabaseRetrieval;
import com.omniwyse.sms.ischool.IschoolWorksheets;
import com.omniwyse.sms.models.ClassRoom;
import com.omniwyse.sms.models.Ischollworksheetsassigned;
import com.omniwyse.sms.models.Lessons;
import com.omniwyse.sms.models.Notifications;
import com.omniwyse.sms.models.Subjects;
import com.omniwyse.sms.models.Teachers;
import com.omniwyse.sms.models.Worksheets;
import com.omniwyse.sms.utils.AssignmentDTOOut;
import com.omniwyse.sms.utils.ClassRoomDetails;
import com.omniwyse.sms.utils.ClassSectionTransferObject;
import com.omniwyse.sms.utils.TeacherModuleDTO;
import com.omniwyse.sms.utils.TeacherScheduleDTO;
import com.omniwyse.sms.utils.TeacherShedule;
import com.omniwyse.sms.utils.TestTransferObject;
import com.omniwyse.sms.utils.TimelineDTO;
import com.omniwyse.sms.utils.TimelineDTOOut;
import com.omniwyse.sms.utils.WorkSheetsDTO;
import com.omniwyse.sms.utils.WorkSheetsDTOOut;

@Service
public class TeacherModuleService {

	@Autowired
	private DatabaseRetrieval retrive;
	@Autowired
	private StudentsService studentService;

	@Autowired
	private WorksheetService workSheetService;

	private Database db;

	@Autowired
	private DBFactory dbFactory;

	public List<TeacherModuleDTO> listAllSubjectsAlongWithClassRooms(long tenantId,
			ClassSectionTransferObject moduleDTO) {

		db = retrive.getDatabase(tenantId);

		List<TeacherModuleDTO> list = db.sql(
				"select classrooms.id,  class_subject_teacher.subjectid as subjectid, subjects.subjectname, classrooms.gradeid,classrooms.sectionname,grades.gradenumber,grades.syllabustype from subjects "
						+ "JOIN class_subject_teacher ON class_subject_teacher.subjectid = subjects.id JOIN classrooms"
						+ " ON classrooms.id = class_subject_teacher.classid JOIN grades on grades.id=classrooms.gradeid where class_subject_teacher.teacherid = ? and subjects.istestable='true'",
				moduleDTO.getId()).results(TeacherModuleDTO.class);

		return list;
	}

	public List<ClassSectionTransferObject> getClassRoomOfTeacherAssignedCRT(long tenantId,
			ClassSectionTransferObject moduleDTO) {
		db = retrive.getDatabase(tenantId);

		List<ClassSectionTransferObject> list = db.sql(
				"select classrooms.id,classrooms.gradeid,classrooms.sectionname,grades.gradenumber,grades.syllabustype from classrooms "
						+ "JOIN grades on grades.id=classrooms.gradeid where classteacherid =? ",
				moduleDTO.getId()).results(ClassSectionTransferObject.class);

		return list;
	}

	public Teachers showTeacherProfile(long tenantId, ClassSectionTransferObject moduleDTO) {

		db = retrive.getDatabase(tenantId);
		Teachers teacher = db.where("id = ?", moduleDTO.getId()).results(Teachers.class).get(0);
		return teacher;

	}

	public List<TeacherShedule> getSchedule(long tenantId, ClassSectionTransferObject dataObject, int dayId) {
		db = retrive.getDatabase(tenantId);
		List<TeacherShedule> teacherSheduleList = db.sql("select * from weekdays").results(TeacherShedule.class);
		for (int i = 0; i < teacherSheduleList.size(); i++) {
			TeacherShedule teacherShedule = teacherSheduleList.get(i);
			List<TeacherScheduleDTO> teacherScheduleDTO = db.sql(
					"select grades.gradenumber, classrooms.gradeid,weekdays.day, classrooms.sectionname, classroom_periods.classroomweekdayid,"
							+ "periods.periodfrom,periods.periodto,class_subject_teacher.teacherid,"
							+ " class_subject_teacher.classid, class_subject_teacher.subjectid,classroom_periods.periodid,"
							+ " subjects.subjectname from class_subject_teacher  "
							+ "inner join classroom_periods on classroom_periods.subjectid=class_subject_teacher.subjectid "
							+ "and class_subject_teacher.classid=classroom_periods.classroomid  "
							+ "join subjects on subjects.id=class_subject_teacher.subjectid  "
							+ "join periods on classroom_periods.periodid=periods.id "
							+ "join classrooms on classrooms.id = classroom_periods.classroomid "
							+ "join grades on classrooms.gradeid = grades.id  "
							+ "join weekdays on weekdays.id= classroom_periods.classroomweekdayid "
							+ "where class_subject_teacher.teacherid= ? and classroom_periods.classroomweekdayid = ? order by classrooms.gradeid asc,"
							+ "classroom_periods.classroomweekdayid asc, periods.periodfrom asc;",
					dataObject.getId(), teacherShedule.getId()).results(TeacherScheduleDTO.class);
			teacherShedule.setTeacherScheduleDTO(teacherScheduleDTO);
		}
		return teacherSheduleList;
	}

	public List<TeacherScheduleDTO> getScheduleDashboard(long tenantId, ClassSectionTransferObject dataObject) {
		// TODO Auto-generated method stub
		db = retrive.getDatabase(tenantId);

		return db.sql(
				"select classrooms.gradeid,weekdays.day, classrooms.sectionname, classroom_periods.classroomweekdayid,"
						+ "periods.periodfrom,periods.periodto,class_subject_teacher.teacherid,"
						+ " class_subject_teacher.classid, class_subject_teacher.subjectid,classroom_periods.periodid,"
						+ " subjects.subjectname from class_subject_teacher  "
						+ "inner join classroom_periods on classroom_periods.subjectid=class_subject_teacher.subjectid "
						+ "and class_subject_teacher.classid=classroom_periods.classroomid  "
						+ "join subjects on subjects.id=class_subject_teacher.subjectid  "
						+ "join periods on classroom_periods.periodid=periods.id "
						+ "join classrooms on classrooms.id = classroom_periods.classroomid "
						+ "join weekdays on weekdays.id= classroom_periods.classroomweekdayid "
						+ "where class_subject_teacher.teacherid= ? and classroom_periods.classroomweekdayid in(1,2,3,4,5,6,7) order by classrooms.gradeid asc,"
						+ "classroom_periods.classroomweekdayid asc, periods.periodfrom asc;",
				dataObject.getId()).results(TeacherScheduleDTO.class);

	}

	public ClassRoomDetails teacherModuleList(long tenantId, long id, String subjectname) {

		db = retrive.getDatabase(tenantId);
		ClassRoomDetails classroom = new ClassRoomDetails();
		classroom.setStudentsOfClassRoom(studentService.getStudentsOfClassRoom(tenantId, id));

		long subjectid = db.where("subjectname=?", subjectname).results(Subjects.class).get(0).getId();
		long gradeid = db.where("id=?", id).results(ClassRoom.class).get(0).getGradeid();
		List<TestTransferObject> listTetss = db
				.sql("select test_type.testtype,test_create.startdate, test_create.enddate from "
						+ "test_create join test_syllabus on test_create.gradeid=?"
						+ " and test_syllabus.subjectid=? and test_create.id=test_syllabus.testid join test_type on"
						+ " test_create.testtypeid=test_type.id ", gradeid, subjectid)
				.results(TestTransferObject.class);

		classroom.setTests(listTetss);

		return classroom;
	}

	public ClassRoomDetails teacherModulestudentsList(long tenantId, long id, String subjectname) {

		db = retrive.getDatabase(tenantId);
		ClassRoomDetails classroom = new ClassRoomDetails();
		classroom.setStudentsOfClassRoom(studentService.getStudentsOfClassRoom(id, tenantId));
		return classroom;
	}

	public List<TestTransferObject> getListOfsubjectTests(long tenantId, long id, String subjectname) {

		db = retrive.getDatabase(tenantId);
		long gradeid = db.where("id=?", id).results(ClassRoom.class).get(0).getGradeid();
		long subjectid = db.where("subjectname=?", subjectname).results(Subjects.class).get(0).getId();

		List<TestTransferObject> testsdetails = db.sql(
				"SELECT  test_syllabus.id,test_syllabus.testid,test_type.testtype,test_mode.testmode,test_create.startdate,test_create.enddate,"
						+ "test_syllabus.subjectid,test_syllabus.subjecttestdate,test_syllabus.maxmarks,test_syllabus.syllabus,status_table.status FROM test_create "
						+ "JOIN test_mode on test_create.modeid = test_mode.id  JOIN test_type on test_create.testtypeid = test_type.id "
						+ "JOIN test_syllabus on test_syllabus.testid = test_create.id JOIN status_table ON status_table.id = test_create.statusid"
						+ " WHERE test_syllabus.subjectid = ? AND test_create.gradeid = ?",
				subjectid, gradeid).results(TestTransferObject.class);

		return testsdetails;

	}

	public List<TimelineDTOOut> viewTimeline(long tenantId, TimelineDTO data) {

		db = retrive.getDatabase(tenantId);
		List<TimelineDTOOut> lessons = null;
		List<WorkSheetsDTOOut> worksheets = null;
		List<AssignmentDTOOut> assignments = null;
		String queryForLessons = "select lessons.id,lessons.lessonname,lessons.status,lessons.lessondescription,lessons.lessonstartdate, lessons.publishtimeline";
		String subjectSelectQuery = ", subjects.subjectname";
		String queryForAssignments = "select lessons.lessonname, assignments.tags, assignments.id,assignments.assignmentname,"
				+ "assignments.dateofassigned,assignments.assignmentduedate "
				+ "from assignments  JOIN lessons ON lessons.id = assignments.lessonsid ";

		String ischoolQuery = "select ischollworksheets_assigned.worksheetname,ischollworksheets_assigned.worksheetpath,ischollworksheets_assigned.id, ischollworksheets_assigned.vendor,"
				+ "subjects.subjectname,ischollworksheets_assigned.dateofassigned, ischollworksheets_assigned.worksheetduedate, lessons.lessonname from"
				+ " ischollworksheets_assigned LEFT JOIN subjects ON subjects.id = ischollworksheets_assigned.subjectid LEFT JOIN lessons ON lessons.id = ischollworksheets_assigned.lessonsid ";

		long classroomid = data.getId();
		if (data.getSubjectname() != null) {

			long subjectid = db.where("subjectname = ?", data.getSubjectname()).results(Subjects.class).get(0).getId();
			queryForLessons = queryForLessons + " from lessons where classroomid=? and subjectid=? ";
			ischoolQuery = ischoolQuery
					+ "where ischollworksheets_assigned.classroomid=? and ischollworksheets_assigned.subjectid=? and ischollworksheets_assigned.lessonsid=?";
			queryForAssignments = queryForAssignments
					+ " where assignments.classroomid=? and assignments.subjectid=? and assignments.lessonsid=?";

			if (data.getDatefrom() != null && data.getDateto() != null) {
				queryForLessons = dateFilterbasedTime(data, queryForLessons);
				Date from = new Date(data.getDatefrom());
				Date to = new Date(data.getDateto());
				lessons = db.sql(queryForLessons, classroomid, subjectid, from, to).results(TimelineDTOOut.class);
			} else {
				lessons = db.sql(queryForLessons, classroomid, subjectid).results(TimelineDTOOut.class);
			}
			for (TimelineDTOOut lesson : lessons) {

				worksheets = db.sql(ischoolQuery, classroomid, subjectid, lesson.getId())
						.results(WorkSheetsDTOOut.class);
				lesson.setWorksheets(worksheets);
				assignments = db.sql(queryForAssignments, classroomid, subjectid, lesson.getId())
						.results(AssignmentDTOOut.class);
				lesson.setAssignments(assignments);

			}
		} else {
			queryForLessons = queryForLessons + subjectSelectQuery + " from lessons JOIN subjects on "
					+ "subjects.id = lessons.subjectid where classroomid=? ";
			ischoolQuery = ischoolQuery
					+ "where ischollworksheets_assigned.classroomid=? and ischollworksheets_assigned.lessonsid=? ";
			queryForAssignments = queryForAssignments + "where assignments.classroomid=? and assignments.lessonsid=? ";
			if (data.getDatefrom() != null && data.getDateto() != null) {
				queryForLessons = dateFilterbasedTime(data, queryForLessons);
				lessons = db.sql(queryForLessons, classroomid, data.getDatefrom(), data.getDateto())
						.results(TimelineDTOOut.class);
			} else {
				lessons = db.sql(queryForLessons, classroomid).results(TimelineDTOOut.class);
			}
			for (TimelineDTOOut lesson : lessons) {

				worksheets = db.sql(ischoolQuery, classroomid, lesson.getId()).results(WorkSheetsDTOOut.class);
				lesson.setWorksheets(worksheets);
				assignments = db.sql(queryForAssignments, classroomid, lesson.getId()).results(AssignmentDTOOut.class);
				lesson.setAssignments(assignments);
			}
		}

		return lessons;
	}

	private String dateFilterbasedTime(TimelineDTO data, String queryForLessons) {

		queryForLessons = queryForLessons + " and lessonstartdate between ? and ? order by lessonstartdate desc";
		return queryForLessons;
	}

	public int addingLesson(long tenantId, TimelineDTO data) {

		int rowEffected = 0;
		db = retrive.getDatabase(tenantId);
		Lessons lesson = new Lessons();

		Date lessonstartDate = new Date(data.getLessonstartdate());
		Transaction transaction = db.startTransaction();
		try {
			lesson.setClassroomid(data.getId());
			lesson.setLessondescription(data.getLessondescription());
			lesson.setLessonstartdate(lessonstartDate);
			lesson.setLessonname(data.getLessonname());
			lesson.setStatus(data.getStatus());
			if (data.getSubjectname() != null) {
				lesson.setSubjectid(
						db.where("subjectname = ?", data.getSubjectname()).results(Subjects.class).get(0).getId());
			}
			Long flag = data.getPublish();
			if (flag != null && flag == 0) {
				lesson.setPublishtimeline(true);
				Notifications notifications = new Notifications();

				notifications.setNotificationname(data.getLessonname());
				notifications.setDescription(data.getLessondescription());
				notifications.setActioncode("TL");
				notifications.setParentactionrequired("No");
				notifications.setPublishedby("Default");
				notifications.setNotificationdate(lessonstartDate);

				rowEffected = db.transaction(transaction).insert(notifications).getRowsAffected();
			}

			rowEffected = db.transaction(transaction).insert(lesson).getRowsAffected();
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			return -3;
		}
		return rowEffected;
	}

	public List<WorkSheetsDTOOut> listWorkSheetsbasedOn(long tenantId, WorkSheetsDTO data) {

		long gradeid = db.where("id = ?", data.getId()).results(ClassRoom.class).get(0).getGradeid();
		data.setGradeid(gradeid);
		List<WorkSheetsDTOOut> list = workSheetService.mySchoolWorksheets(tenantId, data);
		return list;
	}

	public int worksheets(long tenantId, WorkSheetsDTO data) {

		db = retrive.getDatabase(tenantId);
		Long lessonid = null;
		Long classroomid = data.getId();
		Date dateofassigned = new Date(data.getDateofassigned());
		Date duedate = new Date(data.getDuedate());

		if (data.getLessonname() != null && !data.getLessonname().isEmpty()) {
			lessonid = db.where("lessonname = ? and classroomid = ?", data.getLessonname(), classroomid)
					.results(Lessons.class).get(0).getId();
		}
		Ischollworksheetsassigned ischollworksheets = new Ischollworksheetsassigned();
		ischollworksheets.setClassroomid(classroomid);
		ischollworksheets.setDateofassigned(dateofassigned);
		ischollworksheets.setWorksheetduedate(duedate);
		ischollworksheets.setLessonsid(lessonid);
		ischollworksheets.setWorksheetid(data.getWorksheetid());
		Long subjectid = null;
		if (data.getSubjectname() != null && !data.getSubjectname().isEmpty()) {
			subjectid = db.where("subjectname = ?", data.getSubjectname()).results(Subjects.class).get(0).getId();
			ischollworksheets.setSubjectid(subjectid);
		}
		List<Ischollworksheetsassigned> worksheets;
		if (!data.isIsworksheetfromLibrary()) {
			ischollworksheets.setVendor("your worksheets");
			List<Worksheets> worksheet = db.where("id=?", data.getWorksheetid()).results(Worksheets.class);
			if (!worksheet.isEmpty()) {
				ischollworksheets.setWorksheetname(worksheet.get(0).getWorksheetname());
				ischollworksheets.setWorksheetpath(worksheet.get(0).getWorksheetpath());
			}
			if (lessonid == null && subjectid == null) {
				worksheets = db.where("classroomid=?  and worksheetid=? and vendor='your worksheets'", classroomid,
						data.getWorksheetid()).results(Ischollworksheetsassigned.class);
			} else if (lessonid == null) {
				worksheets = db.where("classroomid=?  and worksheetid=? and vendor='your worksheets'", classroomid,
						data.getWorksheetid()).results(Ischollworksheetsassigned.class);
			} else {
				worksheets = db.where("classroomid=?  and  lessonsid=? and  worksheetid=? and vendor='your worksheets'",
						classroomid, lessonid, data.getWorksheetid()).results(Ischollworksheetsassigned.class);
			}

		} else {
			Database metadb = dbFactory.getSchoolDb();
			ischollworksheets.setVendor("iSchool-By-OMNIWYSE");
			List<IschoolWorksheets> ischoolWorksheets = metadb.where("id=?", data.getWorksheetid())
					.results(IschoolWorksheets.class);
			if (!ischoolWorksheets.isEmpty()) {
				ischollworksheets.setWorksheetpath(ischoolWorksheets.get(0).getWorksheetpath());
				ischollworksheets.setWorksheetname(ischoolWorksheets.get(0).getWorksheetname());
			}
			if (lessonid == null && subjectid == null) {
				worksheets = db.where("classroomid=?  and worksheetid=? and vendor='iSchool-By-OMNIWYSE'", classroomid,
						data.getWorksheetid()).results(Ischollworksheetsassigned.class);
			} else if (lessonid == null) {
				worksheets = db.where("classroomid=?  and worksheetid=? and vendor='iSchool-By-OMNIWYSE'", classroomid,
						data.getWorksheetid()).results(Ischollworksheetsassigned.class);
			} else {
				worksheets = db
						.where("classroomid=?  and  lessonsid=? and  worksheetid=? and vendor='iSchool-By-OMNIWYSE'",
								classroomid, lessonid, data.getWorksheetid())
						.results(Ischollworksheetsassigned.class);
			}

		}
		if (worksheets.isEmpty()) {
			return db.insert(ischollworksheets).getRowsAffected();
		}
		return 0;

	}

	public List<Lessons> lessonsList(long tenantId, TimelineDTO data) {

		db = retrive.getDatabase(tenantId);

		long subjectid = db.where("subjectname = ?", data.getSubjectname()).results(Subjects.class).get(0).getId();

		return db.where("classroomid = ? and subjectid = ?", data.getId(), subjectid).results(Lessons.class);
	}

	public List<TestTransferObject> getListOfClassroomTests(long tenantId, long id) {

		db = retrive.getDatabase(tenantId);
		long gradeid = db.where("id=?", id).results(ClassRoom.class).get(0).getGradeid();

		List<TestTransferObject> testsdetails = db
				.sql("SELECT  test_syllabus.id,test_syllabus.testid,test_type.testtype,test_mode.testmode,"
						+ "test_create.startdate,test_create.enddate,test_syllabus.subjecttestdate,test_syllabus.subjectid,test_create.maxmarks,test_syllabus.syllabus"
						+ " FROM test_create " + "JOIN test_mode on test_create.modeid = test_mode.id "
						+ "JOIN test_type on test_create.testtypeid = test_type.id "
						+ "JOIN test_syllabus on test_syllabus.testid = test_create.id "
						+ "WHERE test_create.gradeid = ?", gradeid)
				.results(TestTransferObject.class);

		return testsdetails;

	}

	public int deleteAssignedWorksheet(WorkSheetsDTO data, long tenantId) {
		db = retrive.getDatabase(tenantId);
		return db.sql("delete from ischollworksheets_assigned where id = ?", data.getId()).execute().getRowsAffected();
	}

	public List<WorkSheetsDTOOut> assignedWorksheetsList(long tenantId, TimelineDTO data, boolean status) {

		db = retrive.getDatabase(tenantId);
		// Database metadb = dbFactory.getSchoolDb();
		List<WorkSheetsDTOOut> list = null;
		String ischoolQuery = "select ischollworksheets_assigned.worksheetname,ischollworksheets_assigned.worksheetpath,ischollworksheets_assigned.id, ischollworksheets_assigned.vendor,"
				+ "subjects.subjectname,ischollworksheets_assigned.dateofassigned, ischollworksheets_assigned.worksheetduedate, lessons.lessonname from"
				+ " ischollworksheets_assigned LEFT JOIN subjects ON subjects.id = ischollworksheets_assigned.subjectid LEFT JOIN lessons ON lessons.id = ischollworksheets_assigned.lessonsid ";

		if (data.getSubjectname() != null) {
			long subjectId = db.where(" subjectname = ?", data.getSubjectname()).results(Subjects.class).get(0).getId();

			list = db.sql(ischoolQuery
					+ " where ischollworksheets_assigned.classroomid = ? and ischollworksheets_assigned.subjectid = ?",
					data.getId(), subjectId).results(WorkSheetsDTOOut.class);
		} else if (status == false) {
			list = db.sql(ischoolQuery + " where ischollworksheets_assigned.classroomid = ? ", data.getId())
					.results(WorkSheetsDTOOut.class);
		} else {
			list = db.sql(
					ischoolQuery + " where ischollworksheets_assigned.classroomid = ? and lessons.publishtimeline=1 ",
					data.getId()).results(WorkSheetsDTOOut.class);
		}

		return list;
	}

}