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


                <%-- 
                    - 파일 제출 시 무조건 POST 방식
                    - enctype 속성 추가

                    - enctype : form 태그 데이터가 서버로 제출 될 때 인코딩 되는 방법을 지정. (POST 방식일 때만 사용 가능)
                   
                    - application/x-www-form-urlencoded : 모든 문자를 서버로 전송하기 전에 인코딩 (form태그 기본값)
                   
                    - multipart/form-data : 모든 문자를 인코딩 하지 않음.(원본 데이터가 유지되어 이미지, 파일등을 서버로 전송 할 수 있음.) 
                --%>
                <form action="profile" method="POST" name="myPageFrm" id="profileFrm" enctype="multipart/form-data" >     
                    <div class="profile-image-area">

                        <%-- 프로필 이미지가 없으면 기본 이미지 --%>
                        <c:if test="${empty loginMember.profileImage}" >
                            <img src="/resources/images/user.png" id="profileImage">
                        </c:if>

                        <%-- 프로필 이미지가 있으면 있는 이미지 --%>
                        <c:if test="${not empty loginMember.profileImage}" >
                            <img src="${loginMember.profileImage}" id="profileImage">
                        </c:if>

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

    <script src="/resources/js/myPage/myPage.js"></script>
</body>
</html>