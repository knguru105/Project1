UPDATE period_type 
	SET fromtime = 480, totime = 930, numberofperiods = 8 
	where name = '1-5 grades';
	

	
INSERT INTO periods
(period_type_id,period_number,periodfrom,periodto) 
VALUES (1, 1, 480, 530),
(1,2,530,580),
(1,3,580,630),
(1,4,630,680),
(1,5,680,1470),
(1,6,1470,810),
(1,7,810,870),
(1,8,870,930);


ALTER TABLE classroom_periods MODIFY periodfrom datetime null;

ALTER TABLE classroom_periods MODIFY periodto datetime null;

ALTER TABLE classroom_periods MODIFY subjectid bigint(8);


INSERT INTO classroom_periods
(classroomid,classroomweekdayid,periodid,subjectid)

VALUES(1,2,(SELECT id from periods WHERE period_type_id = 1 and period_number = 1),1),
(1,2,(SELECT id from periods WHERE period_type_id = 1 and period_number = 2),2),
(1,2,(SELECT id from periods WHERE period_type_id = 1 and period_number = 3),3),
(1,2,(SELECT id from periods WHERE period_type_id = 1 and period_number = 4),3),
(1,2,(SELECT id from periods WHERE period_type_id = 1 and period_number = 6),1),
(1,2,(SELECT id from periods WHERE period_type_id = 1 and period_number = 7),1),
(1,2,(SELECT id from periods WHERE period_type_id = 1 and period_number = 8),2),

(1,3,(SELECT id from periods WHERE period_type_id = 1 and period_number = 1),1),
(1,3,(SELECT id from periods WHERE period_type_id = 1 and period_number = 2),1),
(1,3,(SELECT id from periods WHERE period_type_id = 1 and period_number = 3),2),
(1,3,(SELECT id from periods WHERE period_type_id = 1 and period_number = 4),3),
(1,3,(SELECT id from periods WHERE period_type_id = 1 and period_number = 6),2),
(1,3,(SELECT id from periods WHERE period_type_id = 1 and period_number = 7),3),
(1,3,(SELECT id from periods WHERE period_type_id = 1 and period_number = 8),2),

(1,4,(SELECT id from periods WHERE period_type_id = 1 and period_number = 1),2),
(1,4,(SELECT id from periods WHERE period_type_id = 1 and period_number = 2),2),
(1,4,(SELECT id from periods WHERE period_type_id = 1 and period_number = 3),1),
(1,4,(SELECT id from periods WHERE period_type_id = 1 and period_number = 4),3),
(1,4,(SELECT id from periods WHERE period_type_id = 1 and period_number = 6),1),
(1,4,(SELECT id from periods WHERE period_type_id = 1 and period_number = 7),3),
(1,4,(SELECT id from periods WHERE period_type_id = 1 and period_number = 8),3),

(1,5,(SELECT id from periods WHERE period_type_id = 1 and period_number = 1),3),
(1,5,(SELECT id from periods WHERE period_type_id = 1 and period_number = 2),3),
(1,5,(SELECT id from periods WHERE period_type_id = 1 and period_number = 3),1),
(1,5,(SELECT id from periods WHERE period_type_id = 1 and period_number = 4),3),
(1,5,(SELECT id from periods WHERE period_type_id = 1 and period_number = 6),1),
(1,5,(SELECT id from periods WHERE period_type_id = 1 and period_number = 7),3),
(1,5,(SELECT id from periods WHERE period_type_id = 1 and period_number = 8),2),

(1,6,(SELECT id from periods WHERE period_type_id = 1 and period_number = 1),1),
(1,6,(SELECT id from periods WHERE period_type_id = 1 and period_number = 2),3),
(1,6,(SELECT id from periods WHERE period_type_id = 1 and period_number = 3),1),
(1,6,(SELECT id from periods WHERE period_type_id = 1 and period_number = 4),3),
(1,6,(SELECT id from periods WHERE period_type_id = 1 and period_number = 6),1),
(1,6,(SELECT id from periods WHERE period_type_id = 1 and period_number = 7),3),
(1,6,(SELECT id from periods WHERE period_type_id = 1 and period_number = 8),2);