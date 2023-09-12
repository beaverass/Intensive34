CREATE TABLE IF NOT EXISTS shippers (
    id VARCHAR(255) PRIMARY KEY,
    name VARCHAR(255),
    phone_number VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS orders (
    id VARCHAR(255) PRIMARY KEY,
    name VARCHAR(255),
    order_date DATE NOT NULL,
    shipper_id VARCHAR(255),
    FOREIGN KEY (shipper_id) REFERENCES shippers(id)
);

CREATE TABLE IF NOT EXISTS users (
    id VARCHAR(255) PRIMARY KEY,
    full_name VARCHAR(255) NOT NULL,
    phone_number VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    birthday DATE NOT NULL,
    order_id VARCHAR(255),
    FOREIGN KEY (order_id) REFERENCES orders(id)
);


INSERT INTO shippers (id, name, phone_number) VALUES ('1c4d8ee5-f861-458c-981b-5f12b08a9e04','СДЭК', '89607865431');
INSERT INTO shippers (id, name, phone_number) VALUES ('bd157c3c-93a1-47ac-b6c6-6b89784c4e4b','Почта России', '89605675431');
INSERT INTO shippers (id, name, phone_number) VALUES ('5ea183fe-cca7-4924-9adf-1c200b8461c5','Пони Экспресс', '89705675431');

INSERT INTO orders(id, name, order_date, shipper_id) VALUES ('d87c7050-d596-4a07-a3d3-99b9ae613722', 'book', '2023-07-07', '1c4d8ee5-f861-458c-981b-5f12b08a9e04');
INSERT INTO orders(id, name, order_date, shipper_id) VALUES ('01f7bee8-13f0-40e5-9a7b-53c1d59d9500', 'smartphone', '2023-05-10', 'bd157c3c-93a1-47ac-b6c6-6b89784c4e4b');
INSERT INTO orders(id, name, order_date, shipper_id) VALUES ('8c095f68-324f-43d2-a228-e6bf60be933b','laptop', '2023-08-09', '5ea183fe-cca7-4924-9adf-1c200b8461c5');
INSERT INTO orders(id, name, order_date, shipper_id) VALUES ('9dce4eb9-f102-4154-adbf-2b8d22af962b', 'toy', '2023-08-09', '1c4d8ee5-f861-458c-981b-5f12b08a9e04');

INSERT INTO users(id, full_name, phone_number, email, birthday, order_id) VALUES ('3232dd53-45ea-41f6-aa92-5d5b5a0f7319', 'Иванов Пётр Александрович', '89009998881', 'invanov@mail.ru', '2000-09-12', 'd87c7050-d596-4a07-a3d3-99b9ae613722');
INSERT INTO users(id, full_name, phone_number, email, birthday, order_id) VALUES ('9f9771d4-00cc-45b9-99cd-9900983d3e19', 'Петров Иван Александрович', '89809998881', 'petrov@mail.ru', '2010-08-12', '01f7bee8-13f0-40e5-9a7b-53c1d59d9500');
INSERT INTO users(id, full_name, phone_number, email, birthday, order_id) VALUES ('437c6d18-afce-4355-a3df-4564e352abb9', 'Александров Юрий Анатольевич', '89209998881', 'alexandrov@mail.ru', '2001-07-12', '8c095f68-324f-43d2-a228-e6bf60be933b');
INSERT INTO users(id, full_name, phone_number, email, birthday, order_id) VALUES ('d01212ef-c565-483b-a151-bf3ac3168c6b', 'Пушкин Олег Юрьевич', '89000998881', 'pushkin@mail.ru', '2002-10-12', '9dce4eb9-f102-4154-adbf-2b8d22af962b');