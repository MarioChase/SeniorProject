function makeMaze(test, width, height) {
	var maze = JSON.parse(test);
	var c = document.getElementById("myCanvas");
	var ctx = c.getContext("2d");
	var grid = [];
	for (var i = 0; i <= height; i++) {
		for (var j = 0; j <= width; j++) {
			switch (maze.cells[(i * height) + j]) {
			case "w":
				ctx.fillStyle = "white";
				break;
			case "b":
				ctx.fillStyle = "black";
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
			ctx.fillRect(i * 50, j * 50, 49.5, 49.5);
		}
	}
}