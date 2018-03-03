function init(test, m_width, m_height, gamearea) {

	// Fetch our canvas
	var canvas = document.getElementById('world');

	// Setup Matter JS
	var newengine = Matter.Engine.create();
	var newworld = newengine.world;
	console.log(newworld.gravity);
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
	
	makeMaze(test, m_width, m_height, gamearea);
	createCharacter(gamearea);
	// Start the engine
	Matter.Engine.run(gamearea.engine);
	Matter.Render.run(gamearea.render);

}