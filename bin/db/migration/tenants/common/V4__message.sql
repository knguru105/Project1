--******************** MESSAGES TABLES *************************************
CREATE TABLE messages(
	 id bigint(8) NOT NULL PRIMARY KEY AUTO_INCREMENT,
	 message VARCHAR(500) NOT NULL,
	 messagedate datetime NOT NULL,
	 classroomid bigint(8) NOT NULL,
	 senderid bigint(8) NOT NULL,
	 recieverid bigint(8) NOT NULL,
	 sentflag VARCHAR(10) NOT NULL,
	 rootmessageid bigint(8),
	 parentmessageid bigint(8),
	 isreply VARCHAR(20) NOT NULL
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
