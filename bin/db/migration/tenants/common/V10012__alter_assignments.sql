CREATE TABLE assignment_types(
	id bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
	assignmentnumber int NOT NULL,
	assignmentname VARCHAR(50) NOT NULL,
	shortcode VARCHAR(50) NOT NULL
);

INSERT INTO assignment_types(assignmentnumber,assignmentname,shortcode)
 				 VALUES(1,"Homework","AD"),
 				 		(2,"Worksheet","WS"),
 				 		(3,"BooksReading","BR"),
 				 		(4,"TODOProject","PJ");
 				 		
 ALTER TABLE assignments
  ADD (assignment_type_id bigint NOT NULL,
       instructions VARCHAR(500),
       path  VARCHAR(150),
       imagepath VARCHAR(150),
       video_path VARCHAR(150),
       marks int,
       credit boolean DEFAULT false,
       FOREIGN KEY(assignment_type_id) REFERENCES assignment_types(id)
       );
