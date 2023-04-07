// 이 파일 자체가 script 태그라고 생각

// 한 줄 주석
/* 범위 주석 */

function btnClick2(){
    alert("external 버튼이 클릭됨");
}


// 다크모드
function darkMode(){
    const body = document.querySelector("body");

    // ** JS는 카멜 표기법! **
    body.style.backgroundColor = 'black';
    body.style.color = 'white';
}

// 라이트모드
function lightMode(){
    const body = document.querySelector("body");

    // ** JS는 카멜 표기법! **
    body.style.backgroundColor = 'white';
    body.style.color = 'black';
}