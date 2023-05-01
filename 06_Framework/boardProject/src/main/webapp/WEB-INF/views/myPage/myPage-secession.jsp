<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>My Page</title>

    <link rel="stylesheet" href="/resources/css/myPage/myPage-style.css">

</head>
<body>
    <main>
        <jsp:include page="/WEB-INF/views/common/header.jsp"/>

        
        <!-- 마이페이지 - 내 정보 -->
        <section class="myPage-content">
            
			<!-- 사이드메뉴 include -->
			<!-- jsp 액션 태그 -->
			<jsp:include page="/WEB-INF/views/myPage/sideMenu.jsp"/>


            <!-- 오른쪽 마이페이지 주요 내용 부분 -->
            <section class="myPage-main">

                <h1 class="myPage-title">회원 탈퇴</h1>
                <span class="myPage-subject">현재 비밀번호가 일치하는 경우 탈퇴할 수 있습니다.</span>

                <form action="secession" method="POST" name="myPageFrm">

                    <div class="myPage-row">
                        <label>비밀번호</label>
                        <input type="password" name="memberPw" id="memberPw" maxlength="30">              
                    </div>

                    
                    <div class="myPage-row info-title">
                        <label>회원 탈퇴 약관</label>
                    </div>

                    <pre class="secession-terms">
제1조
이 약관은 샘플 약관입니다.

① 약관 내용 1

② 약관 내용 2

③ 약관 내용 3

④ 약관 내용 4


제2조
이 약관은 샘플 약관입니다.

① 약관 내용 1

② 약관 내용 2

③ 약관 내용 3

④ 약관 내용 4

                    </pre>

                    <div>
                        <input type="checkbox" name="agree" id="agree">
                        <label for="agree">위 약관에 동의합니다.</label>
                    </div>


                    <button class="myPage-submit">탈퇴</button>

                </form>

            </section>

        </section>

    </main>

	<jsp:include page="/WEB-INF/views/common/footer.jsp"/>

</body>
</html>