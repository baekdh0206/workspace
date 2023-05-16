package edu.kh.project.main.model.websocket;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class TestWebsocketHandler extends TextWebSocketHandler{

	// WebSocketSession : 클라이언트 - 서버간 전이중통신을 담당하는 객체
	//					클라이언트의 세션을 가로채셔 저장하고 있음
	
	// Set : 중복 X, 순서 X
	// synchronizedSet : 동기화된 Set 객체 반환 
	// ->  멀티쓰레드(줄 안서고 기능들이 서로 실행되려고함)
	//   환경에서 스레드간의 의도치 않은 충돌을 예방하기 위해서 동기화(줄세움)
	private Set<WebSocketSession> sessions
		= Collections.synchronizedSet(new HashSet<>());

	//  - 클라이언트와 연결이 완료되고, 통신할 준비가 되면 실행
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		
		// 클라이언트 웹소켓 연결을 요청하면 sessions에 
		// 클라이언트와의 전이중 통신을 담당하는 객체 WebSocketSession을 추가
		sessions.add(session);

	}

	
	// - 클라이언트로부터 텍스트 메세지를 받았을때 실행
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
	
		// Payload : 통신 시 탑재된 데이터(메시지)
		System.out.println("전달 받은 내용 : " + message.getPayload());
		
		// /testSock으로 연결된 객체를 만든 클라이언트들(sessions)에게
		// 전달 받은 내용을 보냄
		for(WebSocketSession s : sessions) {
			s.sendMessage(message);
		}
		
	}

	
	// - 클라이언트와 연결이 종료되면 실행
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		
		// ssesions에서 나간 클라이언트의 정보를 제거
		sessions.remove(session);
	}
	
	
	
	
}


/* WebSocket
- 브라우저와 웹서버간의 전이중통신을 지원하는 프로토콜이다
- HTML5버전부터 지원하는 기능이다.
- 자바 톰캣7버전부터 지원했으나 8버전부터 본격적으로 지원한다.
- spring4부터 웹소켓을 지원한다. 
(전이중 통신(Full Duplex): 두 대의 단말기가 데이터를 송수신하기 위해 동시에 각각 독립된 회선을 사용하는 통신 방식. 
대표적으로 전화망, 고속 데이터 통신)



WebSocketHandler 인터페이스 : 웹소켓을 위한 메소드를 지원하는 인터페이스
    -> WebSocketHandler 인터페이스를 상속받은 클래스를 이용해 웹소켓 기능을 구현


WebSocketHandler 주요 메소드
        
    void afterConnectionEstablished(WebSocketSession session)
    - 클라이언트와 연결이 완료되고, 통신할 준비가 되면 실행
    
    void handlerMessage(WebSocketSession session, WebSocketMessage message)
    - 클라이언트로부터 메세지가 도착하면 실행
    
    void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus)
    - 클라이언트와 연결이 종료되면 실행

    void handleTransportError(WebSocketSession session, Throwable exception)
    - 메세지 전송중 에러가 발생하면 실행 


----------------------------------------------------------------------------

TextWebSocketHandler :  WebSocketHandler 인터페이스를 상속받아 구현한 텍스트 메세지 전용 웹소켓 핸들러 클래스
 
    handlerTextMessage(WebSocketSession session, TextMessage message)
    - 클라이언트로부터 텍스트 메세지를 받았을때 실행
     




*/
