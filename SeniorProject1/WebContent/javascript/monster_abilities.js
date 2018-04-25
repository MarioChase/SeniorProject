function execute(gamearea, source, character_info, ability_name) {
	switch (ability_name) {
	case "fireball":
		fireball(gamearea, source, character_info);
		break;
	case "boulder_throw":
		boulder_throw(gamearea, source, character_info);
		break;
	case "dagger_throw":
		dagger_throw(gamearea, source, character_info);
		break;
	case "radiant_burst":
		radiant_burst(gamearea, source, character_info);
		break;
	case "blink":
		blink(gamearea, source, character_info);
		break;
	case "charge":
		setTimeout(charge(gamearea, source, character_info),2000);
		break;
	case "dash":
		dash(gamearea, source, character_info);
		break;
	case "rage":
		rage(gamearea, source, character_info);
		break;
	case "ice_spike":
		ice_spike(gamearea, source, character_info);
		break;
	}
}

function fireball(gamearea, source, character_info){
	var stats = {
			range : 6,
			radius : 20,
			mass : .5,
			damage : character_info.int_mod,
			speed : 4,
			destroyable : false, 
			penetrate : true,
			color : '#FF4500'
	}
	shootProjectile(gamearea, source, stats);
}

function boulder_throw(gamearea, source, character_info){
	var stats = {
			range : character_info.str_mod,
			radius :25,
			mass : 80,
			damage : character_info.str_mod,
			speed : character_info.str_mod,
			destroyable : false, 
			penetrate : false,
			color : '#C4C4C4'
	}
	shootProjectile(gamearea, source, stats);
}
// switch to shootTriangle and fix shooting in proper directions
function dagger_throw(gamearea, source, character_info){
	var stats = {
			range : .75,
			radius : 6,
			mass : .2,
			damage : (character_info.str_mod * .75),
			speed : 20,
			destroyable : true, 
			penetrate : false,
			color : '#000000'
	}
	shootTriangle(gamearea, source, stats);
}
function ice_spike(gamearea, source, character_info){
	var stats = {
			range : .75,
			radius : 6,
			mass : .2,
			damage : 2,
			speed : 20,
			destroyable : true, 
			penetrate : false,
			color : '#0044FF'
	}
	shootTriangle(gamearea, source, stats);
}