package com.omniwyse.sms.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dieselpoint.norm.Database;
import com.dieselpoint.norm.Transaction;
import com.omniwyse.sms.db.DatabaseRetrieval;
import com.omniwyse.sms.models.BusSummery;
import com.omniwyse.sms.models.Buses;
import com.omniwyse.sms.models.Routes;
import com.omniwyse.sms.models.Staff;
import com.omniwyse.sms.models.StaffAddresses;
import com.omniwyse.sms.models.Stops;
import com.omniwyse.sms.models.Students;
import com.omniwyse.sms.models.Teachers;
import com.omniwyse.sms.utils.BusSummeryDTO;
import com.omniwyse.sms.utils.RoutesDTO;
import com.omniwyse.sms.utils.RoutesDisplayDTO;
import com.omniwyse.sms.utils.RoutesToStudents;
import com.omniwyse.sms.utils.StaffDTO;

@Service
public class TransportationService {
	@Autowired
	private DatabaseRetrieval retrive;
	private Database db;

	public int busRegistration(long tenantId, Buses bus) {
		db = retrive.getDatabase(tenantId);
	
		if (bus.getId() == 0) {
			bus.setActive(true);
			List<Buses> busnumber = db.where("busnumber=?", bus.getBusnumber()).results(Buses.class);
			if (busnumber.isEmpty()) {
				List<Buses> busname = db.where("registrationnumber=?", bus.getRegistrationnumber()).results(Buses.class);
				if (busname.isEmpty()) {
					db.insert(bus).getRowsAffected();
					BusSummery busSummery = new BusSummery();
					busSummery.setBusid(bus.getId());
					return db.insert(busSummery).getRowsAffected();

				} else
					return 0;
			} else
				return -1;
		} else {
			db.update(bus);
			return 5;
		}
	}

	public int addStop(long tenantId, Stops stops) {
		db = retrive.getDatabase(tenantId);
		
		if (stops.getId() == 0) {
			List<Stops> stopname = db.where("stopname=?", stops.getStopname()).results(Stops.class);
			if (stopname.isEmpty()) {
				return db.insert(stops).getRowsAffected();
			}
			return 0;
		} else {
			db.update(stops);
			return 5;
		}
	}


	public int addBusDetails(long tenantId, RoutesDTO routesDTO) {
		BusSummery busDetails = db.where("busid=?", routesDTO.getBusid()).results(BusSummery.class).get(0);
				busDetails.setDriverid(routesDTO.getDriverid());
				busDetails.setAttenderid(routesDTO.getAttenderid());
				busDetails.setTeacherid(routesDTO.getTeacherid());
				return db.update(busDetails).getRowsAffected();
			
	}

	public List<Buses> buses(long tenantId) {
		db = retrive.getDatabase(tenantId);
		return db.sql("SELECT * FROM buses").results(Buses.class);
	}

	
	public List<Stops> stops(long tenantId) {
		db = retrive.getDatabase(tenantId);
		return db.sql("select * from stops").results(Stops.class);
	}

	public int deleteBus(long tenantId, Buses bus) {
		db = retrive.getDatabase(tenantId);
		if (!bus.isActive()) {
			Transaction transaction=db.startTransaction();
			try
			{
			List<BusSummery> busSummery = db.where("busid=?", bus.getId()).results(BusSummery.class);
			if (!busSummery.isEmpty()) {
				db.transaction(transaction).sql("DELETE FROM bus_summery WHERE busid=?", bus.getId()).execute();
				db.transaction(transaction).sql("update bus_students set busid=null where busid=?",bus.getId()).execute();
			}
			 db.transaction(transaction).delete(bus);
			 transaction.commit();
			 return 1;
			}
			catch(Throwable tw)
			{
				transaction.rollback();
				tw.printStackTrace();
				return 0;
			}

		} else
			return 0;
	}

	public List<RoutesToStudents> listingRoutestoStudents(long tenantId) {
		db = retrive.getDatabase(tenantId);
		List<Routes> routes = db.sql("SELECT * FROM routes").results(Routes.class);
		List<RoutesToStudents> studentRoutes=new ArrayList<RoutesToStudents>();
		for (Routes routename : routes) {
			RoutesToStudents routestostudents=new RoutesToStudents();
			String name = routename.getStops();
			String s = "";
			int firstStop = name.indexOf(",");
			if (firstStop < 0) {
				s = name + "," + name;
			} else {
				s = s + name.substring(0, firstStop);
				int lastStop = name.lastIndexOf(",");
				s = s + "," + name.substring(lastStop + 1);
			}
			routestostudents.setRoute(s);
			routestostudents.setRoutename(routename.getRoutename());
			studentRoutes.add(routestostudents);
		}
		return studentRoutes;
	}

	public int addStaff(long tenantId, StaffDTO staffDTO) {

		if ((staffDTO.getRole() != null)&& ((staffDTO.getRole().equals("DRIVER"))||(staffDTO.getRole().equals("ATTENDER")))) {
			db = retrive.getDatabase(tenantId);
			Transaction transaction = db.startTransaction();
			try {
				Staff staff = new Staff();
				staff.setFirstname(staffDTO.getFirstname());
				staff.setMiddlename(staffDTO.getMiddlename());
				staff.setLastname(staffDTO.getLastname());
				staff.setMailid(staffDTO.getMailid());
				staff.setBloodgroup(staffDTO.getBloodgroup());
				staff.setContactnumber(staffDTO.getContactnumber());
				staff.setMailid(staffDTO.getMailid());
				staff.setDateofbirth(staffDTO.getDateofbirth());
				staff.setDateofjoining(staffDTO.getDateofjoining());
				staff.setRole(staffDTO.getRole());
				staff.setQualification(staffDTO.getQualification());
				staff.setLicensenumber(staffDTO.getLicensenumber());
				staff.setLicenseexpiredate(staffDTO.getLicenseexpiredate());
				staff.setExperience(staffDTO.getExperience());
				staff.setActive(true);

				StaffAddresses staffAddress = new StaffAddresses();
				staffAddress.setDoornumber(staffDTO.getDoornumber());
				staffAddress.setLine1(staffDTO.getLine1());
				staffAddress.setLine2(staffDTO.getLine2());
				staffAddress.setVillage(staffDTO.getVillage());
				staffAddress.setPin(staffDTO.getPin());
				staffAddress.setCity(staffDTO.getCity());
				staffAddress.setDistrict(staffDTO.getDistrict());
				staffAddress.setState(staffDTO.getState());
				if (staffDTO.getId() == 0) {
					List<Staff> staffdetails = db.where("licensenumber=?", staffDTO.getLicensenumber())
							.results(Staff.class);
					if (staffdetails.isEmpty()) {
						db.transaction(transaction).insert(staff);
						long staffid = staff.getId();
						staffAddress.setStaffid(staffid);
						db.transaction(transaction).insert(staffAddress).getRowsAffected();
					} else {
						return -5;
					}
				} else {
					staff.setId(staffDTO.getId());
					db.transaction(transaction).update(staff);
					long staffAddressId = db.where("staffid=?", staffDTO.getId()).results(StaffAddresses.class).get(0)
							.getId();
					staffAddress.setStaffid(staffDTO.getStaffid());
					staffAddress.setId(staffAddressId);
					db.transaction(transaction).update(staffAddress);
				}
				transaction.commit();
				return 1;
			} catch (Throwable tw) {
				transaction.rollback();
				tw.printStackTrace();
				return -1;
			}
		} else
			return -10;
	}

	public int stops(long tenantId, Stops stops) {
		db = retrive.getDatabase(tenantId);
		return db.delete(stops).getRowsAffected();
	}

	public List<BusSummeryDTO> busSummery(long tenantId) {
		db = retrive.getDatabase(tenantId);

		List<BusSummeryDTO> busSummery = db
				.sql("select bus_summery.busid,buses.busnumber,buses.noofseats,bus_summery.noofstudents,routes.routename,routes.stops from buses "
						+ "left join bus_summery on bus_summery.busid=buses.id left join routes on routes.id=bus_summery.routeid ")
				.results(BusSummeryDTO.class);
		for (BusSummeryDTO busdetails : busSummery) {
			Long busid = busdetails.getBusid();
			BusSummery details = db.where("busid=?", busid).results(BusSummery.class).get(0);
			String s = "select licensenumber,firstname,contactnumber from staff where id=?";
			Long driverid = details.getDriverid();
			if (driverid != null) {
				Staff staffdetails = db.sql(s, driverid).results(Staff.class).get(0);
				busdetails.setDrivername(staffdetails.getFirstname());
				busdetails.setDrivercontactnumber(staffdetails.getContactnumber());
				busdetails.setLicensenumber(staffdetails.getLicensenumber());
			}
			Long attenderid = details.getAttenderid();
			if (attenderid != null) {
				Staff staffdetails = db.sql(s, attenderid).results(Staff.class).get(0);
				busdetails.setAttendername(staffdetails.getFirstname());
				busdetails.setAttendercontactnumber(staffdetails.getContactnumber());
			}
			Long teacherid = details.getTeacherid();
			if (teacherid != null) {
				Teachers teacher = db.sql("select teachername,contactnumber from teachers where id=?", teacherid)
						.results(Teachers.class).get(0);
				busdetails.setTeachername(teacher.getTeachername());
				busdetails.setTeachercontactnumber(teacher.getContactnumber());
			}
			Long routeid = details.getRouteid();
			if (routeid != null) {
				Routes route = db.sql("select routename,stops from routes where id=?", routeid).results(Routes.class)
						.get(0);
				busdetails.setRoutename(route.getRoutename());
				busdetails.setStops(route.getStops());
			}
			busdetails.setStudents(db
					.sql("select students.name from bus_students join students on students.id=bus_students.studentid where bus_students.busid=?",
							busid)
					.results(Students.class));
		}
		return busSummery;
	}

	public List<RoutesDisplayDTO> routes(long tenantId) {
		db = retrive.getDatabase(tenantId);
		return db
				.sql("select routes.id,routes.routename,routes.stops,routes.numberofstops,routes.distance,buses.busnumber,buses.registrationnumber,bus_summery.busid from routes "
						+ "left join bus_summery on bus_summery.routeid=routes.id left join buses on buses.id=bus_summery.busid")
				.results(RoutesDisplayDTO.class);

	}

	public List<Staff> busDrivers(long tenantId) {
		db = retrive.getDatabase(tenantId);
		
		return db
				.sql("select staff.id,staff.firstname from staff  left join bus_summery on bus_summery.driverid = staff.id where driverid is NULL and staff.role='DRIVER'")
				.results(Staff.class);
	}

	public List<Staff> busAttenders(long tenantId) {
		db = retrive.getDatabase(tenantId);
		return db
				.sql("select staff.id,staff.firstname from staff left join bus_summery on bus_summery.attenderid = staff.id where attenderid is NULL and staff.role='ATTENDER'")
				.results(Staff.class);
	}
	public List<Buses> routeBuses(long tenantId)
	{
		db = retrive.getDatabase(tenantId);
		return db.sql("select buses.id,buses.busnumber,buses.registrationnumber,buses.busname from buses left join bus_summery on bus_summery.busid = buses.id where routeid is NULL").results(Buses.class);
		
	}

	public List<Teachers> busTeachers(long tenantId) {
		db = retrive.getDatabase(tenantId);
		return db.sql("select teachers.id,teachers.teachername from teachers left join bus_summery on bus_summery.teacherid = teachers.id where teacherid is NULL")
				.results(Teachers.class);
	}

	
	public List<StaffDTO> staff(long tenantId) {
		db = retrive.getDatabase(tenantId);
		return db
				.sql("SELECT staff.id,firstname,lastname,middlename,role,contactnumber,dateofbirth,dateofjoining,licensenumber,licenseexpiredate,mailid,experience,bloodgroup,qualification,"
						+ "active,doornumber,line1,line2,village,city,district,state,pin,staffid FROM staff join addresses on addresses.staffid=staff.id")
				.results(StaffDTO.class);
	}

	public int deleteStaff(long tenantId, StaffDTO staffDTO) {
		db = retrive.getDatabase(tenantId);
		db.sql("delete from staff where id=?", staffDTO.getId());
	return 	db.sql("delete from addresses where staffid=?",staffDTO.getId()).execute().getRowsAffected();
	
	}

	public String addRoute(long tenantId, RoutesDTO routesDTO) {
		db = retrive.getDatabase(tenantId);
		Routes route = new Routes();
		List<Routes> routes = db.where("routename=?", routesDTO.getRoutename()).results(Routes.class);
		String s = "";
		for (int i = 0; i < routesDTO.getStops().size(); i++) {
			String stop = routesDTO.getStops().get(i);
			s = s + stop;
			if (i != routesDTO.getStops().size() - 1)
				s = s + ",";
		}
		if (!routes.isEmpty()) {
			if (routes.get(0).getStops().equals(s)) {
				db.sql("update bus_summery set routeid=? where busid=?", routes.get(0).getId(), routesDTO.getBusid())
						.execute();
				return "1";
			}
			return "0";
		} else {
			List<Routes> stops = db.where("stops=?", s).results(Routes.class);
			if (stops.isEmpty()) {
				route.setRoutename(routesDTO.getRoutename());
				route.setStops(s);
				route.setNumberofstops(routesDTO.getStops().size());
				route.setDistance(routesDTO.getDistance());
				db.insert(route);
				db.sql("update bus_summery set routeid=? where busid=?", route.getId(), routesDTO.getBusid()).execute()
						.getRowsAffected();
				return "1";
			}
			return stops.get(0).getRoutename();
		}
	}
	public int deleteRoute(long tenantId, Routes route) {
		db = retrive.getDatabase(tenantId);
		Transaction transaction=db.startTransaction();
		try
		{
		db.transaction(transaction).sql("update bus_students set routeid=null where routeid=?",route.getId()).execute();
		db.transaction(transaction).sql("update bus_summery set routeid=null where routeid=?", route.getId()).execute();
		db.transaction(transaction).sql("delete from routes where id=?",route.getId()).execute().getRowsAffected();
		transaction.commit();
		return 1;
		}
		catch(Throwable tw)
		{
			transaction.rollback();
			tw.printStackTrace();
			return 0;
			
		}
	}

}