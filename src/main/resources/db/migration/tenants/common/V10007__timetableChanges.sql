CREATE TABLE period_type(
id bigint(8) NOT NULL AUTO_INCREMENT ,
name VARCHAR(100) NOT NULL,
fromtime datetime NOT NULL,
totime datetime NOT NULL,
numberofperiods bigint(8) NOT NULL,
default_value boolean NOT NULL default true,
createdOn timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
modifiedOn timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
PRIMARY KEY (id),
UNIQUE KEY name_UNIQUE (name)
);


CREATE TABLE periods(
id bigint(8) NOT NULL AUTO_INCREMENT,
period_type_id bigint(8) NOT NULL,
period_number VARCHAR(100) NOT NULL,
periodfrom datetime NOT NULL,
periodto datetime NOT NULL,
createdOn timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
modifiedOn timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
PRIMARY KEY (id),
CONSTRAINT uq_Periodtype_Number UNIQUE(period_type_id, period_number),
FOREIGN KEY(period_type_id) REFERENCES period_type(id)
);



INSERT INTO period_type(name,fromtime,totime,numberofperiods,default_value)
VALUES("1-5 grades",'2018-02-28 9:13:05.567','2018-02-28 16:13:05.567',6,true);


ALTER TABLE classrooms
ADD period_type_id bigint(8) NOT NULL DEFAULT 1;

ALTER TABLE classrooms
ADD FOREIGN KEY (period_type_id)
REFERENCES period_type(id);


