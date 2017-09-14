
drop database if exists states;
create database states;


use states;

create table city(
	id int auto_increment not null primary key,
    name varchar(64),
    citizens int
);


create table state(
	id int auto_increment not null primary key,
	name varchar(32),
    population int,
    capital_id int,
    foreign key (capital_id) references city(id)
) default character set utf8 collate utf8_polish_ci;


INSERT INTO city (name,citizens) VALUES
('Praga',1280500),
('Paryż',2000000),
('Wilno',539900),
('Berlin',3400000),
('Warszawa',1753977),
('Olsztyn',173500),
('Gdańsk',463700),
('Sopot',37650),
('Gdynia',247500),
('Kraków',762500);

INSERT INTO state (name, population,capital_id) VALUES
('Czechy', 10627448,1),
('Francja', 66259012,2),
('Litwa',3505738,3),
('Niemcy',80996685,4),
('Polska',38346279,5);

set sql_safe_updates = 0;

select * from state; 

select s.name, c.name 
from state s left join city c 
on s.capital_id = c.id;

-- to samo 2 niżej
select c.name as city from state s left join city c on s.capital_id = c.id;
select name as city from city where exists (select * from state where state.capital_id = city.id);

select s.name, concat((c.citizens/s.population)*100, '%') as capital_citizens from state s left join city c on s.capital_id = c.id;

select s.name 
from state s left join city c on s.capital_id = c.id
where (c.citizens/s.population)*100>10;

alter table city add column is_capital bool;

update city c set c.is_capital = exists (select * from state where state.capital_id = c.id);
select * from city;
delete from city where is_capital = false;
select * from city;


