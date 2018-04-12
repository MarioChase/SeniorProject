$(function() {
$('#submit').click(function() {
	var params = {
			str : $('#str').val(),
			dex : $('#dex').val(),
			con : $('#con').val(),
			int : $('#int').val(),
			wis : $('#wis').val(),
			chr : $('#chr').val()
		};
	console.log(JSON.stringify(params));
	var url = "http://localhost:8080/SeniorProject1/CharacterCreator";
	var data = $("#stats").serialize();
    var request = $.post(url, data);
    request.done(function(json)
    {
       // model = json;
    	sessionStorage.setItem('player', json);
    	console.log(sessionStorage.player);
    });
    request.fail(function(jqXHR, textStatus, errorThrown)
    {
        console.log("Error!");
    });
    
    
	});
});