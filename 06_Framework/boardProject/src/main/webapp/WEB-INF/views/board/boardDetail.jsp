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

    <%-- 누가(로그인한 회원 번호) 
        어떤 게시글(현재 게시글 번호) 좋아요를 클릭/취소 
        
        
    로그인한 회원 번호 얻어오기
    1) ajax로 session에 있는 loginMember의 memberNo를 반환
    2) HTML 요소에 로그인한 회원의 번호를 숨겨 놓고 JS로 얻어오기
    3) jsp 파일 제일 위에있는 script 태그에 JS + EL 이용해서
        전역 변수로 선언해두기
    --%>

    <script>
        // JSP에서 작성 가능한 언어/라이브러리
        // -> html, css, js, java, EL, JSTL 

        // JSP 해석 우선 순위 :  Java/EL/JSTL > HTML,CSS,JS

        // 게시글 번호 전역 변수로 선언
        const boardNo = "${board.boardNo}";

        // 로그인한 회원 번호를 전역 변수로 선언
        // -> 작성한 EL 구문이 null일 경우 빈칸으로 출력되어
        //    변수에 값이 대입되지 않는 문제가 발생할 수 있음!
        // 해결방법 : EL 구문을 '', "" 문자열로 감싸면 해결
        //      -> EL 값이 null이여도 ""(빈문자열)로 출력

        const loginMemberNo = "${loginMember.memberNo}";

        console.log(boardNo);
        console.log(loginMemberNo);

    </script>

    <script src="/resources/js/board/boardDetail.js"></script>
    <script src="/resources/js/board/comment.js"></script>
    
</body>
</html>