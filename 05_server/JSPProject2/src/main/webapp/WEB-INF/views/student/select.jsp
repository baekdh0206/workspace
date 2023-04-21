<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>학생 전체 조회</title>

    <style>
        table{
            border-collapse : collapse;
        }
    </style>
</head>
<body>
    
    <h1>학생 전체 목록</h1>

    <table border="1">
        <tr>
            <th>번호</th>
            <th>학번</th>
            <th>이름</th>
            <th>학과</th>
            <th>주소</th>
        </tr>

        <c:forEach var="std" items="${stdList}" varStatus="vs">
            <tr>
                <td>${vs.count}</td>

                <td>${std.studentNo}</td>

                <td>${std.studentName}</td>

                <td>${std.departmentName}</td>

                <td>${std.studentAddress}</td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>