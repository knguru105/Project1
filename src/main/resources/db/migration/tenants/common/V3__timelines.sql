--******************** Timeline  TABLES ***********************************************************

CREATE TABLE lessons(
	id bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
	lessondescription VARCHAR(150) NOT NULL,
	lessonstartdate date NOT NULL,
	status VARCHAR(30),
	lessonname VARCHAR(50) NOT NULL,
	subjectid bigint,
	publishtimeline boolean DEFAULT false,
	classroomid bigint NOT NULL,
	FOREIGN KEY(classroomid) REFERENCES classrooms(id),
	FOREIGN KEY(subjectid) REFERENCES grade_subjects(id)
);

CREATE TABLE assignments(
	id bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
	assignmentname VARCHAR(50) NOT NULL,
	tags VARCHAR(50) NOT NULL,
	dateofassigned datetime,
	assignmentduedate datetime,
	classroomid bigint NOT NULL,
	subjectid bigint,
	lessonsid bigint,
	publishassignment boolean DEFAULT false,
	FOREIGN KEY(lessonsid) REFERENCES lessons(id),
	FOREIGN KEY(classroomid) REFERENCES classrooms(id),
	FOREIGN KEY(subjectid) REFERENCES grade_subjects(id)
);

CREATE TABLE classroom_worksheets(
	id bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
	worksheetsid bigint NOT NULL,
	dateofassigned datetime,
	worksheetduedate datetime,
	classroomid bigint NOT NULL,
	subjectid bigint,
	lessonsid bigint,
	publishworksheet boolean DEFAULT false,
	FOREIGN KEY(lessonsid) REFERENCES lessons(id),
	FOREIGN KEY(classroomid) REFERENCES classrooms(id),
	FOREIGN KEY(worksheetsid) REFERENCES worksheets(id)
);


CREATE TABLE  notifications(
	id bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
	notificationname VARCHAR(100) NOT NULL,
	description VARCHAR(200) NOT NULL,
	status boolean DEFAULT false,
	notificationdate date NOT NULL,
	publishedby VARCHAR(50) NOT NULL,
	actioncode VARCHAR(30) NOT NULL,
	classid bigint NOT NULL,
	parentactionrequired VARCHAR(30)
);






