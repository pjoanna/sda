drop database if exists shop;
create database shop;


use shop;

create table category(
	id int auto_increment not null,
	category_name varchar(32),
    description varchar(255),
    primary key (id)
);

create table product(
	id int auto_increment not null primary key,
    product_name varchar(32),
    price decimal(6,2),
    category_id int,
	foreign key (category_id) references category(id)
) default character set utf8 collate utf8_polish_ci;
;

insert into category (category_name) 
values
('cat1'),('cat2'),('cat3');

insert into product
values
(id, 'product1', 1101.45, 1),
(id, 'product2', 1102.99, 3),
(id, 'product3', 1103.33, 2),
(id, 'product4', 1104.22, 1),
(id, 'product5', 1105.10, 3);

set sql_safe_updates = 0;

select * from product; 

select p.product_name from product p;
select c.category_name from category c;

select p.product_name, c.category_name 
from product p 
left join category c 
on p.category_id = c.id;

select 
	count(p.product_name) as products_count, 
	c.category_name 
from product p 
left join category c 
on p.category_id = c.id
group by c.id;

select 
	avg(p.price) as avg_price, 
	c.category_name 
from product p 
left join category c 
on p.category_id = c.id
group by c.id;

-- widok
create view category_name_view as select category_name from category;
select * from category_name_view;

create view product_full as select p.id, p.product_name, p.price, c.category_name 
from product p 
left join category c 
on p.category_id = c.id;
select * from product_full;

select product_name, category_name from product_full;

select count(*) as products_count, category_name from product_full group by category_name;

select avg(price) as srednia_cena, category_name from product_full group by category_name;

-- druga część zadania shop

create table customer(
	id int auto_increment not null,
	first_name varchar(32),
    last_name varchar(32),
    primary key (id)
);

create table purchase(
	id int auto_increment not null  primary key,
	date date,
    paid enum('NEW', 'PAID', 'CANCELLED', 'COMPLETION'),
    customer_id int,
    foreign key (customer_id) references customer(id)
);

create table purchase_products(
	purchase_id int,
    product_id int,
    quantity int,
    foreign key (purchase_id) references purchase(id),
    foreign key (product_id) references product(id),
    primary key (purchase_id, product_id)
);

insert into customer
values 
(id, 'imie1','nazw1'),
(id, 'imie2','nazw2');

insert into purchase values
(id, "2017-10-03", 'NEW', 1),
(id, "2017-03-14", 'NEW', 2);

insert into purchase_products values
(1,1,10),
(1,2,12),
(2,3,13),
(2,4,11),
(1,5,12),
(1,4,11),
(2,2,13);
