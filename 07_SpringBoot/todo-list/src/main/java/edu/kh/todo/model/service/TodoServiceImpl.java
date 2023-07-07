package edu.kh.todo.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.kh.todo.model.dto.Todo;
import edu.kh.todo.model.dto.TodoMember;
import edu.kh.todo.model.mapper.TodoMapper;

@Service
public class TodoServiceImpl implements TodoService{

	@Autowired
	private TodoMapper mapper;
	
	@Override
	public int idCheck(String id) {
		return mapper.idCheck(id);
	}
	
	@Override
	public int signup(TodoMember member) {
		return mapper.signup(member);
	}

	@Override
	public Map<String, Object> login(TodoMember member) {
		
		TodoMember loginMember = mapper.login(member);
		
		Map<String, Object> map = new HashMap<>();
		map.put("loginMember", loginMember);

		if(loginMember != null) {
			List<Todo> todoList = mapper.selectTodoLst(loginMember.getTodoMemberNo());
			map.put("todoList", todoList);
		}
		
		return map;
	}

	@Override
	public int insert(Todo todo) {
		int result = mapper.insert(todo);
		return result > 0 ? todo.getTodoNo() : 0;
	}

	@Override
	public int update(Todo todo) {
		return mapper.update(todo);
	}

	@Override
	public int delete(int todoNo) {
		return mapper.delete(todoNo);
	}
	
}
