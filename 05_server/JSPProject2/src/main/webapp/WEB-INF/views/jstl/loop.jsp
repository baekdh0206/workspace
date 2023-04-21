<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%-- JSTL 사용하려면 제발 꼭 작성해주세요 ㅜㅠ --%>

<%-- 제일 많이 사용하는 코드가 모여있음(if, choose, forEach) --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- 문자열 관련 기능 , 배열/리스트 관련 기능 모여있음 
    태그 형태가 아닌 EL 형태로 작성하는 구문
--%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>



<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>JSTL 반복문</title>
</head>
<body>
    <h1>6. 반복문 - for (c:forEach 태그)  </h1>

    <pre>
        - 일반 for + 추가 기능
		
		- 속성
		1) var   : 현재 반복 횟수에 해당하는 변수 (int i)
		2) begin : 반복 시 var 시작 값
		3) end   : 반복이 종료될 var 값
		4) step  : 반복 시 마다 var의 증가 값 (기본값 1)
		
		5) items : 반복 접근한 객체(배열, 컬렉션 객체)
		
		6) varStatus : 현재 반복 상태와 관련된 정보를 제공하는 변수 선언
		
			varStatus="변수명"
			-> c:forEach 구문 내에서 "변수명"을 통해 원하는 값을 얻을 수 있다.
		
			* varStatus에서 제공되는 값
			- current : 현재 반복 횟수(현재 var 값) 
			또는 현재 반복 접근 중인 객체(컬렉션/배열 요소)

			- index : 현재 인덱스값 반환 (0부터 시작)
			
			- count : 현재 몇바퀴째인지 반복 횟수 반환 (1부터 시작)
			
			- first : 첫 번째 반복이면 true, 아니면 false
			
			- last : 마지막 반복이면 true, 아니면 false
    </pre>


    <h3>일반 for문 형식으로 사용하기</h3>

    <c:forEach var="i" begin="1" end="6" step="1">
        <h${i}> 현재 i 값 : ${i} </h${i}>
    </c:forEach>


    <hr>

    <h3 style="color:red"> \${fn:length(리스트명)} : 리스트의 길이 </h3>

    <h4>bookList의 길이 : ${fn:length(bookList)}</h4>

    <c:forEach var="i" begin="0" end="${fn:length(bookList) - 1}" step="1">
        ${bookList[i]}  <br>
    </c:forEach>


    <hr>


    <h3>향상된 for문 형식으로 사용하기</h3>

    <ul>

        <c:forEach var="book" items="${bookList}" varStatus="vs">
            <li>
                index : ${vs.index} <br>
                count : ${vs.count} <br>
                current : ${vs.current} <br>
                book과 current는 같음 : ${book} <br>

                <c:if test="${vs.first}" >
                    첫 번째 요소 입니다. <br>
                </c:if>

                <c:if test="${vs.last}" >
                    마지막 요소 입니다. <br>
                </c:if>
            </li>
            <hr>
        </c:forEach>

    </ul>



</body>
</html>