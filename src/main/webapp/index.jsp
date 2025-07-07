<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home page</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
	<jsp:include page="/pages/common/header.jsp" />

	<main>
		<h1>Student Details Operation</h1>
		<table>
			<tr>
				<th>Get all student details</th>
				<td>
					<form action="./controller/getAllStudentDetails" method="post">
						<input type="submit" value="click here" />
					</form>
				</td>
			</tr>
			<tr>
				<th>Get student detail by ID</th>
				<td>
					<form action="./pages/get/findStudentDetailById.jsp" method="post">
						<input type="submit" value="click here" />
					</form>
				</td>
			</tr>
			<tr>
				<th>Insert student detail</th>
				<td>
					<form action="./pages/insert/insertPage.jsp" method="post">
						<input type="submit" value="click here" />
					</form>
				</td>
			</tr>
			<tr>
				<th>Update student detail by ID</th>
				<td>
					<form action="./pages/update/findStudentDetailById.jsp" method="post">
						<input type="submit" value="click here" />
					</form>
				</td>
			</tr>
			<tr>
				<th>Delete student detail by ID</th>
				<td>
					<form action="./pages/delete/deletePage.jsp" method="post">
						<input type="submit" value="click here" />
					</form>
				</td>
			</tr>
		</table>
	</main>

	<jsp:include page="/pages/common/footer.jsp" />
</body>
</html>
