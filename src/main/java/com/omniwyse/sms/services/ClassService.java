package com.omniwyse.sms.services;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dieselpoint.norm.Database;
import com.omniwyse.sms.Application;
import com.omniwyse.sms.db.DatabaseRetrieval;
import com.omniwyse.sms.models.AcademicYears;
import com.omniwyse.sms.models.ClassRoom;
import com.omniwyse.sms.models.GradeSubjects;
import com.omniwyse.sms.models.Grades;
import com.omniwyse.sms.models.PeriodTypes;
import com.omniwyse.sms.models.SubjectTeacherClass;
import com.omniwyse.sms.models.Teachers;
import com.omniwyse.sms.utils.AcademicYearsDTO;
import com.omniwyse.sms.utils.ClassSectionTransferObject;

@SuppressWarnings("unused")
@Service
public class ClassService {

	private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

	@Autowired
	private DatabaseRetrieval retrieve;

	private SubjectTeacherClass stc;
	private Database db;
    private Long academicid;
	private String sectionname;
	private String teachername;
    private Long teacherid;
	private String gradename;
	private String syllabustype;
    private Long gradeid;

    public int createClass(long tenantId, ClassSectionTransferObject createclass) {

        db = retrieve.getDatabase(tenantId);

        academicid = db.where("active=?", 1).results(AcademicYears.class).get(0).getId();

        sectionname = createclass.getSectionname();
        teachername = createclass.getTeachername();
        gradename = createclass.getGradename();
        syllabustype = createclass.getSyllabustype();

        List<Grades> record = db.where("gradename=? and syllabustype=?", gradename, syllabustype).results(Grades.class);
        if (record.isEmpty()) {
            return -5;
        }
        gradeid = record.get(0).getId();

        List<ClassRoom> records = db.where("academicid = ? and sectionname=? and gradeid=?", academicid, sectionname,
                gradeid).results(ClassRoom.class);
        if (records.isEmpty()) {

            ClassRoom classes = new ClassRoom();

            classes.setAcademicid(academicid);
            classes.setSectionname(sectionname);
            classes.setGradeid(gradeid);

            if (isValidTeachername(teachername)) {
            	
                classes.setClassteacherid(db.where("teachername=?", teachername).results(Teachers.class).get(0).getId());
            }
			if (createclass.getPeriod_type_id() != null) {
				classes.setPeriod_type_id(createclass.getPeriod_type_id());
			} else {
				List<PeriodTypes> periodTypes = db.sql("select * from period_type where default_value = true")
						.results(PeriodTypes.class);
				if (!periodTypes.isEmpty()) {
					classes.setPeriod_type_id(periodTypes.get(0).getId());
				}
			}
            db.insert(classes).getRowsAffected();
            stc = new SubjectTeacherClass();
			List<GradeSubjects> subjectids = db.where("gradeid=?", gradeid).results(GradeSubjects.class);
			for (GradeSubjects subjectid : subjectids) {
				stc.setClassid(classes.getId());
				stc.setSubjectid(subjectid.getSubjectid());
				db.insert(stc);
				}
			return 1;
        }
        return -1;
    }

	private boolean isValidTeachername(String teachername) {

        boolean returnflag = false;

		List<Teachers> teacher = db.where("teachername = ?", teachername).results(Teachers.class);
        if (!teacher.isEmpty()) {
            returnflag = true;
        }
        return returnflag;
	}

    private boolean isExist(long academicyearid, long teacherid) {

        List<ClassRoom> teachersids = db.where("academicid = ?", academicyearid).results(ClassRoom.class);
        for (ClassRoom classes : teachersids) {
            if (classes.getClassteacherid() != null && classes.getClassteacherid() == teacherid) {
                return false;
            }
        }
        return true;
    }

    public int updateClassTeacher(long tenantId, ClassSectionTransferObject updateclass) {

        db = retrieve.getDatabase(tenantId);

        String teachername = updateclass.getTeachername();

        ClassRoom classes = new ClassRoom();
        Long teacherid = null;
        long academicid = updateclass.getAcademicid();
        if (teachername != null) {
            teacherid = db.where("teachername=?", teachername).results(Teachers.class).get(0).getId();
            classes.setAcademicid(updateclass.getAcademicid());
            classes.setSectionname(updateclass.getSectionname());
            classes.setId(updateclass.getId());
            classes.setGradeid(updateclass.getGradeid());
            classes.setClassteacherid(teacherid);
            classes.setPeriod_type_id(updateclass.getPeriod_type_id());
            db.update(classes).execute();

        } else {
            return -1;
        }
        return 1;

    }

	public List<ClassSectionTransferObject> getClassRoomsByYearAndSyllabustype(long tenantId, long academicyearid,String syllabustype) {
		db = retrieve.getDatabase(tenantId);

        List<ClassSectionTransferObject> classroomslist = db.sql("select classrooms.id,classrooms.academicid,classrooms.gradeid, classrooms.period_type_id, grades.gradenumber,grades.gradename,classrooms.sectionname,grades.syllabustype,"
                        + "teachers.teachername,classrooms.classteacherid from classrooms left join grades on classrooms.gradeid=grades.id left JOIN teachers ON classrooms.classteacherid = teachers.id "
                        + "where classrooms.academicid=? and grades.syllabustype=?",academicyearid, syllabustype).results(ClassSectionTransferObject.class);
        return classroomslist;
	}

	

}