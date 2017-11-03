 function createGrid()
        {
            var c = document.getElementById("myCanvas");
            var ctx = c.getContext("2d");
            var grid = [];
            for(var i = 0; i < c.width; i++)
            {
                for(var j = 0; j < c.height; j++)
                {
                ctx.fillRect(i*5,j*5,5,5);
                }
            }
        }