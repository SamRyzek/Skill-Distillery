## Lab - ORM for DML

### Objectives

* Implement DAO methods for creating, updating, and deleting records.

* Implement a full-stack, database-backed Spring MVC web application that allows full CRUD operations.

### Starter Files

* Start with your working [ORM Bind Variables lab](02-Lab-BindVariables.md) solution, which retrieves film titles by ID or keyword using queries with bind variables.

### Instructions

* Implement an `addFilm()` method that takes a `Film` object and inserts it into the database.  It should return the `Film` object, or `null` if the insert fails.

* Add an "Add New Film" link to your home page that links to a "New Film" form with fields to input film attributes. For now, don't worry about language (just hardcode the id for 'English' in your DAO code), categories, or actors.

  Implement a new controller method mapped to your new form's `action`.  It should call your DAO's `addFilm()`, and send the result back to your home page which should display the added film.

* Modify `addFilm()` so it retrieves the ID of the newly-inserted `film` object, and assigns it to the original `Film` object before returning it.

* Make sure your existing `Film` class and DAO film query methods so they include `film.id` in their SELECTs, and include the id as an attribute in the returned `Film` objects.

* Modify the query result display in your JSP to include, for each film, it includes a link to remove the film, including the film's ID in the link.

* Implement `deleteFilm()` in your DAO, and add a controller method to connect it all together.

* Implement a film update operation.

[Prev](deleting.md) | [Up](../README.md)
