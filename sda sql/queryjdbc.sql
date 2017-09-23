-- CREATE SCHEMA `bookstore` IF not exists;
use `bookstore` ;

CREATE TABLE `bookstore`.`person` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(255) NOT NULL,
  `last_name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`));

INSERT INTO person (first_name, last_name) VALUES ('firstname1', 'lastname1'), ('firstname2', 'lastname2');
select * from person;


CREATE TABLE `bookstore`.`animal` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `breed` VARCHAR(255) NOT NULL,
  `person_id` int NOT NULL,
  PRIMARY KEY (`id`)),
  foreign key `person_id` references person(id); 