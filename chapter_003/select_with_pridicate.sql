select avg(price) from devices;

select ppl.name, avg(dev.price) 
from devices_people as dp 
join people ppl 
on dp.people_id = ppl.id
join devices dev
on dp.device_id = dev.id
group by ppl.name;

select ppl.name, avg(dev.price) 
from devices_people as dp 
join people ppl 
on dp.people_id = ppl.id
join devices dev
on dp.device_id = dev.id
group by ppl.name
having avg(dev.price) > 5000;