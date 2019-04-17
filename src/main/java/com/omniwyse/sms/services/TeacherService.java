package com.omniwyse.sms.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dieselpoint.norm.Database;
import com.dieselpoint.norm.Transaction;
import com.omniwyse.sms.models.Teachers;
import com.omniwyse.sms.models.UserCredentials;
import com.omniwyse.sms.models.UserRoleMaintain;
import com.omniwyse.sms.models.UserRoles;
import com.omniwyse.sms.utils.TeachersDTO;


@Service
public class TeacherService {

	@Autowired
    private com.omniwyse.sms.db.DatabaseRetrieval retrive;

	private Database db;

	public int addTeacher(long tenantId, TeachersDTO addTeacher) {

		db = retrive.getDatabase(tenantId);

		String email = addTeacher.getEmailid();
			Teachers teachers=new Teachers();
			teachers.setTeachername(addTeacher.getTeachername());
			teachers.setMiddlename(addTeacher.getMiddlename());
			teachers.setLname(addTeacher.getLname());
			teachers.setBloodgroup(addTeacher.getBloodgroup());
        teachers.setDateofbirth(new Date(addTeacher.getDateofbirth()));
        teachers.setDateofjoining(new Date(addTeacher.getDateofjoining()));
			teachers.setContactnumber(addTeacher.getContactnumber());
			teachers.setGender(addTeacher.getGender());
			teachers.setAbout(addTeacher.getAbout());
			teachers.setAddress(addTeacher.getAddress());
			teachers.setQualification(addTeacher.getQualification());
			teachers.setSubjects(addTeacher.getSubjects());
			teachers.setEmailid(addTeacher.getEmailid());
			teachers.setNoofperiods(addTeacher.getNoofperiods());
			teachers.setMaritalstatus(addTeacher.getMaritalstatus());
			Transaction transaction = db.startTransaction();
			try {
				if (addTeacher.getId() != 0) {
					teachers.setId(addTeacher.getId());
					String existingemailid=db.sql("select emailid from teachers where id=?",addTeacher.getId()).results(Teachers.class).get(0).getEmailid();
					List<Teachers> teacher= db.sql("select * from teachers where emailid=?", addTeacher.getEmailid()).results(Teachers.class);
					if(addTeacher.getEmailid().equals(existingemailid)||teacher.isEmpty())
					{
						long userid=db.sql("select id from usercredentials where mail=?",existingemailid).results(UserCredentials.class).get(0).getId();
					db.transaction(transaction)
							.sql("update usercredentials set mail=? where id=?", addTeacher.getEmailid(),userid).execute();
					db.transaction(transaction).update(teachers);
					transaction.commit();
					return 5;
					}
					return -10;
				}
				if (isValidTeacher(email)) {

				db.transaction(transaction).insert(teachers).getRowsAffected();
				UserCredentials userCredentials = new UserCredentials();
				List<UserCredentials> mail = db.where("mail=?", addTeacher.getEmailid()).results(UserCredentials.class);
				if (mail.isEmpty()) {
					userCredentials.setMail(addTeacher.getEmailid());
					userCredentials.setPassword(addTeacher.getPassword());
					userCredentials.setStatusid(1);

					db.transaction(transaction).insert(userCredentials);

					UserRoleMaintain userRoleMaintain = new UserRoleMaintain();
					userRoleMaintain.setUserid(userCredentials.getId());
					long roleid = db.sql("select id from roles where role=?",addTeacher.getRole()).results(UserRoles.class).get(0)
							.getId();
					userRoleMaintain.setRoleid(roleid);
					db.transaction(transaction).insert(userRoleMaintain);
					transaction.commit();
					return 1;
				} else {
					return -5;
				}
			} else {
				return -1;

			}
			} catch (Throwable tw) {
				tw.printStackTrace();
				transaction.rollback();
				return 0;
			}
	}

	

	private boolean isValidTeacher(String email) {

		List<Teachers> teacher = db.where("emailid=?", email).results(Teachers.class);
		if (teacher.isEmpty()) {
			return true;
		} else

			return false;
	}

}
