package edu.kh.jdbc.dto;

public class Employee2 {
	// 부서명, 직급명, 이름, 이메일
	
	private String departmentName;
	private String jobName;
	private String employeeName;
	private String email;
	
	public Employee2() {
		// TODO Auto-generated constructor stub
	}

	public Employee2(String departmentName, String jobName, String employeeName, String email) {
		super();
		this.departmentName = departmentName;
		this.jobName = jobName;
		this.employeeName = employeeName;
		this.email = email;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return String.format("%s / %s / %s / %s", 
					departmentName, jobName, employeeName, email);
	}
	
	
}
