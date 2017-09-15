-- use, alter table, create table, insert into (multi rows), update - problem z update, not null


use nordea;
CREATE TABLE IF NOT EXISTS author (
firstname VARCHAR(128),
lastname VARCHAR(128)
);

explain author;

use nordea;
CREATE TABLE if not exists ksiazki(
title VARCHAR(255),
author VARCHAR(255),
published DATE,
isbn CHAR(13),
category VARCHAR(64),
page_count INT,
publisher VARCHAR(255),
price DECIMAL(5,2)
);

alter table ksiazki add column data_jakas date;
alter table ksiazki change column data_jakas costam varchar(255);
alter table ksiazki drop column costam;

insert into 
	ksiazki (title, author, category) 
values 
	('title5','author5','dramat2'),
	('title2','author2','komedia'),
	('title3','author3','horror'),
	('title4','author4','bajka');
    
SET SQL_SAFE_UPDATES = 0; -- gdy problem z update !!

update ksiazki set title ='title00' where category = 'dramat';


create table if not exists test_table (
	column1 varchar(255) not null,
	column2 varchar(255),
	column3 varchar(255),
	column4 varchar(255),
	column5 varchar(255),
	column6 varchar(255) not null
);

insert into test_table (column1, column2, column6) values ('cokolwiek1', 'cokolwiek2', 'cokolwiek3');
-- insert into test_table (column1) values ('cos'); -- błąd!!!

create table if not exists test_table3 (
	unikalne_pole2 char(10) unique      
    -- to samo co
    -- unikalne_pole char(10),
    -- unique(unikalne_pole)
);

insert into test_table3 (unikalne_pole2) values('wartosc1'); -- ok
insert into test_table3 (unikalne_pole2) values('wartosc1'); -- błąd bo dodajemy 2 pole takie samo,a to jest unikalne!!
insert ignore into test_table3 (unikalne_pole2) values('wartosc1'); -- z ignore | only warning

