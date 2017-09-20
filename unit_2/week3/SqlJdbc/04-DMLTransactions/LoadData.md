## Loading Data from External Sources

* Most RDBMS provide statements or utilities that allow you to load bulk data from external files.

* The MySQL `LOAD DATA` command loads a file into a table according to the format and other options specified.
  * The `INFILE` parameter specifies the filename.
    * By default this refers to a file on the MySQL server host, with the path relative to MySQL's data directory.
    * Use `LOCAL INFILE` to specify a file relative to the location from which you're running the mysql client.

* The `mysqlimport` utility loads rows into a table from external data files.
  * The name of the datafile determines which table the data will load.
  * Command-line options specify the file's format, following the syntax of `LOAD DATA`.

* The mysqldump utility exports a database's table definitions and/or data, which you can redirect to a file.

  ```bash
  mysqldump mydb > mydbdump.sql
  ```

  * The dump contains standard SQL commands to create and insert data into the dumped tables; you can run this as a script using mysql.

    ```bash
    mysql -u someuser -p < mydbdump.sql
    ```

<hr>

MySQL provides a DML command, `LOAD DATA`, for loading rows into a table from an external source.  LOAD DATA can load data files, parsing records (according to your specifications) into values of the correct types for your table's columns using whatever delimiters are used in the file.

_empdata.txt_
```csv
LNAME, FNAME, ADDRID, STORENUM, USERID
"Tsang","Leila",1,2,ltsang
"Sierra","Lisa",1,6,lsierra
"Happ","Bill",4,1,bhapp
"Garia","Pete",1,5,pgaria
"Ehrlich","Donna",1,4,dehrlich
"Clemens","Edith",1,8,eclemens
"Gonzales","Pamela",1,1,pgonzales
"Merlick","Mary",1,6,mmerlick
"Hausuarde von Ausfernschplendenschliptercrasscren","Keith",1,6,khausuar
"Sierra","Lance",1,4,lsierra
"Plank","Scott",1,2,splank
"Minor","Sammy",1,8,sminor
```

Use `LOAD DATA` to parse and load this into the employees table:
```sql
LOAD DATA
  LOCAL INFILE 'empdata.txt'
  IGNORE
  INTO TABLE staff
  FIELDS TERMINATED BY ','
  OPTIONALLY ENCLOSED BY '"'
  IGNORE 1 LINES
  (last_name, first_name, address_id, store_id, username)
  SET password=PASSWORD(username);
```
You may see messages about skipped records and warnings - run SHOW WARNINGS immediately after the LOAD DATA command to see the details (warnings are reset for each new SQL command).
```sql
show warnings;
```

[Prev](Concurrency.md) | [Up](../README.md) | [Next](Lab.md)
