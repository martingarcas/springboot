-- Crear la base de datos
CREATE DATABASE IF NOT EXISTS project-docker;

-- Usar la base de datos
USE project-docker;

-- Crear la tabla users
CREATE TABLE IF NOT EXISTS products (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL UNIQUE,
    price DECIMAL NOT NULL,
	quantity INTEGER NOT NULL
);

-- Insertar datos en la tabla users
insert into products values (null, "product1", 5.99, 1);
insert into products values (null, "product2", 7.99, 2);
insert into products values (null, "product3", 2.99, 3);
insert into products values (null, "product4", 10.99, 3);
insert into products values (null, "product5", 8.99, 8);
insert into products values (null, "product6", 5.99, 10);