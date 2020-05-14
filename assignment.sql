
CREATE TABLE employees
   ( employee_id NUMBER(6)
   , first_name VARCHAR2(20)
   , last_name VARCHAR2(25)
   CONSTRAINT emp_last_name_nn NOT NULL
   , email VARCHAR2(25)
   CONSTRAINT emp_email_nn NOT NULL
   , phone_number VARCHAR2(20)
   , hire_date DATE
   CONSTRAINT emp_hire_date_nn NOT NULL
   , job_id VARCHAR2(10)
   CONSTRAINT emp_job_nn NOT NULL
   , salary NUMBER(8,2)
   , commission_pct NUMBER(2,2)
   , manager_id NUMBER(6)
   , department_id NUMBER(4)
   , CONSTRAINT emp_salary_min
   CHECK (salary > 0) 
   , CONSTRAINT emp_email_uk
   UNIQUE (email)
   ) ;
CREATE UNIQUE INDEX emp_emp_id_pk
         ON employees (employee_id) ;
ALTER TABLE employees
         ADD ( CONSTRAINT emp_emp_id_pk
   PRIMARY KEY (employee_id));
   
INSERT INTO employees VALUES 
   ( 100
   , 'Steven'
   , 'King'
   , 'SKING'
   , '515.123.4567'
   , TO_DATE('17-JUN-1987', 'dd-MON-yyyy')
   , 'AD_PRES'
   , 24000
   , NULL
   , NULL
   , 90
   );
INSERT INTO employees VALUES 
   ( 101
   , 'Neena'
   , 'Kochhar'
   , 'NKOCHHAR'
   , '515.123.4568'
   , TO_DATE('21-SEP-1989', 'dd-MON-yyyy')
   , 'AD_VP'
   , 17000
   , NULL
   , 100
   , 90
   );
INSERT INTO employees VALUES 
   ( 102
   , 'Lex'
   , 'De Haan'
   , 'LDEHAAN'
   , '515.123.4569'
   , TO_DATE('13-JAN-1993', 'dd-MON-yyyy')
   , 'AD_VP'
   , 17000
   , NULL
   , 100
   , 90
   );
INSERT INTO employees VALUES 
   ( 103
   , 'Alexander'
   , 'Hunold'
   , 'AHUNOLD'
   , '590.423.4567'
   , TO_DATE('03-JAN-1990', 'dd-MON-yyyy')
   , 'IT_PROG'
   , 9000
   , NULL
   , 102
   , 60
   );
INSERT INTO employees VALUES 
   ( 104
   , 'Bruce'
   , 'Ernst'
   , 'BERNST'
   , '590.423.4568'
   , TO_DATE('21-MAY-1991', 'dd-MON-yyyy')
   , 'IT_PROG'
   , 6000
   , NULL
   , 103
   , 60
   );
INSERT INTO employees VALUES 
   ( 105
   , 'David'
   , 'Austin'
   , 'DAUSTIN'
   , '590.423.4569'
   , TO_DATE('25-JUN-1997', 'dd-MON-yyyy')
   , 'IT_PROG'
   , 4800
   , NULL
   , 103
   , 60
   );
   

CREATE TABLE ROLE(
role_id number,
role_name varchar(20),
role_desc varchar(250)
);

ALTER TABLE ROLE ADD (CONSTRAINT role_role_id_pk PRIMARY KEY(role_id));

INSERT INTO ROLE VALUES (1,'admin', 'This user has ultimate rights for everything');
INSERT INTO ROLE VALUES (2,'user', 'This user has user rights for administrative work');

CREATE TABLE MENU(
MENU_ID INTEGER,
MENU_NAME VARCHAR(20),
MENU_DESC VARCHAR(255)
);

ALTER TABLE MENU ADD (CONSTRAINT menu_menu_id_pk PRIMARY KEY(MENU_ID));

CREATE TABLE AUTH_USER(
USER_ID NUMBER,
FIRST_NAME VARCHAR(20),
LAST_NAME VARCHAR(20),
EMAIL VARCHAR(55),
PASSWORD VARCHAR(255),
MOBILE NUMBER,
STATUS VARCHAR(20),
ROLE_ID NUMBER
);
ALTER TABLE AUTH_USER ADD (CONSTRAINT user_user_id_pk PRIMARY KEY(USER_ID));
ALTER TABLE AUTH_USER ADD (CONSTRAINT user_role_id_fk FOREIGN KEY(ROLE_ID) REFERENCES ROLE(ROLE_ID));

insert into auth_user (user_id,first_name,last_name,email,password,status, role_id) values (1,'Oli','Khan','admin@gmail.com','123','VERIFIED', '1');
insert into auth_user (user_id,first_name,last_name,email,password,status, role_id) values (2,'Anika','Sharif','user@gmail.com','123','VERIFIED', '2');

create table ACCOUNT(
ac_no NUMBER NOT NULL,
customer_name varchar(255) not null,
fathers_name varchar(255) not null,
mothers_name varchar(255) not null,
dob DATE not null,
create_date date not null,
address varchar(255) not null,
nid number,
phoneno number,
photo varchar(255),
nid_photo varchar(255),
ac_type integer,
balance number
);

create table AC_TYPES(
AC_TYPE_ID INTEGER,
AC_TYPE_NAME VARCHAR(20),
primary key(AC_TYPE_ID)
);

ALTER TABLE ACCOUNT ADD (CONSTRAINT account_ac_no_pk PRIMARY KEY(ac_no));
ALTER TABLE ACCOUNT ADD (CONSTRAINT account_nid_uk UNIQUE(nid));
ALTER TABLE ACCOUNT ADD (CONSTRAINT account_ac_type_fk FOREIGN KEY(ac_type) REFERENCES AC_TYPES(ac_type_id));

CREATE TABLE PERMISSIONS(
ROLE_ID NUMBER,
MENU_ID INTEGER
);

ALTER TABLE PERMISSIONS ADD (CONSTRAINT permissions_pk PRIMARY KEY(ROLE_ID, MENU_ID));
ALTER TABLE PERMISSIONS ADD (CONSTRAINT permissions_role_id_fk FOREIGN KEY(role_id) REFERENCES ROLE(ROLE_ID));
ALTER TABLE PERMISSIONS ADD (CONSTRAINT permissions_menu_id_fk FOREIGN KEY(menu_id) REFERENCES MENU(MENU_ID));

CREATE TABLE LOG_TYPE(
log_type_id integer,
log_type_name varchar(20),
log_type_desc varchar(255),
primary key(log_type_id)
);

CREATE TABLE ACCOUNT_LOG(
LOG_ID NUMBER,
AC_NO NUMBER,
LOG_DESC VARCHAR(255),
DATE_TIME DATE,
log_type integer
);

ALTER TABLE ACCOUNT_LOG ADD (CONSTRAINT account_log_pk PRIMARY KEY(LOG_ID));
ALTER TABLE ACCOUNT_LOG ADD (CONSTRAINT account_ac_no_fk FOREIGN KEY(AC_NO) REFERENCES ACCOUNT(AC_NO));
ALTER TABLE ACCOUNT_LOG ADD (CONSTRAINT account_log_type_fk FOREIGN KEY(LOG_TYPE) REFERENCES LOG_TYPE(LOG_TYPE_ID));

commit;

