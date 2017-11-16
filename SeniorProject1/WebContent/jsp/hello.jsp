<!DOCTYPE html>
<%@page import="AlgorithmObjects.*"%>
<%@page import="Base.*"%>
<%@page import="MiscObjects.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Hello</title>
	</head>
	<script src="../javascript/GenerateMaze.js"></script>
	<body>
		<%
			Controller controller = new Controller(200, 200);
			controller.start();
		%>
	</body>
		<canvas id="myCanvas" width="600" height="600" style="border:5px solid #000000;">
		</canvas>
		<script type="text/javascript">
			var test = '<%=controller.getJsonMaze()%>';
			makeMaze(test);
		</script>
</html>