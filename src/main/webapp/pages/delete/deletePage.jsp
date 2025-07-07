<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete page</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>

	<jsp:include page="../common/header.jsp" />

	<main>
		<h1>Delete student details by ID</h1>
		<form action="../../controller/deleteStudentById" method="post">
			<table>
				<tr>
					<th>Enter Student ID</th>
					<td><input type="number" name="studentId" required/></td>
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
