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
		int x = 10;
		int y = 10;
		//Sets a fresh grid
		ArrayList<Rectangle> frontier = generateGrid();
		//Holds the location of all available cells
		ArrayList<Integer> candidates = new ArrayList<Integer>();
		//Loop through grid to generate maze
		for (int j = 0; j < 5; j++) {
			//Point that contains current cell that is being changed
			Point p = new Point(x, y);
			//Get the current point selectedd and turn it white
			frontier.get(useCoordinate(x, y)).setFill(Color.WHITE);
			//Add new cells to the frontier and add it to list of candidates
			frontier = findFrontier(frontier,x,y);
			for (int i = 0; i < frontier.size(); i++) {
				if (frontier.get(i).getFill() == Color.RED) {
					candidates.add(i);
				}
			}
			//Get a random cell that is on the frontier
			int select_candidate_num = rand.nextInt(candidates.size());
			Rectangle placeholder = frontier.get(candidates.get(select_candidate_num));
			//Fix wonkiness of HTML canvas
			Point p1 = new Point((int) placeholder.getX() / 5, (int) placeholder.getY() / 5);
			//get Coordinate of selected red cell
			Point next_cell = getCoordinate(select_candidate_num);
			//connect selected cell to a nearby white cell
			p1 = connect(p1,x,y);
			placeholder.setFill(Color.WHITE);
			frontier.get(useCoordinate(p.X + p1.X, p.Y + p1.Y)).setFill(Color.WHITE);
			x = next_cell.X;
			y = next_cell.Y;
			maze = frontier;
		}
		return maze;
	}

	public ArrayList<Rectangle> findFrontier(ArrayList<Rectangle> frontier, int x, int y) {
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
		return frontier;
	}

	public Point connect(Point p1, int x, int y) {
		Point offset = new Point(0, 0);
		if (p1.X > x) {
			offset.X = 1;
		}
		if (p1.X < x) {
			offset.X = -1;
		}
		if (p1.Y < y) {
			offset.Y = -1;
		}
		if (p1.Y > y) {
			offset.Y = 1;
		}
		return offset;
	}

}
