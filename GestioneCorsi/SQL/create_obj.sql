-- Gestione Admin
create table admin(
id_admin int,
nome_admin varchar2(30) not null,
cognome_admin varchar2(30) not null,
username_admin varchar2(10) not null,
password_admin varchar2(500) not null,
constraint p_id_admin primary key(id_admin));

create table docente(
id_docente int,
nome_docente varchar2(30) not null,
cognome_docente varchar2(30) not null,
cv_docente varchar2(500) not null,
constraint p_id_docente primary key(id_docente));

create table corso(
id_corso int,
nome_corso varchar2(30) not null,
data_inizio_corso date not null,
data_fine_corso date not null,
costo_corso int not null,
commenti_corso varchar2(500) not null,
aula_corso varchar2(5),
posti_disponibili int default 50,
id_docente int,
constraint p_id_corso primary key(id_corso),
constraint f_id_docente foreign key(id_docente) references docente(id_docente));

create table corsista(
id_corsista int,
nome_corsista varchar2(30) not null,
cognome_corsista varchar2(30) not null,
precedenti_formativi_corsista varchar2(2) not null,
constraint p_id_corsista primary key(id_corsista));

create table corsista_corso(
id_corsista int,
id_corso int,
constraint f_id_corsista foreign key(id_corsista) references corsista(id_corsista) on delete cascade,
constraint f_id_corso foreign key(id_corso) references corso(id_corso) on delete cascade,
constraint p_cc primary key(id_corsista, id_corso));

--Sequenze
create sequence corsista_seq;
create sequence corso_seq;

--VIEW
create or replace view corso_freq as
select nome_corso, count(corsista_corso.id_corso) as count 
from corsista_corso, corso 
where corso.id_corso = corsista_corso.id_corso 
group by nome_corso
order by count desc;
