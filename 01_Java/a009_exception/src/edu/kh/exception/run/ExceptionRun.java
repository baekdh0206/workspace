package edu.kh.exception.run;

import java.io.IOException;

import edu.kh.exception.service.ExceptionService;

public class ExceptionRun {
	
	public static void main(String[] args) throws IOException {
		
		ExceptionService service = new ExceptionService();
		
		service.startEx5();
	}
}
