## POJO to JSON and back

### POJO To JSON

* By Default, the  `@ResponseBody` and `@Controller` annotations will look for the Jackson-Databind Library in the  `build.gradle`. If it finds the library it will convert the POJO to it's JSON representation.

  * *It accomplishes this conversion by using the public 'getters' on the Java class to return values. It then removes the 'get' and uses the method name as the key for the value*

* You don't have to return JSON however. Some REST API's deal with XML or a number of other formats. You can find a full list of returnable `MediaType`s here  [here](http://docs.oracle.com/javaee/7/api/javax/ws/rs/core/MediaType.html).

* We know `@ResponseBody` will return JSON by default, but what about going back to a Java Object from JSON sent in the Request Body?  

* If we define a `User` class in Java like so:

```java
    public class User{
      private String name;
      private String email;
      private int age;

      //Getters + Setters
    }
```

* The JSON representation of an instance of this class would look like this:
```java
Person kris = new Person("Kris", "kkane@gmail.com", 28);
```

```json
    {"name":"Kris","email":"kkane@gmail.com","age":28}
```

### JSON To POJO

* Assume that we had a web page that would take in the necessary information to construct a new User object, in this case a *name*, *email*, and *age*. We can use a class called `ObjectMapper` to **map** the JSON fields to the Java object field.

* We would use syntax like this to use the `ObjectMapper` class defined in the Jackson library:

```java
    ObjectMapper mapper = new ObjectMapper();
    User user = mapper.readValue(UserJSONString, User.class);
```

* Where would we get the json String from?
In order to have access to the json, we need to access the requests body. We can use Spring's `@RequestBody` annotation. This annotation injects a String representation of the json content sent in the body into a defined variable. The following is an example of a POST request where we access the body.

```java
@RequestMapping(path="users", method=RequestMethod.POST)
public void create(@RequestBody String userJSON){
	ObjectMapper mapper = new ObjectMapper();

	try{
		User newUser = mapper.readValue(userJSON, User.class);
		quizDAO.addUser(newUser);
	}
	catch(Exception e){
		e.printStackTrace();
	}
}
```

### @JsonIgnore

* If you would like a field to be ignored when converting to or from JSON, you can use the `@JsonIgnore` to tell the Jackson libraries to skip that specific field. This is useful for a situation where you have two objects that refer to each other, this causes a circular reference, which will in turn throw an exception.

[Previous](jsonBasics.md) | [Next](demo_address_index.md)
