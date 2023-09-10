CREATE TABLE if not exists orders (
        id BIGSERIAL PRIMARY KEY,
        name VARCHAR(64) NOT NULL
);

CREATE TABLE if not exists users (
        id BIGSERIAL PRIMARY KEY,
        name VARCHAR(64) NOT NULL,
        surname VARCHAR(64) NOT NULL,
        phoneNumber VARCHAR(64) NOT NULL,
        email VARCHAR(64) NOT NULL,
        id_order BIGINT,
        FOREIGN KEY (id_order) REFERENCES orders (id)
);

SELECT * FROM users u JOIN orders o on o.id = u.id_order;