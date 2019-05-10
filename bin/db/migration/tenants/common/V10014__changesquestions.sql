alter table questions add column correctAnswer bigint;
alter table questions add FOREIGN KEY(correctAnswer) REFERENCES multiple_choice(mcq_id);