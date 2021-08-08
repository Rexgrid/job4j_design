create table driver (
id serial primary key,
name varchar(40),
birthday timestamp);

create table driver_license(
id serial primary key,
	seria varchar(10),
	experetion_date timestamp,
	driver_id int references driver(id)
);

insert into driver(name) values ('Tyrion Lanister', date '1955-04-12');
insert into driver_license (seria, experetion_date, driver_id) values ('123 457', date '2022-12-02', 1);

select dl.seria, driver.name from driver_license as dl join driver on dl.driver_id = driver.id;
select dl.experetion_date, driver.name  from driver_license as dl inner join driver on dl.driver_id = driver.id;
select driver.name, driver.birthday as bday , dl.experetion_date from driver_license as dl join driver on dl.driver_id = driver.id;