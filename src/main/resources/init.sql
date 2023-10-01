CREATE TABLE if not exists orders (
                        id int primary key,
                        user_id int,
                        name varchar(55) NOT NULL,
                        order_text varchar(1000),
                        order_face varchar(55),
                        foreign key (user_id) references users(id)
);

CREATE TABLE if not exists users (
                       id int primary key ,
                       name varchar(55),
                       surname varchar(55),
                       age int,
                       birthday date,
                       phone_number varchar(55),
                       email varchar(255),
                       meta json
);