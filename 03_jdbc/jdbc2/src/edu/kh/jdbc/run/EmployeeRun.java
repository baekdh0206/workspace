package edu.kh.jdbc.run;

import edu.kh.jdbc.view.EmployeeView;

// java 프로그램 실행용 클래스
public class EmployeeRun {
	public static void main(String[] args) {
		
		EmployeeView view = new EmployeeView();
		view.displayMenu();
	}
}
