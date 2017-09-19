### Week 3 - Persistence with SQL and JDBC

Monday:   Mysql/SQL [MAMP](MAMP/README.md), [SqlJdbc](SqlJdbc/README.md) - Basic Queries, Predicates and Functions

Tuesday:   [SqlJdbc](SqlJdbc/README.md) - JDBC Introduction, [MVCFilmSite](MVCFilmSite/README.md), [ORM](ORM/README.md)

Wednesday: [SqlJdbc](SqlJdbc/README.md) - DML/More JDBC, [ORM](ORM/README.md)

Thursday: [SqlJdbc](SqlJdbc/README.md) - Joins,  [continue ORM DML Lab](ORM/02-Lab-DML.md)

Friday: DDL and Database design

Homework: Film CRUD

#### Learning Objectives

* Install MySQL locally on your system as part of the MAMP (Mac/Apache/MySQL/P-languages) solution stack
* Use SQL to write both simple and join queries, and to perform Data Manipulation Language (DML) operations.
* Use JDBC to access SQL data from Java code.
* Integrate JDBC/SQL with a Spring/MVC aqpplication.

#### New Technologies
Relational Databases (sometimes called SQL Databases) remain the predominant data storage mechanisms for commercial applications of all kinds.  Proficiency with the SQL language is a must-have skill for any application developer.   In Java, we can use the JDBC (Java Data Base Connectivity) API to run SQL commands from our application code.

Eventually, we'll need to relate Java objects to the relational database records that persist their state.  One mechanism for this is to create a Data Access Ojbect whose methods intercede between Java and the database.  As part of this we my define classes for Object-Relational Mapping or ORM.
