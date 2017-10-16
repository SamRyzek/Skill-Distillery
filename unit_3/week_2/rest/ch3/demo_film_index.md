## Walkthrough

Lets try to add a route to retrieve a collection of films from out database.  

1: Create a FilmDAO.java and FilmController.java files.  

2: Annotate them properly and add a bean for the FilmDAO to your -servlet.xml file.  

3: Create a method in your DAO that selects all the films in your database.  
```java
public List<Film> index(){
  String query = "Select f from Film f";
  return em.createQuery(query, Film.class).getResultList();
}
```

4: Create a controller method called index that has the mapping of `/api/films`, and calls the filmDAO method.
```java
@RequestMapping(path="films", method=RequestMethod.GET)
public List<Film> index(){
  return filmDAO.index();
}
```

5: Hit that route using postman, you should see an error.  
`failed to lazily initialize a collection of role: entities.Language.films`  

6: We need to add `fetch = FetchType.EAGER` to the Language entities film `@OneToMany` field.  

7: If you hit the route again your program will hang. This is because Films have a collection of Languages which have a collection of Films. We have json recursion and need to annotate these two entities using `@JsonBackReference` and `	@JsonManagedReference`.  

* In order to do this you will need to import the library of these annotations into your JPA project. Add this gradle dependency to your `build.gradle`.
```groovy
compile group: 'com.fasterxml.jackson.core', name: 'jackson-annotations', version: '2.8.5'
```

8: These same errors are going to happen with all the Lists in the Film class. Do the same process with the list of actors, add the eager fetching and `@JsonBackReference` and `	@JsonManagedReference` annotations. Instead of doing this for categories, stores, and inventoryItems, add an `@JsonIgnore` to these fields. We will just omit them from our returning json.

9: Run the program and hit the route `http://localhost:8080/VideoStoreREST/api/films`. You should get an array of json film objects.

[Previous](negating_recursive_json.md) | [Next](../ch4/README.md)
