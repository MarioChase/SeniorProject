package AlgorithmObjects;

import java.util.ArrayList;
import MiscObjects.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class PrimAlgorithm extends MazeAlgorithm {
	public PrimAlgorithm(int w, int h) {
		super(w, h);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<Rectangle> generateMaze() {
		int x = rand.nextInt(width/2);
		int y = rand.nextInt(height/2);
		ArrayList<Rectangle> frontier = generateGrid();
		ArrayList<Integer> candidates = new ArrayList<Integer>();
		frontier.get(useCoordinate(x, y)).setFill(Color.WHITE);
			if (isValid(maze.get(useCoordinate(moveLeft(x), y))) == true) {
				frontier.get(useCoordinate(moveLeft(x), y)).setFill(Color.RED);
			}
			if (isValid(maze.get(useCoordinate(moveRight(x), y))) == true) {
				frontier.get(useCoordinate(moveRight(x), y)).setFill(Color.RED);
			}
			if (isValid(maze.get(useCoordinate(x, moveDown(y)))) == true) {
				frontier.get(useCoordinate(x, moveDown(y))).setFill(Color.RED);
			}
			if (isValid(maze.get(useCoordinate(x, moveUp(y)))) == true) {
				frontier.get(useCoordinate(x, moveUp(y))).setFill(Color.RED);
			}
			for(int i = 0; i < frontier.size(); i ++) {
				if(frontier.get(i).getFill() == Color.RED) {
					candidates.add(i);
					Point p = getCoordinate(i);
					System.out.println(p.X + ":" + p.Y);
				}
			}
			frontier.get(candidates.get(rand.nextInt(candidates.size()))).setFill(Color.WHITE);
		maze = frontier;
		return maze;
	}

}
