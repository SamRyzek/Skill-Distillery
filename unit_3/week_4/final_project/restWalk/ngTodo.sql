/*
  Drop / Create DB
*/
DROP DATABASE IF EXISTS `todo`;
CREATE DATABASE `todo`;
USE `todo`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(100) NOT NULL UNIQUE,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY(`id`));

CREATE TABLE `todo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  FOREIGN KEY (`user_id`)
    REFERENCES user (`id`),
  PRIMARY KEY (`id`)
);

INSERT INTO user (email, password) VALUES
  ('a','p'),
  ('b','p'),
  ('c','p'),
  ('d','p'),
  ('e','p'),
  ('f','p'),
  ('g','p');

DROP User IF EXISTS 'todouser'@'localhost';
CREATE User 'todouser'@'localhost' IDENTIFIED BY 'todo';
GRANT SELECT,INSERT,DELETE,UPDATE ON `todo`.* TO 'todouser'@'localhost';
