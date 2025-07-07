package com.example.dao;

import java.util.List;

import com.example.dto.Student;

public interface StudentDao {
	
	public List<Student> getAllStudentDetails();

	public String addNewStudentDetails(Student student);

	public String updateStudentDetailsById(Student student);

	public Student getStudentDetailsById(int id);

	public String deleteStudentDetailsById(int id);

}
