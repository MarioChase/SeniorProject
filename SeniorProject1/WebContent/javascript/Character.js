function createCharacter(gamearea) {
	
	var player = Matter.Bodies.rectangle(20, 20, 30, 30, {
		label: 'player',
		id: 1337,
		density: 0.04,
		friction: 0,
        frictionAir: 0,
        restitution: 0,
        inertia: 'Infinity',
		render : {
			fillStyle : '#FF0000',
			strokeStyle : 'red',
			lineWidth : 1
		}
	});
	
	Matter.World.add(gamearea.world, player);
	
	console.log(sessionStorage.player);
	console.log("Hello");
	
	$(document).keydown(function(e) {
		switch (e.keyCode) {
		case 87:
			Matter.Body.setVelocity(player, {x: 0,y: -1});
			break;
		case 65:
			Matter.Body.setVelocity(player, {x: -1,y: 0})
			break;
		case 83:
			Matter.Body.setVelocity(player, {x: 0,y: 1})
			break;
		case 68:
			Matter.Body.setVelocity(player, {x: 1,y: 0})
			break;
		case 32:
			e.preventDefault();
			shootProjectile(gamearea, player, 1000);
			break;
		case 16:
			
		}

	})
	
	$(document).keyup(function(e) {
		switch (e.keyCode) {
		case 87:
		case 65:
		case 83:
		case 68:
			Matter.Body.setVelocity(player, {x: 0, y: 0})
			break;
		case 32:
			break;
		}

	})

}