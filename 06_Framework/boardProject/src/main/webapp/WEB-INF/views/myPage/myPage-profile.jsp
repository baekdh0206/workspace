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

                <h1 class="myPage-title">프로필</h1>
                <span class="myPage-subject">프로필 이미지를 변경할 수 있습니다.</span>

                <form aciont="profile" method="POST" name="myPageFrm">

                    <div class="profile-image-area">

                        <img src="/resources/images/user.png" id="profileImage">

                    </div>
                    <span id="deleteImage">x</span>

                    <div class="profile-btn-area">
                        <label for="imageInput">이미지 선택</label>
                        <input type="file" name="profileImage" id="imageInput" accept="image/*">
                        <button>변경하기</button>
                    </div>
                    
                    <div class="myPage-row">
                        <label>이메일</label>
                        <span>로그인 회원 이메일</span>
                    </div>
                    
                    <div class="myPage-row">
                        <label>가입일</label>
                        <span>로그인 회원 가입일</span>
                    </div>
                    
                </form>

                

            </section>

        </section>

    </main>

	<jsp:include page="/WEB-INF/views/common/footer.jsp"/>

</body>
</html>