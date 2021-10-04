CREATE DATABASE IF NOT EXISTS org;
USE org;
CREATE TABLE IF NOT EXISTS `organization` (
    Id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100)
) ENGINE=InnoDB;
CREATE TABLE IF NOT EXISTS `user` (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    password VARCHAR (20)
) ENGINE=InnoDB;
