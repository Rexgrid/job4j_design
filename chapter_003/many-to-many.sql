create table author(
id serial primary key,
	name varchar(255)
);

create table book(
	id serial primary key,
	name varchar(255) 
);

create table publisher(
	id serial primary key,
	author_id int references author(id),
	book_id int references book(id)
);

insert into author(name) values ('Turgenev');
insert into book(name) values ('Fathers And Sons');
insert into publisher(author_id, book_id) values (1,1);

select * from publisher;