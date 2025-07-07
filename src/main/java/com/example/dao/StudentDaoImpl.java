package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.dto.Student;
import com.example.util.JDBCUtil;

public class StudentDaoImpl implements StudentDao {

	@Override
	public List<Student> getAllStudentDetails() {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Student> students = null;
		String sqlGetAllDetailsQuery = "select id, firstname, lastname, age, email, marks, address from student;";

		try {

			connection = JDBCUtil.getJdbcConnection();
			if (connection != null) {

				preparedStatement = connection.prepareStatement(sqlGetAllDetailsQuery);
				if (preparedStatement != null) {

					resultSet = preparedStatement.executeQuery();
					if (resultSet != null) {

						students = new ArrayList<>();
						Student student = null;
						while (resultSet.next()) {

							student = new Student();
							student.setId(resultSet.getInt(1));
							student.setFirstName(resultSet.getString(2));
							student.setLastName(resultSet.getString(3));
							student.setAge(resultSet.getInt(4));
							student.setEmail(resultSet.getString(5));
							student.setMarks(resultSet.getInt(6));
							student.setAddress(resultSet.getString(7));

							students.add(student);
						}
						if (students.size() > 0)
							return students;
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				JDBCUtil.cleanUp(connection, preparedStatement, resultSet);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public String addNewStudentDetails(Student student) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sqlInsertQuery = "insert into student(firstname, lastname, age, email, marks, address) values(?,?,?,?,?,?);";
		try {
			connection = JDBCUtil.getJdbcConnection();

			if (connection != null) {
				preparedStatement = connection.prepareStatement(sqlInsertQuery);

				if (preparedStatement != null) {
					preparedStatement.setString(1, student.getFirstName());
					preparedStatement.setString(2, student.getLastName());
					preparedStatement.setInt(3, student.getAge());
					preparedStatement.setString(4, student.getEmail());
					preparedStatement.setInt(5, student.getMarks());
					preparedStatement.setString(6, student.getAddress());

					int rowAffected = preparedStatement.executeUpdate();
					if (rowAffected == 1)
						return "success";
					else
						return "failure";
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				JDBCUtil.cleanUp(connection, preparedStatement, null);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return "failure";
	}

	@Override
	public String updateStudentDetailsById(Student student) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sqlUpdateQuery = "update student set firstname = ? , lastname = ? ,age =  ?, email = ?, marks = ?, address = ? where id = ?";

		try {
			connection = JDBCUtil.getJdbcConnection();
			if (connection != null) {

				preparedStatement = connection.prepareStatement(sqlUpdateQuery);
				if (preparedStatement != null) {

					preparedStatement.setString(1, student.getFirstName());
					preparedStatement.setString(2, student.getLastName());
					preparedStatement.setInt(3, student.getAge());
					preparedStatement.setString(4, student.getEmail());
					preparedStatement.setInt(5, student.getMarks());
					preparedStatement.setString(6, student.getAddress());
					preparedStatement.setInt(7, student.getId());

					int rowAffected = preparedStatement.executeUpdate();
					if (rowAffected == 1)
						return "success";
					else
						return "failure";
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				JDBCUtil.cleanUp(connection, preparedStatement, null);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return "failure";
	}

	@Override
	public Student getStudentDetailsById(int id) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String sqlGetDetailById = "select firstname, lastname, age, email, marks, address from student where id = ?";

		try {
			connection = JDBCUtil.getJdbcConnection();
			if (connection != null) {

				preparedStatement = connection.prepareStatement(sqlGetDetailById);
				preparedStatement.setInt(1, id);
				if (preparedStatement != null) {

					resultSet = preparedStatement.executeQuery();
					if (resultSet != null) {

						Student student = null;
						if (resultSet.next()) {
							student = new Student();
							student.setId(id);
							student.setFirstName(resultSet.getString(1));
							student.setLastName(resultSet.getString(2));
							student.setAge(resultSet.getInt(3));
							student.setEmail(resultSet.getString(4));
							student.setMarks(resultSet.getInt(5));
							student.setAddress(resultSet.getString(6));

							if (student != null)
								return student;
						}
					}
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String deleteStudentDetailsById(int id) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sqlDeleteQuery = "delete from student where id = ?;";

		try {
			connection = JDBCUtil.getJdbcConnection();
			if (connection != null) {

				preparedStatement = connection.prepareStatement(sqlDeleteQuery);
				if (preparedStatement != null) {
					preparedStatement.setInt(1, id);

					int rowAffected = preparedStatement.executeUpdate();
					if (rowAffected == 1)
						return "success";
					else if (rowAffected == 0)
						return "not found";
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				JDBCUtil.cleanUp(connection, preparedStatement, null);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return "failure";
	}

}
