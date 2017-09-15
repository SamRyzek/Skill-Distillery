## Using the `Validator` Interface in the Controller

* Add an instance of the `Validator` interface to your controller, and inject it.

* Add a `BindingResult` to your handler method. This is used to communicate errors to the view. This interface extends the `Errors` interface.

* Call the `Validator`'s `validate` method on the object. This will register any errors.

* Check the `BindingResult` that the `Validator` may have changed for errors, and handle accordingly.

```java
import org.springframework.validation.Validator;
//brevity...
@Controller
public class LoginController {
  @Autowired
  private AuthenticationDAOImpl authDao;

  @Autowired
  private Validator validator; // Use the interface, and @Autowire to inject

  // Method to route to login form (login.jsp)
  @RequestMapping(path="login", method=RequestMethod.GET)
  public ModelAndView login() {
    User u = new User();
    ModelAndView mv = new ModelAndView("login.jsp", "user", u);
    return mv;
  }

  @RequestMapping(path = "login.do", method = RequestMethod.POST)
  public ModelAndView doLoginVal(User user, BindingResult result) {
    ModelAndView mv = new ModelAndView();
    // Call the validate method
    validator.validate(user, result);

    // Determine if there are any errors.
    if (result.hasErrors()) {
      // If there are any errors, return the login form.
      mv.setViewName("login.jsp");
  		return mv;
    }
    // If no errors, send the user forward to the profile view.
    mv.setViewName("profile.jsp");
    return mv;
  }
}
  ```

<hr>

[Prev](validator.md) | [Up](../README.md) | [Next](forms.md)
