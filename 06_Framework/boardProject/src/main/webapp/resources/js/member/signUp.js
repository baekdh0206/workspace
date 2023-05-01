// 회원 가입 JS

/* 정규 표현식(Regular Expression)
    https://regexper.com/
    https://regexr.com/
    https://developer.mozilla.org/ko/docs/Web/JavaScript/Guide/%EC%A0%95%EA%B7%9C%EC%8B%9D

    - 특정한 규칙을 가진 문자열 집합을 표현하는데 사용하는 형식 언어
    - 문자열에 대한 검색, 일치 여부, 치환 등을 수행할 수 있음


    *** JS 정규표현식 객체 생성 방법 ***

    1.  const regEx = new RegExp("정규표현식");
    2.  const regEx = /정규표현식/;


    *** 정규표현식 객체가 제공하는 메서드(함수) ***
    1.  regEx.test(문자열)
        -> 문자열이 정규표현식 패턴에 부합하면 true, 아니면 false

    2.  regEx.exec(문자열)
        -> 문자열이 정규표현식 패턴에 부합하면
            첫 번째 매칭되는 문자열을 반환,
            없으면 null 반환


     *** 정규 표현식의 메타 문자***
        
    문자열의 패턴을 나타내는 문자.
    문자마다 지정된 특별한 뜻이 담겨있다.
    
    a (일반문자열) : 문자열 내에 a라는 문자열이 존재하는 검색 
    [abcd] : 문자열 내에 a,b,c,d 중 하나라도 일치하는 문자가 있는지 검색
    ^(캐럿) : 문자열의 시작을 의미
    $(달러) : 문자열의 끝을 의미

    \w (word, 단어) : 아무 글자(단, 띄어쓰기, 특수문자, 한글 X)
    \d (digit, 숫자) : 아무 숫자(0~9 중 하나)
    \s (space, 공간) : 아무 공백 문자(띄어쓰기, 엔터, 탭 등)

    [0-9]  : 0부터 9까지 모든 숫자
    [ㄱ-힣] : ㄱ부터 힣까지  모든 한글

    [가-힣] : 가부터 힣까지  모든 한글(자음만, 모음만 있는 경우 제외)

    [a-z] : 모든 영어 소문자
    [A-Z] : 모든 영어 대문자

    * 특수문자의 경우 각각을 입력하는 방법밖엔 없음
    단, 메타문자와 중복되는 특수문자는 
    앞에 \(백슬래시)를 추가하여 탈출 문자(Escape)로 만들어 사용

    * 수량 관련 메타 문자
    a{5} : a문자가 5개 존재 == aaaaa
    a{2,5} : a가 2개 이상 5개 이하 ==  aa, aaa, aaaa, aaaaa
    a{2,} : a가 2개 이상
    a{,5} : a가 5개 이하


    * : 0개 이상 == 0번 이상 반복 == 있어도되고, 없어도 되고

    + : 1개 이상 == 1번 이상 반복

    ? : 0개 또는 1개

    . : 1칸 (개행문자를 제외한 문자 하나)
*/


// 이메일 유효성 검사
const memberEmail = document.getElementById("memberEmail");
const emailMessage = document.getElementById("emailMessage");

// 이메일이 입력될 때 마다
memberEmail.addEventListener("input", () => {

    // 입력된 이메일이 없을 경우
    if(memberEmail.value.trim().length == 0){
        memberEmail.value = ""; 

        emailMessage.innerText = "메일을 받을 수 있는 이메일을 입력해주세요.";

        // confirm, error 클래스 삭제해서 검정 글씨로 만들기
        emailMessage.classList.remove("confirm", "error");

        return;
    }




    // 정규 표현식을 이용해서 유효한 형식이지 판별

    // 1) 정규표현식 객체 생성
    const regEx = /^[A-Za-z\d\-\_]{4,}@[가-힣\w\-\_]+(\.\w+){1,3}$/;

    // 2) 입력 받은 이메일과 정규식 일치 여부 판별
    if(  regEx.test(memberEmail.value)  ){ // 유효한 경우
        emailMessage.innerText = "유효한 형식 입니다";
        emailMessage.classList.add("confirm"); // .confirm 스타일 적용
        emailMessage.classList.remove("error"); // .error 스타일 제거
        
    } else{ // 유효하지 않은 경우(무효인 경우)
        emailMessage.innerText = "이메일 형식이 유효하지 않습니다";
        emailMessage.classList.add("error"); // .error 스타일 적용
        emailMessage.classList.remove("confirm"); // .confirm 스타일 제거
    }

});