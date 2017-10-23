# Spring User Authentication
* Spring User authentication can take many forms, but at it's most primitive it will have a controller with routes to manage the state of a User's login, as well as the ability to create a new user (register) and authenticate an existing user (login).

### `AuthDAO`

```java
public interface AuthDAO {
  public User register(User u);
  public User login(User u);
}
```

### `AuthController`

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

#### [Prev](README.md) | [Next]()