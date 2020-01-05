CREATE SEQUENCE rev_db.s_customer_id START WITH 1;

CREATE TABLE rev_db.customer (
  id INT AUTO_INCREMENT NOT NULL,
  full_name VARCHAR(50) NOT NULL,
  email VARCHAR(50) NOT NULL,
  phone VARCHAR(50) NOT NULL,
  address VARCHAR(200),
  date_of_birth DATE,
  created DATETIME,
	modified DATETIME,

  CONSTRAINT pk_customer PRIMARY KEY (id)
);

CREATE SEQUENCE rev_db.s_account_id START WITH 1;

CREATE TABLE rev_db.account (
  id INT AUTO_INCREMENT NOT NULL,
  customer_id INT NOT NULL,
  account_no CHAR(10) NOT NULL,
  account_name VARCHAR(50) NOT NULL,
  account_type VARCHAR(50) NOT NULL,
  account_phone VARCHAR(50),
  balance DECIMAL(11,2) DEFAULT 0.0,
  ccy CHAR(3) NOT NULL,
  bank_code CHAR(6),
  kyc_level INT(1),
  created DATETIME,


  CONSTRAINT pk_account PRIMARY KEY (ID),
  CONSTRAINT fk_account_customer_id FOREIGN KEY (customer_id) REFERENCES rev_db.customer(id)
);

CREATE TABLE rev_db.transfer (
  ref VARCHAR(125) NOT NULL,
  txn_amount decimal(11,2) NOT NULL,
  txn_ccy CHAR(3) NOT NULL,
  debited_account_no CHAR(10) NOT NULL,
  credited_account_no CHAR(10) NOT NULL,
  txn_narration VARCHAR(50) NOT NULL,
  bank_code CHAR(6),
  txn_timestamp DATETIME,

  CONSTRAINT pk_transfer PRIMARY KEY (REF)
);

CREATE SEQUENCE rev_db.s_statement_id START WITH 1;

CREATE TABLE rev_db.statement (
  id INT AUTO_INCREMENT NOT NULL,
  customer_id INT NOT NULL,
  account_no CHAR(10) NOT NULL,
  ccy CHAR(3) NOT NULL,
  txn_timestamp DATETIME,
  txn_amount decimal(11,2) NOT NULL,
  dr_cr CHAR(1) NOT NULL,
  narration VARCHAR(50) NOT NULL,
  bank_code CHAR(6),

  CONSTRAINT pk_statement PRIMARY KEY (ID),
  CONSTRAINT fk_statement_customer_id FOREIGN KEY (customer_id) REFERENCES rev_db.customer(id)
);
