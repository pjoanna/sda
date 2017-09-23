CREATE SCHEMA `bookstore` IF not exists;
use `bookstore` ;

CREATE TABLE `bookstore`.`student` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `lastname` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`));

CREATE USER user_nordea IDENTIFIED BY 'nordea2';

GRANT USAGE ON *.* TO user_nordea@localhost identified BY 'nordea2';
GRANT ALL PRIVILEGES ON bookstore.* TO user_nordea@localhost;

INSERT INTO person (first_name, last_name) VALUES ('firstname1', 'lastname1'), ('firstname2', 'lastname2');