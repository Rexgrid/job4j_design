select  pr.name, type.name from product as pr join type on pr.type_id = type.id where type.name = 'Сыр';
select pr.name, type.name from product as pr join type on pr.type_id = type.id  where pr.name like '%Мороженное%';
select name, expired_date from product where expired_date < now();
select name, price from product where price = (select max(price) from product);
select type.name, count(*) as number from product join type on product.type_id = type.id group by type.name; 
select pr.name from product as pr join type on pr.type_id = type.id where type.name = 'Сыр' or type.name ='Молоко';
select type.name, count(*) as number from product join type on product.type_id = type.id group by type.name having (count(*) < 10); 
select pr.name, type.name from product as pr join type on pr.type_id = type.id;