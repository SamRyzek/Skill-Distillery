/*
  This is an example of how you could write your schema to load into mysql
*/

-- This drops/creates the database, and uses it
DROP SCHEMA IF EXISTS `ngTodo`;
CREATE SCHEMA `ngTODO`;
USE `ngTODO`;

-- Create tables in dependency order
create table user(
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(100) NOT NULL UNIQUE,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`));

create table todo(
 `id` int(11) NOT NULL AUTO_INCREMENT,
 `task` varchar(255) NOT NULL DEFAULT '',
 `description` varchar(1000) NOT NULL DEFAULT '',
 `completed` tinyint(1) NOT NULL DEFAULT 0,
 `due_date` varchar(50),
 `complete_date` varchar(50),
 `user_id` int(11) NOT NULL,
 `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
 `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
 PRIMARY KEY(`id`),
 FOREIGN KEY (`user_id`) REFERENCES user (`id`));

-- Drop/create a user
DROP USER IF EXISTS 'todo'@'localhost';
CREATE USER 'todo'@'localhost' IDENTIFIED BY 'todo';
-- Set limited user permissions
GRANT SELECT, INSERT, UPDATE, DELETE ON `ngTodo`.* TO 'todo'@'localhost';

-- Insert test data
INSERT INTO user (email, password) VALUES ('test@test.com', 'test');

INSERT INTO todo (task, description, completed, user_id) VALUES
  ('Go round mums', 'Bring flowers', 0, 1),
  ('Get Liz Back', 'Book the place that does all the fish', 0, 1),
  ('Sort life out', 'It is a mess', 0, 1);
