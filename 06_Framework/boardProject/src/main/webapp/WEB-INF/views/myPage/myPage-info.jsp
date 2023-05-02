<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>마이페이지</title>

    <link rel="stylesheet" href="/resources/css/myPage/myPage-style.css">

</head>
<body>
    <main>
        <jsp:include page="/WEB-INF/views/common/header.jsp" />

        <section class="myPage-content">

            <jsp:include page="/WEB-INF/views/myPage/sideMenu.jsp" />

            <section class="myPage-main">

                <h1 class="myPage-title">내 정보</h1>
                <span class="myPage-subject">원하는 회원 정보를 수정할 수 있습니다.</span>
            
                <%--  현재 페이지 : http://localhost/myPage/info 
                    제일 뒤에 info 지우고 
                    action에 작성된 경로 추가
                --%>
                <%-- 상대 경로 --%>
                <form action="info" method="POST" name="myPageFrm" id="updateInfo">

                    <div class="myPage-row">
                        <label>닉네임</label>
                        <input type="text" name="memberNickname" maxlength="10" 
                            value="${loginMember.memberNickname}" id="memberNickname">             
                    </div>

                    <div class="myPage-row">
                        <label>전화번호</label>
                        <input type="text" name="memberTel"  maxlength="11" 
                            value="${loginMember.memberTel}" id="memberTel">
                    </div>

                    <div class="myPage-row info-title">
                        <span>주소</span>
                    </div>


                    <%-- ${fn:split(loginMember.memberAddress, '^^^')[0] }
                    ${fn:split(loginMember.memberAddress, '^^^')[1] }
                    ${fn:split(loginMember.memberAddress, '^^^')[2] } --%>

                    <%-- 
                        ${fn:split(문자열, 구분자)} 
                        문자열을 구분자로 나누어 배열 형태로 반환
                    --%>

                    <c:set var="addr" value="${fn:split(loginMember.memberAddress, '^^^')}"/>


                    <div class="myPage-row info-address">
                        <input type="text" name="memberAddress" placeholder="우편번호" value="${addr[0]}" id="postcode">
                        <button type="button" onclick="sample6_execDaumPostcode()">검색</button>
                    </div>

                    <div class="myPage-row info-address">
                        <input type="text" name="memberAddress"  placeholder="도로명/지번 주소"  value="${addr[1]}" id="address">                
                    </div>

                    <div class="myPage-row info-address">
                        <input type="text" name="memberAddress"  placeholder="상세 주소"  value="${addr[2]}" id="detailAddress">                
                    </div>

                    <button class="myPage-submit">수정하기</button>
                </form>

            </section>

        </section>

    </main>
    <jsp:include page="/WEB-INF/views/common/footer.jsp" />

    <!-- 다음 주소 api 추가 -->
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script>
        function sample6_execDaumPostcode() {
            new daum.Postcode({
                oncomplete: function(data) {
                    // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                    // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                    // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                    var addr = ''; // 주소 변수

                    //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                    if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                        addr = data.roadAddress;
                    } else { // 사용자가 지번 주소를 선택했을 경우(J)
                        addr = data.jibunAddress;
                    }

                    // 우편번호와 주소 정보를 해당 필드에 넣는다.
                    document.getElementById('postcode').value = data.zonecode;
                    document.getElementById("address").value = addr;
                    // 커서를 상세주소 필드로 이동한다.
                    document.getElementById("detailAddress").focus();
                }
            }).open();
        }
    </script>

    <script src="/resources/js/myPage/myPage.js"></script>
</body>
</html>