package AlgorithmObjects;
import MiscObjects.*;
import java.util.ArrayList;
import java.util.Random;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/*base maze algorithm takes a width and height of the maze and contains a random number
 * generator to allow for random selection of cells*/

public abstract class MazeAlgorithm implements IMazeAlgorithm{
	int width;
	int height;
	Random rand;
	ArrayList<Rectangle> maze;
	public MazeAlgorithm(int w, int h) {
		width = w;
		height = h;
		maze = generateGrid();
		rand = new Random();
	}
	//generates a black grid of rectangles to cut into
	protected ArrayList<Rectangle> generateGrid() {
		ArrayList<Rectangle> grid = new ArrayList<Rectangle>();
		for (int i = 0; i < this.width; i++) {
			for (int j = 0; j < height; j++) {
				Rectangle r = new Rectangle(i * 5, j * 5, 5, 5);
				r.setFill(Color.BLACK);
				grid.add(r);
			}
		}
		return grid;
	}
	//checks if given rectangle is an unused cell
	protected boolean isValid(Rectangle rectangle) {
		if (rectangle.getFill() == Color.BLACK) {
			return true;
		} else {
			return false;
		}
	}
	//returns the bottom coordinate in the list
	protected int moveDown(int num) {
		if (num <= height / 2) {
			return num + 2;
		}
		return num;
	}
	//returns the top coordinate in the list
	protected int moveUp(int num) {
		if (num > 0) {
			return num - 2;
		}
		return num;
	}
	//returns the coordinate in the column to the right of the given cell
	protected int moveRight(int num) {
		if (num > 0) {
			return num - 2;
		}
		return num;
	}
	//returns the coordinate in the column to the left of the given cell
	protected int moveLeft(int num) {
		if (num <= width / 2) {
			return num + 2;
		}
		return num;
	}
	//converts given coordinates to the index that coordinate is located on the list
	protected int useCoordinate(int x, int y) {
		return ((x * height) + y);
	}
	//converts the given coordinates to the coresponding index
	protected Point getCoordinate(int i) {
		Point coordinate = new Point(i % width, i % height);
		return coordinate;
	}
}
