use bookstore2;
select tytul from ksiazka; -- 1
select concat(autor_imie,' ', autor_nazwisko) as autor from ksiazka; -- 2
select autor_imie, autor_nazwisko, min_wiek from ksiazka; -- 3
select * from ksiazka where rodzaj = 'bajki'; -- 4
select * from ksiazka where rodzaj = 'bajki' and lower(autor_nazwisko) LIKE 'brzechwa'; -- 5
select * from klient where nazwisko = 'Kowalski'; -- 6
select * from klient where nazwisko != 'Kowalski'; -- 7
select * from klient where nazwisko LIKE 'S%' and rok_urodzenia > '1960-01-01'; -- 8
select * from ksiazka where autor_imie = 'Władysław'; -- 9
select * from ksiazka where rodzaj != 'bajki'; -- 10
select k1.imie, k2.imie as polecil
from klient k1 join klient k2 on k1.id_polecony_przez = k2.klient_id; -- 11
select imie from klient where imie not in (select imie from klient_archiwalny);  -- 12 Ani
select distinct imie from klient where imie not in (select DISTINCT imie from klient_archiwalny); -- 12 Pawła
select distinct imie from klient where imie not in (select DISTINCT autor_imie from ksiazka); -- 13
select * from ksiazka k left join recenzja r on k.ksiazka_id = r.ksiazka_id; -- 14
select distinct imie from klient; -- 15
update recenzja set ksiazka_id = null where recenzja_id = 1; -- 16
select * from recenzja where ksiazka_id is null; -- 17
select count(distinct ksiazka_id) from recenzja where ksiazka_id is not null; -- 18
select * from ksiazka k join recenzja r on r.ksiazka_id = k.ksiazka_id where k.min_wiek > 3; -- 19
select * from ksiazka k join ocena_ksiazki o on k.ksiazka_id = o.ksiazka_id; -- 20
select count(*) from ksiazka k join ocena_ksiazki o on k.ksiazka_id = o.ksiazka_id; -- sprawdzenie 20
select * from klient k join recenzja r on k.klient_id = r.klient_id; -- 21
select * from ksiazka k left join recenzja r on k.ksiazka_id = r.ksiazka_id; -- 22;
select * from recenzja r left join ksiazka k on k.ksiazka_id = r.ksiazka_id
union 
select * from recenzja r right join ksiazka k on k.ksiazka_id = r.ksiazka_id; -- 23
select * from klient k left join recenzja r on r.klient_id = k.klient_id; -- 24

select concat(autor_imie," ", autor_nazwisko) as 'autor', 
count(concat(autor_imie, autor_nazwisko)) as 'liczba ksiazek'
from ksiazka 
GROUP BY concat(autor_imie, autor_nazwisko); -- 25

select concat(autor_imie," ", autor_nazwisko) as 'autor', 
count(concat(autor_imie, autor_nazwisko)) as 'liczba ksiazek'
from ksiazka 
GROUP BY concat(autor_imie, autor_nazwisko) where count(concat(autor_imie, autor_nazwisko))>1; -- 26 ??????????

select avg(ocena_ksiazki.ocena) from ocena_ksiazki; -- 27
select * from statystyka_klienta where liczba_przeczytanych_ksiazek>50; -- 28
select distinct s.klient_id from statystyka_klienta s left join ocena_ksiazki o on o.klient_id = s.klient_id where liczba_przeczytanych_ksiazek>50 and o.ocena is not null; -- 29??????

select * from ksiazka where (select  from recenzja where recenzja_tekst = 'Świetna!'); -- 30???????

-- do dokończenia


