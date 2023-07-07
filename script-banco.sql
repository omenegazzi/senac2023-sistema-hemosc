CREATE DATABASE db_hemosc;
use db_hemosc;

CREATE TABLE login(
usuario VARCHAR(30) NOT NULL,
senha VARCHAR(30) NOT NULL,
PRIMARY KEY (usuario)
);
