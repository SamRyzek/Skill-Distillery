## SQL Cheatsheet
This is a quick reference you can use when creating your `User` table in MySQL.

### Comments
* SQL has comments. The syntax for which is as follows:

```sql
-- single line comments are preceded by two hyphens

/*
  Multi-line comments
  are contained between
  slashes and asterisks
*/
```

### Create / Login / Access Database
* Log into MySQL from your terminal:  

```bash
mysql -u root -p
```

* When prompted, enter your password

* If you do not yet have a database to use, you can create one with the `CREATE DATABASE` command:

```sql
CREATE DATABASE quizdb;
```

* Use the `SHOW DATABASES;` command to list all databases, you should see your database listed there.

* Now select your quiz database for use:

```sql
USE quizdb;
```

### Table Creation
* **NOTE:** Creating and maintaining tables in command line is fairly simple, the biggest stumbling block is usually simple syntax mistakes. To best avoid these mistakes, don't be afraid to use a text editor like Atom, which will give you syntax highlighting and allow you to edit your table on the fly. Once you have your table just the way you want it, you can copy and past it into the terminal and it will execute just as if you had written it there to begin with.

* To create a table in MySQL use the `CREATE TABLE` command, followed by the table name between 'back-ticks' and an opening and closing parentheses:

```sql
CREATE TABLE `user` (
  -- schema definitions
);
```

* Between the parentheses, you will define the schema for your table. Let's begin by adding an auto-generated id. In MySQL tables can only have one auto-generated column and it must be defined as a key:

```sql
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
);
```

* The SQL statement above creates a table named `user`, with a single column. The `id` column will be an integer not greater than 11 digits in length, must not be `NULL`, and will be automatically incremented by MySQL (ensuring uniqueness). The `PRIMARY KEY ( )` identifier let's MySQL know that the primary key for this table will the `id` value. Traditionally the `PRIMARY KEY` and any `FOREIGN KEY` declarations are the last schema definitions in a table.

* Additional columns can be added easily to your schema by appropriate type. Usually you will use `int(#)` and `varchar(#)` types for things like numbers and text. Should you be required to store a boolean you can do so with the `tinyint(1)` type.

```sql
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL UNIQUE,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
);
```

* We have added two new columns to the table, `username` and `password` both are fairly straight-forward except for two things of note:

  * `UNIQUE` is a constraint which can be added to fields in MySQL tables. When attempting to create or modify a column marked as `UNIQUE` to a value which already exists within the table, SQL with throw an exception. This is beneficial as the resulting exception can be caught and handled.

  * `password varchar(255) NOT NULL`: 255 characters is longer then the average persons password, the reason we allocate this much room for a password is because we will not ultimately be storing plain text passwords, but rather thoroughly encrypted ones. For example, the word 'banana' would become `$2a$11$NDULn9hUIrwYP9eZ5VGbEedD5HXyAargbkyjoIrVeVJSq3hoimU7m` when encrypted using the bCrypt algorithm.


### Altering Tables
* If you had already created the `user` table and wished to add or remove columns from it (without dropping it first), you may do so with the `ALTER TABLE` command:

```sql
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
);
```

```sql
ALTER TABLE `user` ADD COLUMN `username` varchar(30) NOT NULL UNIQUE;
ALTER TABLE `user` ADD COLUMN `password` varchar(255) NOT NULL;
ALTER TABLE `user` ADD COLUMN `email` varchar(30) NOT NULL UNIQUE;
```

* OH NO! We added an `email` column by mistake...luckily we can use `ALTER TABLE` to drop columns as well:

```sql
ALTER TABLE `user` DROP COLUMN `email`;
```

### Foreign Keys
* Establishing foreign key relationships between tables is easy with the `FOREIGN KEY ... REFERENCES ...` command. For the following example, we will create a hypothetical table that has a foreign key dependency to the `user` table created previously.

```sql
CREATE TABLE `todo` (
      `id` int(11) NOT NULL AUTO_INCREMENT,
      `title` varchar(255) NOT NULL,
      `user_id` int(11) NOT NULL,
      PRIMARY KEY (`id`),
      FOREIGN KEY (`user_id`)
            REFERENCES `user` (`id`)
);
```

* **ALTERNATIVELY** You can add a foreign key after the fact by use the `ALTER TABLE` command:

```sql
ALTER TABLE `todo` ADD FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
```


### Seeding Some Data
* Last but not least, for testing purposes it can be useful to add some simple test data and run some queries. Use the `INSERT (...) VALUES (...);` command to seed data:

```sql
INSERT INTO `user` (username,password) VALUES ('test', 'test');
INSERT INTO `todo` (title,user_id) VALUES ('test_todo', 1);
```

### Creating a SQL User and Granting permissions

```sql
CREATE user 'student'@'localhost' IDENTIFIED BY  'student';
GRANT ALL PRIVILEGES ON quizdb.* TO 'student'@'localhost';
```

[mySQLDocs]:http://dev.mysql.com/doc/
