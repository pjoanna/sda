-- CREATE SCHEMA `bookstore` IF not exists;
use bookstore ;
CREATE TABLE person (
  id INT NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(255) NOT NULL,
  last_name VARCHAR(255) NOT NULL,
  PRIMARY KEY (id));

INSERT INTO person (first_name, last_name) VALUES ('firstname3', 'lastname3'), ('firstname4', 'lastname4');
select * from person;


CREATE TABLE if not exists animal(
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  breed VARCHAR(255) NOT NULL,
  person_id int,
  PRIMARY KEY (id),
  foreign key (person_id) references person(id))
  DEFAULT CHARACTER SET utf8 COLLATE utf8_polish_ci;
  
set sql_safe_updates = 0;
use bookstore;
select * from person ;

INSERT INTO animal(name, breed, person_id) VALUES ('anim1', 'breed1', 1), ('anim2', 'breed2', 2);
INSERT INTO animal(name, breed, person_id) VALUES ('anim3', 'breed3', 2), ('anim4', 'breed4', 1);

select * from animal;

select p.id idfromperson, p.first_name, p.last_name, a.id animalid, a.name, a.breed breed, a.person_id personid from person p left join animal a on p.id= a.person_id where a.person_id =1;
