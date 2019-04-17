

CREATE TABLE diary(
	id bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
	tag VARCHAR(50) NOT NULL,
	description VARCHAR(1000) NOT NULL,
	entrydate  datetime NOT NULL,
	lessonname VARCHAR(1000),
	classroomid bigint NOT NULL,
	subjectid bigint NOT NULL,
	FOREIGN KEY(classroomid) REFERENCES classrooms(id),
	FOREIGN KEY(subjectid) REFERENCES subjects(id)
); 