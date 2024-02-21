CREATE DATABASE alugames

CREATE TABLE jogos (
            id INT AUTO_INCREMENT PRIMARY KEY,
            capa VARCHAR(255),
            descricao VARCHAR(255),
            preco DOUBLE,
            titulo VARCHAR(100))