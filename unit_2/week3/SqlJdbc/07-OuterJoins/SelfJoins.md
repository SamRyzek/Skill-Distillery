## Self Joins

* A self join queries a single table as though it were two separate tables.

  * Self joins are most frequently performed on tables that model hierarchical data, having foreign keys referencing back into the same table.

* To perform a self join just use two different aliases for the same table.

  ```sql
  SELECT emp.first_name, emp.last_name, sup.last_name
    FROM staff emp JOIN staff sup
                     ON emp.supervisor_id = sup.id
   ORDER BY sup.last_name, emp.last_name;
  ```

  * SQL treats the table as though it were two separate tables.

* You can self-join a table any number of times.

  ```sql
  SELECT emp.first_name, emp.last_name, sup.last_name, sup2.last_name
    FROM staff emp JOIN staff sup
                     ON emp.supervisor_id = sup.id
                   JOIN staff sup2
                     ON sup.supervisor_id = sup2.id
   ORDER BY sup2.last_name, sup.last_name, emp.last_name;
  ```

<hr>

[Prev](OuterJoins.md) | [Up](../README.md) | [Next](OtherJoins.md)
