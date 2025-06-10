CREATE DATABASE IF NOT EXISTS neoflex;
USE neoflex;

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL
);

CREATE TABLE movies (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    genre VARCHAR(100) NOT NULL,
    rating DOUBLE NOT NULL
);

INSERT INTO movies (title, genre, rating) VALUES
('The Conjuring', 'horror', 8.2),
('Annabelle', 'horror', 7.5),
('Avengers: Endgame', 'action', 9.0),
('John Wick', 'action', 8.7),
('The Hangover', 'comedy', 8.0),
('Superbad', 'comedy', 7.6);
