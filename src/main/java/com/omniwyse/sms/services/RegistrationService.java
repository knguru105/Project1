package com.omniwyse.sms.services;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dieselpoint.norm.Database;
import com.dieselpoint.norm.Transaction;
import com.omniwyse.sms.Application;
import com.omniwyse.sms.db.DBFactory;
import com.omniwyse.sms.models.Clients;
import com.omniwyse.sms.models.Tenants;
import com.omniwyse.sms.utils.Users;

@Service
public class RegistrationService {

	@Autowired
	private DBFactory database;

	final Logger LOGGER = LoggerFactory.getLogger(RegistrationService.class);

	public int a, b;

	private String code;

	private String emailid;

	private Database db;

	private final Tenants tenant;

	private final Clients client;

	public RegistrationService() {
		tenant = new Tenants();
		client = new Clients();
	}

	public int registration(Users users) {

		tenant.setSname(users.getSchoolname());
        // tenant.setLocation(users.getCity() + "," + users.getStreet());
		code = users.getSchoolcode();
		tenant.setCode(code);
		tenant.setDbname(users.getSchoolcode());
		tenant.setDateofestablishment(users.getDateofestablishment());
		tenant.setCreatedOn(new Date());
		tenant.setModifiedOn(new Date());
		tenant.setUrl("iSchool"+users.getSchoolname());
		client.setFname(users.getContactname());
		client.setContactnumber(users.getContactnumber());
		client.setEmailid(users.getEmailid()); 
		client.setPassword(users.getPassword());
		
		emailid = users.getEmailid();
		db = database.getSchoolDb();
		if (!isValidEmailId()) {
			LOGGER.info("Invalid Email ID for Format");
			return -1;
		}
		
		Transaction transact = db.startTransaction();
		try{
			a = db.transaction(transact).insert(tenant).getRowsAffected();
			client.setSchoolid(tenant.getId());
			b = db.transaction(transact).insert(client).getRowsAffected();
			transact.commit();
		}catch (Exception e) {
			LOGGER.info("Exception in Registration" + e.getMessage());
			transact.rollback();
			return -1;
		}
		return 1;
	}

	private boolean isValidEmailId() {
		List<Clients> data = db.sql("select emailid from clients").results(Clients.class);
		for (Clients p : data) {
			if (p.getEmailid().equals(emailid)) {
				LOGGER.info("emailid duplicate" + p.getEmailid());
				return false;
			}
		}
		return true;

	}

	private boolean isValidCode() {
		List<Tenants> data = db.sql("select code from schools").results(Tenants.class);
		for (Tenants codes : data) {
			LOGGER.info("CODE" + codes.getCode());
			if (codes.getCode().equals(code)) {
				return false;
			}
		}
		return true;
	}
}