java.lang.ClassNotFoundException
- Class.forName("oracle.jdbc.driver.OracleDriver"); 
  구문에 오타가 있는 경우
  
java.sql.SQLException: ORA-01017: 
사용자명/비밀번호가 부적합, 로그온할 수 없습니다
- 아이디 또는 비밀번호 오타

java.sql.SQLRecoverableException: IO 오류: 
The Network Adapter could not establish the connection 
- DB 연결을 위한 URL (type, ip, port, dbName)에 오타


java.sql.SQLSyntaxErrorException
- SQL 문법이 잘못됨

java.sql.SQLSyntaxErrorException: ORA-00933: 
SQL 명령어가 올바르게 종료되지 않았습니다
- SQL에 세미콜론이 포함됨


java.sql.SQLException: 실행할 SQL 문은 비어 있거나 널일 수 없음
- Statement를 이용해서 SQL 수행 시 SQL이 ""(빈문자열) 또는 NULL인 경우


java.sql.SQLException: 부적합한 열 이름
- rs.get자료형("컬럼명") 구문에서 "컬럼명"을 잘못 작성한 경우