create table devices(
    id serial primary key,
    name varchar(255),
    price float
);

create table people(
    id serial primary key,
    name varchar(255)
);

create table devices_people(
    id serial primary key,
    device_id int references devices(id),
    people_id int references people(id)
);

insert into devices(name, price) values ('Iphone XS', 65000.00), ('Samsung Galaxy', 55600.00), ('Playstation 5', 73200.00);
insert into people(name) values ('Igor'), ('Mark'), ('Fedor');
insert into devices_people(device_id, people_id) values (1,1), (2,2), (3,3);
