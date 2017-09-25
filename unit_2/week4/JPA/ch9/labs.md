# Labs

* This final lab in the JPA section will have you write a number of request handlers in the `FilmController`, as well as add some supporting methods in the `FilmDAO`. The goal is to have functional MVC CRUD for the *Film* entity in addition to some additional functionality.

1: Implement the following handler method to present the user with a list of all films:

```java
@RequestMapping(path = "GetFilms.do", method = RequestMethod.GET)
public String index(Model model) {
  // TODO : implement this method
  return "film/index.jsp";
}
```

* Return a `index.jsp` which lists all films titles, and their descriptions.

* Hyperlink each title such that clicking on a film's title will direct through the `show` route and display that film's detail page.


2: Implement the following handler method to present the user with a form to create a new film:

```java
@RequestMapping(path = "NewFilm.do", method = RequestMethod.GET)
public String newFilm(Model model) {
  // TODO : implement this method
  return "film/new.jsp";
}
```

* All this method does is return a `new.jsp` file which contains a form to create a new *Film*.

* ***Note***: there is a constraint that the *language_id* cannot be *NULL*, you will need to create a *LanguageDAO* with an `index` method to forward a list of Languages to use in a drop down menu. Alternatively, you could just hard code all film's language as English for the time being (but you will still need a *LanguageDAO* to retrieve the language object)

* Add a link at the top of `index.jsp` to navigate to the this route.

3: Implement a route to perform the creation task when the *new* form is submitted:

* Be sure to modify your form in the `new.jsp` to use this action with a `POST` method.

```java
@RequestMapping(path = "CreateFilm.do", method = RequestMethod.POST)
public String create(Model model, /* @RequestParam */) {
  // TODO : implement this method
  return "film/show.jsp";
}
```

* ***Note***: we are forwarding to the `show.jsp` to display the details of the film that was just created.

4: Implement a route to display an edit form to the user:

* Add a link to *Edit* on your `show.jsp` for that specific film.

```java
@RequestMapping(path = "EditFilm.do", method = RequestMethod.GET)
public String edit(Model model, @RequestParam("id") int id) {
  // TODO : implement this method
  return "film/edit.jsp";
}
```

* You will return an edit form on `edit.jsp`

* populate the form with data from the film you wish to edit (find it with your DAO)

* The action for the form should be `UpdateFilm.do`, and the method is `POST`

5: Implement a route to update a film and return the user to the films detail page:

```java
@RequestMapping(path = "UpdateFilm.do", method = RequestMethod.POST)
public String update(Model model, @RequestParam("fid") int fid) {
  // TODO : implement this method
  return "film/show.jsp";
}
```

* Don't forget to include the *Film* entities id, so that you can retrieve the managed entity.

6: Implement a route to delete a film and return the user to the list of all films:

```java
@RequestMapping(path = "DestroyFilm.do", method = RequestMethod.POST)
public String destroy(Model model, @RequestParam("fid") int fid) {
  // TODO : implement this method
  return "film/index.jsp";
}
```

* add a *Delete* button to the `show.jsp`

* be sure to add all of the films to model before sending it back to the `index.jsp`

7: Update your `show.jsp` to list all of the actors in a film as well as the title and description.

* You may (and should) experience a *LazyInitializationException* when you try to access the list of *Actor* entities. There are two ways to fix this. Either add a `FetchType.EAGER` to the association, or create a new DAO method which uses a join fetch to extract the list of actors. The former is easier, the latter is better for performance.

8: Implement the following FilmDAO method:

* `public List<Film> searchForFilmByTitle(String search);`

* Search for films with titles similar to the provided text.

9: Implement a route to search for a film by it's title:

```java
@RequestMapping(path = "SearchFilm.do", method = RequestMethod.POST)
public String search(Model model, @RequestParam("search") String search) {
  // TODO : implement this method
  return "film/index.jsp";
}
```

* You will need to use a wildcard search with a parameter to do this effectively and safely. In JPQL, use parameterized values with the SQL `LIKE` keyword as follows:

```sql
LIKE :parameter
```

* You will be returning the results to your `index.jsp` which already knows how to display a list of films.



[Previous](servlet_xml.md) | [Back to ToC](../README.md)
