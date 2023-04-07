// innerText로 내용 읽어오기
function getBoxText(){

    // HTML 웹 문서 내에서 
    // id 속성 값이 "test1"인 요소를 얻어와
    // test1 변수에 대입

    /* var(Variable : 변수) */

    /* var test1  -> 변수 test1을 선언  (자료형 선언 X) */

    /* JS는 대입되는 값에 따라 변수 자료형이 정해진다 */
    var test1 = document.getElementById("test1");

    
    // test1에 저장된 요소의 내용을 얻어와
    // 콘솔창에 출력
    console.log( test1.innerText ); /* 콘솔창 출력 */
    


}