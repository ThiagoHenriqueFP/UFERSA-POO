DROP DATABASE IF EXISTS pizzaria;

CREATE DATABASE IF NOT EXISTS pizzaria;
USE pizzaria;

CREATE TABLE IF NOT EXISTS storage (
	id INTEGER NOT NULL auto_increment primary key,
    name varchar(45) not null,
    value double not null,
    amount integer not null
);

CREATE TABLE IF NOT EXISTS pizza (
	id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(40) NOT NULL,
    value DOUBLE NOT NULL,
    storage_id INTEGER NOT NULL REFERENCES pizzaria.storage
);

CREATE TABLE client (
	id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(40) NOT NULL,
    cpf VARCHAR(20) NOT NULL,
    address VARCHAR(100)
);

CREATE TABLE solicitation (
	id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    size VARCHAR(1) NOT NULL DEFAULT 'P',
    state VARCHAR(45) NOT NULL DEFAULT "Preparando",
    value DOUBLE NOT NULL,
    additional VARCHAR(45),
    created_at DATE NOT NULL DEFAULT (CURRENT_DATE),
    pizza VARCHAR(45) NOT NULL,
    client VARCHAR(45) NOT NULL,
    storage_id INTEGER NOT NULL REFERENCES pizzaria.storage
);