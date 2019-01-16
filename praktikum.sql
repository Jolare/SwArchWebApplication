drop table swarch_produktion;
drop table swarch_maschine;
drop table swarch_koordinate;
drop table swarch_raum;
drop table swarch_gebaude;
drop table swarch_standort;
drop table swarch_mitarbeiter;

create table swarch_mitarbeiter(
    id          number primary key,
    vorname     varchar(20) not null,
    nachname    varchar(20) not null
);
create table swarch_standort(
    id          number primary key,
    plz         varchar2(5),
    ort         varchar2(20),
    strasse     varchar2(50)
);
create table swarch_gebaude(
    id          number primary key,
    name        varchar(30) not null,
    standort_id  number references swarch_standort(id)
);
create table swarch_raum(
    id          number primary key,
    gebaude_id  number not null references swarch_gebaude(id)
);
create table swarch_koordinate(
    id          number primary key,
    laengengrad float,
    breitengrad float,
    raum_id     number not null references swarch_raum(id)
);
create table swarch_maschine(
    id          number primary key,
    raum_id     number references swarch_raum(id),
    mitarbeiter_id  number references swarch_mitarbeiter(id)
);
create table swarch_produktion(
    id          number primary key,
    datum       date,
    maschine_id number references swarch_maschine(id),
    nummer      number
);

insert into swarch_mitarbeiter(id, vorname, nachname) values(1, 'Hans', 'Peter');
insert into swarch_mitarbeiter(id, vorname, nachname) values(2, 'Christine', 'Schuster');
insert into swarch_mitarbeiter(id, vorname, nachname) values(3, 'Albert', 'Einstein');
insert into swarch_standort(id,plz,ort,strasse) values(1,'72458','Albstadt','Jakobstr.3');
insert into swarch_standort(id,plz,ort,strasse) values(2,'67890','Testhausen','Siebenstrasse 9');
insert into swarch_gebaude(id,name,standort_id) values(1,'Gebäude 201',1);
insert into swarch_gebaude(id,name,standort_id) values(2,'Sudgebaeude',2);
insert into swarch_raum(id,gebaude_id) values(1,1);
insert into swarch_raum(id,gebaude_id) values(2,1);
insert into swarch_raum(id,gebaude_id) values(3,1);
insert into swarch_raum(id,gebaude_id) values(4,2);
insert into swarch_raum(id,gebaude_id) values(5,2);
insert into swarch_koordinate(id,laengengrad,breitengrad,raum_id) values(1,48.209235,9.032534,1);
insert into swarch_koordinate(id,laengengrad,breitengrad,raum_id) values(2,48.209227,9.032572,1);
insert into swarch_koordinate(id,laengengrad,breitengrad,raum_id) values(3,48.209198,9.032500,1);
insert into swarch_koordinate(id,laengengrad,breitengrad,raum_id) values(4,48.209253,9.032461,1);
insert into swarch_koordinate(id,laengengrad,breitengrad,raum_id) values(5,0,0,2);
insert into swarch_koordinate(id,laengengrad,breitengrad,raum_id) values(6,5,0,2);
insert into swarch_koordinate(id,laengengrad,breitengrad,raum_id) values(7,5,5,2);
insert into swarch_koordinate(id,laengengrad,breitengrad,raum_id) values(8,0,5,2);
insert into swarch_koordinate(id,laengengrad,breitengrad,raum_id) values(9,48.2093569,9.0320732,3);
insert into swarch_koordinate(id,laengengrad,breitengrad,raum_id) values(10,48.2091055,9.0320158,3);
insert into swarch_koordinate(id,laengengrad,breitengrad,raum_id) values(11,48.2094335,9.0328859,3);
insert into swarch_koordinate(id,laengengrad,breitengrad,raum_id) values(12,48.2093371,9.0321737,3);
insert into swarch_maschine(id,raum_id,mitarbeiter_id) values(1,4,1);
insert into swarch_maschine(id,raum_id,mitarbeiter_id) values(2,4,2);
insert into swarch_maschine(id,raum_id,mitarbeiter_id) values(3,5,3);
insert into swarch_produktion(id,datum,maschine_id,nummer) values(1,to_date('01.01.2018','dd.mm.yyyy'),1,20);
insert into swarch_produktion(id,datum,maschine_id,nummer) values(2,to_date('05.05.2018','dd.mm.yyyy'),1,5);
insert into swarch_produktion(id,datum,maschine_id,nummer) values(3,to_date('05.07.2018','dd.mm.yyyy'),2,40);
insert into swarch_produktion(id,datum,maschine_id,nummer) values(4,to_date('09.09.2018','dd.mm.yyyy'),3,10);
commit;