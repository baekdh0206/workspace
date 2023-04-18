<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>로그인 결과</title>
</head>
<body>
    <h1>로그인 결과</h1>

    <ul>
        <li>id : <%= request.getParameter("id") %> </li>
        <li>pw : <%= request.getParameter("pw") %> </li>
    </ul>

    <%-- JSP 주석 --%>
    <%-- Servlet에서 추가한 속성(message) 얻어오기 --%>

    <%-- Object request.getAttribute("키") --%>

    <h1> <%= request.getAttribute("message") %> </h1>

    <button type="button" onclick="history.back()">돌아가기</button>

</body>
</html>