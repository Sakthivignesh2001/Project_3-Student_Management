package com.example.service;

import java.util.List;

import com.example.dao.StudentDao;
import com.example.dao.StudentDaoFactory;
import com.example.dto.Student;

public class StudentServiceImpl implements StudentService {
	
	private StudentDao studentDao;

	@Override
	public List<Student> getAllStudentDetails() {
		studentDao = StudentDaoFactory.getStudentDao();
		return studentDao.getAllStudentDetails();
	}

	@Override
	public String addNewStudentDetails(Student student) {
		studentDao = StudentDaoFactory.getStudentDao();
		return studentDao.addNewStudentDetails(student);
	}

	@Override
	public String updateStudentDetailsById(Student student) {
		studentDao = StudentDaoFactory.getStudentDao();
		return studentDao.updateStudentDetailsById(student);
	}

	@Override
	public Student getStudentDetailsById(int id) {
		studentDao = StudentDaoFactory.getStudentDao();
		return studentDao.getStudentDetailsById(id);
	}

	@Override
	public String deleteStudentDetailsById(int id) {
		studentDao = StudentDaoFactory.getStudentDao();
		return studentDao.deleteStudentDetailsById(id);
	}

}
