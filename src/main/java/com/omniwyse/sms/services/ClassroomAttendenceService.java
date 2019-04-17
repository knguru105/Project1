package com.omniwyse.sms.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dieselpoint.norm.Database;
import com.dieselpoint.norm.Transaction;
import com.omniwyse.sms.db.DatabaseRetrieval;
import com.omniwyse.sms.models.AttendanceMode;
import com.omniwyse.sms.models.AttendanceSubjectwise;
import com.omniwyse.sms.models.ClassRoom;
import com.omniwyse.sms.models.ClassroomAttendance;
import com.omniwyse.sms.models.Subjects;
import com.omniwyse.sms.utils.ClassAttendenceTransferObject;
import com.omniwyse.sms.utils.ClassSectionTransferObject;
import com.omniwyse.sms.utils.StudentTransferObject;
import com.omniwyse.sms.utils.TeacherModuleDTO;

@Service
public class ClassroomAttendenceService {

	@Autowired
	private DatabaseRetrieval retrive;

	@Autowired
	private TeacherModuleService teacherservice;

	@Autowired
	private StudentsService studentService;

	private Database db;

	// list of students for the classroom attendance

	public ClassAttendenceTransferObject studentsList(long tenantId,
			ClassAttendenceTransferObject classattendancetransferobject) {

		db = retrive.getDatabase(tenantId);
		long gradeid = classattendancetransferobject.getGradeid();
		String sectionname = classattendancetransferobject.getSectionname();
		long classid = db.where("gradeid=? and sectionname=?", gradeid, sectionname).results(ClassRoom.class).get(0)
				.getId();

		classattendancetransferobject.setStudentsOfClassRoom(studentService.getStudentsOfClassRoom(classid, tenantId));

		return classattendancetransferobject;
	}

	// Record students attendance

	public int saveAttendanceForClassroom(long tenantId, long classroomid,
			List<ClassAttendenceTransferObject> classattendancetransferobject) {

		db = retrive.getDatabase(tenantId);
		Transaction transact = db.startTransaction();
		try {
			for (ClassAttendenceTransferObject attendencerecords : classattendancetransferobject) {

				ClassroomAttendance classroomAttendance = new ClassroomAttendance();
				classroomAttendance.setClassroomid(classroomid);
				classroomAttendance.setStudentid(attendencerecords.getId());
				classroomAttendance.setDateofattendance(attendencerecords.getDateofattendance());
				classroomAttendance.setAttendancestatus(attendencerecords.getAttendancestatus());
				List<ClassroomAttendance> attendance = db
						.sql("select * from classroom_attendance where classroomid=? and dateofattendance=?",
								classroomid, attendencerecords.getDateofattendance())
						.results(ClassroomAttendance.class);
				if (attendance.isEmpty()) {
					db.transaction(transact).insert(classroomAttendance);

				} else {
					return -1;
				}
			}
			transact.commit();
		} catch (Throwable tr) {
			transact.rollback();
			tr.printStackTrace();
			return -3;
		}
		return 1;
	}

	public int saveAttendanceForClassroomAndSubject(long tenantId, long classroomid, long subjectid,
			List<ClassAttendenceTransferObject> classattendancetransferobject) {

		db = retrive.getDatabase(tenantId);
		Transaction transact = db.startTransaction();
		try {
			for (ClassAttendenceTransferObject attendencerecords : classattendancetransferobject) {

				ClassroomAttendance classroomAttendance = new ClassroomAttendance();
				classroomAttendance.setClassroomid(classroomid);
				classroomAttendance.setStudentid(attendencerecords.getId());
				classroomAttendance.setDateofattendance(attendencerecords.getDateofattendance());
				classroomAttendance.setAttendancestatus(attendencerecords.getAttendancestatus());
				classroomAttendance.setSubjectid(subjectid);
				List<ClassroomAttendance> attendance = db.sql(
						"select * from classroom_attendance where classroomid=? and dateofattendance=? and subjectid=?",
						classroomid, attendencerecords.getDateofattendance(), attendencerecords.getSubjectid())
						.results(ClassroomAttendance.class);
				if (attendance.isEmpty()) {
					db.transaction(transact).insert(classroomAttendance);

				} else {
					return -1;
				}
			}
			transact.commit();
		} catch (Throwable tr) {
			transact.rollback();
			tr.printStackTrace();
			return -3;
		}
		return 1;
	}

	public int addingAttendanceStatus(long tenantId,
			List<ClassAttendenceTransferObject> classattendancetransferobject) {

		db = retrive.getDatabase(tenantId);
		Transaction transact = db.startTransaction();
		ClassAttendenceTransferObject classattendance = classattendancetransferobject.get(0);

		try {
			long classroomid = classattendance.getClassroomid();
			long attendancetypeid = db.sql("select * from school_attendance where status=1")
					.results(AttendanceMode.class).get(0).getId();
			if (attendancetypeid != 1) {

				for (ClassAttendenceTransferObject attendencerecords : classattendancetransferobject) {

					ClassroomAttendance classroomAttendance = new ClassroomAttendance();
					classroomAttendance.setClassroomid(classroomid);
					classroomAttendance.setStudentid(attendencerecords.getId());
					classroomAttendance.setDateofattendance(attendencerecords.getDateofattendance());
					classroomAttendance.setAttendancestatus(attendencerecords.getAttendancestatus());
					List<ClassroomAttendance> attendance = db
							.sql("select * from classroom_attendance where classroomid=? and dateofattendance=?",
									classroomid, attendencerecords.getDateofattendance())
							.results(ClassroomAttendance.class);
					if (attendance.isEmpty()) {
						db.transaction(transact).insert(classroomAttendance);

					} else {
						return -1;
					}
				}

			} else {

				for (ClassAttendenceTransferObject attendencerecords : classattendancetransferobject) {

					ClassroomAttendance classroomAttendance = new ClassroomAttendance();
					classroomAttendance.setClassroomid(classroomid);
					classroomAttendance.setStudentid(attendencerecords.getId());
					classroomAttendance.setDateofattendance(attendencerecords.getDateofattendance());
					classroomAttendance.setAttendancestatus(attendencerecords.getAttendancestatus());
					// long subjectid = db
					// .sql("select * from subjects where subjectname=?",
					// attendencerecords.getSubjectname())
					// .results(Subjects.class).get(0).getId();
					classroomAttendance.setSubjectid(attendencerecords.getSubjectid());
					List<ClassroomAttendance> attendance = db.sql(
							"select * from classroom_attendance where classroomid=? and dateofattendance=? and subjectid=?",
							classroomid, attendencerecords.getDateofattendance(), attendencerecords.getSubjectid())
							.results(ClassroomAttendance.class);
					if (attendance.isEmpty()) {
						db.transaction(transact).insert(classroomAttendance);

					} else {
						return -1;
					}

				}

			}
			transact.commit();
		} catch (Throwable tr) {
			transact.rollback();
			tr.printStackTrace();
			return -3;
		}

		return 1;
	}

	// dates list

	public List<ClassroomAttendance> getdates(long tenantId) {

		db = retrive.getDatabase(tenantId);
		long attendancetypeid = db.sql("select * from school_attendance  where status=1").results(AttendanceMode.class)
				.get(0).getId();
		if (attendancetypeid != 1) {
			return db.sql("select distinct dateofattendance from classroom_attendance")
					.results(ClassroomAttendance.class);
		} else {
			List<AttendanceSubjectwise> listdates = db.sql("select distinct dateofattendance from classroom_attendance")
					.results(AttendanceSubjectwise.class);
			List<ClassroomAttendance> dates = null;
			ClassroomAttendance classroomattendance = new ClassroomAttendance();
			for (AttendanceSubjectwise date : listdates) {
				classroomattendance.setDateofattendance(date.getDateofattendance());
				dates.add(classroomattendance);
			}
			return dates;
		}
	}

	// view attendance

	@SuppressWarnings("null")
	public List<ClassAttendenceTransferObject> getAttendance(long tenantId, long classroomid, long subjectid) {
		db = retrive.getDatabase(tenantId);
		long attendancetypeid = db.sql("select * from school_attendance where status = true")
				.results(AttendanceMode.class).get(0).getId();
		if (attendancetypeid != 1) {
			return getAttendanceForClassRoom(tenantId, classroomid);
		} else {
			return getAttendanceForClassroomAndSubject(tenantId, classroomid, subjectid);
		}
	}

	public List<ClassAttendenceTransferObject> getAttendanceForClassroomAndSubject(long tenantId, long classroomid,
			long subjectid) {
		List<ClassAttendenceTransferObject> attendancedetails = new ArrayList<ClassAttendenceTransferObject>();
		db = retrive.getDatabase(tenantId);
		List<ClassroomAttendance> subjectwisedates = db.sql(
				"select distinct dateofattendance from  classroom_attendance where classroomid=? and subjectid=? order by dateofattendance desc",
				classroomid, subjectid).results(ClassroomAttendance.class);
		for (ClassroomAttendance date : subjectwisedates) {
			ClassAttendenceTransferObject attendancereport = new ClassAttendenceTransferObject();

			attendancereport.setDateofattendance(date.getDateofattendance());

			Long studentscount = db.sql(
					"select count(*) as count from classroom_attendance where classroomid=? and dateofattendance=? and subjectid=?",
					classroomid, date.getDateofattendance(), subjectid).first(Long.class);

			attendancereport.setNoofstudents(studentscount);

			long status = 0;
			Long absentiescount = getAbsenteeCount(classroomid, subjectid, date, status);
			attendancereport.setNoofabsents(absentiescount);

			List<StudentTransferObject> absentiesnames = getStudentsWithAttendanceStatusbySubject(classroomid,
					subjectid, date, status);

			attendancereport.setStudents(absentiesnames);
			status = 1;
			Long presentiescount = getAbsenteeCount(classroomid, subjectid, date, status);

			attendancereport.setNoofpresents(presentiescount);
			attendancedetails.add(attendancereport);
		}
		return attendancedetails;
	}

	public List<ClassAttendenceTransferObject> getAttendanceForClassRoom(long tenantId, long classroomid) {

		db = retrive.getDatabase(tenantId);
		List<ClassAttendenceTransferObject> attendancedetails = new ArrayList<ClassAttendenceTransferObject>();
		List<ClassroomAttendance> onetimedates = db.sql(
				"select distinct dateofattendance from classroom_attendance where classroomid=? order by dateofattendance desc",
				classroomid).results(ClassroomAttendance.class);
		for (ClassroomAttendance date : onetimedates) {
			ClassAttendenceTransferObject attendancereport = new ClassAttendenceTransferObject();
			attendancereport.setDateofattendance(date.getDateofattendance());

			Long studentscount = db.sql(
					"select count(*) as count from classroom_attendance where classroomid=? and dateofattendance=?",
					classroomid, date.getDateofattendance()).first(Long.class);

			attendancereport.setNoofstudents(studentscount);

			long status = 0;
			Long absentiescount = db.sql(
					"select count(*) as count from classroom_attendance where classroomid=? and dateofattendance=? and attendancestatus=?",
					classroomid, date.getDateofattendance(), status).first(Long.class);
			attendancereport.setNoofabsents(absentiescount);

			List<StudentTransferObject> absentiesnames = getStudentsWithAttendanceStatus(classroomid, date, status);

			attendancereport.setStudents(absentiesnames);
			status = 1;
			Long presentiescount = db.sql(
					"select count(*) as count from classroom_attendance where classroomid=? and dateofattendance=? and attendancestatus=?",
					classroomid, date.getDateofattendance(), status).first(Long.class);

			attendancereport.setNoofpresents(presentiescount);
			attendancedetails.add(attendancereport);

		}
		return attendancedetails;
	}

	private Long getAbsenteeCount(long classroomid, long subjectid, ClassroomAttendance date, long status) {
		return db.sql(
				"select count(*) as count from classroom_attendance where classroomid=? and dateofattendance=? and attendancestatus=? and subjectid=?",
				classroomid, date.getDateofattendance(), status, subjectid).first(Long.class);
	}

	private List<StudentTransferObject> getStudentsWithAttendanceStatus(long classroomid, ClassroomAttendance date,
			long status) {
		List<StudentTransferObject> absentiesnames = db.sql(
				"select students.id,students.name,parents.contactnumber from classroom_attendance "
						+ "join students on classroom_attendance.studentid=students.id "
						+ "join parents on parents.id=students.parentid "
						+ "and classroom_attendance.classroomid=? and  classroom_attendance.dateofattendance=? "
						+ "and classroom_attendance.attendancestatus=?",
				classroomid, date.getDateofattendance(), status).results(StudentTransferObject.class);
		return absentiesnames;
	}

	private List<StudentTransferObject> getStudentsWithAttendanceStatusbySubject(long classroomid, long subjectid,
			ClassroomAttendance date, long status) {
		List<StudentTransferObject> absentiesnames = db.sql(
				"select students.id,students.name,parents.contactnumber from classroom_attendance "
						+ "join students on classroom_attendance.studentid=students.id "
						+ "join parents on parents.id=students.parentid "
						+ "and classroom_attendance.classroomid=? and  classroom_attendance.dateofattendance=? "
						+ "and classroom_attendance.attendancestatus=? and subjectid=?",
				classroomid, date.getDateofattendance(), status, subjectid).results(StudentTransferObject.class);
		return absentiesnames;
	}

	// optional attendance modes
	public List<AttendanceMode> listattendancemodes(long tenantId) {
		db = retrive.getDatabase(tenantId);
		return db.sql("select id,attendance_type from school_attendance ").results(AttendanceMode.class);
	}

	// optinal attendance status
	public String addingAttendanceStatus(long tenantId, ClassAttendenceTransferObject classattendancetransferobject) {
		db = retrive.getDatabase(tenantId);
		String attendancetype = classattendancetransferobject.getAttendance_type();
		List<AttendanceMode> status = db.where("status=1").results(AttendanceMode.class);
		if (status.isEmpty()) {
			db.sql("update school_attendance set status=1 where attendance_type=?", attendancetype).execute();
			return "updated";
		} else {
			return status.get(0).getAttendance_type();
		}
	}

	// attendance
	public List<TeacherModuleDTO> listTeacherAttendanceOption(long tenantId, ClassSectionTransferObject moduleDTO) {
		db = retrive.getDatabase(tenantId);
		long attendancetypeid = db.sql("select * from school_attendance where status=1").results(AttendanceMode.class)
				.get(0).getId();
		if (attendancetypeid != 1) {

			List<TeacherModuleDTO> onetime = db.sql(
					"select classrooms.id,classrooms.gradeid,classrooms.sectionname from classrooms where classrooms.classteacherid=?",
					moduleDTO.getId()).results(TeacherModuleDTO.class);
			return onetime;
		} else {
			return teacherservice.listAllSubjectsAlongWithClassRooms(tenantId, moduleDTO);
		}

	}
}