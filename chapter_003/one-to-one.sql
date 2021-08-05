create table country(
	id serial primary key,
	name varchar(255)
);

create table area_code(
	id serial primary key,
	code varchar(3),
	country_id int references country(id) unique
);

insert into country(name) values ('Russia');
insert into area_code(code, country_id) values ('+7', 1);

select * from area_code;