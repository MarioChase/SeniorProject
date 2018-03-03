<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form name="mazeform" action="../jsp/Level.jsp" method="post">
		<input type="text" name="size"> <select name="algorithm">
			<option value="BackTracker">BackTracker</option>
			<option value="BackTrackerModified">ModifiedBackTracker</option>
		</select> <input type="submit" value="Generate Maze">
	</form>
</body>
</html>