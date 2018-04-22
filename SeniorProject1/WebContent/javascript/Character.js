function createCharacter(gamearea) {
	var player = Matter.Bodies.rectangle(20, 20, 30, 30, {
		label : 'player',
		id : 1337,
		density : 0.04,
		friction : 0,
		frictionAir : 0,
		restitution : 0,
		inertia : Infinity,
		render : {
			fillStyle : '#FF0000',
			strokeStyle : 'red',
			lineWidth : 1
		}
	});
	Matter.World.add(gamearea.world, player);
	setInterval(function() {
		spawnMonster(gamearea, player);
	}, (Math.random()*6000) + 2000);
	var player_info = JSON.parse(sessionStorage.player);
	$(document).keydown(function(e) {
		switch (e.keyCode) {
		case 87:
			Matter.Body.setVelocity(player, {
				x : player.velocity.x,
				y : -1
			});
			break;
		case 65:
			Matter.Body.setVelocity(player, {
				x : -1,
				y : player.velocity.y
			})
			break;
		case 83:
			Matter.Body.setVelocity(player, {
				x : player.velocity.x,
				y : 1
			})
			break;
		case 68:
			Matter.Body.setVelocity(player, {
				x : 1,
				y : player.velocity.y
			})
			break;
		case 81:
			execute(gamearea, player, player_info, player_info.Ability3_Name);
			break;
		case 32:
			e.preventDefault();
			execute(gamearea, player, player_info, player_info.Ability1_Name);
			break;
		case 16:
			execute(gamearea, player, player_info, player_info.Ability2_Name);
		}
	})

	$(document).keyup(function(e) {
		switch (e.keyCode) {
		case 87:
		case 83:
			Matter.Body.setVelocity(player, {
				x : player.velocity.x,
				y : 0
			})
			break;
		case 65:
		case 68:
			Matter.Body.setVelocity(player, {
				x : 0,
				y : player.velocity.y
			})
			break;

		case 32:
			break;
		}

	})

}