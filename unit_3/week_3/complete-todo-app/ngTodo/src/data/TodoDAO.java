package data;

import java.util.Collection;

import entities.Todo;

public interface TodoDAO {
	public Collection<Todo> index(int uid);
	
	public Todo create(int uid, String json);
	
	public Todo show(int uid, int tid);
	
	public boolean destroy(int uid, int tid);
	
	public Todo update(int uid, int tid, String json);
}
