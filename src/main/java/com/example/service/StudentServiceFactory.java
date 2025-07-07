package com.example.service;

public class StudentServiceFactory {
	
	private static StudentService studentService = null;
	
	private StudentServiceFactory() {
		
	}
	
	public static StudentService getStudentService() {
		
		if(studentService == null)
			studentService = new StudentServiceImpl();
		
		return studentService;
	}

}
