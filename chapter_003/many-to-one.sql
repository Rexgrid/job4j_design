create table producerCompany(
id serial primary key,
	name varchar(255)
);

create table phoneModel(
	id serial primary key,
	model_name varchar(255),
	producer_company_id int references producerCompany(id)
	);

insert into producerCompany(name) values ('Motorola');
insert into phoneModel(model_name, producer_company_id) values ('E398', 1);
	
	select * from phoneModel;
	