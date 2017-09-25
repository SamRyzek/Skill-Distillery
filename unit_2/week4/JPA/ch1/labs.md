# Labs

* ***NOTE:*** The following exercises ask you to build entities for some of your SQL tables. Not every column will have a corresponding field in the Entity after this lab. That is totally fine and will not cause any problems.

1: Create an *Address* entity.  

* Add the following fields and map them to the corresponding database columns:

  * id

  * street

  * street2

  * state

  * city

  * postalCode

  * phone

The _address_ table looks like this:  

```
+----------------+------------------+------+-----+---------+----------------+
| Field          | Type             | Null | Key | Default | Extra          |
+----------------+------------------+------+-----+---------+----------------+
| id             | int(10) unsigned | NO   | PRI | NULL    | auto_increment |
| address        | varchar(50)      | NO   |     | NULL    |                |
| address2       | varchar(50)      | YES  |     | NULL    |                |
| city           | varchar(50)      | NO   |     | NULL    |                |
| state_province | varchar(20)      | NO   |     | NULL    |                |
| postal_code    | varchar(10)      | YES  |     | NULL    |                |
| country_code   | char(2)          | YES  | MUL | NULL    |                |
| phone          | varchar(20)      | NO   |     | NULL    |                |
+----------------+------------------+------+-----+---------+----------------+
```

* Add gets/sets and a `toString()` implementation.  

* Remember to add *Address* to your *persistence.xml*

2: Create a new file AddressTest.java in your client package

* Add a `main()` method that does a `find()` to retrieve the *Address* entity with primary key `5`.  

* Print out some of its properties.

* From here on out, for each entity you create, add gets/sets and a `toString()`.

3: Create a *Staff* entity.  

* Map the fields to their corresponding columns:

  * id

  * firstName

  * lastName

  * email

The _staff_ table looks like this:

```
+---------------+----------------------+------+-----+---------+----------------+
| Field         | Type                 | Null | Key | Default | Extra          |
+---------------+----------------------+------+-----+---------+----------------+
| id            | int(10) unsigned     | NO   | PRI | NULL    | auto_increment |
| first_name    | varchar(45)          | NO   |     | NULL    |                |
| last_name     | varchar(45)          | NO   |     | NULL    |                |
| address_id    | int(10) unsigned     | NO   | MUL | NULL    |                |
| email         | varchar(50)          | YES  |     | NULL    |                |
| store_id      | smallint(5) unsigned | NO   | MUL | NULL    |                |
| supervisor_id | int(10) unsigned     | YES  | MUL | NULL    |                |
| active        | tinyint(1)           | NO   |     | 1       |                |
| username      | varchar(16)          | YES  | UNI | NULL    |                |
| password      | varchar(41)          | YES  |     | NULL    |                |
+---------------+----------------------+------+-----+---------+----------------+
```

* Remember to add *Staff* to your *persistence.xml*

4: Create a *Language* entity with mapped fields for:  

  * id

  * name

The _language_ table looks like this:  

```
+-------+----------------------+------+-----+---------+----------------+
| Field | Type                 | Null | Key | Default | Extra          |
+-------+----------------------+------+-----+---------+----------------+
| id    | smallint(5) unsigned | NO   | PRI | NULL    | auto_increment |
| name  | char(20)             | NO   |     | NULL    |                |
+-------+----------------------+------+-----+---------+----------------+
```

* Remember to add *Language* to your *persistence.xml*

5: Create a *Film* entity.  

* Map the following fields to their corresponding columns:

  * id

  * title

  * description

  * releaseYear

  * rentalRate

  * length

  * replacementCost

The _film_ table looks like this:

```
+------------------+---------------------------------------------------------------------+------+-----+---------+----------------+
| Field            | Type                                                                | Null | Key | Default | Extra          |
+------------------+---------------------------------------------------------------------+------+-----+---------+----------------+
| id               | int(10) unsigned                                                    | NO   | PRI | NULL    | auto_increment |
| title            | varchar(255)                                                        | NO   | MUL | NULL    |                |
| description      | text                                                                | YES  |     | NULL    |                |
| release_year     | year(4)                                                             | YES  |     | NULL    |                |
| language_id      | smallint(5) unsigned                                                | NO   | MUL | NULL    |                |
| rental_duration  | tinyint(3) unsigned                                                 | NO   |     | 3       |                |
| rental_rate      | decimal(4,2)                                                        | NO   |     | 4.99    |                |
| length           | smallint(5) unsigned                                                | YES  |     | NULL    |                |
| replacement_cost | decimal(5,2)                                                        | NO   |     | 19.99   |                |
| rating           | enum('G','PG','PG13','R','NC17')                                    | YES  |     | G       |                |
| special_features | set('Trailers','Commentaries','Deleted Scenes','Behind the Scenes') | YES  |     | NULL    |                |
+------------------+---------------------------------------------------------------------+------+-----+---------+----------------+
```
* Remember to add *Film* to your *persistence.xml*


* For the *releaseYear* and *length*, use `int` as the data type. For the *rentalRate* and *replacementCost*, use a `double`.

[Previous](persistence_xml.md) | [Next](../ch2)
