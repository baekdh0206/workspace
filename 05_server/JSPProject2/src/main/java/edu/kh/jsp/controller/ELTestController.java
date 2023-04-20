package edu.kh.jsp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.jsp.model.dto.Book;

@WebServlet("/elTest")
public class ELTestController extends HttpServlet{
	
	
	// a태그 요청(get방식)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		RequestDispatcher dispatcher
			= req.getRequestDispatcher("/WEB-INF/views/el/elTest.jsp");
		
		dispatcher.forward(req, resp);
	}
	
	
	
	// form태그 요청(post 방식)
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// POST 방식 -> req 문자 인코딩 부터 변경
		req.setCharacterEncoding("UTF-8");
		
		// 새로운 값을 req에 세팅
		
		req.setAttribute("address", "서울시 중구 남대문로 120");
		req.setAttribute("score", 100);
		
		List<String> strList = new ArrayList<>();
		strList.add("가가가");
		strList.add("나나나");
		strList.add("다다다");
		
		req.setAttribute("strList", strList);
		
		Book book = new Book("어린왕자", "생택쥐베리", 4000);
		
		req.setAttribute("book", book);
		
		
		List<String> list1 = null;				// null
		List<String> list2 = new ArrayList<>(); // 비어있음
		
		req.setAttribute("list1", list1);
		req.setAttribute("list2", list2);
		
		
		
		// 요청 위임(forward) 구문 작성
		RequestDispatcher dispatcher
			= req.getRequestDispatcher("/WEB-INF/views/el/elResult.jsp");
				
		dispatcher.forward(req, resp);
		
	}
	
	
	
	

}
