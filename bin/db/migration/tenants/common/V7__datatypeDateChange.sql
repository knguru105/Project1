-----------Notification Table--------

ALTER TABLE notifications MODIFY notificationdate datetime;


-----------TRANSPORTATION Table--------

ALTER TABLE staff MODIFY dateofbirth datetime;
ALTER TABLE staff MODIFY dateofjoining datetime;
ALTER TABLE staff MODIFY licenseexpiredate datetime;


-----------------Buses-------------------------

ALTER TABLE buses MODIFY manufacturingdate datetime;
ALTER TABLE buses MODIFY joindate datetime;