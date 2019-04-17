package com.omniwyse.sms.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dieselpoint.norm.Database;
import com.omniwyse.sms.models.Holidays;
import com.omniwyse.sms.utils.HolidaysDTO;

@Service
public class HolidaysService {

	@Autowired
    private com.omniwyse.sms.db.DatabaseRetrieval retrive;

	private Database db;

    public int postHoliday(HolidaysDTO holidaydto, long tenantId) {
        db = retrive.getDatabase(tenantId);

        Holidays holidays = new Holidays();

        Date fromdate = new Date(holidaydto.getFromdate());
        Date todate = new Date(holidaydto.getTodate());

        if (todate.compareTo(fromdate) >= 0) {
                holidays.setOccassion(holidaydto.getOccassion());
                holidays.setFromdate(fromdate);
                holidays.setTodate(todate);
                return db.insert(holidays).getRowsAffected();
        }
        return 0;
    }
    
    
    // private boolean alreadyExist(Date newfromdate, Date newtodate,
    // List<Holidays> existingholidayslist) {
    //
    // int size = existingholidayslist.size();
    // for(Holidays existingholiday : existingholidayslist){
    //
    // // another way to compare the days using dateutils
    // if (!DateUtils.isSameDay(newfromdate, existingholiday.getTodate())) {
    // }
    //
    // if (newfromdate.compareTo(existingholiday.getTodate()) > 0) {
    // size--;
    // } else if ((newfromdate.compareTo(existingholiday.getFromdate()) < 0 &&
    // newtodate.compareTo(existingholiday
    // .getFromdate()) < 0)) {
    // size--;
    // }
    // }
    // if(size == 0) {
    // return true;
    // }
    // return false;
    // }
    

	public List<Holidays> listOfHolidays(long tenantId) {
		
		db = retrive.getDatabase(tenantId);
		
        return db.results(Holidays.class);
	}

	public int deleteHoliday(Holidays holiday, long tenantId) {
		db = retrive.getDatabase(tenantId);
		return db.delete(holiday).getRowsAffected();
	}

    public int editHoliday(Holidays holidays, long tenantId) {
        db = retrive.getDatabase(tenantId);

        return db.update(holidays).getRowsAffected();

    }

}
