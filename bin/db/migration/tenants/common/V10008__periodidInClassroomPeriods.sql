ALTER TABLE classroom_periods
ADD COLUMN periodid bigint(8) NOT NULL;

ALTER TABLE classroom_periods
ADD FOREIGN KEY (periodid)
REFERENCES periods(id);


ALTER TABLE periods 
MODIFY period_number bigint(8) NOT NULL ;