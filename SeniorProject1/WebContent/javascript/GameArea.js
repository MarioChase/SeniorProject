function startGame() {
	myGameArea = {
		canvas : document.getElementById("myCanvas"),
		start : function() {
			this.canvas.className = 'player';
			this.context = this.canvas.getContext("2d");
			document.body
					.insertBefore(this.canvas, document.body.childNodes[0]);
			this.interval = setInterval(updateGameArea, 20);
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
	myGamePiece.speedY = -1;
}

function movedown() {
	myGamePiece.speedY = 1;
}

function moveleft() {
	myGamePiece.speedX = -1;
}

function moveright() {
	myGamePiece.speedX = 1;
}