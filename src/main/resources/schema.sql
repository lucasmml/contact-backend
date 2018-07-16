drop table PERSON;
drop table CONTACT;

CREATE TABLE IF NOT EXISTS PERSON (
	id integer not null,
	name varchar(250) not null,
	primary key(id)
);

CREATE TABLE IF NOT EXISTS CONTACT (
	id integer not null,  
	name VARCHAR(50) NOT NULL,
	contact_value VARCHAR(150) NOT NULL,
	person_id integer not null,
	foreign key (person_id) references PERSON(id)
);