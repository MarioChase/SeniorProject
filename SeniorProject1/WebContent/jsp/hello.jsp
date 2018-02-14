<!DOCTYPE html>
<%@page import="AlgorithmObjects.*"%>
<%@page import="Base.*"%>
<%@page import="MiscObjects.*"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script src="../javascript/GenerateMaze.js"></script>
<script src="../javascript/Timer.js"></script>
<script src="../javascript/GameArea.js"></script>
<link rel="stylesheet" type="text/css" href="./CSS/gameview.css">
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Hello</title>
	</head>
	<body onload="startGame()">
		<%
			int width = Integer.parseInt(request.getParameter("size"));
			int height = Integer.parseInt(request.getParameter("size"));
			String algorithm = request.getParameter("algorithm");
			Controller controller = new Controller(width, height, algorithm);
			controller.start();
		%>
		<div id="gameview">
			<canvas id="myCanvas" width="<%=width*100%>" height="<%=height*100%>" style="border:5px solid #000000;">
			</canvas>
			<script type="text/javascript">
				var test = '<%=controller.getJsonMaze()%>';
				makeMaze(test,<%=width%>,<%=height%>);
			</script>
		</div>
	</body>
		
		
	<div id="txt"></div>
</html>