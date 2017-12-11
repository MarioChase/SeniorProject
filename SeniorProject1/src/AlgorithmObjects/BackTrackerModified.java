package AlgorithmObjects;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

//This algorithm is similar to a recursive backtracking algorithm 
public class BackTrackerModified extends MazeAlgorithm {
	public BackTrackerModified(int w, int h) {
		super(w, h);
		// TODO Auto-generated constructor stub
	}

	// maze generation
	public ArrayList<Rectangle> generateMaze() {
		ArrayList<Rectangle> maze = super.generateGrid();
		Stack<String> directions = new Stack<String>();
		// arbitrary starting point
		int x = 2;
		int y = 2;
		// Loop through all elements in the grid list
		do{
				// used for setting the next cell
				int x_modifier = 0;
				int y_modifier = 0;
				// picks a random direction
				switch (rand.nextInt(3)) {
				/*
				 * case num: if(space is valid in directions coordinate){ set the modifier
				 * accordingly set the current cell accordingly track the movement on the stack
				 * }
				 */
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
					// occurs when all current options at a point are invalid
				default:
					// checks for an empty stack
					if (directions.isEmpty() == false) {
						// looks at the top of the stack
						switch (directions.peek()) {
						// Moves accordingly based on the direction and removes the instruction
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
				// fills the modified coordinates to full
				maze.get(useCoordinate(x + x_modifier, y + y_modifier)).setFill(Color.WHITE);
				maze.get(useCoordinate(x, y)).setFill(Color.WHITE);
		} while (directions.size() < 100);
		return maze;
	}
}
