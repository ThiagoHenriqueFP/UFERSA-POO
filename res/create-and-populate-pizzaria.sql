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
    storage_id INT NOT NULL REFERENCES pizzaria.storage
);

CREATE TABLE additionals (
	id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(40) NOT NULL,
    value DOUBLE NOT NULL,
    storage_id INT NOT NULL REFERENCES pizzaria.storage
);

CREATE TABLE client (
	id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(40) NOT NULL,
    address VARCHAR(100)
);

ALTER TABLE client ADD cpf varchar (15);

CREATE TABLE solicitation (
	id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    size CHAR DEFAULT 'G',
    state VARCHAR(15) DEFAULT 'fazendo',
    value DOUBLE NOT NULL,
    created_at DATE,
    pizza_id INTEGER NOT NULL REFERENCES pizzaria.pizza,
    client_id INTEGER NOT NULL REFERENCES pizzaria.client,
    additionals_id INTEGER REFERENCES pizzaria.additionals
);

INSERT INTO client (name, cpf, address) values ('dudu', '000.168.273-00', 'R. Vicente Fernandes, 54 - Nova Betânia, portão preto');

INSERT INTO storage (name, value, amount) VALUES ('calabresa', 30, 400);
INSERT INTO storage (name, value, amount) VALUES ('catupiry', 3, 100);

INSERT INTO pizza (name, value, storage_id) values (
'calabrisa',
(select value from storage where name='calabresa'),
(select id from storage where name='calabresa')
);

INSERT INTO additionals (name, value, storage_id) VALUES (
	'catupiry',
    (SELECT value FROM pizzaria.storage WHERE name='catupiry'),
    (SELECT id FROM pizzaria.storage WHERE name='catupiry')
);

INSERT INTO solicitation (size, value, created_at, pizza_id, client_id, additionals_id) VALUES (
	'G',
    45, 
    curdate(),
    1,
    1,
    1
);

SELECT * FROM solicitation;