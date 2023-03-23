/* 1. 
 * 현재 재직중인 사원의
사번, 이름, 부서명, 직급명, 급여, 전화번호, 이메일
직급코드 오름차순으로 조회*/
SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY, EMAIL,
	NVL(DEPT_TITLE, '없음') DEPT_TITLE, 
	NVL(PHONE, '없음') PHONE
FROM EMPLOYEE
JOIN JOB USING(JOB_CODE)
LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
WHERE ENT_YN = 'N'
ORDER BY JOB_CODE
;


/* 2. 
 * 퇴직한 사원의
사번, 이름, 전화번호, 이메일, 퇴사일
퇴사일 오름차순으로 조회*/
SELECT EMP_ID, EMP_NAME, EMAIL,
	NVL(PHONE, '없음') PHONE,
	TO_CHAR(ENT_DATE, 'YYYY"년" MM"월" DD"일') ENT_DATE
FROM EMPLOYEE
WHERE ENT_YN = 'Y'
ORDER BY ENT_DATE 
;

/* 3.
 사번을 입력 받아 일치하는 사원의  
 사번, 이름, 부서명, 직급명, 급여, 전화번호, 이메일, 입사일, 퇴직여부 조회
 */
SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY, EMAIL, HIRE_DATE, ENT_YN,
NVL(DEPT_TITLE, '없음') DEPT_TITLE, 
NVL(PHONE, '없음') PHONE
FROM EMPLOYEE
JOIN JOB USING(JOB_CODE)
LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
WHERE EMP_ID = ?
;

/*5. 사번으로 사원 정보 수정*/
UPDATE EMPLOYEE
SET PHONE = ?,
    EMAIL = ?,
    SALARY = ?,
    BONUS = ?
WHERE EMP_ID = ?
;


-- 입력 받은 사번의 사원이 존재하지 않으면 0
-- 사원은 있는데 퇴직처리된 사원이면 1
-- 사원도 있고, 재직중인 사원이면 2  조회

-- 선택함수 DECODE / CASE
SELECT CASE 
		-- 존재하지 않는 사원?
		WHEN (SELECT COUNT(*) FROM EMPLOYEE WHERE EMP_ID = 200) = 0
		THEN 0
		
		-- 존재하지만 퇴직한 사원?
		WHEN (SELECT COUNT(*) FROM EMPLOYEE 
			  WHERE EMP_ID = 200 AND ENT_YN = 'Y') = 1
		THEN 1
		
		-- 존재는 하지만 퇴직하지 않은 사원!
		ELSE 2
	END "CHECK"
FROM DUAL;



SELECT CASE 
	WHEN (SELECT COUNT(*) FROM EMPLOYEE WHERE EMP_ID = 200) = 0
	THEN 0
	WHEN (SELECT COUNT(*) FROM EMPLOYEE 
		  WHERE EMP_ID = 200 AND ENT_YN = 'Y') = 1
	THEN 1
	ELSE 2
	END "CHECK"
FROM DUAL
;


-- 7. 퇴직 처리
UPDATE EMPLOYEE 
SET ENT_YN = 'Y',
	ENT_DATE = SYSDATE
WHERE EMP_ID = ?
;


UPDATE EMPLOYEE 
SET ENT_YN = 'N'
WHERE EMP_ID = 223;
COMMIT;

/* 8.
가장 최근(입사일이 늦은) 사원 5명의
사번, 이름, 부서명, 입사일을
입사일 내림차순으로 조회 */
-- ROWNUM, 인라인뷰(FROM절 서브쿼리)

SELECT * FROM 
	(SELECT EMP_ID, EMP_NAME, HIRE_DATE,
		NVL(DEPT_TITLE,'부서없음') DEPT_TITLE
	FROM EMPLOYEE
	LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
	ORDER BY HIRE_DATE DESC)
WHERE ROWNUM <= 5;

-- 9.
--// 각 부서별
--// 부서명, 인원 수, 급여 평균
--// 부서코드 오름차순 조회
SELECT DEPT_CODE, NVL(DEPT_TITLE, '부서없음') DEPT_TITLE, 
	COUNT(*) 인원, FLOOR(AVG(SALARY)) 평균
FROM EMPLOYEE
LEFT JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
GROUP BY DEPT_CODE, DEPT_TITLE
ORDER BY DEPT_CODE
;






