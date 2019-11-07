<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Word Count</h1>
	<div align="center">
	<form action="count" method="post">
		<table>
			<tr>
				<td><textarea placeholder="Enter text" id="text" rows="20" cols="80" name="text"></textarea></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit"></td>
			</tr>
		</table>
		<table>
			<tr>
				<td><h3>Word Count is ${count}</h3></td>
			</tr>
			<tr>
				<td><h3>Top Used Words are ${topWords}</h3></td>
			</tr>
		</table>
	</form>
	</div>
</body>
</html>