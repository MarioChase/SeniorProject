function shootProjectile(gamearea, source) {

	var projectile = Matter.Bodies.circle(source.position.x, source.position.y, 5, {
		density : 0.04,
		friction : 0.01,
		frictionAir : 0.00001,
		restitution : 0.8,
		render : {
			fillStyle : '#F35e66',
			strokeStyle : 'black',
			lineWidth : 1
		}
	});
	Matter.Body.setVelocity(projectile,source.velocity);
	Matter.World.add(gamearea.world, projectile);

}