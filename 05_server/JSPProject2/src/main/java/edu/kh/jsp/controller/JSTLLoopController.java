package edu.kh.jsp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.jsp.model.dto.Book;

@WebServlet("/jstl/loop")
public class JSTLLoopController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		List<Book> bookList = new ArrayList<>();
		
		bookList.add(new Book("언어의 무게", "파스칼 메르시어", 19800));
		bookList.add(new Book("자신의 존재에 대해 사과하지 말 것", "카밀라 팡", 16920));
		bookList.add(new Book("노동의 상실", "어밀리아 호건", 15300));
		bookList.add(new Book("신의 아들 단군", "박정효", 13500));
		
		req.setAttribute("bookList", bookList);
		
		// loop.jsp로 요청 위임
		req.getRequestDispatcher("/WEB-INF/views/jstl/loop.jsp").forward(req, resp);
	}
	
	
}
