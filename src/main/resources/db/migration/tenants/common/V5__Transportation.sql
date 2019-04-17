--*****************************************TRANSPORTATION TABLES ****************************************************************

CREATE TABLE staff(
	id bigint(8) NOT NULL PRIMARY KEY AUTO_INCREMENT,
	firstname VARCHAR(50) NOT NULL,
	middlename VARCHAR(50),
	lastname VARCHAR(50) NOT NULL,
	role VARCHAR(100) NOT NULL,
	contactnumber bigint NOT NULL,
	dateofbirth date NOT NULL,
	dateofjoining date NOT NULL,
	licensenumber VARCHAR(100) NOT NULL,
	licenseexpiredate date NOT NULL,
	mailid VARCHAR(50),
	experience VARCHAR(50) NOT NULL,
	bloodgroup VARCHAR(30) NOT NULL,
	qualification VARCHAR(100),
	active boolean NOT NULL,
	createdon timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
    modifiedon timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
	UNIQUE(licensenumber)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE addresses(
	id bigint(8) NOT NULL PRIMARY KEY AUTO_INCREMENT,
	doornumber VARCHAR(30) NOT NULL,
	line1 VARCHAR(500) NOT NULL,
	line2 VARCHAR(500),
	village VARCHAR(500) NOT NULL,
	city VARCHAR(500) NOT NULL,
	district VARCHAR(500) NOT NULL,
	state VARCHAR(500) NOT NULL,
	pin bigint(8) NOT NULL,
	staffid bigint(8) NOT NULL,
	FOREIGN KEY(staffid) references staff(id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


CREATE TABLE buses(
	id bigint(8) NOT NULL PRIMARY KEY AUTO_INCREMENT,
	busnumber VARCHAR(30) NOT NULL,
	busname VARCHAR(50) NOT NULL,
	modelnumber VARCHAR(50) NOT NULL,
	manufacturingdate date NOT NULL,
	companyname VARCHAR(50) NOT NULL,
	joindate date NOT NULL,
	registrationnumber VARCHAR(100) NOT NULL,
	color VARCHAR(50) NOT NULL,
	noofseats bigint NOT NULL,
	active boolean DEFAULT true NOT NULL,
	bustype VARCHAR(10) not null,
	createdon timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
    modifiedon timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
	UNIQUE(busnumber),
	UNIQUE(busname)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;



CREATE TABLE stops(
	id bigint(8) NOT NULL PRIMARY KEY AUTO_INCREMENT,
	stopname VARCHAR(50) NOT NULL,
	landmark VARCHAR(100) NOT NULL,
	lattitude double NOT NULL,
	longitude double NOT NULL,
	createdon timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
    modifiedon timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
	UNIQUE(stopname)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;



CREATE TABLE routes(
	id bigint(8) NOT NULL PRIMARY KEY AUTO_INCREMENT,
	routename VARCHAR(500) NOT NULL,
	distance VARCHAR(50) NOT NULL,
	stops varchar(150) NOT NULL,
	numberofstops int NOT NULL,
	UNIQUE(routename),
	createdon timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
    modifiedon timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


CREATE TABLE bus_students(
	id bigint(8) NOT NULL PRIMARY KEY AUTO_INCREMENT,
	busid bigint,
	studentid bigint NOT NULL,
	routeid bigint NOT NULL,
	FOREIGN KEY(busid) references buses(id),
	FOREIGN KEY(studentid) references students(id),
	FOREIGN KEY(routeid) references routes(id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


CREATE TABLE bus_summery(
	id bigint(8) NOT NULL PRIMARY KEY AUTO_INCREMENT,
	busid bigint NOT NULL,
	noofstudents bigint NOT NULL DEFAULT 0,
	routeid bigint, 
	driverid bigint,
	attenderid bigint,
	teacherid bigint,
	FOREIGN KEY(busid) references buses(id),
	FOREIGN KEY(routeid) references routes(id),
	FOREIGN KEY(driverid) references staff(id),
	FOREIGN KEY(attenderid) references staff(id),
	FOREIGN KEY(teacherid) references teachers(id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
