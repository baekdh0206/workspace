package edu.kh.todo.model.service;

import java.util.Map;

import edu.kh.todo.model.dto.Todo;
import edu.kh.todo.model.dto.TodoMember;

public interface TodoService {
	
	int idCheck(String id);

	int signup(TodoMember member);

	Map<String, Object> login(TodoMember member);

	int insert(Todo todo);

	int update(Todo todo);

	int delete(int todoNo);

}
