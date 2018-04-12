<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script src="../javascript/test.js"></script>
<title>Insert title here</title>
</head>
<body>
	<form id="stats" name="mazeform" action="../jsp/Level.jsp" method="post">
		<label for="str"> Strength </label>
		<input id="str" type="text" name="str" /></br>
		<label for="dex"> Dexterity </label>
		<input id="dex" type="text" name="dex" /></br>
		<label for="con"> Constitution </label>
		<input id="con" type="text" name="con" /></br>
		<label for="int"> Intelligence </label>
		<input id="int" type="text" name="int" /></br>
		<label for="wis"> Wisdom </label>
		<input id="wis" type="text" name="wis" /></br>
		<label for="chr"> Charisma </label>
		<input id="chr" type="text" name="chr" /></br>
		<input type="text" name="size"> <select name="algorithm">
			<option value="BackTracker">BackTracker</option>
			<option value="BackTrackerModified">ModifiedBackTracker</option></select></br>
		<button id="submit" type="submit" value="Submit">Enter the Dungeon</button>
	</form>
	<div id="txt"></div>
</body>
</html>