function spawnMonster(gamearea, source) {

	var url = "http://localhost:8080/SeniorProject1/MonsterSpawner";
	var data = {
			time : 1000
	};
    var request = $.post(url, data);
    request.done(function(json)
    {
       // model = json;
    	console.log(json);
    });
    request.fail(function(jqXHR, textStatus, errorThrown)
    {
        console.log("Error!");
    });
	
	var monster = Matter.Bodies.polygon(source.position.x + 300, source.position.y + 300,3, 20, {
		density : 0.5,
		friction : 0.25,
		frictionAir : 0.00001,
		restitution : 0.8,
		label : 'monster',
		render : {
			fillStyle : 'blue',
			strokeStyle : 'black',
			lineWidth : 1
		}
	});
	Matter.Body.setVelocity(monster, {x:2, y:0});
	Matter.World.add(gamearea.world, monster);
	setInterval(function(){
		Matter.Body.applyForce(monster, {x: monster.position.x, y: monster.position.y}, {x: 1, y: 0})
		},1000);
}