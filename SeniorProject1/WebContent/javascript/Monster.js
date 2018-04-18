var monster_stats;
function getMonsterStats(){
	var url = "http://localhost:8080/SeniorProject1/MonsterSpawner";
	var data = {
		time : spawncheck
	};
	var request = $.post(url, data);
	request.done(function(json) {
		monster_stats = JSON.parse(json);
	});
	request.fail(function(jqXHR, textStatus, errorThrown) {
		console.log("Error!");
	});
}
function spawnMonster(gamearea, source) {
	var model = monster_stats;
	getMonsterStats();
	console.log(monster_stats.monster_class);
	var monster = {
		body : Matter.Bodies.polygon(source.position.x + 300,
				source.position.y + 300, (monster_stats.monster_class + 3), 20, {
					density : 0.5,
					friction : 0.25,
					frictionAir : 0.00001,
					restitution : 0.8,
					label : 'monster',
					health : monster_stats.Health,
					render : {
						fillStyle : 'blue',
						strokeStyle : 'black',
						lineWidth : 1
					}
				})
	};
	Matter.Body.setVelocity(monster.body, {
		x : 2,
		y : 0
	});
	Matter.World.add(gamearea.world, monster.body);
	setInterval(function() {
		Matter.Body.applyForce(monster.body, {
			x : monster.body.position.x,
			y : monster.body.position.y
		}, {
			x : 1,
			y : 0
		})
	}, 1000);
}