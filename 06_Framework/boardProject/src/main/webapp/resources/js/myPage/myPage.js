// 내 정보(수정) 페이지

const memberNickname = document.getElementById("memberNickname");
const memberTel = document.getElementById("memberTel");
const updateInfo = document.getElementById("updateInfo");

// 내 정보 수정 form태그가 존재할 때 (내 정보 페이지)
if(updateInfo != null){
    // 전역변수로 수정 전 닉네임/전화번호를 저장
    initNickname = memberNickname.value;
    initTel = memberTel.value;

    // 닉네임 유효성 검사
    memberNickname.addEventListener("input", () => {

        // 변경 전 닉네임과 입력 값이 같을 경우
        if(memberNickname.value == initNickname){ 
            memberNickname.removeAttribute("style");
            return;
        }

        // 정규 표현식으로 유효성 검사
        const regEx = /^[가-힣\w\d]{2,10}$/;

        if(regEx.test(memberNickname.value)){ // 유효
            memberNickname.style.color = "green";

        }else{ // 무효
            memberNickname.style.color = "red";
        }
    });


    // 전화번호 유효성 검사
    memberTel.addEventListener("input", () => {

        // 변경 전 전화번호와 입력 값이 같을 경우
        if(memberTel.value == initTel){ 
            memberTel.removeAttribute("style");
            return;
        }

        // 정규 표현식으로 유효성 검사
        const regEx = /^0(1[01679]|2|[3-6][1-5]|70)[1-9]\d{2,3}\d{4}$/;

        if(regEx.test(memberTel.value)){ // 유효
            memberTel.style.color = "green";

        }else{ // 무효
            memberTel.style.color = "red";
        }
    });

    
    // form태그 제출 시 유효하지 않은 값이 있으면 제출 X
    updateInfo.addEventListener("submit", e => {

        // 닉네임이 유효하지 않을 경우
        if(memberNickname.style.color == "red"){
            alert("닉네임이 유효하지 않습니다.");
            memberNickname.focus(); // 포커스 이동
            e.preventDefault(); // 기본 이벤트 제거
            return;
        }

        // 전화번호가 유효하지 않을 경우
        if(memberTel.style.color == "red"){
            alert("전화번호가 유효하지 않습니다.");
            memberTel.focus(); // 포커스 이동
            e.preventDefault(); // 기본 이벤트 제거
            return;
        }
    });
} // if end



// 비밀번호 변경 제출 시
const changePwFrm = document.getElementById("changePwFrm");
const currentPw = document.getElementById("currentPw");
const newPw = document.getElementById("newPw");
const newPwConfirm = document.getElementById("newPwConfirm");


if(changePwFrm != null){ // 비밀번호 변경 페이지인 경우

    changePwFrm.addEventListener("submit", e => {
        
        // 현재 비밀번호 미작성 시
        if(currentPw.value.trim() == ""){
            alert("현재 비밀번호를 입력해주세요");
            e.preventDefault();
            currentPw.focus();
            return;
        }

        // 비밀번호 유효성 검사
        const regEx = /^[a-zA-Z0-9\!\@\#\-\_]{6,20}$/;
        if(!regEx.test(newPw.value)){
            alert("비밀번호가 유효하지 않습니다");
            e.preventDefault();
            newPw.focus();
            return;
        }

        // 비밀번호 == 비밀번호 확인
        if(newPw.value != newPwConfirm.value){
            alert("비밀번호가 일치하지 않습니다");
            e.preventDefault();
            newPwConfirm.focus();
            return;
        }
    });
}



const secessionFrm = document.getElementById("secessionFrm");

if(secessionFrm != null){ // 탈퇴 페이지인 경우

    const memberPw = document.getElementById("memberPw");
    const agree = document.getElementById("agree");

    secessionFrm.addEventListener("submit", e => {

        if(memberPw.value.trim() == ""){ // 비밀번호 미작성
            alert("비밀번호를 작성해주세요");
            e.preventDefault();
            memberPw.focus();
            return;
        }

        if(!agree.checked){ // 동의 체크가 되지 않은 경우
            alert("약관 동의 후 탈퇴 버튼을 눌러주세요");
            e.preventDefault();
            agree.focus();
            return;
        }

        if(!confirm("정말 탈퇴 하시겠습니까?")){ // 취소 클릭 시
            alert("탈퇴 취소");
            e.preventDefault();
            return;
        }
    });



}