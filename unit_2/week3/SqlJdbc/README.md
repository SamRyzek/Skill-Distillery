## Introduction to SQL and JDBC

Relational Databases (sometimes called SQL Databases) remain the predominant data storage mechanisms for commercial applications of all kinds.  Proficiency with the SQL language is a must-have skill for any application developer.   In Java, we can use the JDBC (Java Data Base Connectivity) API to run SQL commands from our application code.

Relational Databases are implemented by Relational Database Management Systems (RDBMS).  Important commercial RDBMSs include [Oracle Database](https://docs.oracle.com/database/122/nav/development.htm), IBM [DB2](http://www.ibm.com/analytics/us/en/technology/db2/), and Microsoft [SQL Server](https://www.microsoft.com/en-cy/sql-server/sql-server-2016).  Important open-source implementations include [MySQL](https://www.mysql.com/) and its clone [MariaDB](https://mariadb.org/), [PostgreSQL](https://www.postgresql.org/), the embedded DBMS [SQLite](https://sqlite.org/).

We'll use MySQL, a key component of AMP (Apache/MySQL/PHP) stack web platforms.  Before we can start we need to set up our example database: 

[Load the Sample Data](00-LoadSchema.md)

### Topics

* [SQL Queries - The SELECT Statement](01-BasicQueries/README.md)
* [SQL Queries - Predicates and Functions](02-Predicates/README.md)
* [Introduction to JDBC](03-JDBCIntro/README.md)
* [Data Manipulation and Transactions](04-DMLTransactions/README.md)
* [JDBC SQL Programming](05-JDBCProgramming/README.md)
* [SQL Queries - Joins](06-Joins/README.md)
* [SQL Queries - Outer, Self, and Other Joins](07-OuterJoins/README.md)
* [Subqueries and Aggregate Functions](08-Aggregates/README.md)

[Next](01-BasicQueries/README.md)
