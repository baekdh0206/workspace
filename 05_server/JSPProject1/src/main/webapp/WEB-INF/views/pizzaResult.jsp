<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>피자 주문 결과</title>
</head>
<body>
    <%-- JSP 주석 --%>
    <%-- 
        <%=  %> : 표현식(Expression)
                - 자바코드의 값을 HTML 형식으로 출력
                    -> EL(Expression Language)로 대체

        <% %> : 스크립틀릿(Scriptlet)
                - JSP에서 자바 코드를 작성할 수 있는 영역
                - HTML로 출력되진 않음
                - 변수 선언, if,for,while() 등 작성
                    -> JSTL 라이브러리로 대체
    --%>

    <h3>피자 종류 : <%= request.getAttribute("pizzaName") %>
                    (<%= request.getParameter("size") %>)</h3>

    <h3>수량 : <%= request.getParameter("amount") %></h3>

    <h3>총 가격 : <%= request.getAttribute("price") %> </h3>


    <pre>
        JSP에서 Java와 HTML 코드가 같이 작성된 경우
        
        Java 코드가 먼저 해석되고 나서
        HTML 코드가 해석된다
    </pre>

    <% for(int i=1 ; i<=6 ; i++){ %>

        <h<%= i %>> <%= i %> </h<%= i %>>

    <% } %>
</body>
</html>