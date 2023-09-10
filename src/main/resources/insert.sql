insert into orders (id, name)
values (3, 'Buy acc 6k pts'),
       (4, 'Buy acc 4k pts');

insert into users (id, name, surname, phonenumber, email, id_order)
values (3, 'Артем', 'Арбузов', '8-996-000-00-00', 'artemUser@gmail.com', 3),
       (4, 'Борис', 'Бананов', '8-996-000-00-01', 'borisUser@gmail.com', 4);