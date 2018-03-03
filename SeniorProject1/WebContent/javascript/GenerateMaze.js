var walls = [];

function makeMaze(test, width, height) {
	var maze = JSON.parse(test);
	var c = document.getElementById("myCanvas");
	var ctx = c.getContext("2d");
	for (var i = 0; i <= height; i++) {
		for (var j = 0; j <= width; j++) {
			switch (maze.cells[(i * height) + j]) {
			case "w":
				ctx.fillStyle = "white";
				break;
			case "b":
				ctx.fillStyle = "black";
				walls.push({
					wall_x : i * 100,
					wall_y : j * 100,
					wall_width : 99.5,
					wall_height : 99.5
				});
				break;
			case "s":
				ctx.fillStyle = "blue";
				break;
			case "e":
				ctx.fillStyle = "green";
				break;
			case "r":
				ctx.fillStyle = "red";
				break;
			default:
				ctx.fillStyle = "black";
				break;
			}
			ctx.fillRect(i * 100, j * 100, 99.5, 99.5);
		}
	}
}

