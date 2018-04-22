function execute(gamearea, source, character_info, ability_name) {
	console.log(ability_name);
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
			radius : 30,
			mass : .5,
			damage : 5,
			destroyable : false, 
			penetrate : true,
			color : '#FF4500'
	}
	console.log("shoot fireball");
	shootProjectile(gamearea, source, stats);
}

function boulder_throw(gamearea, source, character_info){
	var stats = {
			range : 5,
			radius :25,
			mass : 80,
			damage : 3,
			speed : 5,
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
			damage : 2,
			speed : 10,
			destroyable : true, 
			penetrate : false,
			color : '#000000'
	}
	shootTriangle(gamearea, source, stats);
}
// make projectile burst into more projectiles
function radiant_burst(gamearea, source, character_info){
	var stats = {
			range : 5,
			radius : 4,
			mass : .2,
			damage : 2,
			speed : 2,
			penetrate : false,
			color : '#FFFFFF'
	}
	shootProjectile(gamearea, source, stats);
	
}
function blink(gamearea, source, character_info){
	Matter.Body.translate(source, {x: (source.velocity.x * 150), y: (source.velocity.y * 150)});
}
function dash(gamearea, source, character_info){
	source.position.x += 5 * source.velocity.x;
	source.position.y += 5 * source.velocity.y;
	source.isSensor = true;
	setTimeout(function(){source.isSensor = false;}, 500);
	setTimeout(function(){Matter.Body.setVelocity(source, {x:0, y:0});}, 500);
}
function charge(gamearea, source, character_info){
	console.log(source.velocity);
	if(source.velocity.x == 1 || source.velocity.y == 1 || source.velocity.x == -1 || source.velocity.y == -1){
		Matter.Body.applyForce(source, 
				{x: source.position.x + source.velocity.x,y: source.position.y + source.velocity.y},
				{x: 2 * source.velocity.x,y: 2 * source.velocity.y});
		console.log(source.velocity.x);
		Matter.Body.setVelocity(source, {x:0, y:0});
	}
}
function rage(gamearea, source, character_info){
	console.log(source.inertia);
	Matter.Body.scale(source, 1.5, 1.5);
	Matter.Body.setInertia(source,Infinity);
	setTimeout(function()
	{
		Matter.Body.scale(source, (2/3), (2/3));
		Matter.Body.setInertia(source,Infinity);
	},3000);
	
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