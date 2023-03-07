/* SELECT (조회, DQL 또는 DML)
 * 
 * - 데이터를 조회하면 조건에 맞는 행들이 조회됨
 *   -> 조회된 행들의 집합을 "RESULT SET"이라고 한다.
 * 
 * - RESULT SET은 0개 이상의 행이 포함될 수 있다.
 *   -> 왜 0개 이상?? 조건에 맞는 행이 없을 수도 있기 때문에...

 * 
 * [작성법]
 * 
 * SELECT 컬럼명 | *(모든 컬럼)
 * FROM 테이블명
 * WHERE 조건식; -- 조건에 맞는 행만 조회
 * 
 *  * */

-- EMPLOYEE 테이블에서 모든 행, 모든 컬럼을 조회
-- (WHERE절 없음 == 모든 행)
-- '*' : ALL, 모두, 전부 
SELECT * FROM EMPLOYEE;

SELECT EMP_NAME FROM EMPLOYEE;

SELECT EMP_ID, EMP_NAME, PHONE FROM EMPLOYEE;


-- DEPARTMENT 테이블의 모든 행, 열 조회
SELECT * FROM DEPARTMENT;

-- DEPARTMNET 테이블에서 부서명만 조회
--> 테이블 정보에서 컬럼명, COMMENT 확인
SELECT DEPT_TITLE FROM DEPARTMENT;

-------------------------------------------------------

-- <컬럼 값 산술 연산>

-- 컬럼 값 : 행과 열이 교차되는 테이블의 한 칸(== 한 셀)에 작성된 값(DATA)

-- SELECT 문 작성 시 컬럼명에 산술 연산을 작성하면
--  조회되는 결과 컬럼 값에 산술 연산이 반영된다.

-- EMPLOYEE 테이블에서 모든 사원의 사번, 이름, 급여, 급여 + 100만을 조회
SELECT EMP_ID, EMP_NAME, SALARY, SALARY + 1000000
FROM EMPLOYEE;


-- EMPLOYEE 테이블에서 모든 사원의 이름, 연봉(급여 * 12) 조회
SELECT EMP_NAME, SALARY * 12 FROM EMPLOYEE;

-------------------------------------------------------------------

-- (중요!!) <오늘 날짜 조회>

SELECT SYSDATE FROM DUAL;
-- SYSDATE : 시스템상의 현재 날짜(시간)

-- DUAL(DUmmy tAbLe) : 가짜 테이블(실제 테이블이 아닌 임시 테이블 용도)
SELECT 100*20+30 FROM DUAL;

-- 어제, 오늘, 내일 조회
--> DATE 타입에 +,- 연산 가능(일 단위) 
SELECT SYSDATE-1, SYSDATE, SYSDATE+1
FROM DUAL;

-- 한 시간 후 조회
SELECT SYSDATE + (1/24) FROM DUAL;

-- 1분 후 조회
SELECT SYSDATE + (1/24/60) FROM DUAL;

-- 30분 후 조회
SELECT SYSDATE + (1/24/60*30) FROM DUAL;

-- EMPLOYEE 테이블에서 이름, 입사일, 오늘 까지 근무할 날짜 조회
-- 시간 끼리 연산 가능 (미래로 갈수록 큰 수)
-- 연산 결과는 일 단위로 조회
SELECT EMP_NAME, HIRE_DATE, (SYSDATE - HIRE_DATE) / 365
FROM EMPLOYEE;

-------------------------------------------------------------

-- <컬럼 별칭 지정>

-- 별칭 지정 방법
-- 1) 컬럼명 AS 별칭 : 문자O, 띄어쓰기 X, 특수문자 X
-- 2) 컬럼명 AS "별칭" : 문자O, 띄어쓰기 O, 특수문자 O
-- 3) 컬럼명 별칭 : 문자O, 띄어쓰기 X, 특수문자 X
-- 4) 컬럼명 "별칭" : 문자O, 띄어쓰기 O, 특수문자 O

-- EMPLOYEE 테이블에서 이름, 연봉 조회
SELECT EMP_NAME AS "[사원 이름]", SALARY * 12 "사원 연봉"
FROM EMPLOYEE;

----------------------------------------------------------------------------

-- 리터럴 : 표현되는 값 자체
-- DB에서 리터럴 : 임의로 지정한 값을 기존 테이블에 존재하는 값 처럼 사용
--> 리터럴 표기법 : ''(홑따옴표, 기본적으로 문자열 의미)
SELECT EMP_NAME, SALARY, '원' AS 단위
FROM EMPLOYEE;

------------------------------------------------------------

-- <DISTINCT> (별개의, 따로따로)
--> 조회 시 지정된 컬럼에 중복 값을 한 번만 표시할 때 사용

-- EMPLOYEE 테이블에서 현재 사원들이 속해있는 부서 코드 종류 조회
SELECT DISTINCT DEPT_CODE FROM EMPLOYEE;

---------------------------------------------------------------------

-- <WHERE 절>
-- 테이블에서 조건을 충족하는 컬럼 값을 가진 행만 조회할 때 사용

-- WHERE 절에는 조건식(TRUE/FALSE)을 작성

-- 비교 연산자 : >, >=, <, <=, = (같다), !=, <> (같지 않다)
-- 논리 연산자 : AND, OR, NOT

-- EMPLOYEE 테이블에서 급여가 3백만원 초과인 사원의
-- 사번, 이름, 급여, 부서코드 조회
/*해석 순서*/
/*3*/ SELECT EMP_ID, EMP_NAME, SALARY, DEPT_CODE
/*1*/ FROM EMPLOYEE
/*2*/ WHERE SALARY > 3000000;
-- 단, SALARY 값이 300만 초과


-- EMPLOYEE 테이블에서
-- 연봉이 5천만원 이하인 사원의 사번, 이름 조회
/*3*/ SELECT EMP_ID, EMP_NAME
/*1*/ FROM EMPLOYEE
/*2*/ WHERE SALARY * 12 <= 50000000;


-- EMPLOYEE 테이블에서 부서코드가 'D9'이 아닌 사원의
-- 사번, 이름, 부서코드, 전화번호 조회
SELECT EMP_ID 사번, EMP_NAME 이름, DEPT_CODE 부서코드, PHONE 전화번호
FROM EMPLOYEE
WHERE DEPT_CODE <> 'D9';


-- EMPLOYEE 테이블에서 부서코드가 'D6'이고
-- 급여가 300만 이상인 사원의
-- 이름, 급여, 부서코드 조회
SELECT EMP_NAME, SALARY, DEPT_CODE
FROM EMPLOYEE
WHERE DEPT_CODE = 'D6'
AND SALARY >= 3000000;


-- EMPLOYEE 테이블에서 
-- 급여가 300만 이상 500만 이하인 직원의 모든 컬럼 조회
SELECT *
FROM EMPLOYEE
WHERE SALARY >= 3000000 AND SALARY <= 5000000;


-- 컬럼명 BETWEEN A AND B : 컬럼 값이 A이상 B 이하인 경우 TRUE
SELECT * 
FROM EMPLOYEE
WHERE SALARY BETWEEN 3000000 AND 5000000;


-- EMPLOYEE 테이블에서 
-- 급여가 300만 이상 500만 이하가 아닌 직원의 모든 컬럼 조회
--  == 300만 미만, 500만 초과

-- NOT BETWEEN A AND B : 
-- 컬럼 값이 A 이상 B 이하가 아닌경우
-- == A 미만 , B 초과
SELECT *
FROM EMPLOYEE
--WHERE SALARY < 3000000 OR SALARY > 5000000;
WHERE SALARY NOT BETWEEN 3000000 AND 5000000;



-- EMPLOYEE 테이블에서 
-- 부서코드가 'D5' 또는 'D6' 또는 'D9'인 사원의
-- 사번, 이름, 부서코드 조회
SELECT EMP_ID, EMP_NAME, DEPT_CODE
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
OR    DEPT_CODE = 'D6'
OR    DEPT_CODE = 'D9';


-- 컬럼명 IN (값1, 값2, 값3, ...) : 컬럼 값에 () 안의 값이 포함된 행은 TRUE

SELECT EMP_ID, EMP_NAME, DEPT_CODE
FROM EMPLOYEE
WHERE DEPT_CODE IN ('D5','D6','D9');



-- EMPLOYEE 테이블에서 
-- 부서코드가 'D5' 또는 'D6' 또는 'D9' 아닌 사원의
-- 사번, 이름, 부서코드 조회
SELECT EMP_ID, EMP_NAME, DEPT_CODE
FROM EMPLOYEE
WHERE DEPT_CODE != 'D5'
AND   DEPT_CODE != 'D6'
AND   DEPT_CODE != 'D9';


-- NOT IN(값1, 값2, 값3,...) : ()내 값을 제외한 행 TRUE
SELECT EMP_ID, EMP_NAME, DEPT_CODE
FROM EMPLOYEE
WHERE DEPT_CODE NOT IN ('D5','D6','D9');


--------------------------------------------------------------

-- <NULL 처리 연산>

-- JAVA에서 NULL : 참조하는 객체가 없다.
-- DB에서   NULL : 컬럼 값이 없다.

-- IS NULL     : 컬럼 값이 NULL인      경우 TRUE
-- IS NOT NULL : 컬럼 값이 NULL이 아닌 경우 TRUE


-- EMPLOYEE 테이블에서 부서가 없는 사원의 모든 컬럼 조회
SELECT * 
FROM EMPLOYEE
WHERE DEPT_CODE IS NULL;

-- EMPLOYEE 테이블에서 부서가 있는 사원의 모든 컬럼 조회
SELECT * 
FROM EMPLOYEE
WHERE DEPT_CODE IS NOT NULL;

-----------------------------------------------------------

-- 연결 연산자( || )
-- 여러 값을 하나의 컬럼 값으로 연결하는 연산자
-- (== 자바의 문자열 이어쓰기(+) )

-- OOO의 급여는 OOO원 입니다.
SELECT EMP_NAME || '의 급여는 ' || SALARY || '원 입니다.' AS 결과
FROM EMPLOYEE;

-- '' : 값, 리터럴
-- "" : 계정명, 비밀번호, 컬럼명, 테이블명   
--      값이 아닌 것들에 대한 대소문자 구분

-----------------------------------------------------------------------

/* LIKE
 * 
 * - 비교하려는 값이 특정한 패턴을 만족 시키면(TRUE) 조회하는 연산자
 * 
 * [작성법]
 * WHERE 컬럼명 LIKE '패턴'
 * 
 * - LIKE 패턴( == 와일드 카드  ) 
 * 
 * '%' (포함)
 * - '%A' : 문자열이 앞은 어떤 문자든 포함되고 마지막은 A
 * 			-> A로 끝나는 문자열
 * - 'A%' : A로 시작하는 문자열
 * - '%A%' : A가 포함된 문자열
 *  
 * 
 * '_' (글자 수)
 * - 'A_' : A 뒤에 아무거나 한 글자만 있는 문자열
 *          (AB ,A1, AQ, A가)
 * 
 * - '___A' : A 앞에 아무거나 3글자만 있는 문자열
 */

-- EMPLOYEE 테이블에서 성이 '전' 씨인 사원의 사번, 이름 조회
SELECT EMP_ID, EMP_NAME -- 3
FROM EMPLOYEE  -- 1
WHERE EMP_NAME LIKE '전%'; -- 2


-- EMPLOYEE 테이블에서 이름에 '하'가 포함되는 사원의 사번, 이름 조회
SELECT EMP_ID, EMP_NAME
FROM EMPLOYEE
WHERE EMP_NAME LIKE '%하%';

-- EMPLOYEE 테이블에서
-- 전화번호가 '010'으로 시작하는 사원의 
-- 사번, 이름, 전화번호 조회
SELECT EMP_ID, EMP_NAME, PHONE
FROM EMPLOYEE
--WHERE PHONE LIKE '010%';
WHERE PHONE LIKE '010________';


-- EMPLOYEE 테이블에서
-- 전화번호가 '010'으로 시작하지 않는 사원의 
-- 사번, 이름, 전화번호 조회
--> NOT LIKE
SELECT EMP_ID, EMP_NAME, PHONE
FROM EMPLOYEE
WHERE PHONE NOT LIKE '010%'
OR PHONE IS NULL; 

-- EMPLOYEE 테이블에서
-- 이메일에 @ 앞글자가 5글자인 사원의 
-- 사번, 이름, 이메일 조회
SELECT EMP_ID, EMP_NAME, EMAIL
FROM EMPLOYEE
WHERE EMAIL LIKE '_____@%';

-- EMPLOYEE 테이블에서
-- 이메일에 _ 앞글자가 3글자인 사원의 
-- 사번, 이름, 이메일 조회
SELECT EMP_ID, EMP_NAME, EMAIL
FROM EMPLOYEE
WHERE EMAIL LIKE '____%';
--> 문제점 : 와일드 카드 문자(_)와 패턴에 사용된 일반 문자가
--           같은 문자 이기 때문에 구분이 안되는 문제가 발생

--> 해결 방법 : ESCAPE 옵션을 이용하여 일반 문자(_)를 구분

SELECT EMP_ID, EMP_NAME, EMAIL
FROM EMPLOYEE
WHERE EMAIL LIKE '___#_%' ESCAPE '#';
				--> '#' 뒤에 한 글자(_)를 일반 문자로 벗어나게함


--------------------------------------------------------

-- <WHERE절 날짜(시간) 비교>
-- EMPLOYEE 테이블에서 입사일(고용일)이
-- '1990/01/01' ~ '2000/12/31' 사이인 사원의
-- 사번, 이름, 고용일 조회
SELECT EMP_ID, EMP_NAME, HIRE_DATE
FROM EMPLOYEE
WHERE HIRE_DATE >= '1990/01/01'
AND   HIRE_DATE <= '2000-12-31';
--> '1990/01/01' == 문자열 -> DATE 타입으로 변경
--> 오라클 DB는 작성된 값이 다른 형식의 데이터 타입이여도
--  표기법이 다른 데이터 타입과 일치하다면
--  자동으로 데이터 타입을 변경 할 수 있다.

SELECT EMP_NAME, SALARY FROM EMPLOYEE
WHERE SALARY >= '3000000';
-- 3000000 : NUMBER
-- '3000000' : CHAR


-------------------------------------------------------
/* ORDER BY 절
 * 
 * - SELECT문의 조회 결과(RESULT SET)를 정렬할 때 사용하는 구문
 * 
 * - *** SELECT구문에서 제일 마지막에 해석된다! ***
 * 
 * [작성법]
 * 3: SELECT 컬럼명 AS 별칭, 컬럼명, 컬럼명, ...
 * 1: FROM 테이블명
 * 2: WHERE 조건식
 * 4: ORDER BY 컬럼명 | 별칭 | 컬럼 순서 [오름/내림 차순] 
 * 	        [NULLS FIRST | LAST]
 * */

-- EMPLOYEE 테이블에서 모든 사원의 이름, 급여를
-- 급여 오름차순으로 조회
SELECT EMP_NAME, SALARY
FROM EMPLOYEE
ORDER BY SALARY /*ASC*/;
	--> 오름차순(ASC)가 기본값

-- 급여 내림차순으로 조회
SELECT EMP_NAME, SALARY
FROM EMPLOYEE
ORDER BY SALARY DESC;
	--> 내림차순을 원할경우 DESC 작성

-- 급여가 200만 이상인 사원을 급여 오름차순으로 조회
SELECT EMP_NAME, SALARY
FROM EMPLOYEE
WHERE SALARY >= 2000000
ORDER BY SALARY;

/*** 문자열, 날짜, 숫자 모두 정렬 가능 ***/

-- 이름 오름차순 정렬
SELECT EMP_NAME FROM EMPLOYEE ORDER BY EMP_NAME;

-- 입사일 내림차순 정렬
SELECT EMP_NAME, HIRE_DATE
FROM EMPLOYEE
ORDER BY HIRE_DATE DESC;

-- ORDER BY절에 별칭|순서 사용하기

-- 연봉 내림차순 조회
/*2*/SELECT EMP_NAME, SALARY * 12 AS 연봉
/*1*/FROM EMPLOYEE
/*3*/ORDER BY /*SALARY * 12*/ /*연봉*/   2 DESC;
			--   컬럼명      |  별칭  | 순서


/* (주의) WHERE절에서 별칭|순서는 사용할 수 없다  */
/*3*/SELECT EMP_NAME, SALARY * 12 AS 연봉
/*1*/FROM EMPLOYEE
/*2*/WHERE 연봉 >= 50000000; 
-- 오류 발생(SELECT절 해석이 안된 상태에서 별칭을 WHERE절 작성)


-- NULLS FIRST|LAST 확인
-- 전화번호 오름차순 조회
SELECT EMP_NAME, PHONE
FROM EMPLOYEE
ORDER BY PHONE /*NULLS LAST*/  NULLS FIRST;
			--  오름차순 기본값

-- 전화번호 내림차순 조회
SELECT EMP_NAME, PHONE
FROM EMPLOYEE
ORDER BY PHONE DESC /*NULLS FIRST*/ NULLS LAST;
			--  내림차순 기본값 

/* <정렬 중첩> 
 * - 큰 분류를 먼저 정렬하고, 내부 분류를 다음에 정렬하는 방식
 * */

-- 부서코드 별 급여 내림 차순 (부서코드는 내림차순)
SELECT EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
ORDER BY DEPT_CODE DESC NULLS LAST, SALARY DESC;


