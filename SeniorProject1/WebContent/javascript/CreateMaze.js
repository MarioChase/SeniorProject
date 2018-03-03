function makeMaze(test, m_width, m_height, gamearea) {
	maze = JSON.parse(test);
	
	var canvas = document.getElementById('world');

	for (var i = 0; i <= m_height/2 + (Math.sqrt(m_height) / 2); i++) {
		for (var j = 0; j <= m_width/2 + (Math.sqrt(m_width) / 2); j++) {
			switch (maze.cells[(i * (m_height)) + j]) {
			case "w":
				break;
			case "b":
				Matter.World.add(gamearea.world, createWall(i, j));
				break;
			default:
				break;
			}
		}
	}
}

function createWall(i, j) {
	return Matter.Bodies.rectangle(((i * 100) + 50),((j * 100) + 50), 100, 100, {
		isStatic : true,
		render : {
			fillStyle : '#000000',
			strokeStyle : '#000000',
			lineWidth : 0
		}
	});
}
