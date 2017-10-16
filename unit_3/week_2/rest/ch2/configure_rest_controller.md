# Configure a Spring `RestController`
### Using Spring @ResponseBody and @RestController Annotations

Configuring a Spring REST project is similar to the Spring MVC projects we have done in the past. It is a fairly easy transition as we only need to know two new annotations, ```@RestController``` and ```@ResponseBody```.

### @ResponseBody

The ```@ResponseBody``` annotation is placed above an ```@RequestMapping``` annotation. It changes the way Spring handles the return value from trying to map it to a view, to returning a JSON representation of an object, or a text value representation of a primitive type.

When you put ```@ResponseBody``` above the class definition, every ```@RequestMapping``` within that class will have the ```@ResponseBody``` functionality. If you have ```@ResponseBody``` at a class level, and you want a ```@RequestMapping``` to return a view, set the return type of that method to an ```ModelAndView```.

### @RestController
`@RestController` is a convenience annotation that adds both the ```@ResponseBody``` and ```@Controller``` annotations to the class level. If this annotation is added to a class all routes are assumed to be RESTful.

### @PathVariable, Why It's Important For REST

The ```@PathVariable``` annotation provides and alternative way to get data from the client, where it is directly embedded in the URL of a request, instead of in a query string.

**Example:**

```java
@RequestMapping("/service/{arg1}")
```
Will pull a parameter value from a URL Path such as:
```
http://localhost:8080/Project/api/anArgumentValue
```

To do the same thing with @RequestParam, we would take data from a URL such as:
```
http://localhost:8080/Project/rest?arg1=anArgumentValue
```
```java
    @RequestMapping("/employees/{id}")
    @ResponseBody
    public String getEmployee(@PathVariable int id){
    return dao.getEmployeeById(id);
    }
```
One of the primary reasons that we use ```@PathVariable``` to get data is that the request is cleaner, and provides a more semantic approach to getting data from an application or web service. We don't want to clutter our URI with additional special characters. A clean URI will only include nouns and `/`.

[Previous](configure_spring_rest.md) | [Next](pingPong.md)
