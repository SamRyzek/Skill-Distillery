## Unit Testing Session Attributes

* We can test session attributes with JUnit using `MockHttpSession` or Hamcrest matchers.

### MockHttpSession

* In the following test, we instruct MockMvc to use a `MockHttpSession` object as its session when it makes a request.

  * This allows us to then search the `MockHttpSession` object for any attributes we expect.

  ```java
  //StateController.java
  @Controller
  @SessionAttributes({"modelState"})
  public class StateController {
      @Autowired
      private StateDAO stateDao;

      @ModelAttribute("modelState")
      public State initSessionState(){
    	  State st = stateDao.getStates().get(0);
    	  return st;
      }

      @RequestMapping(path="index.do")
    	public String index() {
    		return "index.jsp";
    	}
  }
  ```

  ```java
  //StateControllerTests.java
  @Test
  public void testModelStateInSession(){
    try {
			MockHttpSession mockSession = new MockHttpSession();
			mockMvc.perform(get("/index.do")
			.session(mockSession))
			  .andExpect(status().isOk());

			assertThat(mockSession.getAttribute("modelState"),
			  hasProperty("abbreviation", is("CO")));
		}
		catch (Exception e) {
			fail(e.toString());
		}
  }
  ```

### Hamcrest Matcher `request()`

* We can use the Hamcrest matcher `request()` and method `sessionAttribute()` to get an attribute from the session Spring used for the request.

  * This is placed inside an `andExpect()` call when we are making the request.

  ```java
  // StateControllerTests.java
  @Test
  public void test_model_state_in_session(){
    try {
			MvcResult result = mockMvc.perform(get("/GetStateData.do").param("next", "Next"))
			  .andExpect(status().isOk())
			  .andExpect(request().sessionAttribute("modelState",
			      hasProperty("abbreviation", is("CO"))))
			  .andReturn();
		}
		catch (Exception e) {
			fail(e.toString());
		}
  }
  ```

[Prev](spring_session.md) | [Up](../README.md) | [Next](states_lab_3.md)
