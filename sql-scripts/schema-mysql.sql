CREATE TABLE IF NOT EXISTS orgdetail(
  org_tid int(12) NOT NULL,
  orgName varchar(500) DEFAULT NULL,
  noOfemp int(10) DEFAULT NULL,
  PRIMARY KEY (org_tid)
)