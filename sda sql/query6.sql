
 
drop database if exists company;
create database company;

use company;
create table worker(
	id int auto_increment not null,
	worker_name varchar(128),
    salary decimal(10,2),
    age int,
    primary key (id)
) default character set utf8 collate utf8_polish_ci;
;

insert into worker 
(worker_name, salary, age)
values
('worker1', 111101, 35),
('worker2', 111102, 34),
('worker3', 111103, 54),
('worker4', 111104, 85),
('worker5', 111105, 32);

insert into worker(salary) values
(1000,  1000, 1000, 1500, 1500, 1500, 2000, 2000, 4000, 4000);

set sql_safe_updates = 0;
select * from worker;

select * from worker order by salary asc;
select * from worker order by salary desc;

select avg(salary) as srednia_pensja from worker;
select min(salary) as min_pensja from worker;
select max(salary) as max_pensja from worker;
select count(*) as workers_count, salary from worker group by salary;

-- 1 sposób
select * from worker where salary = (select max(salary) from worker);
select * from worker where salary = (select min(salary) from worker);

-- 2 sposób
select * from worker order by salary asc;
select worker_name, salary, age from worker;

select * from worker order by salary desc;
select worker_name, salary, age from worker;









