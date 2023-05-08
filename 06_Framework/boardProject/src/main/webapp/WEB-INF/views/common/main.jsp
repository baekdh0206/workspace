<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시판 프로젝트</title>

</head>
<body>

    <main>

        <%-- header.jsp 추가(포함) --%>

        <%-- 
            <jsp:include page="jsp파일경로" /> 

            - JSP 액션 태그 (jsp에 기본 내장된 태그)
            - 다른 jsp 파일의 코드를 현재 위치에 추가(포함)
            - jsp 파일 경로는 webapp 폴더를 기준으로 작성
        --%>
        <jsp:include page="/WEB-INF/views/common/header.jsp" />


        <section class="content">
            <section class="content-1">

                <h3>로그인된 회원 정보</h3>
                ${sessionScope.loginMember}

                <h3>닉네임이 일치하는 회원의 전화번호 조회</h3>

                <input type="text" id="inputNickname"> 
                <button id="btn1">조회</button>
                <h4 id="result1"></h4>

                <hr>

                <h3>이메일을 입력 받아 일치하는 회원의 정보를 조회</h3>
                email : <input type="text" id="inputEmail">
                <button id="btn2">조회</button>
                <ul id="result2">
                </ul>

                <hr>
                <h3>이메일이 일부라도 일치하는 모든회원 조회</h3>
                검색어 : <input type="text" id="input">
                <button id="btn3">조회</button>

                <table border="1" style="border-collapse:collapse">
                    <thead>
                        <tr>
                            <th>회원번호</th>
                            <th>이메일</th>
                            <th>닉네임</th>
                        </tr>
                    </thead>

                    <tbody id="result3">
                        <tr>
                            <td>1</td>
                            <td>user01@kh.or.kr</td>
                            <td>유저일</td>
                        </tr>
                    </tbody>

                </table>



            </section>

            <section class="content-2">

                <c:choose>  
                    <%-- 
                        c:choose 내부에는 c:when, c:otherwise, jsp 주석만 작성 가능
                        c:when, c:otherwise 내부에는 다른 코드 작성 가능!
                    --%>

                    <%-- EL empty 연산자 : 비어 있거나 null 이면 true --%>
                    <c:when test="${empty sessionScope.loginMember}">

                        <!-- method="POST" : 제출 되는 값이 주소에 안보임 -->
                        <form action="/member/login" method="POST" id="loginFrm">
                            <fieldset class="id-pw-area">
                                <section>
                                    <input type="text" name="memberEmail" 
                                        placeholder="이메일" autocomplete="off"
                                        value="${cookie.saveId.value}" >


                                    <input type="password" name="memberPw" placeholder="비밀번호">                  
                                </section>
                                <section>
                                    <button>로그인</button>
                                </section>
                            </fieldset>

                            <label>

                                <%--   
                                <c:if test="${empty cookie.saveId.value}">
                                    <input type="checkbox" name="saveId"> 아이디 저장
                                </c:if>

                                <c:if test="${not empty cookie.saveId.value}">
                                    <input type="checkbox" name="saveId" checked> 아이디 저장
                                </c:if> 
                                --%>
                                
                                <c:if test="${not empty cookie.saveId.value}" >
                                    <%-- 쿠키에 저장된 이메일이 있으면 save 변수 선언
                                        -> page scope (페이지 내에서 사용 가능, if문 끝나도 가능!)
                                    --%>
                                    <c:set var="save" value="checked"/>
                                </c:if>

                                <input type="checkbox" name="saveId" ${save}> 아이디 저장

                            </label>

                            <article class="signup-find-area">
                                <a href="/member/signUp">회원가입</a>
                                <span>|</span>
                                <a href="#">ID/PW 찾기</a>
                            </article>
                        </form>

                    </c:when>

                    
                    <%-- 로그인 되었을 때 --%>
                    <c:otherwise>
                        <article class="login-area">

                            <a href="/myPage/profile">
                                <img src="/resources/images/user.png" id="memberProfile">
                            </a>

                            <div class="my-info">
                                <div>
                                    <a href="/myPage/info" id="nickname">${sessionScope.loginMember.memberNickname}</a>

                                    <a href="/member/logout" id="logoutBtn">로그아웃</a>
                                </div>   

                                <p>${loginMember.memberEmail}</p>

                            </div>

                        
                        </article>
                    </c:otherwise>


                </c:choose>

                
            </section>
        </section>
    </main>

    <%-- footer --%>
    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>


    <!-- main.js 추가 -->
    <script src="/resources/js/main.js"></script>
</body>
</html>