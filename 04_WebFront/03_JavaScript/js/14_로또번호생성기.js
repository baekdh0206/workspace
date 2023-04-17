const createBtn = document.getElementById("createBtn");
const container = document.getElementById("container");

createBtn.addEventListener("click", () => {

    // 난수 배열 생성
    const arr = []; // 빈 배열

    while(arr.length < 6){ // arr에 저장된 값이 6개 미만인 경우 반복
        const random = Math.floor(Math.random() * 45 + 1); // 난수 생성

        // arr 요소 중 중복되는 값 제거
        // == arr 요소 중 중복되는 값이 있으면 push를 안하겠다
        // == arr 요소 중 중복되는 값이 없으면 push를 하겠다

        // 배열명.indexOf(값) : 값이 일치하는 요소의 index 반환
        //                      없으면 -1 반환
        if(arr.indexOf(random) == -1)  arr.push(random); 
                                        // 배열 마지막 요소로 추가
    }

    // 오름차순 정렬
    arr.sort( (a,b) => a-b ); // 내부 함수 결과가 양수면 오른쪽으로 이동
    
    for(let i=0 ; i<arr.length ; i++){
        container.children[i].innerText = arr[i];
    }

});