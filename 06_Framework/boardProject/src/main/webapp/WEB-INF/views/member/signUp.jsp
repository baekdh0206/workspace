<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입</title>

    <link rel="stylesheet" href="/resources/css/member/signUp-style.css">
</head>
<body>
    <main>
        <%-- header.jsp include --%>
        <%-- 다른 JSP 코드를 현재 위치에 포함
            webapp 부터의 jsp 경로를 작성--%>
        <jsp:include page="/WEB-INF/views/common/header.jsp"/>

        <section class="signUp-content">

            <form action="/member/signUp" method="POST" name="signUpFrm" id="signUpFrm">

                <!-- 이메일 입력 -->
                <label for="memberEmail">
                    <span class="required">*</span> 아이디(이메일)
                </label>

                <div class="signUp-input-area">
                    <input type="text" name="memberEmail" id="memberEmail" 
                    placeholder="아이디(이메일)" maxlength="30" autocomplete="off">
                    
                    <button id="sendAuthKeyBtn" type="button">인증번호 받기</button>
                </div>
                <span class="signUp-message" id="emailMessage">메일을 받을 수 있는 이메일을 입력해주세요.</span>



                <!-- 인증번호 입력 -->
                <label for="emailCheck">
                    <span class="required">*</span> 인증번호
                </label>

                <div class="signUp-input-area">
                    <input type="text" name="authKey" id="authKey" s placeholder="인증번호 입력" maxlength="6" autocomplete="off" >
                    
                    <button id="checkAuthKeyBtn" type="button">인증하기</button>
                </div>
                <span class="signUp-message" id="authKeyMessage"></span>
                                <!-- 인증번호가 일치하지 않습니다 -->
                

                <!-- 비밀번호/비밀번호 확인 입력 -->
                <label for="memberPw">
                    <span class="required">*</span> 비밀번호
                </label>

                <div class="signUp-input-area">
                    <input type="password" name="memberPw" id="memberPw" 
                    placeholder="비밀번호" maxlength="20" >
                </div>
                <div class="signUp-input-area">
                    <input type="password" name="memberPwConfirm" id="memberPwConfirm" 
                    placeholder="비밀번호 확인" maxlength="20" >
                </div>

                <span class="signUp-message" id="pwMessage">영어,숫자,특수문자(!,@,#,-,_) 6~20글자 사이로 입력해주세요.</span>


                <!-- 닉네임 입력 -->
                <label for="memberNickname">
                    <span class="required">*</span> 닉네임
                </label>

                <div class="signUp-input-area">
                    <input type="text" name="memberNickname" id="memberNickname" placeholder="닉네임" maxlength="10" >
                </div>

                <span class="signUp-message" id="nickMessage">한글,영어,숫자로만 2~10글자</span>


                <!-- 전화번호 입력 -->
                <label for="memberTel">
                    <span class="required">*</span> 전화번호
                </label>

                <div class="signUp-input-area">
                    <input type="text" name="memberTel" id="memberTel" placeholder="(- 없이 숫자만 입력)" maxlength="11">
                </div>

                <span class="signUp-message" id="telMessage">전화번호를 입력해주세요.(- 제외)</span>



                <!-- 주소 입력 -->
                <label for="memberAddress">주소</label>

                <div class="signUp-input-area">
                    <input type="text" name="memberAddress" placeholder="우편번호" maxlength="6" id="sample6_postcode">
                    
                    <button type="button" onclick="sample6_execDaumPostcode()">검색</button>
                </div>

                <div class="signUp-input-area">
                    <input type="text" name="memberAddress" placeholder="도로명/지번 주소" id="sample6_address">
                </div>

                <div class="signUp-input-area">
                    <input type="text" name="memberAddress" placeholder="상세 주소" id="sample6_detailAddress">
                </div>


                <button id="signUpBtn">가입하기</button>
            </form>
        </section>

    </main>

    <%-- footer.jsp include --%>
    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>


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
                    document.getElementById('sample6_postcode').value = data.zonecode;
                    document.getElementById("sample6_address").value = addr;
                    // 커서를 상세주소 필드로 이동한다.
                    document.getElementById("sample6_detailAddress").focus();
                }
            }).open();
        }
    </script>


    <script src="/resources/js/member/signUp.js"></script>
</body>
</html>