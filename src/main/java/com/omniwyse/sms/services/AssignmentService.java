package com.omniwyse.sms.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dieselpoint.norm.Database;
import com.omniwyse.sms.db.DatabaseRetrieval;
import com.omniwyse.sms.models.AssignmentType;
import com.omniwyse.sms.models.Assignments;
import com.omniwyse.sms.models.Lessons;
import com.omniwyse.sms.models.Subjects;
import com.omniwyse.sms.utils.AssignmentDTO;
import com.omniwyse.sms.utils.AssignmentDTOOut;
import com.omniwyse.sms.utils.TimelineDTO;

@Service
public class AssignmentService {

	@Autowired
	private DatabaseRetrieval retrive;
	private Database db;

	public int assignAssignment(long tenantId, AssignmentDTO assigning) {

		db = retrive.getDatabase(tenantId);

		return db.insert(assignments(db, assigning)).getRowsAffected();
	}

	private Assignments assignments(Database db, AssignmentDTO assigning) {

		Assignments assignment = new Assignments();
		long classroomid = assigning.getId();
		String assignmentname = assigning.getAssignmentname();
		Date dateofassigned = assigning.getDateofassigned();
		Date assignmentduedate =  assigning.getAssignmentduedate();
		assignment.setClassroomid(classroomid);
		assignment.setAssignmentname(assignmentname);
		assignment.setDateofassigned(dateofassigned);
		assignment.setAssignmentduedate(assignmentduedate);
		assignment.setTags(assigning.getTags());

		assignment.setAssignment_type_id(assigning.getAssignment_type_id());
		assignment.setInstructions(assigning.getInstructions());
		assignment.setPath(assigning.getPath());
		assignment.setImagepath(assigning.getImagepath());
		assignment.setVideo_path(assigning.getVideo_path());
		assignment.setMarks(assigning.getMarks());
		assignment.setCredit(assigning.isCredit());

		if (assigning.getSubjectname() != null && !assigning.getSubjectname().isEmpty()) {

			Long subjectid = db.where("subjectname = ?", assigning.getSubjectname()).results(Subjects.class).get(0)
					.getId();
			assignment.setSubjectid(subjectid);
		}
		if (assigning.getLessonname() != null && !assigning.getLessonname().isEmpty()) {
			Long lessonid = db.where("lessonname = ? and classroomid = ?", assigning.getLessonname(), classroomid)
					.results(Lessons.class).get(0).getId();
			assignment.setLessonsid(lessonid);
		}

		return assignment;
	}

	public int deleteAssignedAssignment(Assignments data, long tenantId) {
		db = retrive.getDatabase(tenantId);
		return db.delete(data).getRowsAffected();

	}

	public List<AssignmentDTOOut> assignmentsList(long tenantId, TimelineDTO data, boolean status) {

		db = retrive.getDatabase(tenantId);
		List<AssignmentDTOOut> list = null;
		String query = "select subjects.subjectname,assignments.id,assignments.assignmentduedate, assignments.assignmentname, assignments.dateofassigned,"
				+ "assignments.publishassignment, assignments.tags, lessons.lessonname from assignments LEFT JOIN lessons ON "
				+ "lessons.id = assignments.lessonsid LEFT JOIN subjects  ON subjects.id = assignments.subjectid ";
		if (data.getSubjectname() != null) {
			long subjectId = db.where("subjectname = ?", data.getSubjectname()).results(Subjects.class).get(0).getId();
			list = db.sql(query + " where assignments.classroomid = ? and assignments.subjectid = ?", data.getId(),
					subjectId).results(AssignmentDTOOut.class);
			return list;
		} else if (status == false) {
			list = db.sql(query + " where assignments.classroomid = ? ", data.getId()).results(AssignmentDTOOut.class);
			return list;
		} else {
			list = db.sql(query + " where assignments.classroomid = ? and lessons.publishtimeline=1 ", data.getId())
					.results(AssignmentDTOOut.class);
			return list;
		}
	}

	public List<AssignmentDTO> getAssignmentForClassRoom(long tenantId, Long classRoomId) {
		db = retrive.getDatabase(tenantId);
		List<AssignmentDTO> list = null;
		String query = "select subjects.subjectname,assignments.id,assignments.assignmentduedate, assignments.assignmentname, assignments.dateofassigned,"
				+ "assignments.publishassignment, assignments.tags, lessons.lessonname from assignments LEFT JOIN lessons ON "
				+ "lessons.id = assignments.lessonsid LEFT JOIN subjects  ON subjects.id = assignments.subjectid ";
		list = db.sql(query + " where assignments.classroomid = ?", classRoomId).results(AssignmentDTO.class);
		return list;
	}

	public List<AssignmentDTO> getAssignmentsForClassRoomAndSubject(long tenantId, Long classRoomId, Long subjectId) {
		db = retrive.getDatabase(tenantId);
		List<AssignmentDTO> list = null;
		String query = "select subjects.subjectname,assignments.id,assignments.assignmentduedate, assignments.assignmentname, assignments.dateofassigned,"
				+ "assignments.publishassignment, assignments.tags, lessons.lessonname from assignments LEFT JOIN lessons ON "
				+ "lessons.id = assignments.lessonsid LEFT JOIN subjects  ON subjects.id = assignments.subjectid ";
		list = db.sql(query + " where assignments.classroomid = ? and assignments.subjectid=?", classRoomId, subjectId).results(AssignmentDTO.class);
		return list;
	}

	public int addAssignmentType(long tenantId, AssignmentType assignmentType) {
		int rowEffected = 0;
		 db = retrive.getDatabase(tenantId);
		List<AssignmentType> assignmentTypeList = db.where("assignmentname = ?",assignmentType.getAssignmentname()).results(AssignmentType.class);
		if(assignmentTypeList.isEmpty())
		{
			rowEffected = db.insert(assignmentType).getRowsAffected();
		}
		return rowEffected;
	}
	
	public List<AssignmentType> getAssignmentTypeList(long tenantId) {
		db = retrive.getDatabase(tenantId);
		return db.sql("select * from assignment_types").results(AssignmentType.class);

	}

}
