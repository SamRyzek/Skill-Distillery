package controllers;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import data.State;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "StateControllerTests-context.xml" })
@WebAppConfiguration
public class StateControllerTests {
	MockMvc mockMvc;

	@Autowired
	WebApplicationContext wc;

	@Autowired
	StateController controller;

	MockStateDAO mockDAO;

	@Before
	public void setUp() {
		mockDAO = wc.getBean(MockStateDAO.class);

		// TODO - uncomment below to add a Mock object, which we control
		// controller.setStateDao(mockDAO);
		
		// TODO - build the MockMvc object with MockMvcBuilders
	}

	@After
	public void tearDown(){
		mockDAO.loadStates(); //cleanup
	}

	@Test
	public void test_GET_GetStateData_do_with_valid_name_param_returns_State() {
		try {
			MvcResult result = mockMvc.perform(get("/GetStateData.do").param("name", "Colorado"))
					.andExpect(status().isOk()).andReturn();
			ModelAndView mv = result.getModelAndView();
			assertEquals("result.jsp", mv.getViewName());
			ModelMap map = mv.getModelMap();
			assertNotNull(map.get("state"));

			State st = (State) map.get("state");
			assertEquals("Colorado", st.getName());
			assertEquals("CO", st.getAbbreviation());
			assertEquals("3", st.getLatitude());
			// TODO - test other fields

		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

	@Test
	public void test_GET_GetStateData_do_with_invalid_name_param_does_not_add_State_to_model() {
		// TODO - complete this and remove fail("implement");
		//fail("implement");
	}

	@Test
	public void test_GET_GetStateData_do_with_valid_abbr_param_adds_State_to_model() {
		// TODO - complete this and remove fail("implement");
		//fail("implement");
	}

	@Test
	public void test_GET_GetStateData_do_with_invalid_abbr_param_does_not_add_State_to_model() {
		// TODO - complete this and remove fail("implement");
		//fail("implement");
	}

	@Test
	public void test_POST_NewState_do_adds_state_and_returns_resultJSP() {
		// TODO - complete this and remove fail("implement");
		//fail("implement");
		
		// check the mock object's list directly for the new state
	}
	
	// TODO - change previous test according to directions
	
//	@Test
//	public void test_GET_stateAdded_do_returns_resultJSP_view() {
//		// TODO - complete this and remove fail("implement");
//		//fail("implement");
//	}
}
