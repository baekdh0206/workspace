<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>

<c:forEach items="${boardTypeList}" var="boardType">
    <c:if test="${boardType.BOARD_CODE == boardCode}" >
        <c:set var="boardName" value="${boardType.BOARD_NAME}"/>
    </c:if>
</c:forEach>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${boardName}</title>

    <link rel="stylesheet" href="/resources/css/board/boardDetail-style.css">
    <link rel="stylesheet" href="/resources/css/board/comment-style.css">

</head>
<body>
    <main>
        <jsp:include page="/WEB-INF/views/common/header.jsp"/>

        <section class="board-detail">  
            <!-- 제목 -->
            <h1 class="board-title">${board.boardTitle}  <span> - ${boardName}</span>    </h1>

            <!-- 프로필 + 닉네임 + 작성일 + 조회수 -->
            <div class="board-header">
                <div class="board-writer">

                    <!-- 프로필 이미지 -->
                    <c:choose>
                        <c:when test="${empty board.profileImage}">
                            <%-- 프로필 이미지가 없을 경우 기본 이미지 출력 --%>
                            <img src="/resources/images/user.png">
                        </c:when>
                        
                        <c:otherwise>
                            <%-- 프로필 이미지가 있을 경우 출력 --%>
                            <img src="${board.profileImage}">
                        </c:otherwise>
                    </c:choose>

                    <span>${board.memberNickname}</span>

                    
                    <!-- 좋아요 하트 -->
                    <span class="like-area">
                        
                        <%-- 좋아요 누른적이 없거나, 로그인 --%>
                        <c:if test="${empty likeCheck}">
                            <i class="fa-regular fa-heart" id="boardLike"></i>
                        </c:if>

                        <%-- 좋아요 누른적이 있을 때 --%>
                        <c:if test="${not empty likeCheck}">
                            <i class="fa-solid fa-heart" id="boardLike"></i>
                        </c:if>

                        <span>${board.likeCount}</span>
                    </span>

                </div>

                <div class="board-info">
                    <p> <span>작성일</span> ${board.boardCreateDate} </p>     

                    <!-- 수정한 게시글인 경우 -->
                    <c:if test="${not empty board.boardUpdateDate}" >
                        <p> <span>마지막 수정일</span>  ${board.boardUpdateDate} </p>   
                    </c:if>

                    <p> <span>조회수</span> ${board.readCount} </p>                    
                </div>
            </div>

            <!-- 이미지가 있을 경우 -->
            <c:if test="${not empty board.imageList}" >
            
                <!-- 썸네일 영역(썸네일이 있을 경우) -->
                <%--  
                    - 이미지는 IMG_ORDER 오름차순을 정렬된다
                    - IMG_ORDER의 값이 0인 이미지가 썸네일이다
                    -> imageList에 썸네일이 있다면
                        조회 되었을 때 IMG_ORDER가 0인 이미지가
                        imageList [0]에 저장 되었을 것이다
                --%>
                <c:if test="${board.imageList[0].imageOrder == 0}">
                    <h5>썸네일</h5>
                    <div class="img-box">
                        <div class="boardImg thumbnail">
                            <img src="${board.imageList[0].imagePath}${board.imageList[0].imageReName}">                     
                            <a href="${board.imageList[0].imagePath}${board.imageList[0].imageReName}"
                                download="${board.imageList[0].imageOriginal}">다운로드</a>         
                        </div>
                    </div>
                </c:if>

                <%-- 썸네일을 제외한 나머지 이미지의 시작 인덱스 번호 --%>
                <%-- 썸네일이 있을 경우 --%>
                <c:if test="${board.imageList[0].imageOrder == 0}" >
                    <c:set var="start" value="1"/>
                </c:if>

                <%-- 썸네일이 없을 경우 --%>
                <c:if test="${board.imageList[0].imageOrder != 0}" >
                    <c:set var="start" value="0"/>
                </c:if>


                <%-- ${fn:length(board.imageList)} : imageList의 길이 --%>

                <%-- 일반 이미지가 있을 경우 --%>
                <c:if test="${fn:length(board.imageList) > start}" >

                    <!-- 업로드 이미지 영역 -->
                    <h5>업로드 이미지</h5>
                    <div class="img-box">
                        
                        <c:forEach var="i" begin="${start}" end="${fn:length(board.imageList) - 1}">        

                            <div class="boardImg">
                                <c:set var="path" 
                                    value="${board.imageList[i].imagePath}${board.imageList[i].imageReName}"/>

                                <img src="${path}">   

                                <a href="${path}" 
                                    download="${board.imageList[i].imageOriginal}">다운로드</a>                
                            </div>

                        </c:forEach>


                    </div>
                </c:if>


            
            </c:if>



            


            <!-- 내용 -->
            <div class="board-content">${board.boardContent}</div>


            <!-- 버튼 영역-->
            <div class="board-btn-area">


                <!-- 로그인한 회원과 게시글 작성자 번호가 같은 경우-->
                <c:if test="${loginMember.memberNo == board.memberNo}" >
                    <button id="updateBtn">수정</button>
                    <button id="deleteBtn">삭제</button>
                </c:if>



                <button id="goToListBtn">목록으로</button>
            </div>


        </section>

        <!-- 댓글 include-->
        <jsp:include page="comment.jsp"/>
    </main>

    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>


</body>
</html>