package edu.kh.jsp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jstl/condition")
public class JSTLConditionController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setAttribute("name", "홍길동");
		req.setAttribute("money", 50000);
		
		req.getRequestDispatcher("/WEB-INF/views/jstl/condition.jsp").forward(req, resp);
		
	
	
	}
}
