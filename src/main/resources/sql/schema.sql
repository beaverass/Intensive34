CREATE TABLE IF NOT EXISTS shippers (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    phone_number VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS orders (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    order_date DATE NOT NULL,
    shipper_id INT,
    FOREIGN KEY (shipper_id) REFERENCES shippers(id)
);

CREATE TABLE IF NOT EXISTS users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    full_name VARCHAR(255) NOT NULL,
    phone_number VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    birthday DATE NOT NULL,
    order_id INT,
    FOREIGN KEY (order_id) REFERENCES orders(id)
);


INSERT INTO shippers (name, phone_number) VALUES ('СДЭК', '89607865431');
INSERT INTO shippers (name, phone_number) VALUES ('Почта России', '89605675431');
INSERT INTO shippers (name, phone_number) VALUES ('Пони Экспресс', '89705675431');

INSERT INTO orders(name, order_date, shipper_id) VALUES ('book', '2023-07-07', 1);
INSERT INTO orders(name, order_date, shipper_id) VALUES ('smartphone', '2023-05-10', 2);
INSERT INTO orders(name, order_date, shipper_id) VALUES ('laptop', '2023-08-09', 3);
INSERT INTO orders(name, order_date, shipper_id) VALUES ('toy', '2023-08-09', 1);

INSERT INTO users(full_name, phone_number, email, birthday, order_id) VALUES ('Иванов Пётр Александрович', '89009998881', 'invanov@mail.ru', '2000-09-12', 4);
INSERT INTO users(full_name, phone_number, email, birthday, order_id) VALUES ('Петров Иван Александрович', '89809998881', 'petrov@mail.ru', '2010-08-12', 5);
INSERT INTO users(full_name, phone_number, email, birthday, order_id) VALUES ('Александров Юрий Анатольевич', '89209998881', 'alexandrov@mail.ru', '2001-07-12', 6);
INSERT INTO users(full_name, phone_number, email, birthday, order_id) VALUES ('Пушкин Олег Юрьевич', '89000998881', 'pushkin@mail.ru', '2002-10-12', 7);