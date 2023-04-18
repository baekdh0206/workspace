<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원 가입 결과</title>
</head>
<body>
    <h3 style="color:hotpink"><%= request.getParameter("inputName") %>님의 가입을 환영합니다.</h3>

    <ul>
        <li> id : <%= request.getParameter("inputId") %> </li>
        <li> pw : <%= request.getParameter("inputPw") %> </li>
    </ul>

	<% if( !request.getParameter("introduction").equals("") ){ %>
    <h4>자기소개</h4>
    <p>
        <%= request.getParameter("introduction") %>
    </p>
    <% } %>
    
</body>
</html>