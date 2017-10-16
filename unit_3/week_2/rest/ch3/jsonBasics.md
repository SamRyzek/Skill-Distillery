## Labs

API's respond with json representations of data. Including the Jackson jars, which we discussed earlier, automatically map returned Java objects to json or primitive types to a string representation.

1: Open the project we configured with ping/pong, MyFirstRestProject.

2: Create a package called data.  
* Create a User class.
* A User should have a name, username, email, and password.
* Create all the appropriate gets and sets for these fields.

3: Add the jackson jars to your build.gradle.  

```xml
compile group: 'com.fasterxml.jackson.core', name: 'jackson-core', version: '2.8.5'
compile group: 'com.fasterxml.jackson.core', name: 'jackson-databind', version: '2.8.5'
```

* The the jackson jars use these gets and sets to generate the json so if they aren't included, your program will fail.

4: In the controller create another method getUser(). Assign the URL `/users` path to this method using `@RequestMapping`. Inside of the methods instantiate a new instance of a User and return the created object.

```Java
@RequestMapping(path = "users", method = RequestMethod.GET)
public User getUser(){
  return new User("Andrew", "ACConlin", "andrew@mail.com", "wombat1");
}
```

5: In the browser or postman hit the URL `localhost:8080/api/users`. You should get the json representation of the User object as a response. If you are getting errors make sure you have properly included all gets and sets in the User class and included both Jackson jars in your `build.gradle`.

```json
{"name":"Andrew", "username" : "ACConlin", "email":"anrew@mail.com", "password":"wombat1"}
```

[Previous](responding_with_json.md) | [Next](pojoTojsonAndBack.md)
