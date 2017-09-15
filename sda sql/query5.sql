drop database if exists personal_data;
create database personal_data;

use personal_data;
create table person(
	first_name varchar(128),
    last_name varchar(128),
    age int
) default character set utf8 collate utf8_polish_ci;
;

insert into person 
(first_name, last_name, age) 
values 
('imie1','nazwisko1', 24),
('imie2','nazwisko2', 25),
('imie3','nazwisko3', 36),
('imie4','nazwisko4', 25),
('imie5','nazwisko5', 36),
('imie6','nazwisko6', 47);

select * from person;
select first_name from person;

set sql_safe_updates = 0;

update person set age=age+1;

select count(*) as person_count, age  from person group by age;

 
drop database if exists contacts;
create database contacts;

use contacts;
create table contact(
	id int auto_increment not null,
	first_name varchar(128),
    last_name varchar(128),
    phone_number varchar(128),
    e_mail varchar(128) default 'brak',
    primary key (id)
) default character set utf8 collate utf8_polish_ci;
;

insert into contact 
(first_name, last_name, phone_number, e_mail)
values
('imie1', 'nazwisko1', 111101, 'email1@mail.com'),
('imie2', 'nazwisko2', 111102, 'email2@mail.com'),
('imie3', 'nazwisko3', 111103, 'email3@mail.com'),
('imie4', 'nazwisko4', 111104, 'email4@mail.com'),
('imie5', 'nazwisko5', 111105, default);


set sql_safe_updates = 0;
select * from contact;
select last_name, phone_number from contact;
select concat(first_name, ' ', last_name) as names, e_mail from contact;

select count(*) as ilosc_osob from contact;
select first_name, last_name from contact where last_name = 'nazwisko3';
select first_name,last_name from contact where last_name LIKE 'nazwisko%';

select first_name,last_name from contact where phone_number LIKE '672%';
select count(*) as liczba_osob from contact where phone_number LIKE '%0';

update contact set e_mail='brak' where e_mail = null;

select * from contact;
