CREATE TABLE worksheets_tags(
id bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
tags VARCHAR(100) NOT NULL,
worksheetid VARCHAR(500) NOT NULL
);

CREATE INDEX worksheettags on worksheets_tags(tags);
