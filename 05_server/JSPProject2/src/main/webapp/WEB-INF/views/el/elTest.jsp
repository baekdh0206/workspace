<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>EL</title>
</head>
<body>
    <h1>EL(Expression Language)</h1>

    <pre>
        JSP의 표현식을  <%--   <%= %>  expression   --%>
        조금 더 효율적이고 간단히 작성할 수 있도록 고안된 언어
        (JSP에 내장되어 있음)

        화면(HTML)에 출력 하고자하는 자바 코드를

        <%-- \$ 로 작성하면 화면에 $로 보임 --%>
        \${ key } 형식으로 작성하면
        해당 위치에 알맞은 value가 출력됨
    </pre>

    <h3>EL의 특징 1번 : get이라는 단어를 사용하지 않는다</h3>

    <pre>
        EL은 자바코드를 얻어와 출력하는 언어
        -> 출력 전용 언어(set 불가)
        -> get밖에 남지 않으므로 생략
    </pre>

    테스트 1(JSP 표현식) : <%= request.getParameter("test") %>
    <br>
    테스트 2(EL) : ${param.test}


    <hr>

    <h3>EL의 특징 2번 : null, NullPointerException을 빈칸으로 처리</h3>

    테스트 1(JSP 표현식) : <%= request.getParameter("num") %>
    <br>
    테스트 2(EL) : ${param.num == '123'}

    <hr>

    <form action="/elTest" method="POST">
        이름 : <input type="text" name="inputName">
        <br>
        나이 : <input type="number" name="inputAge">

        a <input type="checkbox" name="opt" value="a">
        b <input type="checkbox" name="opt" value="b">
        c <input type="checkbox" name="opt" value="c">

        <button>제출</button>
    </form>

</body>
</html>