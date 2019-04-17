
--********************* TEST SYLLABUS TABLE ***************************

ALTER TABLE test_syllabus ADD COLUMN subjecttestdate datetime;


--********************* WEEK DAYS TABLE *******************************

UPDATE weekdays SET day='TUESDAY' WHERE day='TUESEDAY';
UPDATE weekdays SET day='THURSDAY' WHERE day='THURSEDAY';
UPDATE weekdays SET day='SATURDAY' WHERE day='SATERDAY';


--******************* TRANSPORTATION TABLES ***************************

ALTER TABLE bus_students MODIFY routeid bigint;



       
       
       