<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<!DOCTYPE html>
<html lang=ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	
    <title>채팅방</title>

    <link rel="stylesheet" href="/resources/css/main-style.css">
    <link rel="stylesheet" href="/resources/css/board/boardDetail-style.css">
	<link rel="stylesheet" href="/resources/css/chatting/chatting-style.css">

    <script src="https://kit.fontawesome.com/a2e8ca0ae3.js" crossorigin="anonymous"></script>
</head>

<body>
	<main>

		<jsp:include page="../common/header.jsp"></jsp:include>

		<button id="addTarget">추가</button>

		<div id="addTargetPopupLayer" class="popup-layer-close">  
			<span id="closeBtn">&times</span>

			<div class="target-input-area">
				<input type="search" id="targetInput" placeholder="닉네임 또는 이메일을 입력하세요" autocomplete="off">
			</div>

			<ul id="resultArea">
				<%-- <li class="result-row" data-id="1">
					<img class="result-row-img" src="/resources/images/user.png">
					<span> <mark>유저</mark>일</span>
				</li>
				<li class="result-row"  data-id="2">
					<img class="result-row-img" src="/resources/images/user.png">
					<span><mark>유저</mark>이</span>
				</li>

				<li class="result-row">일치하는 회원이 없습니다</li> --%>
			</ul>
		</div>
	
		<div class="chatting-area">
			<ul class="chatting-list">
				<c:forEach var="room" items="${roomList}">

					<li class="chatting-item" chat-no="${room.chattingNo}" target-no="${room.targetNo}">
						<div class="item-header">
							<c:if test="${not empty room.targetProfile}">
								<img class="list-profile" src="${room.targetProfile}">
							</c:if>
							<c:if test="${empty room.targetProfile}">
								<img class="list-profile" src="/resources/images/user.png">
							</c:if>
						</div>
						<div class="item-body">
							<p>
								<span class="target-name">${room.targetNickName}</span>
								<span class="recent-send-time">${room.sendTime}</span>
							</p>
							<div>
								<p class="recent-message">${room.lastMessage}</p>

								<c:if test="${room.notReadCount > 0}">
									<p class="not-read-count">${room.notReadCount}</p>
								</c:if>
							</div>
						</div>
					</li>

				</c:forEach>

			</ul>

			<div class="chatting-content">
				<ul class="display-chatting">
					<%-- <li class="my-chat">
						<span class="chatDate">14:01</span>
						<p class="chat">가나다라마바사</p>
					</li>

					<li class="target-chat">
						<img src="/resources/images/user.png">

						<div>
							<b>이번유저</b>	<br>
							<p class="chat">
								안녕하세요?? 반갑습니다.<br>
								ㅎㅎㅎㅎㅎ
							</p>
							<span class="chatDate">14:05</span>
						</div>
					</li> --%>
				</ul>	
			
				<div class="input-area">
					<textarea id="inputChatting" rows="3"></textarea>
					<button id="send">보내기</button>
				</div>
			</div>
		</div>
	</main>

	<jsp:include page="../common/footer.jsp"></jsp:include>

   
	<!--------------------------------------- sockjs를 이용한 WebSocket 구현을 위해 라이브러리 추가 ---------------------------------------------->
	
	<!-- https://github.com/sockjs/sockjs-client -->
	<script src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>
	<script>
		// 로그인한 회원 번호
		const loginMemberNo = "${loginMember.memberNo}";
	</script>

	<script src="/resources/js/chatting//chatting.js"></script>
</body>
</html>
