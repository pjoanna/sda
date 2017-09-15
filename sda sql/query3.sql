-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: hr
-- ------------------------------------------------------
-- Server version	5.6.34-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `countries`
--
DROP TABLE IF EXISTS countries;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE countries (
  COUNTRY_ID char(2) NOT NULL COMMENT 'Primary key of countries table.',
  COUNTRY_NAME varchar(40) DEFAULT NULL COMMENT 'Country name',
  REGION_ID double DEFAULT NULL COMMENT 'Region ID for the country. Foreign key to region_id column in the departments table.',
  PRIMARY KEY (COUNTRY_ID),
  KEY `COUNTR_REG_FK` (REGION_ID),
  CONSTRAINT `COUNTR_REG_FK` FOREIGN KEY (REGION_ID) REFERENCES regions (REGION_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='country table. Contains 25 rows. References with locations table.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `countries`
--

LOCK TABLES countries WRITE;
/*!40000 ALTER TABLE `countries` DISABLE KEYS */;
INSERT INTO countries VALUES ('AR','Argentina',2),('AU','Australia',3),('BE','Belgium',1),('BR','Brazil',2),('CA','Canada',2),('CH','Switzerland',1),('CN','China',3),('DE','Germany',1),('DK','Denmark',1),('EG','Egypt',4),('FR','France',1),('IL','Israel',4),('IN','India',3),('IT','Italy',1),('JP','Japan',3),('KW','Kuwait',4),('ML','Malaysia',3),('MX','Mexico',2),('NG','Nigeria',4),('NL','Netherlands',1),('SG','Singapore',3),('UK','United Kingdom',1),('US','United States of America',2),('ZM','Zambia',4),('ZW','Zimbabwe',4);
/*!40000 ALTER TABLE countries ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `departments`
--

DROP TABLE IF EXISTS `departments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `departments` (
  `DEPARTMENT_ID` smallint(6) NOT NULL COMMENT 'Primary key column of departments table.',
  `DEPARTMENT_NAME` varchar(30) NOT NULL COMMENT 'A not null column that shows name of a department. Administration,\nMarketing, Purchasing, Human Resources, Shipping, IT, Executive, Public\nRelations, Sales, Finance, and Accounting. ',
  `MANAGER_ID` int(11) DEFAULT NULL COMMENT 'Manager_id of a department. Foreign key to employee_id column of employees table. The manager_id column of the employee table references this column.',
  `LOCATION_ID` smallint(6) DEFAULT NULL COMMENT 'Location id where a department is located. Foreign key to location_id column of locations table.',
  UNIQUE KEY `DEPT_ID_PK` (`DEPARTMENT_ID`),
  KEY `DEPT_LOCATION_IX` (`LOCATION_ID`),
  KEY `DEPT_MGR_FK` (`MANAGER_ID`),
  CONSTRAINT `DEPT_LOC_FK` FOREIGN KEY (`LOCATION_ID`) REFERENCES `locations` (`LOCATION_ID`),
  CONSTRAINT `DEPT_MGR_FK` FOREIGN KEY (`MANAGER_ID`) REFERENCES `employees` (`EMPLOYEE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Departments table that shows details of departments where employees\nwork. Contains 27 rows; references with locations, employees, and job_history tables.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departments`
--

LOCK TABLES `departments` WRITE;
/*!40000 ALTER TABLE `departments` DISABLE KEYS */;
INSERT INTO `departments` VALUES (10,'Administration',200,1700),(20,'Marketing',201,1800),(30,'Purchasing',114,1700),(40,'Human Resources',203,2400),(50,'Shipping',121,1500),(60,'IT',103,1400),(70,'Public Relations',204,2700),(80,'Sales',145,2500),(90,'Executive',100,1700),(100,'Finance',108,1700),(110,'Accounting',205,1700),(120,'Treasury',NULL,1700),(130,'Corporate Tax',NULL,1700),(140,'Control And Credit',NULL,1700),(150,'Shareholder Services',NULL,1700),(160,'Benefits',NULL,1700),(170,'Manufacturing',NULL,1700),(180,'Construction',NULL,1700),(190,'Contracting',NULL,1700),(200,'Operations',NULL,1700),(210,'IT Support',NULL,1700),(220,'NOC',NULL,1700),(230,'IT Helpdesk',NULL,1700),(240,'Government Sales',NULL,1700),(250,'Retail Sales',NULL,1700),(260,'Recruiting',NULL,1700),(270,'Payroll',NULL,1700);
/*!40000 ALTER TABLE `departments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employees` (
  `EMPLOYEE_ID` int(11) NOT NULL DEFAULT '0' COMMENT 'Primary key of employees table.',
  `FIRST_NAME` varchar(20) DEFAULT NULL COMMENT 'First name of the employee. A not null column.',
  `LAST_NAME` varchar(25) NOT NULL COMMENT 'Last name of the employee. A not null column.',
  `EMAIL` varchar(25) NOT NULL COMMENT 'Email id of the employee',
  `PHONE_NUMBER` varchar(20) DEFAULT NULL COMMENT 'Phone number of the employee; includes country code and area code',
  `HIRE_DATE` datetime NOT NULL COMMENT 'Date when the employee started on this job. A not null column.',
  `JOB_ID` varchar(10) NOT NULL COMMENT 'Current job of the employee; foreign key to job_id column of the\njobs table. A not null column.',
  `SALARY` decimal(8,2) DEFAULT NULL COMMENT 'Monthly salary of the employee. Must be greater\nthan zero (enforced by constraint emp_salary_min)',
  `COMMISSION_PCT` decimal(2,2) DEFAULT NULL COMMENT 'Commission percentage of the employee; Only employees in sales\ndepartment elgible for commission percentage',
  `MANAGER_ID` int(11) DEFAULT NULL COMMENT 'Manager id of the employee; has same domain as manager_id in\ndepartments table. Foreign key to employee_id column of employees table.\n(useful for reflexive joins and CONNECT BY query)',
  `DEPARTMENT_ID` smallint(6) DEFAULT NULL COMMENT 'Department id where employee works; foreign key to department_id\ncolumn of the departments table',
  PRIMARY KEY (`EMPLOYEE_ID`),
  UNIQUE KEY `EMP_EMAIL_UK` (`EMAIL`),
  UNIQUE KEY `EMP_EMP_ID_PK` (`EMPLOYEE_ID`),
  KEY `EMP_DEPARTMENT_IX` (`DEPARTMENT_ID`),
  KEY `EMP_JOB_IX` (`JOB_ID`),
  KEY `EMP_MANAGER_IX` (`MANAGER_ID`),
  KEY `EMP_NAME_IX` (`LAST_NAME`,`FIRST_NAME`),
  CONSTRAINT `EMP_DEPT_FK` FOREIGN KEY (`DEPARTMENT_ID`) REFERENCES `departments` (`DEPARTMENT_ID`),
  CONSTRAINT `EMP_JOB_FK` FOREIGN KEY (`JOB_ID`) REFERENCES `jobs` (`JOB_ID`),
  CONSTRAINT `EMP_MANAGER_FK` FOREIGN KEY (`MANAGER_ID`) REFERENCES `employees` (`EMPLOYEE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='employees table. Contains 107 rows. References with departments,\njobs, job_history tables. Contains a self reference.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees`
--

/*!40000 ALTER TABLE employees DISABLE KEYS */;
 LOCK TABLES employees WRITE;
	INSERT INTO 
employees
	VALUES 
(100,'Steven','King','SKING','515.123.4567','2003-06-17 00:00:00','AD_PRES',24000.00,NULL,NULL,90),
(101,'Neena','Kochhar','NKOCHHAR','515.123.4568','2005-09-21 00:00:00','AD_VP',17000.00,NULL,100,90),
(102,'Lex','De Haan','LDEHAAN','515.123.4569','2001-01-13 00:00:00','AD_VP',17000.00,NULL,100,90),
(103,'Alexander','Hunold','AHUNOLD','590.423.4567','2006-01-03 00:00:00','IT_PROG',9000.00,NULL,102,60),
(104,'Bruce','Ernst','BERNST','590.423.4568','2007-05-21 00:00:00','IT_PROG',6000.00,NULL,103,60),
(105,'David','Austin','DAUSTIN','590.423.4569','2005-06-25 00:00:00','IT_PROG',4800.00,NULL,103,60),
(106,'Valli','Pataballa','VPATABAL','590.423.4560','2006-02-05 00:00:00','IT_PROG',4800.00,NULL,103,60),
(107,'Diana','Lorentz','DLORENTZ','590.423.5567','2007-02-07 00:00:00','IT_PROG',4200.00,NULL,103,60),
(108,'Nancy','Greenberg','NGREENBE','515.124.4569','2002-08-17 00:00:00','FI_MGR',12008.00,NULL,101,100),
(109,'Daniel','Faviet','DFAVIET','515.124.4169','2002-08-16 00:00:00','FI_ACCOUNT',9000.00,NULL,108,100),
(110,'John','Chen','JCHEN','515.124.4269','2005-09-28 00:00:00','FI_ACCOUNT',8200.00,NULL,108,100),
(111,'Ismael','Sciarra','ISCIARRA','515.124.4369','2005-09-30 00:00:00','FI_ACCOUNT',7700.00,NULL,108,100),
(112,'Jose Manuel','Urman','JMURMAN','515.124.4469','2006-03-07 00:00:00','FI_ACCOUNT',7800.00,NULL,108,100),
(113,'Luis','Popp','LPOPP','515.124.4567','2007-12-07 00:00:00','FI_ACCOUNT',6900.00,NULL,108,100),
(114,'Den','Raphaely','DRAPHEAL','515.127.4561','2002-12-07 00:00:00','PU_MAN',11000.00,NULL,100,30),
(115,'Alexander','Khoo','AKHOO','515.127.4562','2003-05-18 00:00:00','PU_CLERK',3100.00,NULL,114,30),
(116,'Shelli','Baida','SBAIDA','515.127.4563','2005-12-24 00:00:00','PU_CLERK',2900.00,NULL,114,30),
(117,'Sigal','Tobias','STOBIAS','515.127.4564','2005-07-24 00:00:00','PU_CLERK',2800.00,NULL,114,30),
(118,'Guy','Himuro','GHIMURO','515.127.4565','2006-11-15 00:00:00','PU_CLERK',2600.00,NULL,114,30),
(119,'Karen','Colmenares','KCOLMENA','515.127.4566','2007-08-10 00:00:00','PU_CLERK',2500.00,NULL,114,30),
(120,'Matthew','Weiss','MWEISS','650.123.1234','2004-07-18 00:00:00','ST_MAN',8000.00,NULL,100,50),
(121,'Adam','Fripp','AFRIPP','650.123.2234','2005-04-10 00:00:00','ST_MAN',8200.00,NULL,100,50),
(122,'Payam','Kaufling','PKAUFLIN','650.123.3234','2003-05-01 00:00:00','ST_MAN',7900.00,NULL,100,50),
(123,'Shanta','Vollman','SVOLLMAN','650.123.4234','2005-10-10 00:00:00','ST_MAN',6500.00,NULL,100,50),
(124,'Kevin','Mourgos','KMOURGOS','650.123.5234','2007-11-16 00:00:00','ST_MAN',5800.00,NULL,100,50),
(125,'Julia','Nayer','JNAYER','650.124.1214','2005-07-16 00:00:00','ST_CLERK',3200.00,NULL,120,50),
(126,'Irene','Mikkilineni','IMIKKILI','650.124.1224','2006-09-28 00:00:00','ST_CLERK',2700.00,NULL,120,50),
(127,'James','Landry','JLANDRY','650.124.1334','2007-01-14 00:00:00','ST_CLERK',2400.00,NULL,120,50),
(128,'Steven','Markle','SMARKLE','650.124.1434','2008-03-08 00:00:00','ST_CLERK',2200.00,NULL,120,50),
(129,'Laura','Bissot','LBISSOT','650.124.5234','2005-08-20 00:00:00','ST_CLERK',3300.00,NULL,121,50),
(130,'Mozhe','Atkinson','MATKINSO','650.124.6234','2005-10-30 00:00:00','ST_CLERK',2800.00,NULL,121,50),
(131,'James','Marlow','JAMRLOW','650.124.7234','2005-02-16 00:00:00','ST_CLERK',2500.00,NULL,121,50),
(132,'TJ','Olson','TJOLSON','650.124.8234','2007-04-10 00:00:00','ST_CLERK',2100.00,NULL,121,50),
(133,'Jason','Mallin','JMALLIN','650.127.1934','2004-06-14 00:00:00','ST_CLERK',3300.00,NULL,122,50),
(134,'Michael','Rogers','MROGERS','650.127.1834','2006-08-26 00:00:00','ST_CLERK',2900.00,NULL,122,50),
(135,'Ki','Gee','KGEE','650.127.1734','2007-12-12 00:00:00','ST_CLERK',2400.00,NULL,122,50),
(136,'Hazel','Philtanker','HPHILTAN','650.127.1634','2008-02-06 00:00:00','ST_CLERK',2200.00,NULL,122,50),
(137,'Renske','Ladwig','RLADWIG','650.121.1234','2003-07-14 00:00:00','ST_CLERK',3600.00,NULL,123,50),
(138,'Stephen','Stiles','SSTILES','650.121.2034','2005-10-26 00:00:00','ST_CLERK',3200.00,NULL,123,50),
(139,'John','Seo','JSEO','650.121.2019','2006-02-12 00:00:00','ST_CLERK',2700.00,NULL,123,50),
(140,'Joshua','Patel','JPATEL','650.121.1834','2006-04-06 00:00:00','ST_CLERK',2500.00,NULL,123,50),
(141,'Trenna','Rajs','TRAJS','650.121.8009','2003-10-17 00:00:00','ST_CLERK',3500.00,NULL,124,50),
(142,'Curtis','Davies','CDAVIES','650.121.2994','2005-01-29 00:00:00','ST_CLERK',3100.00,NULL,124,50),
(143,'Randall','Matos','RMATOS','650.121.2874','2006-03-15 00:00:00','ST_CLERK',2600.00,NULL,124,50),
(144,'Peter','Vargas','PVARGAS','650.121.2004','2006-07-09 00:00:00','ST_CLERK',2500.00,NULL,124,50),
(145,'John','Russell','JRUSSEL','011.44.1344.429268','2004-10-01 00:00:00','SA_MAN',14000.00,0.40,100,80),
(146,'Karen','Partners','KPARTNER','011.44.1344.467268','2005-01-05 00:00:00','SA_MAN',13500.00,0.30,100,80),
(147,'Alberto','Errazuriz','AERRAZUR','011.44.1344.429278','2005-03-10 00:00:00','SA_MAN',12000.00,0.30,100,80),
(148,'Gerald','Cambrault','GCAMBRAU','011.44.1344.619268','2007-10-15 00:00:00','SA_MAN',11000.00,0.30,100,80),
(149,'Eleni','Zlotkey','EZLOTKEY','011.44.1344.429018','2008-01-29 00:00:00','SA_MAN',10500.00,0.20,100,80),
(150,'Peter','Tucker','PTUCKER','011.44.1344.129268','2005-01-30 00:00:00','SA_REP',10000.00,0.30,145,80);

UNLOCK TABLES;



-- zadanie 1
desc employees; -- 1
select * from employees; -- 2
select first_name, last_name, salary from employees; -- 3
select first_name as imie, last_name as nazwisko from employees; -- 4
select * from departments; -- 5
select fisrt_name from employees;
select hire_date as data_zatrudnienia from employees;
select first_name, last_name from employees; 
select concat(first_name, ' ',last_name) from employees; -- 6
select first_name, last_name from employees order by first_name asc; -- 7
select last_name from employees order by LAST_NAME desc; -- 8
select last_name, salary from employees order by SALARY desc; -- 9
select first_name, last_name, salary from employees order by SALARY asc, last_name desc; -- 10
select distinct last_name from employees; -- 11 nazwiska
select distinct first_name from employees; -- 11 imiona - bardziej widoczna różnica
select * from employees where last_name='King'; -- 12
select last_name from employees where salary < 5000; -- 13

