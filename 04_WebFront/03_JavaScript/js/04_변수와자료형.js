
// 전역 변수
var str = "JS코드를 함수 내부가 아닌 "
        + "JS파일 또는 script태그에 바로 작성하면 "
        + "HTML 랜더링 시 바로 수행된다.";

// clg 쓰면 자동 완성 됩니다!
console.log(str);

// 변수 선언 위치에 따른 구분
var num1 = 1;   // 전역 변수
num2 = 2;       // 전역 변수

console.log("(전)num1 : " + num1);
console.log("(전)num2 : " + num2);

function testFn(){
    var num3 = 3; // function 지역 변수
    num4 = 4;     // 전역 변수

    console.log("함수 내부에서 선언된 (함)num3 : " + num3);
    console.log("함수 내부에서 선언된 (전)num4 : " + num4);

    if(1 == 1){ // 무조건 if문 수행
        var num5 = 5;   // function 지역 변수
        num6 = 6;       // 전역 변수
    }

    console.log("if문 종료 후 (if)num5 : " + num5);
    console.log("if문 종료 후 (if)num6 : " + num6);

}

// 함수 호출
testFn();

// num3 is not defined(정의 되지 않음 == 존재하지 않거나 접근 불가능)
// console.log("함수 밖에서 (함)num3 : " + num3);

// JS 코드 중간에 에러가 발생하면
// 같은 파일/함수 내 에러 이후 부분 코드가 해석되지 않는다.
console.log("함수 밖에서 (전)num4 : " + num4);


// 에러 발생
// console.log("함수 밖에서 (if)num5 : " + num5); 
console.log("함수 밖에서 (if)num6 : " + num6);



// var 변수명 중복 확인
var testValue = 10;
console.log(testValue);

var testValue = 20;
console.log(testValue);


// let/const 확인
let let1 = 10;
// let let1 = 20; // 변수명 중복 X

// const는 let이랑 똑같은데 상수인 점만 다름!
const temp = 999;
// temp = 1000; //typeError: Assignment to constant variable.

function testFn2(){
    let let1 = 20;
    let let2 = 200;

    if(1==1){
        let let1 = 30;
        let let3 = 300; // let3 is not defined
    }

    // console.log("if문 내부 let3 : " + let3);
}

testFn2(); // 함수 호출
// console.log("함수 내부에 선언한 let2 : " + let2); // 에러
// let2 is not defined


// var의 호이스팅(hoisting) : 
//  변수가 선언되기 전에 사용 가능하게 하는 기술
// -> error가 발생하지 않고 undefined로 출력됨
console.log(test);
var test = 10;
console.log(test);


