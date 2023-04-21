package edu.kh.jsp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/scopeCheck")
public class ScopeCheckController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		// webapp(/) 폴더 기준으로 JSP 경로 작성
		req.getRequestDispatcher("/WEB-INF/views/scope/scopeCheck.jsp").forward(req, resp);
	}

}




