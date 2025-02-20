CREATE DATABASE customerdb;

USE customerdb;

CREATE TABLE customer (
    id_customer INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    genre VARCHAR(50) NOT NULL,
    age INT NOT NULL,
    ci VARCHAR(50) NOT NULL,
    address VARCHAR(150) NOT NULL,
    telephone VARCHAR(10) NOT NULL,
    password VARCHAR(255) NOT NULL,
    state VARCHAR(50) NOT NULL
);