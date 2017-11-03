package AlgorithmObjects;
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class BackTracker extends MazeAlgorithm{
	public BackTracker(int w, int h) {
		super(w, h);
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Rectangle> generateMaze() {
		ArrayList<Rectangle> maze = super.generateGrid();
		Stack<String> directions = new Stack<String>();
		
		int x = 2;
		int y = 2;
		for (int i = 0; i < (width * height); i++) {
			int x_modifier = 0;
			int y_modifier = 0;
			switch (rand.nextInt(3)) {
			case 0:
				if (isValid(maze.get(useCoordinate(moveLeft(x), y))) == true) {
					x_modifier = -1;
					x = moveLeft(x);
					directions.push("Left");
					break;
				}
			case 1:
				if (isValid(maze.get(useCoordinate(moveRight(x), y))) == true) {
					x_modifier = 1;
					x = moveRight(x);
					directions.push("Right");
					break;
				}
			case 2:
				if (isValid(maze.get(useCoordinate(x, moveUp(y)))) == true) {
					y_modifier = 1;
					y = moveUp(y);
					directions.push("Up");
					break;
				}
			case 3:
				if (isValid(maze.get(useCoordinate(x, moveDown(y)))) == true) {
					y_modifier = -1;
					y = moveDown(y);
					directions.push("Down");
					break;

				}
			default:
				if (directions.isEmpty() == false) {
					switch (directions.peek()) {
					case "Left":
						x_modifier = 1;
						x = moveRight(x);
						directions.pop();
						break;
					case "Right":
						x_modifier = -1;
						x = moveLeft(x);
						directions.pop();
						break;
					case "Up":
						y_modifier = -1;
						y = moveDown(y);
						directions.pop();
						break;
					case "Down":
						y_modifier = 1;
						y = moveUp(y);
						directions.pop();
						break;

					}
				}
			}
			maze.get(useCoordinate(x + x_modifier, y + y_modifier)).setFill(Color.WHITE);
			maze.get(useCoordinate(x, y)).setFill(Color.WHITE);
		}
		maze.get(useCoordinate(2,2)).setFill(Color.GREEN);
		maze.get(useCoordinate(width/2,height/2)).setFill(Color.BLUE);
		return maze;
	}
}
