drop table swarch_produktion;
drop table swarch_maschine;
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
    gebaude_id  number not null references swarch_gebaude(id),
    bereich     MDSYS.SDO_GEOMETRY
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
insert into swarch_raum(id,gebaude_id,bereich) values(1,1,MDSYS.SDO_GEOMETRY(2003,NULL,NULL,MDSYS.SDO_ELEM_INFO_ARRAY(1,1003,3),MDSYS.SDO_ORDINATE_ARRAY(48.209235,9.032534, 48.209227,9.032572, 48.209198,9.032500, 48.209253,9.032461, 48.209235,9.032534)));
insert into swarch_raum(id,gebaude_id,bereich) values(2,1,MDSYS.SDO_GEOMETRY(2003,NULL,NULL,MDSYS.SDO_ELEM_INFO_ARRAY(1,1003,3),MDSYS.SDO_ORDINATE_ARRAY(3,1, 3,3, 5,3, 5,1, 3,1)));
insert into swarch_raum(id,gebaude_id,bereich) values(3,1,MDSYS.SDO_GEOMETRY(2003,NULL,NULL,MDSYS.SDO_ELEM_INFO_ARRAY(1,1003,3),MDSYS.SDO_ORDINATE_ARRAY(5,1, 5,3, 7,3, 7,1, 5,1)));
insert into swarch_raum(id,gebaude_id,bereich) values(4,2,MDSYS.SDO_GEOMETRY(2003,NULL,NULL,MDSYS.SDO_ELEM_INFO_ARRAY(1,1003,3),MDSYS.SDO_ORDINATE_ARRAY(8,8, 8,10, 10,10, 10,8, 8,8)));
insert into swarch_raum(id,gebaude_id,bereich) values(5,2,MDSYS.SDO_GEOMETRY(2003,NULL,NULL,MDSYS.SDO_ELEM_INFO_ARRAY(1,1003,3),MDSYS.SDO_ORDINATE_ARRAY(10,10, 10,15, 15,15, 15,10, 10,10)));
insert into swarch_maschine(id,raum_id,mitarbeiter_id) values(1,4,1);
insert into swarch_maschine(id,raum_id,mitarbeiter_id) values(2,4,2);
insert into swarch_maschine(id,raum_id,mitarbeiter_id) values(3,5,3);
insert into swarch_produktion(id,datum,maschine_id,nummer) values(1,to_date('01.01.2018','dd.mm.yyyy'),1,20);
insert into swarch_produktion(id,datum,maschine_id,nummer) values(2,to_date('05.05.2018','dd.mm.yyyy'),1,5);
insert into swarch_produktion(id,datum,maschine_id,nummer) values(3,to_date('05.07.2018','dd.mm.yyyy'),2,40);
insert into swarch_produktion(id,datum,maschine_id,nummer) values(4,to_date('09.09.2018','dd.mm.yyyy'),3,10);
commit;