<!DOCTYPE html>
<%@page import="AlgorithmObjects.*"%>
<%@page import="Base.*"%>
<%@page import="MiscObjects.*"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Hello</title>
	</head>
	<script src="../javascript/GenerateMaze.js"></script>
	<body>
		<%
			int width = Integer.parseInt(request.getParameter("size"));
			int height = Integer.parseInt(request.getParameter("size"));
			String algorithm = request.getParameter("algorithm");
			Controller controller = new Controller(width, height, algorithm);
			controller.start();
		%>
	</body>
		<canvas id="myCanvas" width="<%=width*3.5%>" height="<%=height*3.5%>" style="border:5px solid #000000;">
		</canvas><br>
		<script type="text/javascript">
			var test = '<%=controller.getJsonMaze()%>';
			makeMaze(test,<%=width%>,<%=height%>);
		</script>
</html>