package Base;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

import org.json.simple.JSONObject;

import AlgorithmObjects.*;
import MiscObjects.JsonHandler;
import javafx.*;
import javafx.application.Application;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

//reconfigure to interact with front end
public class Controller {
	public int width;
	public int height;
	ArrayList<Rectangle> grid;

	public Controller(int w, int h) {
		width = w;
		height = h;
	}

	public void start() {
		IMazeAlgorithm algorithm = new PrimAlgorithm(width, height);
		grid = algorithm.generateMaze();
	}

	public JSONObject getJsonMaze() {
		JsonHandler jsonConverter = new JsonHandler();
		JSONObject jsonMaze = jsonConverter.mazeToJson(grid);
		return jsonMaze;
	}

}
