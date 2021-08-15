create table type(
id  serial primary key,
name varchar(255));

create table product(
id serial primary  key,
name varchar(130),
type_id int references type(id),
expired_date timestamp,
price float);