ALTER TABLE period_type
MODIFY COLUMN fromtime bigint(8) NOT NULL;

ALTER TABLE period_type
MODIFY COLUMN totime bigint(8) NOT NULL;


ALTER TABLE periods
MODIFY COLUMN periodfrom bigint(8) NOT NULL;

ALTER TABLE periods
MODIFY COLUMN periodto bigint(8) NOT NULL;

