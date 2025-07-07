package com.example.dao;

public class StudentDaoFactory {
	
	private static StudentDao studentDao = null;
	
	private StudentDaoFactory() {
		
	}

	public static StudentDao getStudentDao() {
		
		if(studentDao == null)
			studentDao = new StudentDaoImpl();
		
		return studentDao;
	}
}
