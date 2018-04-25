<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="AlgorithmObjects.*"%>
<%@page import="Base.*"%>
<%@page import="MiscObjects.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<html>
<head>
	<head>
		<!-- Visit alexandergottlieb.com for more tutorials -->
		<title>Balls Matter</title>
	</head>
	<link rel="stylesheet" type="text/css" href="style.css">
	<!--<div id="overlay">
	<div id="health"></div>
	<div id="mana"></div>
	<div id="stamina"></div>-->
	
	</div>
	<body onload="on()">
		<%
			int width = Integer.parseInt(request.getParameter("size"));
			int height = Integer.parseInt(request.getParameter("size"));
			String algorithm = request.getParameter("algorithm");
			Controller controller = new Controller(width, height, algorithm);
			controller.start();
		%>
		<canvas id="world"  width=0 height=0 style="border:5px solid #000000;"></canvas>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/matter-js/0.10.0/matter.min.js"></script>
		<script src="../javascript/CreateWorld.js"></script>
		<script src="../javascript/CreateMaze.js"></script>
		<script src="../javascript/Character.js"></script>
		<script src="../javascript/Projectile.js"></script>
		<script src="../javascript/Monster.js"></script>
		<script src="../javascript/test.js"></script>
		<script src="../javascript/abilities.js"></script>
		<script src="../javascript/monster_abilities.js"></script>
		<script type="text/javascript">
				var test = '<%=controller.getJsonMaze()%>';
				init(test,<%=width%>,<%=height%>);
				console.log(sessionStorage.player);
				
				setInterval(function(){
					$("#health").text(JSON.parse(sessionStorage.player).Health);
				},500);
				
				setInterval(function(){
					$("#mana").text(JSON.parse(sessionStorage.player).Mana);
				},500);
				
				setInterval(function(){
					$("#stamina").text(JSON.parse(sessionStorage.player).Stamina);
				},500);
		</script>
		
	</body>
</head>
</body>
</html>