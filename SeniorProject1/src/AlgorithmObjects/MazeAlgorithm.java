package AlgorithmObjects;
import MiscObjects.*;
import java.util.ArrayList;
import java.util.Random;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

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
	protected boolean isValid(Rectangle rectangle) {
		if (rectangle.getFill() == Color.BLACK) {
			return true;
		} else {
			return false;
		}
	}

	protected int moveDown(int num) {
		if (num <= height / 2) {
			return num + 2;
		}
		return num;
	}

	protected int moveUp(int num) {
		if (num > 0) {
			return num - 2;
		}
		return num;
	}

	protected int moveRight(int num) {
		if (num > 0) {
			return num - 2;
		}
		return num;
	}

	protected int moveLeft(int num) {
		if (num <= width / 2) {
			return num + 2;
		}
		return num;
	}

	protected int useCoordinate(int x, int y) {
		return ((x * height) + y);
	}
	
	protected Point getCoordinate(int i) {
		Point coordinate = new Point(i % width, i % height);
		return coordinate;
	}
}
