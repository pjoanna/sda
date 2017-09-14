use bookstore;

CREATE TABLE books (
title VARCHAR(128),
author VARCHAR(128),
published DATE,
isbn CHAR(17),
category VARCHAR(128),
page_count INT,
publisher VARCHAR(128),
price DECIMAL(10,2),
on_stock INT DEFAULT 0
) DEFAULT CHARACTER SET utf8 COLLATE utf8_polish_ci;

INSERT INTO books (title, author, published, isbn, category, page_count, publisher, price) VALUES ('Spring w akcji. Wydanie IV', 'Craig Walls', '2015-08-13', '978-83-283-0849-7', 'programowanie java', 624, 'Helion', 89.00);
INSERT INTO books (title, author, published, isbn, category, page_count, publisher, price) VALUES ('MySQL. Vademecum profesjonalisty', 'Paul DuBois', '2014-03-28', '978-83-246-8146-4', 'bazy danych', 1216, 'Helion', 149.00);

INSERT INTO books (title, author, published, isbn, category, page_count, publisher, price) VALUES (
'Angular 2. Tworzenie interaktywnych aplikacji internetowych',
'Gion Kunz',
'2017-03-09',
'978-83-283-3196-9',
'programowanie javascript',
352,
'Helion',
59.00
);

INSERT INTO books (title, author, published, isbn, category, page_count, publisher, price) VALUES (
'AngularJS. Tworzenie aplikacji webowych. Receptury',
'Matt Frisbie',
'2016-03-10',
'978-83-283-2148-9',
'programowanie javascript',
328,
'Helion',
59.00
);

INSERT INTO books (title, author, published, isbn, category, page_count, publisher, price) VALUES (
'MySQL Cookbook. Solutions for Database Developers and Administrators. 3rd Edition',
'Paul DuBois',
'2014-07-28',
'978-1-4493-7414-3',
'bazy danych',
866,
'O\'Reilly Media',
259.00
);

INSERT INTO books (title, author, published, isbn, category, page_count, publisher, price) VALUES (
'PHP 5. Leksykon kieszonkowy',
'Marcin Lis',
'2011-10-21',
'978-83-246-3892-5',
'programowanie php',
168,
'Helion',
24.90
);

INSERT INTO books (title, author, published, isbn, category, page_count, publisher, price) VALUES (
'C#. Ćwiczenia. Wydanie IV',
'Marcin Lis',
'2016-07-22',
'978-83-283-2894-5',
'programowanie c#',
264,
'Helion',
34.90
);

INSERT INTO books (title, author, published, isbn, category, page_count, publisher, price) VALUES (
'SQL. Ćwiczenia praktyczne. Wydanie II (ebook)',
'Marcin Lis',
'2011-06-22',
'978-83-246-3478-1',
'bazy danych',
176,
'Helion',
29.00
);

INSERT INTO books (title, author, isbn, category, page_count, publisher, price) VALUES (
'JavaScript dla dzieci',
'Nick Morgan',
'978-83-011-8316-5',
'programowanie javascript',
320,
'PWN',
69.00
);

INSERT INTO books (title, author, isbn, category, page_count, publisher, price) VALUES (
'Python dla dzieci',
'Briggs Jason R.',
'978-83-011-8368-4',
'programowanie python',
320,
'PWN',
69.00
);

INSERT INTO books (title, author, isbn, category, page_count, publisher, price) VALUES (
'Java Programowanie praktyczne od podstaw',
'Krzysztof Barteczko',
'978-83-011-7809-3',
'programowanie java',
486,
'PWN',
59.00
);

INSERT INTO books (title, author, isbn, category, page_count, publisher, price) VALUES (
'Java. Uniwersalne techniki programowania',
'Krzysztof Barteczko',
'978-83-011-8341-7',
'programowanie java',
600,
'PWN',
69.00
);

alter table books modify column title varchar(128) NOT NULL;
alter table books modify column author varchar(128) NOT NULL;
alter table books modify column isbn char(17) NOT NULL unique;
alter table books modify column publisher varchar(128) default 'nieznana';
alter table books add column in_stock int(128) default 0;




