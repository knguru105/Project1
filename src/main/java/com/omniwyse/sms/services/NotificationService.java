package com.omniwyse.sms.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dieselpoint.norm.Database;
import com.dieselpoint.norm.Transaction;
import com.omniwyse.sms.db.DatabaseRetrieval;
import com.omniwyse.sms.models.Lessons;
import com.omniwyse.sms.models.Notifications;
import com.omniwyse.sms.models.StatusTable;
import com.omniwyse.sms.models.Teachers;
import com.omniwyse.sms.utils.NotificationsDTO;

@Service
public class NotificationService {

	@Autowired
	private DatabaseRetrieval retrieve;
	private Database db;

	public int publishNotification(long tenantId, NotificationsDTO data) {

		int rowEffected = 0;
		db = retrieve.getDatabase(tenantId);

		Notifications notifications = new Notifications();
		Transaction transaction = db.startTransaction();

		try {
			notifications.setNotificationname(data.getNotificationname());
			notifications.setDescription(data.getDescription());
			int rows = checkActioncode(tenantId, data);
			if (rows == 0) {
				Date currentdate = new Date();
				notifications.setActioncode(data.getActioncode());
				notifications.setParentactionrequired(data.getParentactionrequired());
				String teachername = db.where("id=?", data.getUserid()).results(Teachers.class).get(0).getTeachername();
				notifications.setPublishedby(teachername);
				notifications.setNotificationdate(currentdate);
				notifications.setStatus(true);
				notifications.setClassid(data.getClassid());
				rowEffected = db.transaction(transaction).insert(notifications).getRowsAffected();
				transaction.commit();
			}

		} catch (Exception e) {
			transaction.rollback();
			return -1;
		}
		return rowEffected;
	}

	private int checkActioncode(long tenantId, NotificationsDTO data) {

		db = retrieve.getDatabase(tenantId);
		int rowEffected = 0;
		long id = data.getId();
		if (data.getActioncode().equals("Timeline")) {
			long notificationid = isExistInNotifications(data);
			if (notificationid != 0) {
			if(db.where("id = ?", id).results(Lessons.class).get(0).isPublishtimeline()){
				rowEffected = db.sql("update lessons set publishtimeline = ? where id = ?", false, id).execute()
						.getRowsAffected();
			}else{
				rowEffected = db.sql("update lessons set publishtimeline = ? where id = ?", true, id).execute()
						.getRowsAffected();
			}
				rowEffected = db.sql("update notifications set status = ? where id= ?", false, notificationid).execute()
						.getRowsAffected();
				return rowEffected;
			} else {
				db.sql("update lessons set publishtimeline = ? where id = ?", true, id).execute().getRowsAffected();
			}
		} else if (data.getActioncode().equals("Tests")) {
			long notificationid = isExistInNotifications(data);
			if (notificationid != 0) {
				Long statusId = db.where("status = ?", "").results(StatusTable.class).get(0).getId();
				rowEffected = db.sql("update test_create set statusid = ? where id = ?", statusId, id).execute()
						.getRowsAffected();
			}
			return db.sql("update notifications set status = ? where id= ?", false, notificationid).execute()
					.getRowsAffected();
		}
		return rowEffected;
	}

	private long isExistInNotifications(NotificationsDTO data) {

		List<Notifications> notification = db.where("notificationname = ?", data.getNotificationname())
				.results(Notifications.class);
		if (!notification.isEmpty()) {
			return notification.get(0).getId();
		}

		return 0;
	}

	public List<NotificationsDTO> listAllPublishednNotifications(long tenantid, NotificationsDTO data) {

		db = retrieve.getDatabase(tenantid);

		List<NotificationsDTO> list = db.sql("select * from notifications where status = 0")
				.results(NotificationsDTO.class);

		return list;
	}

	public List<NotificationsDTO> listSentPublishednNotifications(long tenantid, NotificationsDTO data) {

		db = retrieve.getDatabase(tenantid);

		List<NotificationsDTO> list = db.sql("select * from notifications where status = 1")
				.results(NotificationsDTO.class);

		return list;
	}

}