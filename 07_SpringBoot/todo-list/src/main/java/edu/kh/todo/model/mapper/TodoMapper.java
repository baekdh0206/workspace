package edu.kh.todo.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.kh.todo.model.dto.Todo;
import edu.kh.todo.model.dto.TodoMember;

@Mapper
public interface TodoMapper {

	int idCheck(String id);
	
	int signup(TodoMember member);

	TodoMember login(TodoMember member);

	List<Todo> selectTodoLst(int todoMemberNo);

	int insert(Todo todo);

	int update(Todo todo);

	int delete(int todoNo);
	
	


}
