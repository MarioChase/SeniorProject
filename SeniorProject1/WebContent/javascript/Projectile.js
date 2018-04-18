function shootProjectile(gamearea, source, range) {

	var projectile = Matter.Bodies.circle(source.position.x + source.velocity.x, source.position.y+source.velocity.y, 5, {
		density : 0.1,
		friction : 0.01,
		frictionAir : 0.00001,
		restitution : 0.8,
		label : 'projectile',
		damage : 1,
		render : {
			fillStyle : '#F35e66',
			strokeStyle : 'black',
			lineWidth : 1
		}
	});
	Matter.Body.setVelocity(projectile,source.velocity);
	Matter.World.add(gamearea.world, projectile);
	setTimeout(function(){Matter.World.remove(gamearea.world,projectile)},1000);
}