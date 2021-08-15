create table car_body(
id serial primary key,
name varchar(255)	
);

create table car_engine(
id serial primary key,
name varchar(255)
);

create table car_transmission(
id serial primary key,
name varchar(255)
);

create table car(
id serial primary key,
name varchar(255),
car_body_id int references car_body(id) NOT NULL,
car_engine_id int references car_engine(id) NOT NULL,
car_transmission_id int references car_transmission(id) NOT NULL);


insert into car_body(name) values ('2-doors'), ('4-doors'), ('cabrio'), ('minivan');
insert into car_engine(name) values ('v-8'), ('v-6'), ('v-10'), ('inline');
insert into car_transmission(name) values ('5-speed'), ('6-speed'), ('10-speed');
insert into car(name, car_body_id, car_engine_id, car_transmission_id) values
('Honda Accord', 2, 4, 1), ('Ford Mustang', 1, 1, 2), ('Mercedes e250 cabriolet', 3, 4, 2), ('Lada Granta', 2, 4, 1); 

select c.name, cb.name as body, ce.name as engine, ct.name as transmisson  from car c, car_body cb, car_engine ce, car_transmission ct 
where c.car_body_id = cb.id and c.car_engine_id = ce.id and c.car_transmission_id = ct.id;
select car_body.name as body from car_body left join car on car.car_body_id = car_body.id where car.name is null ;
select car_engine.name as engine from car_engine left join car on car.car_engine_id = car_engine.id where car.name is null;
select ct.name as transmission from car_transmission as ct left join car on car.car_transmission_id = ct.id where car.name is null;