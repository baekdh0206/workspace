
const loginFrm = document.getElementById("loginFrm");

const memberEmail = document.querySelector("#loginFrm input[name='memberEmail']");
const memberPw = document.querySelector("#loginFrm input[name='memberPw']");

if(loginFrm != null){
    // 로그인 시도를 할 때
    loginFrm.addEventListener("submit", e => {
        
        // alert("로그인");

        // form태그 기본 이벤트 제거
        // e.preventDefault();

        // 이메일이 입력되지 않은 경우
        // 문자열.trim() : 문자열 좌우 공백 제거
        if(memberEmail.value.trim().length == 0){
            alert("이메일을 입력해주세요.");

            memberEmail.value = ""; // 잘못 입력된 값(공백) 제거
            memberEmail.focus(); // 이메일 input태그에 초점을 맞춤

            e.preventDefault(); // 제출 못하게하기
            return; 
        }


        // 비밀번호가 입력되지 않은 경우
        if(memberPw.value.trim().length == 0){
            alert("비밀번호를 입력해주세요.");

            memberPw.value = ""; // 잘못 입력된 값(공백) 제거
            memberPw.focus(); // 이메일 input태그에 초점을 맞춤

            e.preventDefault(); // 제출 못하게하기
            return; 
        }


    });
}

// 비동기로 이메일이 일치하는 회원의 닉네임 조회
function selectNickname(email){

    fetch("/selectNickname?email=" + email)  
        // 지정된 주소로 GET방식 비동기 요청(ajax)
		// 전달하고자 하는 파라미터를 주소 뒤 쿼리스트링으로 추가

    .then(response => response.text() ) // 요청에 대한 응답 객체(response)를 필요한 형태로 파싱

    .then(nickname => { console.log(nickname)}) // 첫 번째 then에서 파싱한 데이터를 이용한 동작 작성

    .catch( e => { console.log(e)}); // 예외 발생 시 처리할 내용을 작성

}




// 닉네임이 일치하는 회원의 전화번호 조회
const inputNickname = document.getElementById("inputNickname");
const btn1 = document.getElementById("btn1");
const result1 = document.getElementById("result1");

btn1.addEventListener("click", () => {

    // fetch() API를 이용해서 ajax(비동기 통신)

    // GET 방식 요청 (파라미터를 쿼리스트링으로 추가)
    fetch("/selectMemberTel?nickname=" + inputNickname.value)  
    .then( resp => resp.text() )
    // resp : 응답 객체
    // resp.text() : 응답 객체 내용을 문자열로 변환하여 반환

    .then(tel => { 
        /* 비동기 요청 후 수행할 코드 */ 
        result1.innerText = tel; // 조회 결과를 result1에 출력
    })
    // tel : 파싱되어 반환된 값이 저장된 변수

    .catch( err => console.log(err) );
    // 에러 발생 시 콘솔에 출력
});


// fetch() API를 이용한 POST 방식 요청

// 이메일을 입력 받아 일치하는 회원의 정보를 모두 조회
const inputEmail = document.getElementById("inputEmail");
const btn2 = document.getElementById("btn2");
const result2 = document.getElementById("result2");

btn2.addEventListener('click', () => {

    // POST 방식 비동기 요청

    // JSON.stringify() :  JS객체 -> JSON
    // JSON.parse()     :  JSON -> JS 객체

    fetch("/selectMember", {
        method : "POST",
        headers : {"Content-Type" : "application/json"},
        body : JSON.stringify({"email" : inputEmail.value})
    })
    .then(resp => resp.json()) // 응답 객체를 매개변수로 얻어와 파싱
    .then(member => {
        console.log(member);

        // ul(#result2)의 내부 내용 모두 없애기
        result2.innerHTML = "";
        
        const li1 = document.createElement("li");
        li1.innerText = `회원번호 : ${member.memberNo}`;

        const li2 = document.createElement("li");
        li2.innerText = `이메일 : ${member.memberEmail}`;

        const li3 = document.createElement("li");
        li3.innerText = `닉네임 : ${member.memberNickname}`;

        const li4 = document.createElement("li");
        li4.innerText = `전화번호 : ${member.memberTel}`;

        const li5 = document.createElement("li");
        li5.innerText = `주소 : ${member.memberAddress}`;

        const li6 = document.createElement("li");
        li6.innerText = `가입일 : ${member.enrollDate}`;

        result2.append(li1, li2, li3, li4, li5, li6);


    }) // 파싱한 데이터를 이용해서 비동기 처리 후 동작

    .catch(err => {
        console.log(err);
        result2.innerText = "일치하는 회원이 없습니다";
    } );
});




// 이메일이 일부라도 일치하는 모든회원 조회
const input = document.getElementById("input");
const btn3 = document.getElementById("btn3");
const result3 = document.getElementById("result3");

btn3.addEventListener("click", () => {

    fetch("/selectMemberList", {
        method : "POST",
        headers : {"Content-Type" : "application/text"}, // 문자열 하나를 파라미터로 전달
        body : input.value // 보내질 문자열 하나 
    })
    .then(resp => resp.json())
    .then(memberList => {
        console.log(memberList);

        result3.innerHTML = "";

        if(memberList.length == 0){
            result3.innerText = "조회 결과가 없습니다";
            return;
        }

        // 향상된 for문으로 memberList 순차 접근
        for(let member of memberList){

            // tr, td 만들어서 result3에 추가
            const tr = document.createElement("tr");

            const td1 = document.createElement("td");
            td1.innerText = member.memberNo;

            const td2 = document.createElement("td");
            td2.innerText = member.memberEmail;

            const td3 = document.createElement("td");
            td3.innerText = member.memberNickname;

            // 1) tr의 자식으로 td1,td2,td3 추가
            tr.append(td1, td2, td3);

            // 2) result3의 자식으로 tr 추가
            result3.append(tr);
        }
    })
    .catch(err => {
        console.log(err);
    });
});


// -------------------------------------------------------------------
// 웹소켓 테스트
// 1. SockJS 라이브러리 추가

// 2. SockJS를 이용해서 클라이언트용 웹소켓 객체 생성
let testSock = new SockJS("/testSock");

function sendMessage(name, str){
    // 매개변수를 JS 객체에 저장
    let obj = {}; // 비어있는 객체

    obj.name = name; // 객체에 일치하는 key가 없다면 자동으로 추가
    obj.str = str;

    // console.log(obj);

    // 웹소켓 연결된 곳으로 메시지를 보냄
    testSock.send(JSON.stringify(obj));         
                 // JS객체 -> JSON
}


// 웹소켓 객체(testSock)가 서버로 부터 전달 받은 메시지가 있을 경우
testSock.onmessage = e => {
    // e : 이벤트 객체
    // e.data : 전달 받은 메세지 (JSON)

    let obj = JSON.parse(e.data); // JSON -> JS 객체

    console.log(`보낸사람 : ${obj.name} / ${obj.str}`);
}