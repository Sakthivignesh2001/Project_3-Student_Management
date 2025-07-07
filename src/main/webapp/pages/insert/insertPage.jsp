<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert page</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/style.css">

</head>
<body>

	<jsp:include page="../common/header.jsp" />

	<main>
		<h1>Enter student details</h1>
		<form action="../../controller/addNewStudent" method="post">
			<table>
				<tr>
					<th>Enter Student First Name</th>
					<td><input type="text" name="firstname" required /></td>
				</tr>
				<tr>
					<th>Enter Student Last Name</th>
					<td><input type="text" name="lastname" required /></td>
				</tr>
				<tr>
					<th>Enter Student Age</th>
					<td><input type="number" name="age" required /></td>
				</tr>
				<tr>
					<th>Enter Student Email</th>
					<td><input type="text" name="email" required /></td>
				</tr>
				<tr>
					<th>Enter Student Marks</th>
					<td><input type="number" name="marks" required /></td>
				</tr>
				<tr>
					<th>Enter Student Address</th>
					<td><input type="text" name="address" required /></td>
				</tr>
				<tr>
					<td colspan="2" style="text-align: center;"><input
						type="submit" value="Submit" /></td>
				</tr>
			</table>
		</form>
	</main>

	<jsp:include page="../common/footer.jsp" />

</body>
</html>
