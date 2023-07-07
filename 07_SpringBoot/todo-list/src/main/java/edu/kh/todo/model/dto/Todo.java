package edu.kh.todo.model.dto;

import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.ToString;

@Getter
@Service
@ToString
public class Todo {
	private int todoNo;
	private String title;
	private String isDone;
	private int todoMemberNo; 
}
