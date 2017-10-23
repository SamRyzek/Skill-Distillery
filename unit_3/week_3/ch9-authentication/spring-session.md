# Spring Session

* The following is a quick review of using `HttpSession` to hold server-side state with HTTP Request/Response sessions.

### `HttpSession`

* *Session* objects are representations of the browsers' local *session* storage.

  * Session storage is just an in memory key-value store used in the browser to cache information (like cookies)

  * With every request sent to a server, the browser's session store is bundled and sent with it.

  * Every server response returns the potentially modified session to the browser to be cached.

* The `HttpSession` object is a key-value store that can be request from Spring through *Dependency Injection*

* `HttpSession` exposes simple methods for adding, retrieving and removing values from the cache.

  * `session.setAttribute("stringKey", ObjectValue)`
    * Adds a key-value pair to the session

  * `session.getAttribute("stringKey")`
    * Returns the value associated with the provided key

  * `session.removeAttribute("stringKey")`
    * Removes the value associated with the provided key from the storage

### Obtaining the `HttpSession`
* There are two ways in Spring to retrieve the session:

1: Use dependency injection.
  * SpringMVC will inject the `HttpSession` object into a request handler if a typed parameter is provided:

```java
  @RequestMapping(path = "/logout", method = RequestMethod.POST)
  public Boolean logout(HttpSession session, HttpServletResponse res) {
    session.removeAttribute("user");
    return true;
  }
```

2: Use the `HttpServletResquest` object to retrieve it directly:

```java
  @RequestMapping(path = "/logout", method = RequestMethod.POST)
  public Boolean logout(HttpServletRequest req, HttpServletResponse res) {
    req.getSession().removeAttribute("user");
    return true;
  }
```

* Both of the above approaches will have the same result. If you do not have the ability to inject the `HttpSession` attribute, you may alternatively use the `HttpServletRequest` attribute.

### Hands On

```java
@RestController
@RequestMapping("/auth")
public class AuthController {
  
  @Autowired
  private AuthDAO authDAO;

  @RequestMapping(path = "/register", method = RequestMethod.POST)
  public User register(HttpSession session, @RequestBody User user) {
    // TODO : Create the provided user, place the user in session, return the user
    return null;
  }
  
  @RequestMapping(path = "/login", method = RequestMethod.POST)
  public User login(HttpSession session, @RequestBody User user) {
    // TODO : Authenticate user object, place the user in session, return the user
    return null;
  }
  
  @RequestMapping(path = "/logout", method = RequestMethod.POST)
  public Boolean logout(HttpSession session, HttpServletResponse response) {
    // TODO : Remove the "user" session, if successfully removed, return true
    return null;
  }
  
  @RequestMapping(path = "/unauthorized")
  public String unauth(HttpServletResponse response) {
    response.setStatus(401);
    return "unauthorized";
  }
}
```

1: Implement the three stubbed methods (register, login, logout). Use `HttpSession` and the `authDAO` to place user objects in session.

#### [Prev](encryption.md) | [Next](interceptors.md)