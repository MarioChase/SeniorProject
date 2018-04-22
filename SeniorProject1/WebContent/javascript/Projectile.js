function shootProjectile(gamearea, source, stats) {

	var projectile = Matter.Bodies.circle(source.position.x + source.velocity.x, source.position.y+source.velocity.y, stats.radius, {
		mass : stats.mass,
		friction : 0.01,
		frictionAir : 0.00001,
		restitution : 0.8,
		label : 'projectile',
		damage : stats.damage,
		destroyable : stats.destroyable,
		isSensor : stats.penetrate,
		render : {
			fillStyle : stats.color,
			strokeStyle : 'black',
			lineWidth : 1
		}
	});
	Matter.Body.setVelocity(projectile,{x: stats.speed * source.velocity.x, y: stats.speed * source.velocity.y});
	Matter.World.add(gamearea.world, projectile);
	setTimeout(function(){Matter.World.remove(gamearea.world,projectile)},stats.range * 1000);
}

function shootTriangle(gamearea, source, stats) {
	var projectile = Matter.Bodies.polygon(source.position.x + source.velocity.x, source.position.y + source.velocity.y, 3, stats.radius, {
		mass : stats.mass,
		friction : 0.01,
		frictionAir : 0.01,
		restitution : 1,
		label : 'projectile',
		damage : stats.damage,
		destroyable : stats.destroyable,
		isSensor : stats.penetrate,
		render : {
			fillStyle : stats.color,
			strokeStyle : 'black',
			lineWidth : 1
		}
	});
	Matter.Body.setVelocity(projectile,{x: stats.speed * source.velocity.x, y: stats.speed * source.velocity.y});
	Matter.World.add(gamearea.world, projectile);
	setTimeout(function(){Matter.World.remove(gamearea.world,projectile)},stats.range * 1000);
}