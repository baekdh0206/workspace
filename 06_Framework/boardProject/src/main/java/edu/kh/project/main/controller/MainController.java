package edu.kh.project.main.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.text.ParseException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// @Controller : 현재 클래스가 컨트롤러임을 명시
//				-> 요청, 응답 처리
//				+ bean 등록

// instance : 클래스 -> 객체
//	--> new 클래스명(); 객체 생성을 개발자가 직접함

// IOC(Inversion Of Control, 제어의 역전)
// -> 프레임워크(Spring Container)가 객체를 생성하고 관리
// --> 이 때 생성된 객체 == Bean

@Controller
public class MainController {

	// tip : spring에서 controller 메서드 작성 시
	// 반환 값을 모르겠으면 일단 String으로 작성!
	
	
//	@RequestMapping("/") : 요청 주소가 "/"인 경우
//							해당 메서드와 연결
	@RequestMapping("/")
	public String mainForward() {
		// main.jsp로 화면 전환
		
		
//		<beans:property name="prefix" value="/WEB-INF/views/" />
//		<beans:property name="suffix" value=".jsp" />
		
		// Spring에서 forward 하는 방법!!
		// -> webapp 폴더를 기준으로
		//    요청 위임할 JSP 파일 경로를 리턴하면 된다!
		
		// 단, servlet-context.xml에 작성된
		// prefix, suffix 부분을 제외하고 작성!!!
		// -> prefix + 리턴 값 + suffix로 경로 완성!
		// ** View Resolver **
		
		return "common/main";
	}
	
	
	@PostMapping(value = "/test", produces = "application/json; charset=UTF-8")
	@ResponseBody
	@CrossOrigin(origins = "https://www.q-net.or.kr")
	public String test(@RequestBody String data) {
		
		
		String value = "";
		String apiUrl = "https://www.q-net.or.kr/qlf006.do";
	    try{
	        HttpURLConnection connection = null;
	        URL url = new URL(apiUrl);

	        connection = (HttpURLConnection)url.openConnection();
	        connection.setRequestMethod("POST"); // post 또는 get, 근데 request body 넣으려면 post!
	        connection.setRequestProperty("Content-Type", "application/json; charset=euc-kr");
	        connection.setDoOutput(true);

	        
	        
	        
	        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
	        bw.write(data);
	        bw.flush();
	        bw.close();

	        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));            
	        
	        
	        while(true) {
	        	String temp =  br.readLine();
	        	if(temp == null) break;
	        	
	        	value += temp;
	        }
	        System.out.println(value);

	    } catch (EOFException e) {
	    	System.out.println(value);
		}
	    
	    catch (Exception e){
	    	e.printStackTrace();
	    }
		
		return value;
	}
	
	
	
	
	
}
