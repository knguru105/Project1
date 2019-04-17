
 ALTER TABLE classroom_worksheets DROP FOREIGN KEY classroom_worksheets_ibfk_3;
 
 ALTER TABLE classroom_worksheets DROP COLUMN worksheetsid;
 
 ALTER TABLE classroom_worksheets ADD COLUMN worksheetname VARCHAR(50) NOT NULL;
 
 ALTER TABLE classroom_worksheets ADD COLUMN vendor VARCHAR(50);
 
 
 CREATE TABLE ischollworksheets_assigned(
 	id bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
	worksheetname VARCHAR(50) NOT NULL,
	worksheetpath VARCHAR(150) NOT NULL,
	dateofassigned datetime,
	worksheetduedate datetime,
	classroomid bigint NOT NULL,
	subjectid bigint,
	lessonsid bigint,
	vendor VARCHAR(50),
	publishworksheet boolean DEFAULT false,
	FOREIGN KEY(lessonsid) REFERENCES lessons(id),
	FOREIGN KEY(classroomid) REFERENCES classrooms(id)
); 


ALTER TABLE ischollworksheets_assigned ADD COLUMN worksheetid bigint;
DROP TABLE classroom_worksheets;