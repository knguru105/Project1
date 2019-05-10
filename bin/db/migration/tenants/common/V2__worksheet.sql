
--******************** WORKSHEETS TABLES **********************************************************************************************************

CREATE TABLE degreeofdifficulty(
	id bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
	degreeofdifficulty VARCHAR(50) NOT NULL
);

INSERT INTO degreeofdifficulty (degreeofdifficulty) values('EASY'),('INTERMEDIATE'),('ADVANCED');

CREATE TABLE worksheets(
	id bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
	worksheetname VARCHAR(50) NOT NULL,
	gradeid bigint NOT NULL,
	subjectid bigint NOT NULL,
	degreeofdifficultyid bigint NOT NULL,
	tags VARCHAR(100) NOT NULL,
	description VARCHAR(100) NOT NULL,
	worksheetpath VARCHAR(100) NOT NULL,
	worksheet blob,
	createdby VARCHAR(50),
	createdon timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
    modifiedon timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
	FOREIGN KEY(gradeid) REFERENCES grades(id),
	FOREIGN KEY(subjectid) REFERENCES grade_subjects(id),
	FOREIGN KEY(degreeofdifficultyid) REFERENCES degreeofdifficulty (id)
); 

--******************** WORKSHEETS1_STATUS TABLES **********************************************************************************************************

CREATE TABLE worksheet1_status (
  id bigint(8) NOT NULL,
  description varchar(150) NOT NULL,
  createdOn timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
  modifiedOn timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
  PRIMARY KEY (id),
  UNIQUE KEY name_UNIQUE (description)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


INSERT INTO worksheet1_status(id,description)
 				 VALUES(1,"Active"),
 				 		(0,"InActive");
 				 		
	


--******************** WORKSHEETS1 TABLES **********************************************************************************************************

 				 		
 				 		
CREATE TABLE worksheets1(
	w_id bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
	worksheet_name VARCHAR(50) NOT NULL,
	gradeid bigint NOT NULL,
	subjectid bigint NOT NULL,
	status_id bigint not null,
	degreeofdifficultyid bigint not null,
	worksheet_path VARCHAR(100) NOT NULL,
	createdby VARCHAR(50),
	createdon timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
    modifiedon timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
	FOREIGN KEY(gradeid) REFERENCES grades(id),
	FOREIGN KEY(subjectid) REFERENCES subjects(id),
	FOREIGN KEY(status_id) REFERENCES worksheet1_status(id),
	FOREIGN KEY(degreeofdifficultyid) REFERENCES degreeofdifficulty(id)
); 

INSERT INTO worksheets1(w_id, worksheet_name, gradeid, subjectid, status_id,degreeofdifficultyid, worksheet_path, createdby)
 				 VALUES(1,"worksheet1",1,6,1,1,"/desktop","karan"),
 				 		(2,"worksheet2",2,4,0,2,"/desktop/images","guru"),
 				 		(3,"worksheet3",2,4,1,3,"/desktop/images","madhavi");
 	


--******************** WORKSHEETS TAG TABLES **********************************************************************************************************

create table worksheets1_tags(
tagid bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
tags varchar(45) NOT NULL,
w_id bigint,
FOREIGN KEY(w_id) REFERENCES worksheets1(w_id)
);



 	

--******************** QUESTION_TYPE TABLES **********************************************************************************************************


create table question_type(
qtype_id bigint not null auto_increment primary key,
qtype varchar(45) not null 
);


INSERT INTO question_type(qtype_id, qtype)
 				 VALUES(1,"MCQ"),
 				 		(2,"Descriptive");
 	


--******************** QUESTIONS TABLES **********************************************************************************************************

create table questions(
questionid bigint not null auto_increment primary key,
questionDescription varchar(500) not null,
questiontype_id bigint not null,
gradeid bigint not null,
subjectid bigint not null,
status_id bigint not null,
degreeofdifficultyid bigint not null,
context varchar(500) not null,

FOREIGN KEY(questiontype_id) REFERENCES question_type(qtype_id),
FOREIGN KEY(gradeid) REFERENCES grades(id),
FOREIGN KEY(subjectid) REFERENCES subjects(id),
FOREIGN KEY(status_id) REFERENCES worksheet1_status(id),
FOREIGN KEY(degreeofdifficultyid) REFERENCES degreeofdifficulty(id)

);



 	

--******************** MULTIPLE CHOICE TABLES **********************************************************************************************************

create table multiple_choice(
mcq_id bigint not null auto_increment primary key,
mcq_order bigint not null,
mcq_description varchar(50) not null,
questionid bigint,
FOREIGN KEY(questionid) REFERENCES questions(questionid)
);



 	

--******************** IMAGES TABLES **********************************************************************************************************

create table images(
image_id bigint not null auto_increment primary key,
image_name varchar(50) not null,
image_path varchar(50) not null,
image_for_id bigint,
image_class varchar(50) not null
);





--********************************worksheet1_question table**********************************************************************************************

create table worksheet1_question(
id bigint not null auto_increment primary key,
w_id bigint not null,
q_id bigint not null,
FOREIGN KEY(w_id) REFERENCES worksheets1(w_id),
FOREIGN KEY(q_id) REFERENCES questions(questionid)
);



 --********************************Chapter table**********************************************************************************************
		
 				 		
 create table chapter(
 id bigint not null auto_increment primary key,
 wid bigint not null,
 chaptername varchar(50) not null,
 FOREIGN KEY(wid) REFERENCES worksheets1(w_id)
 );
 
 
 
  --********************************question_image table**********************************************************************************************
					
 create table question_image(
 id bigint not null auto_increment primary key,
 questionid bigint not null,
 imageid bigint not null,
 foreign key(questionid) references questions(questionid),
 foreign key(imageid) references images(image_id) 
 );
 
 --********************************multipleChoice_image table**********************************************************************************************

 create table multipleChoice_image(
 id bigint not null auto_increment primary key,
 mcqid bigint not null,
 imageid bigint not null,
 foreign key(mcqid) references multiple_choice(mcq_id),
 foreign key(imageid) references images(image_id)
  );