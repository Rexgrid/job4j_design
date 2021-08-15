insert into role(name) values ('admin');
insert into users(name, role_id) values ('Egor Aleksandrov', 1);
insert into rules(name) values ('adding a request');
insert into role_rules(role_id, rules_id) values (1,1);
insert into category(name) values ('very important issue');
insert into state (name) values ('in progress');
insert into item (name, user_id, state_id, category_id) values ('printer is broke down', 1,1,1);
insert into attachment (name, item_id) values ('photo', 1);
insert into comments (name, item_id) values ('problem description', 1);