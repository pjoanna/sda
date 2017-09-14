drop database if exists personal_data;
create database personal_data;

use personal_data;
create table person(
	first_name varchar(128),
    last_name varchar(128),
    age int
);

insert into person 
(first_name, last_name) 
values 
('imie1','naziwsko1'),
('imie2','naziwsko2'),
('imie3','naziwsko3'),
('imie4','naziwsko4');

select * from person;
select first_name from person;

