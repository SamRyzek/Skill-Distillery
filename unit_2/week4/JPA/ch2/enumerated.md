# `@Enumerated`

* You may want to map a particular database column onto a Java *enum*. 

  * For example, a *gender* column would have a small number of allowable values.

* By default, JPA will attempt to store the ordinal value for your *enum* into the database.

  * The ordinal value is a zero based incrementing number where the first value in your *enum* is zero, the second is one, and so on.

* Most of the time it would be better to store the actual *enum* name, instead.

  * Annotate your field (not the *enum* itself) with `@Enumerated(EnumType.STRING)` to override the default ordinal behavior.

```java
@Enumerated(EnumType.STRING)
private Gender gender;
```
  
### Hands On:
1: Create a new enum called *Rating* in the *entities* package and add the following values: 
  * G
  * PG
  * PG13
  * R
  * NC17

* Next, modify your *Film* entity and add a new field for the film’s rating. 

* Don’t forget to annotate the field with `@Enumerated`. 

* Also, generate get/set methods.
  
For reference, here is the _film_ table:  

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

2: Modify your *FilmTest* class, write a test called `films_have_ratings` which ensures that a given film has the expected rating.

* Don't forget, the returned value your are testing for will be an *enum*...not a *String*.

[Previous](temporal.md) | [Next](labs.md)
