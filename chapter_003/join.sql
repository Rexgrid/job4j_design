create table departments (
id serial primary key,
	name varchar(120)
);

create table employees (
id serial primary key,
	name varchar(70),
	dep_id int references departments(id)
);

insert into departments(name) values ('Sales'), ('Administration'), ('Law department');
insert into employees(name, dep_id) values ('Alex', 1), ('Josh', 1), ('Colin', '1'), ('Carl', 2), ('Elena', 2);

select * from employees e left join departments d on e.dep_id = d.id;
select * from employees e right join departments d on e.dep_id = d.id;
select * from employees e full join departments d on e.dep_id = d.id;
select * from employees e cross join departments d;
select d.name from departments d left join employees e on e.dep_id = d.id where e.name is null;
select * from employees e right join departments d on e.dep_id = d.id;
select * from departments d left join employees e on e.dep_id = d.id;

create table teens (
name varchar(255),
gender varchar(1)
);

insert into teens values ('Alex', 'm'), ('Elena', 'f'), ('Mark', 'm'), ('Irina', 'f');

select t1.gender as p1, t2.gender as p2 from teens t1 cross join teens t2;