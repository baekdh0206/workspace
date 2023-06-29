const count = document.getElementById("count");
const content = document.getElementById("content");

content.addEventListener("input", e => {

    let input = e.target;

    // 150글자 입력되는 순간 글자 수를 빨간색으로 변경
    // 150글자를 초과해서 작성한 부분은 삭제

    // 150글자 이상 -> #count에 error 클래스 추가
    if (input.value.length >= 150) {

        count.classList.add("error");
        input.value = input.value.substring(0, 150);

    } else { // 150글자 이하 -> #count에 error 클래스 제거
        count.classList.remove("error");
    }

    count.innerText = input.value.length;

});


document.getElementById('sample').addEventListener('click', ()=>{
    const chars = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';
    let str = '';

    for (let i = 0; i < 149; i++) {
        str += chars.charAt(Math.floor(Math.random() * chars.length));
    }

    content.value = str;
    count.innerText = str.length;
})