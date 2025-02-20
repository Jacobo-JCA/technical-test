CREATE DATABASE accountdb;;

USE accountdb;

CREATE TABLE account (
    id INT AUTO_INCREMENT PRIMARY KEY,
    account_number VARCHAR(20) UNIQUE NOT NULL,
    account_type VARCHAR(50),
    balance DECIMAL(10, 2) DEFAULT 0,
    account_status BOOLEAN DEFAULT TRUE
);

CREATE TABLE movement (
    id INT AUTO_INCREMENT PRIMARY KEY,
    date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    account_id INT,
    movement_type VARCHAR(50),
    value DECIMAL(10, 2),
    balance_before DECIMAL(10, 2),
    balance_after DECIMAL(10, 2),
    FOREIGN KEY (account_id) REFERENCES account(id)
);

