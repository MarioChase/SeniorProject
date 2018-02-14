function startGame() {
	myGameArea = {
		canvas : document.getElementById("myCanvas"),
		start : function() {
			this.canvas.className = 'player';
			this.context = this.canvas.getContext("2d");
			document.body
					.insertBefore(this.canvas, document.body.childNodes[0]);
			this.interval = setInterval(updateGameArea, 20);
			setInterval(isColliding, 1);
			$(document).keydown(function(e) {
				switch (e.keyCode) {
				case 87:
					moveup();
					break;
				case 65:
					moveleft();
					break;
				case 83:
					movedown();
					break;
				case 68:
					moveright();
					break;
				case 32:
					break;
				}

			})
			$(document).keyup(function(e) {
				switch (e.keyCode) {
				case 87:
					stopY();
					break;
				case 65:
					stopX();
					break;
				case 83:
					stopY();
					break;
				case 68:
					stopX();
					break;
				}
			})
		},
		clear : function() {
			this.context.clearRect(myGamePiece.x, myGamePiece.y, myGamePiece.x
					- (myGamePiece.x - 30), myGamePiece.y
					- (myGamePiece.y - 30));
		}
	}
	myGameArea.start();
	myGamePiece = new component(30, 30, "red", 10, 120);
}

function isColliding() {
	for (var i = 0; i < walls.length; i++) {
		if (((myGamePiece.x + 32) >= (walls[i].wall_x) && myGamePiece.x - 2 <= (walls[i].wall_x + 100))
				&& (myGamePiece.y + 32 >= walls[i].wall_y && myGamePiece.y - 2 <= walls[i].wall_y + 100)) {
			return true;
		}
	}
	return false;
}

function isCollidingRight() {
	for (var i = 0; i < walls.length; i++) {
		if ((myGamePiece.x - 2) >= (walls[i].wall_x - 5)) {
			console.log("right collision");
			return true;
		} else {
			return false
		}
	}
	return false;
}

function isCollidingLeft() {
	for (var i = 0; i < walls.length; i++) {
		if ((myGamePiece.x) >= (walls[i].wall_x + 100)) {
			return true;
		} else {
			return false
		}
	}
	return false;
}

function updateGameArea() {
	myGameArea.clear();
	myGamePiece.newPos();
	myGamePiece.update();
}

function component(width, height, color, x, y) {
	this.width = width;
	this.height = height;
	this.speedX = 0;
	this.speedY = 0;
	this.x = x;
	this.y = y;
	this.update = function() {
		ctx = myGameArea.context;
		ctx.fillStyle = color;
		ctx.fillRect(this.x, this.y, this.width, this.height);
	}
	this.newPos = function() {
		this.x += this.speedX;
		this.y += this.speedY;
	}
}

var myGameArea = {};

function stopX() {
	myGamePiece.speedX = 0;
}

function stopY() {
	myGamePiece.speedY = 0;
}

function moveup() {
	if (myGamePiece.speedY >= -1 && isColliding() == false) {
		myGamePiece.speedY -= 1;
	} else {
		myGamePiece.speedY = 0;
	}
}

function movedown() {
	if (myGamePiece.speedY <= 1 && isColliding() == false) {
		myGamePiece.speedY += 1;
	} else {
		myGamePiece.speedY = 0;
	}
}

function moveleft() {
	if (isColliding() == true && isCollidingLeft() == true) {
		stopX();
	} else if (myGamePiece.speedX >= -1 && isColliding() == true
			&& isCollidingLeft() == false) {
		console.log("wut");
		myGamePiece.speedX = -1;
	} else if (myGamePiece.speedX == 0 && isColliding() == true
			&& isCollidingLeft() == false) {
		console.log("wat");
		myGamePiece.speedX = -1;
	}
	else {
		myGamePiece.speedX -= 1;
	}
}
function moveright() {
	if (isColliding() == true && isCollidingRight() == true) {
		stopX();
	} else if (myGamePiece.speedX >= 1 && isCollidingRight() == true
			&& isCollidingRight() == false) {
		myGamePiece.speedX += 1;
	} else if (myGamePiece.speedX == 0 && isCollidingRight() == true
			&& isCollidingRight() == false) {
		myGamePiece.speedX += 1;
	}
	else {
		myGamePiece.speedX += 1;
	}
}