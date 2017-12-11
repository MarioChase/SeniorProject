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
	public String algorithm_entered;
	ArrayList<Rectangle> grid;

	public Controller(int w, int h, String algorithm) {
		width = w;
		height = h;
		algorithm_entered = algorithm;
	}

	public void start() {
		IMazeAlgorithm algorithm = null;
		switch(algorithm_entered) {
		case "BackTracker":
			algorithm = new BackTracker(width, height);
			break;
		case "BackTrackerModified":
			algorithm = new BackTrackerModified(width, height);
			break;
		}
		
		grid = algorithm.generateMaze();
	}

	public JSONObject getJsonMaze() {
		JsonHandler jsonConverter = new JsonHandler();
		JSONObject jsonMaze = jsonConverter.mazeToJson(grid);
		return jsonMaze;
	}

}
