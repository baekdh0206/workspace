
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


// 자료형 확인
function typeTest(){

    // typeof 연산자 : 자료형을 검사하는 연산자

    const box = document.getElementById("typeBox");
    
    // undefined
    let temp; // 선언 후 값 초기화 X -> undefined
    box.innerHTML = "temp : " + typeof temp;

    // string
    const name = "홍길동";
    box.innerHTML += "<br>name : " + name + " / " + typeof name;

    const gender = 'M';
    box.innerHTML += "<br>gender : " + gender + " / " + typeof gender;

    const phone = '01012341234';
    box.innerHTML += "<br>phone : " + phone + " / " + typeof phone;

    /* '' , "" 둘 다 string!! */


    // number
    const age = 20; // 정수
    const height = 178.9; // 실수

    box.innerHTML += "<br>age : " + age + " / " + typeof age;
    box.innerHTML += "<br>height : " + height + " / " + typeof height;


    // boolean
    const isTrue = true;
    box.innerHTML += "<br>isTrue : " + isTrue + " / " + typeof isTrue;


    // object
    
    // Java --> int[] arr = {10,20,30,40,50};
    // JS의 배열(== object),  초기화에 [] 사용!!
    const arr = [10, 20, 30, 40, 50];
    box.innerHTML += "<br>arr : " + arr + " / " + typeof arr;

    
    // Java 객체 --> class에 작성된 내용대로 메모리(heap)에 할당

    // JS의 객체는 {K:V} Map형식으로 작성
    // ** key는 무조건 string으로 고정 **

    const user = {"id":"user01",  'pw':'pass01', address:'서울시 중구'};
    box.innerHTML += "<br>user : " + user + " / " + typeof user;

    console.log(user); // 콘솔로 객체 출력 시 
                        // 브라우저가 파악하기 쉽게 바꿔서 출력

    // 객체 V 출력 방법 (1)
    box.innerHTML += "<br>user.id : " + user.id;
    box.innerHTML += "<br>user.pw : " + user.pw;
    box.innerHTML += "<br>user.address : " + user.address;

    // 객체 V 출력 방법 (2)
    box.innerHTML += "<br>user['id'] : " + user['id'];
    box.innerHTML += "<br>user['pw'] : " + user['pw'];
    box.innerHTML += "<br>user['address'] : " + user['address'];



    // function (* 함수도 자료형이다!!! *)
    const sumFn = function(n1, n2){ return n1 + n2; }

    box.innerHTML += "<br>sumFn : " + sumFn + " / " + typeof sumFn;

    // 함수명만 작성 : 함수에 작성된 코드가 그대로 출력
    // 함수명() 작성 : 함수 실행(함수 호출)

    box.innerHTML += "<br>sumFn(1,2) : " + sumFn(1,2);

    // doubleFn 함수 호출
    box.innerHTML += "<br>doubleFn(sumFn) : " + doubleFn(sumFn);
}

function doubleFn(fn){ 
            //const fn = function(n1, n2){ return n1 + n2; }
    // 전달 받은 함수의 결과를 2배로 반환하는 함수
    return fn(1,2) * 2;
}


