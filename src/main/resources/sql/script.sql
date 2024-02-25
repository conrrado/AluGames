CREATE DATABASE alugames

CREATE TABLE jogos (
            id INT AUTO_INCREMENT PRIMARY KEY,
            capa VARCHAR(255),
            descricao VARCHAR(255),
            preco DOUBLE,
            titulo VARCHAR(100))

CREATE TABLE gamer (
            id INT AUTO_INCREMENT PRIMARY KEY,
            nome VARCHAR(255),
            email VARCHAR(255),
            aniversario VARCHAR(16),
            usuario VARCHAR(64))