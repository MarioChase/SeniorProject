function makeMaze(test) {
	var maze = JSON.parse(test);
	var c = document.getElementById("myCanvas");
	var ctx = c.getContext("2d");
	var grid = [];
	for (var i = 0; i <= 200; i++) {
		for (var j = 0; j <= 200; j++) {
			switch (maze.cells[(i * 200) + j]) {
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
				ctx.fillStyle = "red";
				break;
			default:
				ctx.fillStyle = "purple";
				break;
			}
			ctx.fillRect(i * 5, j * 5, 5, 5);
		}
	}
}