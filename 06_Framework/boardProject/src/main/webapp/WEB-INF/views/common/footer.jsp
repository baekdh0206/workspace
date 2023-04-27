<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<footer>
    <p>Copyright &copy; KH Information Educational Institute A-Class</p>

    <article>
        <a href="#">프로젝트 소개</a>    
        <span>|</span>
        <a href="#">이용약관</a>    
        <span>|</span>
        <a href="#">개인정보처리방침</a>    
        <span>|</span>
        <a href="#">고객센터</a>    
    </article>
</footer>

<%-- request에 message가 존재할 경우 --%>
<%-- not empty : 비어있지 않을 경우 true --%>
<c:if test="${not empty message}">

    <script>
        // EL/JSTL 구문이 먼저 해석되는데
        // 문자열의 경우 따옴표가 없는 상태이니 붙여줘야한다!!!
        alert('${message}');
    </script>

</c:if>