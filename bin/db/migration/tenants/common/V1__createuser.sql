-- **************** USER ROLES TABLES **************************************************************************************************************************************************************************

CREATE TABLE roles(
  id bigint(8) NOT NULL AUTO_INCREMENT,
  role varchar(255) NOT NULL, 
  description varchar(255) NOT NULL,
  createdon timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
  modifiedon timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
  PRIMARY KEY (id),
  UNIQUE KEY name_UNIQUE (role)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

 INSERT INTO roles(role,description)
 				 VALUES("SUPERADMIN","School owner"),
 				 	   ("ADMIN","School admin"),
 				 	   ("TEACHER","School teacher"),
 				 	   ("PARENT","Father or gardian of student"),
 				 	   ("STUDENT","student"),
 				 	   ("ADMINSTAFF","Admin Staff"),
 				 	   ("ATTENDER","Bus cleaner or maintainer"),
 				 	   ("DRIVER","Bus driver"),
 				 	   ("TRANSPORTCLERK","Transportaion accounts manager");
 				 	   
 CREATE TABLE userstatus(
  id bigint(8) NOT NULL AUTO_INCREMENT,
  status varchar(150) NOT NULL,
  createdon timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
  modifiedon timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
  PRIMARY KEY (id),
  UNIQUE KEY name_UNIQUE (status)
 )ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO userstatus(status)
			VALUES("Active"),
				  ("InActive"),
			 	  ("Pending");

CREATE TABLE usercredentials(
  id bigint(8) NOT NULL AUTO_INCREMENT,
  mail varchar(255) NOT NULL,
  password varchar(255) NOT NULL,
  statusid bigint(8)NOT NULL,
  createdon timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
  modifiedon timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
  PRIMARY KEY (id),
  FOREIGN KEY (statusid) REFERENCES userstatus (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO usercredentials(mail,password,statusid) 
					 VALUES("bhaskar@omniwyse.com","bhaskar",1),
					 	   ("tejachava@omniwyse.com","tejachava",1),
					 	   ("dariya@omniwyse.com","dariya",1),
					 	   ("rameshrangam@omniwyse.com","rameshrangam",1),
					 	   ("pushpa@omniwyse.com","pushpa",1),
					 	   ("mamatha@omniwyse.com","mamatha",1),
					 	   ("harinath@omniwyse.com","harinath",1),
					 	   ("mahatma@omniwyse.com","mahatma",1);

 CREATE TABLE UserRoleMaintain(
  id bigint(8) NOT NULL AUTO_INCREMENT,
  userid bigint(8) NOT NULL,
  roleid bigint(8) NOT NULL,
  createdon timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
  modifiedon timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
  PRIMARY KEY (id),
  FOREIGN KEY (userid) REFERENCES usercredentials (id),
  FOREIGN KEY (roleid) REFERENCES roles (id)
 )ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
 
 INSERT INTO UserRoleMaintain(userid,roleid)
 					   VALUES((SELECT ID FROM usercredentials WHERE mail = "bhaskar@omniwyse.com"),(SELECT ID FROM roles WHERE role = "ADMIN")),
 					   		 ((SELECT ID FROM usercredentials WHERE mail = "tejachava@omniwyse.com"),(SELECT ID FROM roles WHERE role = "TEACHER")),
 					   		 ((SELECT ID FROM usercredentials WHERE mail = "dariya@omniwyse.com"),(SELECT ID FROM roles WHERE role = "TEACHER")),
 					   		 ((SELECT ID FROM usercredentials WHERE mail = "rameshrangam@omniwyse.com"),(SELECT ID FROM roles WHERE role = "TEACHER")),
 					   		 ((SELECT ID FROM usercredentials WHERE mail = "pushpa@omniwyse.com"),(SELECT ID FROM roles WHERE role = "TEACHER")),
 					   		 ((SELECT ID FROM usercredentials WHERE mail = "mamatha@omniwyse.com"),(SELECT ID FROM roles WHERE role = "TEACHER")),
 					   		 ((SELECT ID FROM usercredentials WHERE mail = "harinath@omniwyse.com"),(SELECT ID FROM roles WHERE role = "PARENT")),
 					   		 ((SELECT ID FROM usercredentials WHERE mail = "mahatma@omniwyse.com"),(SELECT ID FROM roles WHERE role = "PARENT"));
 	
 					   		 
 -- ***************************************** PREDEFINED STATUS TABLE ************************************************************************************************************************************************************
 
 CREATE TABLE status_table(
	id bigint(8) NOT NULL PRIMARY KEY,
	status  varchar(40) NOT NULL,
	description varchar(150)
);	

insert into status_table values(1,'DRAFT','Created but inactive'),
						   	   (2,'ACTIVE','Created and inprogress'),
						   	   (3,'DONE','Completed'),
						   	   (4,'CLOSED','Completed and sealed');
 					   		 
  -- *********** BOARD OF EDUCATION TABLES ****************************************************************************************************************************************************************************

CREATE TABLE educationboard(
  id bigint(8) NOT NULL AUTO_INCREMENT,
  boardid bigint(8) NOT NULL,
  boardname varchar(150) NOT NULL,
  createdon timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
  modifiedon timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
  PRIMARY KEY (id),
  UNIQUE KEY name_UNIQUE (boardname)
 )ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

 
CREATE TABLE syllabus(
	id bigint(8) NOT NULL PRIMARY KEY,
	syllabustype  varchar(40) NOT NULL,
	description varchar(150)
);
insert into syllabus(id,syllabustype,description)
					 values(1,'STATE',''),
						   (2,'CBSE','Central Board of Secondary Education'),
						   (3,'ICSE','Indian Certificate of Secondary Education'),
						   (4,'IB','International Baccalaureate'),
						   (5,'CAMBRIDGE','');

						   

--**************************ACADEMIC YEARS TABLES***********************************************************************************************************************************************************************

CREATE TABLE academicyears(
	id bigint(8) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	passingyear bigint(8) NOT NULL,
	academicyearstarting datetime NOT NULL,
	academicyearending datetime NOT NULL,
	active INT NOT NULL,
	createdon timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
    modifiedon timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3)
);

INSERT INTO academicyears(passingyear,academicyearstarting,academicyearending,active)
			values(2017,'2017-06-04','2018-04-04',1);


--******************** HOLIDAYS TABLES ********************************************************************************************************************************************************************************

CREATE TABLE holidays(
	id bigint(8) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	occassion VARCHAR(50) NOT NULL,
	fromdate datetime NOT NULL,
	todate datetime NOT NULL,
	createdon timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
    modifiedon timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3)
);


--******************** EVENTS TABLES ********************************************************************************************************************************************************************************

CREATE TABLE events(
	id bigint(8) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	eventdate datetime NOT NULL,
	eventname VARCHAR(50) NOT NULL,
	chiefguest VARCHAR(50) NOT NULL,
	description VARCHAR(100) NOT NULL,
	createdon timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
    modifiedon timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3)
);


--******************** NEWS TABLES ********************************************************************************************************************************************************************************

CREATE TABLE newsfeed(
	id bigint(8) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	headline VARCHAR(50) NOT NULL,
	releasedate datetime NOT NULL,
	description VARCHAR(150) NOT NULL,
	createdon timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
    modifiedon timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3)
);


--************ HOUSES TABLES ************************************************************************************************************************************************************************************

CREATE TABLE houses(
	id bigint(8) NOT NULL PRIMARY KEY AUTO_INCREMENT,
	housename VARCHAR(50) NOT NULL,
	description VARCHAR(400) NOT NULL,
	UNIQUE (housename),
	createdon timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
    modifiedon timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3)
);

INSERT INTO houses(housename,description) VALUES
		('C.V.Raman','C.V.Raman was a nobel prize winner for his work on Molecular Diffraction of Light popularly known as Raman Effect . His achievements signify a scientific and rational outlook of the school system.'),
		('Lal Bhahdur Shastri','Lal Bhahdur Shastri house recalls the memory of Great Indian Politician and Second Prime Minister of India'),
		('Chatrapati Shivaji','Shivaji is a house of the hero of Maharashtra known as Chhatrapati Shivaji . An icon in Freedom Fight  teaches us how to be an able administrator.'),
		('Subhash Chandra Bose','Subhash house is a house of Subhash Chandra Bose, popularly known as Netaji  a freedom fighter.It teaches us never to give up in life.');
		
 -- *********** SUBJECTS TABLES ***********************************************************************************************************************************************************************************

CREATE TABLE subjects(
	id bigint(8) NOT NULL AUTO_INCREMENT PRIMARY KEY, 
	subjectname VARCHAR(150) NOT NULL,
	subjectid bigint(8),
	istestable VARCHAR(30) NOT NULL,
	createdon timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
    modifiedon timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3)
);

insert into subjects(subjectname,subjectid,istestable) 
	values('Telugu',1,'true'),
		  ('Hindi',2,'true'),
		  ('English',3,'true'),
		  ('Maths',4,'true'),
		  ('Science',5,'true'),
		  ('Social',6,'true');
	
		  
 -- ********** GRADES TABLES ************************************************************************************************************************************

CREATE TABLE grades(
	id bigint(8) NOT NULL AUTO_INCREMENT,
	gradenumber bigint(8) NOT NULL,
	gradename VARCHAR(30) NOT NULL,
	syllabustype VARCHAR(30) NOT NULL,
	PRIMARY KEY (id,syllabustype),
	createdon timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
    modifiedon timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3)
);

insert into grades(gradenumber, gradename, syllabustype)
	values(1, "1st class","STATE"),
		  (2, "2nd class","STATE");


CREATE TABLE  grade_subjects(
	id bigint(8) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	gradeid bigint(8) NOT NULL,
	subjectid bigint(8) NOT NULL,
	FOREIGN KEY(gradeid) references grades(id),
	createdon timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
    modifiedon timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3)
);

insert into grade_subjects(gradeid,subjectid)
	values(1,1),(1,2),(1,3),
		  (2,1),(2,2),(2,3),(2,4);
		  

 -- ***************** TEACHERS TABLES ********************************************************************************************************************************************************************************

CREATE TABLE teachers(
	id bigint(8) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	teachername VARCHAR(30) NOT NULL,
	middlename VARCHAR(30),
	lname VARCHAR(30),
	maritalstatus VARCHAR(30),
	contactnumber VARCHAR(12) NOT NULL,
	emailid VARCHAR(30) NOT NULL,
	bloodgroup VARCHAR(30) NOT NULL,
	address VARCHAR(100) NOT NULL,
	qualification VARCHAR(30) NOT NULL,
	about LONGTEXT NOT NULL,
	subjects VARCHAR(30) NOT NULL,
	dateofbirth datetime NOT NULL,
	dateofjoining datetime NOT NULL,
	gender VARCHAR(10) NOT NULL,
	noofperiods int NOT NULL,
	UNIQUE (emailid),
	UNIQUE (teachername)
);

	insert into teachers(teachername,middlename,lname,maritalstatus,contactnumber,emailid,bloodgroup,address,qualification,about,subjects,dateofbirth,dateofjoining,gender,noofperiods)
	values('Teja','','chava','unmarried','9555544449','tejachava@omniwyse.com','A+','plot no:14-15-456,Madhapur,hyd-500074','B.Ed','She has 10+ years of experience in chemistry and physics','Science','1985-01-01','2006-06-01','female',4),
	('Dariya','','','unmarried','9666655559','dariya@omniwyse.com','O+','plot no:12-13-420,Gachibowli,Hyd-500073','B.Ed','He has 9+ years of experience in social ','Social','1988-02-01','2008-06-05','male',5),
	('Rameshrangam','','','unmarried','9640242289','rameshrangam@omniwyse.com','AB+','plot no:18-14-97/328,LB nagar,Hyd-500097','B.Ed','He has 7+ years of experience in Mathematics','Maths','1990-07-01','2010-06-10','male',4),
	('Pushpa','','','unmarried','9000011119','pushpa@omniwyse.com','B-','plot no:1-2-143/341,Madhapur,Hyd-500074','B.Ed','She has 5+ years of experience in English','English','1987-01-01','2012-06-15','female',5),
	('Mamatha','','','unmarried','9111155559','mamatha@omniwyse.com','A-','flat no:201,Hyderabad-500090','B.Ed','She has 15+ years of experience in mathematics','Telugu','1975-02-02','2002-07-10','female',4);
			

	
		  
-- ***************************************** CLASSROOM TABLES *******************************************************************************************
			
CREATE TABLE classrooms(
	id bigint(8) NOT NULL AUTO_INCREMENT,
	gradeid bigint(8) NOT NULL,
	academicid bigint(8) NOT NULL,
	sectionname VARCHAR(10) NOT NULL,
	classteacherid bigint(8),
	PRIMARY KEY(id,gradeid,sectionname,academicid),
	FOREIGN KEY(classteacherid) references teachers (id),
	FOREIGN KEY(academicid) references academicyears(id),
	FOREIGN KEY(gradeid) references grades(id)
);

insert into classrooms(gradeid,academicid,sectionname,classteacherid)
	values(1,1,'A',1),
		  (1,1,'B',4);
		  
		  

CREATE TABLE class_subject_teacher(
	id bigint(8) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	classid bigint(8) NOT NULL,
	subjectid bigint(8) NOT NULL,
	teacherid bigint(8),
	FOREIGN KEY(subjectid) references subjects(id),
	FOREIGN KEY(classid) references classrooms(id)
	);

	insert into class_subject_teacher( classid, subjectid, teacherid)
				values(1,1,1),(1,2,2),(1,3,3),
					  (2,1,1),(2,2,2),(2,3,3),(2,4,4);



--************************* PARENTS TABLE ****************************************************************************************************************************************************************************

CREATE TABLE parents(
	id bigint(8) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	mothername VARCHAR(50) NOT NULL,
	fathername VARCHAR(50) NOT NULL,
	emailid VARCHAR(50) NOT NULL,
	contactnumber bigint NOT NULL,
	address VARCHAR(200) NOT NULL,
	UNIQUE(emailid)
);

INSERT INTO parents(fathername,mothername,emailid,contactnumber,address)
VALUES('harinath','sunitha','harinath@omniwyse.com',9345666666,'hno:5-2-203, Janagaon,Telangana,508203'),
	  ('mahatma','Kasturba','mahatma@omniwyse.com',9721666666,'plot no:12-14-97,patancheruvu,Hyd -500045');


-- ********** STUDENTS TABLES **************************************************************************************************************************************************************************************

CREATE TABLE students(
	id bigint(8) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	gradeid bigint(8) NOT null,
	name VARCHAR(30) NOT NULL,
	middlename VARCHAR(30),
	lastname VARCHAR(30) NOT NULL,
	bloodgroup VARCHAR(10) NOT NULL,
	height VARCHAR(10) NOT NULL,
	weight VARCHAR(10) NOT NULL,
	parentid bigint NOT NULL,
	address VARCHAR(100) NOT NULL,
	dateofbirth datetime NOT NULL,
	dateofjoining datetime NOT NULL,
	gender VARCHAR(10) NOT NULL,
	emailid VARCHAR(30),
	admissionnumber VARCHAR(20) NOT NULL,
	houseid bigint(8),
	UNIQUE(admissionnumber),
	FOREIGN KEY(gradeid) references grades(id),
	FOREIGN KEY(parentid) references parents(id)
);

insert into students(parentid,houseid,gradeid,name,middlename,lastname,bloodgroup,height,weight,address,dateofbirth,dateofjoining,gender,emailid,admissionnumber)
	values (1,3,1,'Mohan','','','A+','2.1','17','hno:5-2-203, Janagaon,Telangana,508203','2005-07-26','2010-06-10','male','vikram@gmail.com','7011'),
		   (2,2,2,'Kalpana','','','A+','2.1','19','plot no:12-14-97,patancheruvu,Hyd -500045','2003-07-25','2008-01-01','female','kalpana@gmail.com','90111'),
		   (2,2,2,'Srinadh','','','A+','2.1','18.5','hno:5-203,kr nagar, mancheryal,Telangana-504203','2002-07-25','2006-06-06','male','srinadh@gmail.com','10111');

CREATE TABLE classroom_students(
	id bigint(8) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	classid bigint(8) NOT NULL,
	studentid bigint(8) NOT NULL,
	FOREIGN KEY(classid) references classrooms(id),
	FOREIGN KEY(studentid) references students(id)
);

	
-- ************* TESTS TABLES ********************************************************************************************************************************************************************************************

CREATE TABLE test_type(
	id bigint(8) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	testtype VARCHAR(100) NOT NULL,
	createdon timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
    modifiedon timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3)
);

INSERT INTO test_type(testtype) VALUES('UNITTEST1'),
									  ('UNITTEST2'),
									  ('UNITTEST3'),
									  ('QUARTERLY'),
									  ('HALFYEAR'),
									  ('ANNUAL');

CREATE TABLE test_mode(
	id bigint(8) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	testmode VARCHAR(30) NOT NULL,
	createdon timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
    modifiedon timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3)
	);

insert into test_mode(testmode) values('ONLINE'),
									  ('OFFLINE');
									  

-- ************* TEST SCHEDULES TABLES ***********************************************************************************************************************************************************************************

CREATE TABLE test_create(
	id bigint(8) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	gradeid bigint(8) NOT NULL,
	testtypeid bigint(8) NOT NULL,
	startdate datetime NOT NULL,
	enddate datetime NOT NULL,
	modeid bigint(8) NOT NULL,
	maxmarks bigint(8) NOT NULL,
	academicid bigint(8) NOT NULL,
	statusid bigint(8) NOT NULL,
	createdon timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
    modifiedon timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
	FOREIGN KEY(gradeid) REFERENCES grades(id),
	FOREIGN KEY(testtypeid) REFERENCES test_type(id),
	FOREIGN KEY(modeid) REFERENCES test_mode(id),
	FOREIGN KEY(statusid) REFERENCES status_table(id),
	FOREIGN KEY(academicid) REFERENCES academicyears(id)
);

CREATE TABLE test_syllabus(
	id bigint(8) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	testid bigint(8) NOT NULL,
	subjectid bigint(8) NOT NULL, 
	maxmarks bigint(8),
	syllabus VARCHAR(250),
	FOREIGN KEY(testid) REFERENCES test_create(id)
);

-- *************************TEST RESULT TABLE ***************************************************************************************************************************************************************************

CREATE TABLE classroom_testresult(
  id bigint(8) NOT NULL AUTO_INCREMENT,
  classid bigint(8) NOT NULL,
  studentid bigint(8) NOT NULL,
  testid bigint(8) NOT NULL,
  resultorgrade varchar(15),
  PRIMARY KEY (id),
  FOREIGN KEY (classid) REFERENCES classrooms (id),
  FOREIGN KEY (studentid) REFERENCES students (id),
  FOREIGN KEY (testid) REFERENCES test_create (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE student_testresult(
  id bigint(8) NOT NULL AUTO_INCREMENT,
  classid bigint(8) NOT NULL, 
  testid bigint(8) NOT NULL,
  studentid bigint(8) NOT NULL,
  subjectid bigint(8) NOT NULL,
  marks bigint(8),
  PRIMARY KEY (id),
  FOREIGN KEY (testid) REFERENCES test_create (id),
  FOREIGN KEY (subjectid) REFERENCES grade_subjects (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


--******************** TIMETABLE TABLES ********************************************************************************************************************************************************************************

CREATE TABLE weekdays(
	id bigint(8) NOT NULL AUTO_INCREMENT,
	day varchar(15) NOT NULL,
	PRIMARY KEY (id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

	INSERT INTO weekdays(day) VALUES ('MONDAY'),
									 ('TUESEDAY'),
									 ('WEDNESDAY'),
									 ('THURSEDAY'),
									 ('FRIDAY'),
									 ('SATERDAY'),
									 ('SUNDAY');

CREATE TABLE classroom_weekdays(
	id bigint(8) NOT NULL AUTO_INCREMENT,
	classroomid bigint(8) NOT NULL,
	weekdayid bigint(8) NOT NULL,
	PRIMARY KEY (id),
	FOREIGN KEY (weekdayid) REFERENCES weekdays(id),
	FOREIGN KEY(classroomid) references classrooms(id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE classroom_periods( 
	id bigint(8) NOT NULL AUTO_INCREMENT,
	periodfrom datetime NOT NULL,
	periodto datetime NOT NULL,
	subjectid INT NOT NULL,
	classroomid bigint(8) NOT NULL,
	classroomweekdayid bigint(8) NOT NULL,
	PRIMARY KEY (id),
	FOREIGN KEY(classroomweekdayid) references weekdays(id),
	FOREIGN KEY(classroomid) references classrooms(id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1; 

--******************** ATTENDANCE  TABLES *****************************************************************************************************************************************************************************


CREATE TABLE school_attendance(
	id bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
	attendance_type VARCHAR(20) NOT NULL,
	status boolean
);

INSERT INTO school_attendance (attendance_type,status)
						values('SUBJECTWISE',0),
							  ('ONETIME',1);

CREATE TABLE classroom_attendance(
	id bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
	studentid bigint NOT NULL,
	classroomid bigint NOT NULL,
	dateofattendance datetime NOT NULL,
	attendancestatus INT NOT NULL,
	subjectid bigint,
	FOREIGN KEY(studentid) REFERENCES students(id),
	FOREIGN KEY(classroomid) REFERENCES classrooms(id),
	FOREIGN KEY(subjectid) REFERENCES subjects(id)
); 


--******************** SCHOOL TIMINGS  TABLES *****************************************************************************************************************************************************************************
CREATE TABLE school_timings(
	id bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
	from_time datetime NOT NULL,
	to_time TIME NOT NULL
);

--******************* OPTIONS *******************************************************************************************************************************************************************************************
CREATE TABLE options(
	id bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(100) NOT NULL,
	optionvalue VARCHAR(100) NOT NULL,
	UNIQUE(name)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

