<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script src="../javascript/test.js"></script>
<title>Insert title here</title>
</head>
<body>
	<link rel="stylesheet" type="text/css" href="character_creation.css">
	<form id="stats" name="mazeform" action="../jsp/Level.jsp" method="post">
		<div id="stat_block">
		<label for="str"> Strength </label></br>
		<input id="str" type="text" name="str" /></br>
		<label for="dex"> Dexterity </label></br>
		<input id="dex" type="text" name="dex" /></br>
		<label for="con"> Constitution </label></br>
		<input id="con" type="text" name="con" /></br>
		<label for="int"> Intelligence </label></br>
		<input id="int" type="text" name="int" /></br>
		<label for="wis"> Wisdom </label></br>
		<input id="wis" type="text" name="wis" /></br>
		<label for="chr"> Charisma </label></br>
		<input id="chr" type="text" name="chr" /></br>
		</div>
		<div id="ability_select">
		<label for="ability1"> Main Ability </label></br>
		<select id="ability1" name="ability1">
 			<option value="boulder_throw">Boulder Throw</option>
  			<option value="fireball">Fireball</option>
  			<!--<option value="radiant_burst">Radiant Burst</option>-->
  			<option value="dagger_throw">Dagger Throw</option>
		</select></br>
		<label for="ability3"> Secondary Ability </label></br>
		<select id="ability3" name="ability3">
  			<option value="rage">Rage</option>
  			<option value="ice_spike">Ice Spike</option>
  			<!-- <option value="crossbow">Crossbow</option> -->
  			<!-- <option value="smite">Smite</option>-->
		</select></br>
		<label for="ability2"> Movement Ability</label></br>
		<select id="ability2" name="ability2">
  			<option value="charge">Charge</option>
  			<option value="dash">Dash</option>
  			<option value="blink">Blink</option>
  			<!--<option value="divine_push">Divine Push</option>-->
		</select></br>
		</br>
		<label for="text"> Maze Size</label></br>
		<input type="text" name="size"> </br>
		<label for="maze_type"> Maze Type</label></br>
		<select id="maze_type" name="algorithm"></br>
			<option value="BackTracker">BackTracker</option>
			<option value="BackTrackerModified">ModifiedBackTracker</option>
			</select></br>
		<button id="submit" type="submit" value="Submit">Enter the Dungeon</button>
		</div>
		
	</form>
	<div id="txt"></div>
</body>
</html>