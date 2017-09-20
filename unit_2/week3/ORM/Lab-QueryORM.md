## Lab - ORM for Retrieval

### Objectives

* Map retrieved database data into simple application objects.

* Implement a full-stack, database-backed Spring MVC web application that performs queries.

### Starter Files

* Start with your working [MVCFilmSite](../MVCFilmSite/Lab.md) application, which retrieves film titles by ID or keyword.

### Instructions

* Define a `Film` class with attributes that map to the columns of the `film` table.  Use appropriate datatypes and Java naming conventions.

* Modify your existing DAO query methods so than instead of returning `String`s or `List<String>` or `List<List<String>>`, they return `Film` or `List<Film>`.  Update your controller and JSP code to use the returned objects.

* Define an `Actor` class with id, first name, and last name fields.  Include the usual getters, setters, toString, etc (of course!), and appropriate constructor(s).

* Modify your `Film` class to include a list of actors.  When a film is retrieved from the database, its actors are also retrieve and included in the `Film` object.

* Update your existing code so when a film is displayed, its cast also displays.

* Make sure your DAO code uses bind variables instead of concatenating values into SQL strings.

<hr>

[Prev](nestedRetrieval.md) | [Up](../README.md) | [Next](creation.md)
