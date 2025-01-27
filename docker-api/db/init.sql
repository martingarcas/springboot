-- Crear la base de datos
CREATE DATABASE IF NOT EXISTS `project-docker`;

-- Usar la base de datos
USE `project-docker`;

-- Crear la tabla products
CREATE TABLE IF NOT EXISTS products (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL UNIQUE,
    price DECIMAL NOT NULL,
    quantity INTEGER NOT NULL
);

-- Insertar datos en la tabla products
INSERT INTO products VALUES (null, "product1", 5.99, 1);
INSERT INTO products VALUES (null, "product2", 7.99, 2);
INSERT INTO products VALUES (null, "product3", 2.99, 3);
INSERT INTO products VALUES (null, "product4", 10.99, 3);
INSERT INTO products VALUES (null, "product5", 8.99, 8);
INSERT INTO products VALUES (null, "product6", 5.99, 10);
