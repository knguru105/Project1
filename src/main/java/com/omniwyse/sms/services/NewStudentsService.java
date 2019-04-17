package com.omniwyse.sms.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dieselpoint.norm.Database;
import com.dieselpoint.norm.Transaction;

import com.omniwyse.sms.models.BusSummery;
import com.omniwyse.sms.models.Buses;
import com.omniwyse.sms.models.ClassRoom;
import com.omniwyse.sms.models.Grades;
import com.omniwyse.sms.models.House;
import com.omniwyse.sms.models.Parents;
import com.omniwyse.sms.models.Routes;
import com.omniwyse.sms.models.StudentClassroom;
import com.omniwyse.sms.models.Students;
import com.omniwyse.sms.models.StudentsInBus;
import com.omniwyse.sms.models.UserCredentials;
import com.omniwyse.sms.models.UserRoleMaintain;
import com.omniwyse.sms.models.UserRoles;
import com.omniwyse.sms.utils.ClassRoomStudents;
import com.omniwyse.sms.utils.StudentTransferObject;

/**
 * Currently work in progress - Not used
 * @author reddyraja
 *
 */
@Service
public class NewStudentsService {

	@Autowired
	private com.omniwyse.sms.db.DatabaseRetrieval retrive;

	private Database db;

	private long gradeid;
	private String gradename;
	private String syllabustype;
	private String admissionnumber;
	private Students students;

	public int createStudent(StudentTransferObject addStudent, long tenantId) {
		db = retrive.getDatabase(tenantId);
		Transaction transaction = db.startTransaction();
		Students student = prepareStudent(addStudent);

		gradeid = db.where("gradename=? and syllabustype=?", gradename, syllabustype).results(Grades.class).get(0)
				.getId();
		List<House> house = db.where("housename=?", addStudent.getHousename()).results(House.class);
		if (!house.isEmpty()) {
			student.setHouseid(house.get(0).getId());
		}
		
		student.setGradeid(gradeid);
		admissionnumber = addStudent.getAdmissionnumber();
		if (!isValidStudent(admissionnumber)) {
			return 0;
		}
		return db.transaction(transaction).insert(students).getRowsAffected();
	}

	/*
	 * public int addParentToStudent(ParentTransferObject parent, long tenantId) {
	 * db = retrive.getDatabase(tenantId); Transaction transaction =
	 * db.startTransaction();
	 * 
	 * Parents parent = new
	 * Parents();parent.setMothername(addStudent.getMothername());
	 * parent.setFathername(addStudent.getFathername());
	 * parent.setEmailid(addStudent.getParentemailid());
	 * parent.setContactnumber(addStudent.getContactnumber());
	 * parent.setAddress(addStudent.getParentaddress());
	 * 
	 * db.transaction(transaction).insert(parent);
	 * 
	 * UserCredentials userCredentials = new UserCredentials();
	 * List<UserCredentials> mail = db.where("mail=?",
	 * addStudent.getParentemailid()).results(UserCredentials.class); if
	 * (mail.isEmpty()) { userCredentials.setMail(addStudent.getParentemailid());
	 * userCredentials.setPassword(addStudent.getPassword());
	 * userCredentials.setStatusid(1);
	 * db.transaction(transaction).insert(userCredentials); UserRoleMaintain
	 * userRoleMaintain = new UserRoleMaintain();
	 * userRoleMaintain.setUserid(userCredentials.getId()); long roleid =
	 * db.sql("select id from roles where role=?",
	 * addStudent.getRole()).results(UserRoles.class) .get(0).getId();
	 * userRoleMaintain.setRoleid(roleid);
	 * db.transaction(transaction).insert(userRoleMaintain); if (register(parentid,
	 * addStudent, db, transaction) == 0) return 0; } else { return -5; } }
	 * 
	 */

	/*
	 * Parents parent = new
	 * Parents();parent.setMothername(addStudent.getMothername());parent.
	 * setFathername(addStudent.getFathername());parent.setEmailid(addStudent.
	 * getParentemailid());parent.setContactnumber(addStudent.getContactnumber());
	 * parent.setAddress(addStudent.getParentaddress());try {
	 * db.transaction(transaction).insert(parent); long parentid = parent.getId();
	 * UserCredentials userCredentials = new UserCredentials();
	 * List<UserCredentials> mail = db.where("mail=?",
	 * addStudent.getParentemailid()).results(UserCredentials.class); if
	 * (mail.isEmpty()) { userCredentials.setMail(addStudent.getParentemailid());
	 * userCredentials.setPassword(addStudent.getPassword());
	 * userCredentials.setStatusid(1);
	 * db.transaction(transaction).insert(userCredentials); UserRoleMaintain
	 * userRoleMaintain = new UserRoleMaintain();
	 * userRoleMaintain.setUserid(userCredentials.getId()); long roleid =
	 * db.sql("select id from roles where role=?",
	 * addStudent.getRole()).results(UserRoles.class) .get(0).getId();
	 * userRoleMaintain.setRoleid(roleid);
	 * db.transaction(transaction).insert(userRoleMaintain); if (register(parentid,
	 * addStudent, db, transaction) == 0) return 0; } else { return -5; } }catch(
	 * Throwable tw) { tw.printStackTrace(); transaction.rollback(); return -1; }
	 * 
	 * }transaction.commit(); return 1;}
	 * 
	 */

	public int register(long parentid, StudentTransferObject addStudent, Database db, Transaction transaction) {
		students = new Students();
		gradename = addStudent.getGradename();
		syllabustype = addStudent.getSyllabustype();
		students.setAddress(addStudent.getAddress());
		students.setAdmissionnumber(addStudent.getAdmissionnumber());
		students.setDateofbirth(new Date(addStudent.getDob()));
		students.setDateofjoining(new Date(addStudent.getDoj()));
		students.setEmailid(addStudent.getEmailid());
		students.setGender(addStudent.getGender());
		students.setName(addStudent.getName());
		students.setMiddlename(addStudent.getMiddlename());
		students.setLastname(addStudent.getLastname());
		students.setBloodgroup(addStudent.getBloodgroup());
		students.setHeight(addStudent.getHeight());
		students.setWeight(addStudent.getWeight());
		students.setParentid(parentid);
		gradeid = db.where("gradename=? and syllabustype=?", gradename, syllabustype).results(Grades.class).get(0)
				.getId();
		List<House> house = db.where("housename=?", addStudent.getHousename()).results(House.class);
		if (!house.isEmpty()) {
			students.setHouseid(house.get(0).getId());
		}
		students.setGradeid(gradeid);
		admissionnumber = addStudent.getAdmissionnumber();

		if (isValidStudent(admissionnumber)) {
			return db.transaction(transaction).insert(students).getRowsAffected();
		} else {
			return 0;
		}
	}

	private Students prepareStudent(StudentTransferObject addStudent) {
		students = new Students();
		// gradename = addStudent.getGradename();
		// syllabustype = addStudent.getSyllabustype();
		students.setAddress(addStudent.getAddress());
		students.setAdmissionnumber(addStudent.getAdmissionnumber());
		students.setDateofbirth(new Date(addStudent.getDob()));
		students.setDateofjoining(new Date(addStudent.getDoj()));
		students.setEmailid(addStudent.getEmailid());
		students.setGender(addStudent.getGender());
		students.setName(addStudent.getName());
		students.setMiddlename(addStudent.getMiddlename());
		students.setLastname(addStudent.getLastname());
		students.setBloodgroup(addStudent.getBloodgroup());
		students.setHeight(addStudent.getHeight());
		students.setWeight(addStudent.getWeight());
		return students;
	}

	private boolean isValidStudent(String admissionnumber) {
		List<Students> students = db.where("admissionnumber=?", admissionnumber).results(Students.class);
		if (students.isEmpty())
			return true;
		else
			return false;
	}

	public String updateStudent(StudentTransferObject updateStudent, long tenantId) {
		db = retrive.getDatabase(tenantId);
		List<Grades> grade = db
				.where("gradename=? and syllabustype=?", updateStudent.getGradename(), updateStudent.getSyllabustype())
				.results(Grades.class);
		Parents parent = db.where("id=?", updateStudent.getParentid()).results(Parents.class).get(0);
		parent.setFathername(updateStudent.getFathername());
		parent.setMothername(updateStudent.getMothername());
		parent.setContactnumber(updateStudent.getContactnumber());
		parent.setAddress(updateStudent.getParentaddress());
		db.update(parent);
		Students students = new Students();
		students.setId(updateStudent.getId());
		students.setParentid(updateStudent.getParentid());
		long houseid = db.where("housename=?", updateStudent.getHousename()).results(House.class).get(0).getId();
		students.setGradeid(grade.get(0).getId());
		students.setHouseid(houseid);
		students.setName(updateStudent.getName());
		students.setMiddlename(updateStudent.getMiddlename());
		students.setLastname(updateStudent.getLastname());
		students.setGender(updateStudent.getGender());
		students.setHeight(updateStudent.getHeight());
		students.setWeight(updateStudent.getWeight());
		students.setEmailid(updateStudent.getEmailid());
		students.setBloodgroup(updateStudent.getBloodgroup());
		students.setDateofbirth(new Date(updateStudent.getDob()));
		students.setDateofjoining(new Date(updateStudent.getDoj()));
		students.setAddress(updateStudent.getAddress());
		students.setAdmissionnumber(updateStudent.getAdmissionnumber());
		int rowEffected = db.update(students).getRowsAffected();
		if (rowEffected > 0) {
			return assignStudentsToBus(tenantId, updateStudent.getRoutename(), updateStudent.getId());
		} else
			return "-10";
	}

	public String assignStudentsToBus(long tenantId, String routename, long studentid) {
		if (routename != null) {
			db = retrive.getDatabase(tenantId);
			Long routeid = db.where("routename=?", routename).results(Routes.class).get(0).getId();
			List<BusSummery> busDetails = db.where("routeid=?", routeid).results(BusSummery.class);
			for (BusSummery busSummery : busDetails) {
				long noofstudents = busSummery.getNoofstudents();
				long noofseats = db.where("id=?", busSummery.getBusid()).results(Buses.class).get(0).getNoofseats();
				if (noofseats == noofstudents + 2) {
					continue;
				} else {
					StudentsInBus studentsInBus = new StudentsInBus();
					studentsInBus.setBusid(busSummery.getBusid());
					studentsInBus.setRouteid(routeid);
					studentsInBus.setStudentid(studentid);
					List<StudentsInBus> student = db.where("studentid=?", studentid).results(StudentsInBus.class);
					if (student.isEmpty()) {
						db.insert(studentsInBus).getRowsAffected();

					} else {
						StudentsInBus students = student.get(0);
						if (students.getBusid() != null) {
							db.sql("UPDATE bus_summery SET noofstudents=noofstudents-1 WHERE busid=?",
									student.get(0).getBusid()).execute();
						}
						studentsInBus.setId(student.get(0).getId());
						db.update(studentsInBus);
					}
					db.sql("UPDATE bus_summery SET noofstudents=noofstudents+1 WHERE busid=?", busSummery.getBusid())
							.execute();
					return db.sql("SELECT busnumber FROM buses WHERE id=?", busSummery.getBusid()).results(Buses.class)
							.get(0).getBusnumber();
				}

			}
			return "0";
		}
		return "1";

	}

	public int addStudentToClassroom(String admissionnumber, long classid, long tenantId) {
		StudentClassroom studentclassroom = new StudentClassroom();
		db = retrive.getDatabase(tenantId);
		long studentid = db.where("admissionnumber=?", admissionnumber).results(Students.class).get(0).getId();
		studentclassroom.setClassid(classid);
		studentclassroom.setStudentid(studentid);
		return db.insert(studentclassroom).getRowsAffected();
	}

	public List<ClassRoomStudents> getStudentsOfClassRoom(long classid, long tenantId) {
		db = retrive.getDatabase(tenantId);

		return db.sql("select students.name,students.id,parents.fathername,students.parentid,students.admissionnumber "
				+ "from students JOIN parents ON parents.id = students.parentid inner join "
				+ "classroom_students on classroom_students.classid=? and classroom_students.studentid=students.id",
				classid).results(ClassRoomStudents.class);

	}

	public List<Students> getStudentsOfGrade(long gradeid, long tenantId) {
		db = retrive.getDatabase(tenantId);
		return db.where("gradeid=?", gradeid).results(Students.class);
	}

	public List<Students> getStudentsList(long classroomid, long tenantId) {
		db = retrive.getDatabase(tenantId);
		long gradeId = db.where("id = ?", classroomid).results(ClassRoom.class).get(0).getGradeid();
		List<Students> gradestudentslist = getStudentsOfGrade(gradeId, tenantId);
		List<ClassRoomStudents> classstudentslist = getStudentsOfClassRoom(classroomid, tenantId);
		List<Students> studentslist = new ArrayList<Students>();
		int count = 0;
		for (Students stu : gradestudentslist) {
			count = 0;
			for (ClassRoomStudents s : classstudentslist) {
				if (stu.getId() == s.getId()) {
					count++;
					break;
				}
			}
			if (count == 0) {
				studentslist.add(stu);
			}

		}
		return studentslist;
	}
}
