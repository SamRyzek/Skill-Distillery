package controllers;

import java.util.Collection;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import data.TodoDAO;
import entities.Todo;

@RestController
public class TodoController {
	
	@Autowired
	private TodoDAO todoDao;
	
	@RequestMapping(path = "ping", method = RequestMethod.GET)
	public String ping() {
		return "pong";
	}
	
	@RequestMapping(path = "user/{uid}/todo", method = RequestMethod.GET)
	public Collection<Todo> index(@PathVariable int uid) {
		return todoDao.index(uid);
	}
	
	@RequestMapping(path = "user/{uid}/todo/{tid}", method = RequestMethod.GET)
	public Todo show(@PathVariable int uid, @PathVariable int tid, HttpServletResponse res) {
		Todo todo = todoDao.show(uid,tid);
		if (todo == null) {
			res.setStatus(404);
			return null;
		}
		return todo;
	}
	
	@RequestMapping(path = "user/{uid}/todo", method = RequestMethod.POST)
	public Todo create(@PathVariable int uid, @RequestBody String json, HttpServletResponse res) {
		res.setStatus(201);
		return todoDao.create(uid, json);
	}
	
	@RequestMapping(path = "user/{uid}/todo/{tid}", method = RequestMethod.DELETE)
	public boolean destroy(@PathVariable int uid, @PathVariable int tid, HttpServletResponse res) {
		return todoDao.destroy(uid,tid);
	}
	
	@RequestMapping(path = "user/{uid}/todo/{tid}", method = RequestMethod.PUT)
	public Todo update(
			@PathVariable int uid, 
			@PathVariable int tid, 
			@RequestBody String json, 
			HttpServletResponse res) {
		return todoDao.update(uid,tid,json);
	}
}
