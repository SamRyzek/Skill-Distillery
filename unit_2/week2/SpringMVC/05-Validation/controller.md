## Using Validation Information in the Controller

* In your controller annotate a command object parameter with the `@Valid` annotation.

  ```java
  @Controller
  public class LoginController {
    @Autowired
    private AuthenticationDAO authDao;

    @RequestMapping(path="login", method=RequestMethod.GET)
    public ModelAndView login() {
      User u = new User();
      ModelAndView mv = new ModelAndView();
      mv.setViewName("login.jsp");
      // Prime the model with an empty user object so that
      // the form can populate it with values
      mv.addObject("user", u);
      return mv;
    }

    @RequestMapping(path="login.do", method=RequestMethod.POST)
    public ModelAndView doLogin(@Valid User user, Errors errors) {
      ModelAndView mv = new ModelAndView();

      // Determine if there are any errors.
      if (errors.getErrorCount() != 0) {
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

* The `@Valid` annotation instructs Spring MVC to validate the object when the method is called.

  * Reminder, this command object's properties are automatically populated by Spring MVC based on matching request parameters.

* Add an `Errors` object as a parameter to your method so you can determine if any validation problems occurred.

  * Regarding parameter order, this object must follow the corresponding command object.

  * Spring MVC will load this object with errors, if they occur.

  * Use the `getErrorCount()` method to determine if there were any errors. A non-zero result indicates validation problems.

    * Redisplay the page that failed validation to have the user try again.

      ```java
      @Controller
      public class LoginController {
        @Autowired
        private AuthenticationDAOImpl authDao;

        @RequestMapping(path="login", method=RequestMethod.GET)
        public ModelAndView login() {
          User u = new User();
          ModelAndView mv = new ModelAndView();
          mv.setViewName("login.jsp");
          // Prime the model with an empty user object so that
          // the form can populate it with values
          mv.addObject("user", u);
          return mv;
        }

        @RequestMapping(path="login.do", method=RequestMethod.POST)
        public ModelAndView doLogin(@Valid User user, Errors errors) {
          ModelAndView mv = new ModelAndView();

          // Determine if there are any errors.
          if (errors.getErrorCount() != 0) {
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

[Prev](annotations.md) | [Up](../README.md) | [Next](validator.md)
