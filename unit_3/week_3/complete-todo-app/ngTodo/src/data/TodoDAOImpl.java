package data;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;

import entities.Todo;
import entities.User;

@Repository
@Transactional
public class TodoDAOImpl implements TodoDAO {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Collection<Todo> index(int uid) {
		String query = "SELECT t FROM Todo t WHERE t.user.id = :uid";
		
		List<Todo> todoList = em.createQuery(query, Todo.class)
			.setParameter("uid", uid)
			.getResultList();
		
		return new HashSet<Todo>(todoList);
	}

	@Override
	public Todo create(int uid, String json) {
		ObjectMapper om = new ObjectMapper();
		Todo newTodo = null;
		
		try {
			newTodo = om.readValue(json, Todo.class);
			User user = em.find(User.class, uid);
			newTodo.setUser(user);
			em.persist(newTodo);
			em.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newTodo;
	}

	@Override
	public boolean destroy(int uid, int tid) {
		Todo t = em.find(Todo.class, tid);
		em.remove(t);
		
		if (em.find(Todo.class, tid) != null) {
			return false;
		}
		return true;
	}

	@Override
	public Todo update(int uid, int tid, String json) {
		ObjectMapper om = new ObjectMapper();
		Todo mappedTodo = null;
		Todo managed = null;
		try {
			mappedTodo = om.readValue(json, Todo.class);
			managed = em.find(Todo.class, tid);
			managed.setCompleted(mappedTodo.isCompleted());
			managed.setTask(mappedTodo.getTask());
			managed.setDescription(mappedTodo.getDescription());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return managed;
	}

	@Override
	public Todo show(int uid, int tid) {
		return em.find(Todo.class, tid);
	}

}
