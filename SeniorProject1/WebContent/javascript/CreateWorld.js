
var spawncheck = 0;

function init(test, m_width, m_height, gamearea) {

	// Fetch our canvas
	var canvas = document.getElementById('world');

	// Setup Matter JS
	var newengine = Matter.Engine.create();
	var newworld = newengine.world;
	var newrender = Matter.Render.create({
		canvas : canvas,
		engine : newengine,
		options : {
			width : (m_width/2 + (Math.sqrt(m_width) / 2))*100,
			height : (m_height/2 + (Math.sqrt(m_height) / 2))*100,
			background : 'transparent',
			wireframes : false,
			showAngleIndicator : false
		}
	});

	var gamearea = {
		engine : newengine,
		world : newworld,
		render : newrender
	};
	
	gamearea.engine.world.gravity.y = 0;
	setInterval(function(){spawncheck += 1;},1000);
	makeMaze(test, m_width, m_height, gamearea);
	createCharacter(gamearea);
	
	// Start the engine
	Matter.Engine.run(gamearea.engine);
	Matter.Render.run(gamearea.render);
	
	var v_bound_wall =  Matter.Bodies.rectangle(-25, 0, 50,  m_height * 200, {
		isStatic : true,
		render : {
			fillStyle : '#000000',
			strokeStyle : '#000000',
			label : 'wall',
			lineWidth : 0
		}
	});
	
	var h_bound_wall =  Matter.Bodies.rectangle(0, -25,  m_width * 200, 50, {
		isStatic : true,
		render : {
			fillStyle : '#000000',
			strokeStyle : '#000000',
			label : 'wall',
			lineWidth : 0
		}
	});
	
	Matter.World.add(gamearea.world,[h_bound_wall,v_bound_wall]);
	
	Matter.Events.on(gamearea.engine, 'beforeUpdate', function() {
	});
	
	function collision(event) {
		var collisions = event.source.pairs.collisionStart;
		for  (var i = 0; i < collisions.length; i ++){
			
			var bodyA = event.source.pairs.collisionStart[i].bodyA;
			var bodyB = event.source.pairs.collisionStart[i].bodyB;
			if(bodyA.label == 'projectile' && bodyB.label == 'monster' || bodyA.label == 'monster' && bodyB.label == 'projectile'){
				damageMonster(gamearea, bodyA, bodyB);
				monsterProjectile(gamearea, bodyA);
				if(bodyA.isSensor == false || bodyA.destroyable == true){
					Matter.World.remove(gamearea.world,bodyB);
				}
			}
			if(bodyA.label == 'player' && bodyB.label == 'monster' ||bodyA.label == 'monster' && bodyB.label =='player'){
				monsterProjectile(gamearea, bodyA);
			}
			if(bodyA.label == 'monster_projectile' && bodyB.label == 'player' || bodyA.label == 'player' && bodyB.label == 'monster_projectile'){
				damagePlayer(gamearea, bodyB, bodyA);
			}
			if(bodyA == 'projectile' && bodyB.label == 'Rectangle Body' ||bodyA.label == 'Rectangle Body' && bodyB.label =='projectile'){
				if(bodyA.destroy_on_wall == true){
					Matter.World.remove(gamearea.world,bodyB);
				}
			}
		}
	}
	Matter.Events.on(gamearea.engine, 'collisionStart', collision);
	
}
function damagePlayer(gamearea, player, projectile){
	player.Health -= projectile.damage;
	$("#health").text(JSON.parse(sessionStorage.player).Health);
	 if(player.Health <= 0){ 
		alert("Game over returning to character creation");
		$(location).attr('href', 'http://localhost:8080/SeniorProject1/jsp/MazeForm.jsp')
	}
	 
}
function damageMonster(gamearea, monster, projectile){
	monster.health -= projectile.damage;
	if(monster.health <= 0){
		Matter.World.remove(gamearea.world,monster)
	}
}


