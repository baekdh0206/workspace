package edu.kh.todo.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TodoMember {
	private int todoMemberNo;
	private String id;
	private String pw;
	private String name;
}
