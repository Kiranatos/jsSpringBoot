insert into bank_user (name) values ('Ivan');
insert into bank_user (name) values ('John');
insert into bank_user (name) values ('Petr');
insert into bank_user (name) values ('John');
insert into bank_user (name) values ('Artem');

insert into account (name, amount, user_id) values ('ac1Iv', 10, 1);
insert into account (name, amount, user_id) values ('ac2Iv', 11, 1);
insert into account (name, amount, user_id) values ('ac3Iv', 120, 1);
insert into account (name, amount,  user_id) values ('ac4Iv', 0, 1);

insert into account (name, amount,  user_id) values ('ac1J', 50, 2);
insert into account (name, amount,  user_id) values ('ac2J', 20, 2);
insert into account (name, amount,  user_id) values ('ac3J', 100, 2);

insert into fruit_table (id_fruit, fruit_name,  provider_code) values (1, 'Cocos SQL', 110);
insert into fruit_table (id_fruit, fruit_name,  provider_code) values (2, 'Cherry SQL', 120);
insert into fruit_table (id_fruit, fruit_name,  provider_code) values (103, 'Mandarin SQL', 130);
insert into fruit_table (id_fruit, fruit_name,  provider_code) values (202, 'Pineapple SQL', 140);

-- insert into fruit_table (id_fruit, fruit_name,  provider_code) values (100, 'cocos', 100);
/*
insert into fruit_table (fruit_name,  provider_code) values ('cocos', 100);
insert into fruit_table (fruit_name,  provider_code) values ('papaya', 200);
*/
/*
*/

