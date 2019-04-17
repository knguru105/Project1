package com.omniwyse.sms.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dieselpoint.norm.Database;
import com.dieselpoint.norm.Transaction;
import com.omniwyse.sms.FlywayRunner;
import com.omniwyse.sms.db.DatabaseRetrieval;
import com.omniwyse.sms.models.ClassRoom;
import com.omniwyse.sms.models.ClassRoomPeriods;
import com.omniwyse.sms.models.PeriodTypes;
import com.omniwyse.sms.models.Periods;
import com.omniwyse.sms.models.WeekDays;
import com.omniwyse.sms.utils.PeriodCellDTO;
import com.omniwyse.sms.utils.PeriodDTO;
import com.omniwyse.sms.utils.PeriodTypesDTO;
import com.omniwyse.sms.utils.TimeTableDataTransferObject;
import com.omniwyse.sms.utils.TimeTableView;
import com.omniwyse.sms.utils.TimetableDTO;

@Service
public class TimeTableService {

	@Autowired
	private DatabaseRetrieval retrive;

	public Database db;

	private static final Logger LOGGER = LoggerFactory.getLogger(FlywayRunner.class);

	public int addPeriodType(long tenantId, PeriodTypesDTO periodTypesDTO) {
		int rowEffected;
		try {
			db = retrive.getDatabase(tenantId);
			List<PeriodTypes> periodtypename = db.where("name = ?", periodTypesDTO.getName())
					.results(PeriodTypes.class);
			if (periodtypename.isEmpty()) {
				PeriodTypes periodTypes = new PeriodTypes();
				periodTypes.setName(periodTypesDTO.getName());

				
				long fromtimehours = Integer.parseInt(periodTypesDTO.getFromtime().getHH());
				
				System.out.println("fromtime hours:"+fromtimehours );
				long fromtime = fromtimehours * 60 + Integer.parseInt(periodTypesDTO.getFromtime().getMm());
				if (periodTypesDTO.getFromtime().getA().equalsIgnoreCase("pm"))
					fromtime = fromtime + (12 * 60);

				long totimehours = Integer.parseInt(periodTypesDTO.getTotime().getHH());

				System.out.println("fromtime hours:"+totimehours );
				long totime = totimehours * 60 + Integer.parseInt(periodTypesDTO.getTotime().getMm());
				if (periodTypesDTO.getTotime().getA().equalsIgnoreCase("pm"))
					totime = totime + (12 * 60);

				periodTypes.setFromtime(fromtime);
				periodTypes.setTotime(totime);

				periodTypes.setNumberofperiods(periodTypesDTO.getNumberofperiods());
				rowEffected = db.insert(periodTypes).getRowsAffected();
			} else {
				return 0;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			rowEffected = -5;
		}

		return rowEffected;

	}

	public List<PeriodTypes> getPeriodTypeList(long tenantId) {
		db = retrive.getDatabase(tenantId);
		List<PeriodTypes> periodTypes = db.sql("select id,name,fromtime,totime,numberofperiods from period_type").results(PeriodTypes.class);
	return periodTypes;
	
	}

	public int addPeriod(long tenantId, PeriodDTO periodDTO) {
		db = retrive.getDatabase(tenantId);
		int rowEffected = 0;
		List<Periods> periodsList = db
				.sql("select * from periods where periods.period_type_id = ? ", periodDTO.getPeriod_type_id())
				.results(Periods.class);
		List<PeriodTypes> periodTypes = db
				.sql("select numberofperiods from period_type where id = ? ", periodDTO.getPeriod_type_id())
				.results(PeriodTypes.class);

		try {
			if ((!periodTypes.isEmpty()) && (periodsList.size() < periodTypes.get(0).getNumberofperiods())) {
			
										
					long fromtimehours = Integer.parseInt(periodDTO.getPeriodfrom().getHH());
					
					System.out.println("fromtime hours:"+fromtimehours );
					long periodfrom = fromtimehours * 60 + Integer.parseInt(periodDTO.getPeriodfrom().getMm());
					if (periodDTO.getPeriodfrom().getA().equalsIgnoreCase("pm"))
						periodfrom = periodfrom + (12 * 60);

					long totimehours = Integer.parseInt(periodDTO.getPeriodto().getHH());

					System.out.println("fromtime hours:"+totimehours );
					long periodto= totimehours * 60 + Integer.parseInt(periodDTO.getPeriodto().getMm());
					if (periodDTO.getPeriodto().getA().equalsIgnoreCase("pm"))
						periodto = periodto + (12 * 60);
					
					if(!checkIfExistingTime(periodfrom,periodto,periodsList))
							{
				
					Periods period = new Periods();
					period.setPeriod_type_id(periodDTO.getPeriod_type_id());
					period.setPeriodfrom(periodfrom);
					period.setPeriodto(periodto);
					period.setPeriod_number(periodDTO.getPeriod_number());
					rowEffected = db.insert(period).getRowsAffected();
							}
					else
						rowEffected = -5;
			} else
				rowEffected = -1;
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return rowEffected;
	}

	private boolean checkIfExistingTime(Long periodfrom, Long periodto, List<Periods> periods) {
		boolean isExist = false;
		for (int i = 0; i < periods.size(); i++) {
			Periods period = periods.get(0);

			if ((periodfrom > period.getPeriodfrom() && periodfrom >= period.getPeriodto())
					&& (periodto > period.getPeriodfrom()) && periodto > period.getPeriodto())

			{
				continue;
			} else {
				isExist = true;
			}
		}
		return isExist;
	}
	

	public int createClassPeriods(long tenantId,PeriodCellDTO periodCellDTO) {
		db = retrive.getDatabase(tenantId);
		int num = 0;
		Transaction transact = db.startTransaction();
		try {
			
			List<ClassRoomPeriods> classRoomPeriods = db.sql(
					"select * from classroom_periods where classroomid = ? and classroomweekdayid = ? and periodid = ?",
					periodCellDTO.getClassroomid(), periodCellDTO.getWeekdayid(), periodCellDTO.getPeriodid()).results(ClassRoomPeriods.class);
			if (classRoomPeriods.isEmpty()) {
				ClassRoomPeriods clsprds = new ClassRoomPeriods();
				clsprds.setClassroomweekdayid(periodCellDTO.getWeekdayid());
				clsprds.setClassroomid(periodCellDTO.getClassroomid());

				clsprds.setPeriodid(periodCellDTO.getPeriodid());
				
				clsprds.setSubjectid(periodCellDTO.getSubjectid());
				num = db.transaction(transact).insert(clsprds).getRowsAffected();
			}
			else
			{
				//There may be other updates?
				db.transaction(transact).sql("update classroom_periods set subjectid = ? where id = ?", periodCellDTO.getSubjectid(),classRoomPeriods.get(0).getId()).execute();
				num=1;
			}
			
			transact.commit();

		} catch (Throwable thr) {
			transact.rollback();
			LOGGER.error("Error in saving period values");
			return -3;
		}
		return num;
	}

	public List<WeekDays> getAllDays(long tenantId) {
		db = retrive.getDatabase(tenantId);
		return db.sql("select * from weekdays order by id asc").results(WeekDays.class);
	}

	public TimetableDTO listPeriods(Long tenantId, Long classRoomId) {
		db = retrive.getDatabase(tenantId);

		TimetableDTO timetableDTO = new TimetableDTO();

		List<ClassRoom> classRoom = db.sql("select period_type_id from classrooms where id = ?", classRoomId)
				.results(ClassRoom.class);
		if (classRoom != null || !classRoom.isEmpty() ) {

			Long periodTypeId = classRoom.get(0).getPeriod_type_id();

			timetableDTO.setPeriodTypes(db.sql("select * from period_type where id = ?", periodTypeId)
					.results(PeriodTypes.class).get(0));

			List<Periods> periods = db.sql("select * from periods where period_type_id = ? order by periods.id asc", periodTypeId)
					.results(Periods.class);
			timetableDTO.setPeriods(periods);
		
			
			List<TimeTableView> timeTableViewList = db.sql("select * from weekdays order by id asc").results(TimeTableView.class);
			for(int i=0;i<timeTableViewList.size();i++)
			{
				TimeTableView timeTableView = timeTableViewList.get(i);
				
				
				List<TimeTableDataTransferObject> timeTableDataTransferObject = db.sql("select periods.id,periods.period_number,classroom_periods.periodid,subjects.subjectname,classroom_periods.subjectid from periods left join classroom_periods on classroom_periods.periodid = periods.id and classroom_periods.classroomweekdayid = ? and classroom_periods.classroomid =? " + 
						"left join subjects on classroom_periods.subjectid = subjects.id where periods.period_type_id =? order by periods.id asc", timeTableView.getId(),classRoomId,periodTypeId).results(TimeTableDataTransferObject.class);


//			List<TimeTableDataTransferObject> timeTableDataTransferObject = db.sql("select periods.id,periods.period_number,classroom_periods.periodid,subjects.subjectname,classroom_periods.subjectid from periods left join classroom_periods on classroom_periods.periodid = periods.id and classroom_periods.classroomweekdayid = ? " + 
//					"left join subjects on classroom_periods.subjectid = subjects.id where periods.period_type_id = ?", timeTableView.getId(),periodTypeId).results(TimeTableDataTransferObject.class);
//			
			
				timeTableView.setTimeTableDataTransferObject(timeTableDataTransferObject);
			}

			timetableDTO.setTimeTableView(timeTableViewList);
		
	}

 return timetableDTO;

}

	public List<Periods> getPeriodsList(long tenantId) {
		
		db = retrive.getDatabase(tenantId);
		return db.sql("select * from periods").results(Periods.class);
		
	
	}
}
