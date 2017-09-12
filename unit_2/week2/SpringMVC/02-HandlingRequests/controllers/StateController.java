package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import data.State;
import data.StateDAO;

@Controller
public class StateController {
	// TODO : Autowire a StateDAO and create getters and setters

	// TODO : Implement a request handler for:
	// path "GetStateData.do"
	// params "name"
	// method GET
	// return : ModelAndView
	// view : "result.jsp"
	// object : "state", getStateByName

	// TODO : Implement a request handler for:
	// path "GetStateData.do"
	// params "abbr"
	// method GET
	// return : ModelAndView
	// view : "result.jsp"
	// object : "state", getStateByAbbreviation

	// TODO : Implement a request handler for:
	// path "NewState.do"
	// method POST
	// command object : State
	// return : ModelAndView
	// view : "result.jsp"

	// -------------------

	// TODO : Implement another request handler for:
	// path "NewState.do"
	// method POST
	// command object : State
	// return : ModelAndView
	// view : "redirect:stateAdded.do"
	// behavior : add state to dao, add state to flashAttributes
	
	// TODO : Implement another request handler for:
    // path "stateAdded.do"
    // method GET
    // command object : State
    // return : ModelAndView
    // view : "result.jsp" or "result" if using InternalResourceViewResolver

}
