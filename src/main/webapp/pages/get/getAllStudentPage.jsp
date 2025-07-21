<%@ page import="java.util.List"%>
<%@ page import="com.example.dto.Student"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Get All Student Page</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
	<jsp:include page="../common/header.jsp" />

	<main>
		<h1>All Student Details</h1>
		<table>
			<tr>
				<th>Student_Id</th>
				<th>Student_FirstName</th>
				<th>Student_LastName</th>
				<th>Student_Age</th>
				<th>Student_email</th>
				<th>Student_Marks</th>
				<th>Student_Address</th>
			</tr>

			<%
			List<Student> students = (List<Student>) request.getAttribute("students");
			if (students != null) {
				for (Student student : students) {
			%>
			<tr>
				<th><%=student.getId()%></th>
				<th><%=student.getFirstName()%></th>
				<th><%=student.getLastName()%></th>
				<th><%=student.getAge()%></th>
				<th><%=student.getEmail()%></th>
				<th><%=student.getMarks()%></th>
				<th><%=student.getAddress()%></th>
			</tr>
			<%
			}
			} else {
			%>
			<h2>No Student Details are available</h2>
			<%
			}
			%>

		</table>
	</main>

	<jsp:include page="../common/footer.jsp" />
</body>
</html>
