# Labs
1: Add `@GeneratedValue` to the `id` field of the following *Entities*:  

  * *Language*

  * *Film*

  * *Address*

  * *Staff*

2: Build *JUnit* test cases to ensure that mappings are correct for:
  * *Language*

  * *Film*

  * *Address*

  * *Staff*

3: Create a *Rental* entity.  

* Map the following:
  * id

  * rentalDate

  * returnDate  

Here is the _rental_ table for reference:  

```
+--------------+------------------+------+-----+---------+----------------+
| Field        | Type             | Null | Key | Default | Extra          |
+--------------+------------------+------+-----+---------+----------------+
| id           | int(11)          | NO   | PRI | NULL    | auto_increment |
| rental_date  | datetime         | NO   | MUL | NULL    |                |
| inventory_id | int(10) unsigned | NO   | MUL | NULL    |                |
| customer_id  | int(10) unsigned | NO   | MUL | NULL    |                |
| return_date  | datetime         | YES  |     | NULL    |                |
| staff_id     | int(10) unsigned | NO   | MUL | NULL    |                |
+--------------+------------------+------+-----+---------+----------------+
```

4: Create *JUnit* test cases for *Rental* to check that it's mappings are successful.  

* If you are getting a failed test, check the console to see why it is failing.

  * What could : `Caused by: org.hibernate.UnknownEntityTypeException` be indicating?

[Previous](enumerated.md) | [Next](../ch3)
