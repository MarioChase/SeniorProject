package MiscObjects;

import java.util.ArrayList;

import org.json.simple.*;
import org.json.simple.parser.*;

import com.sun.prism.paint.Color;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class JsonHandler {
	public JsonHandler() {

	}

	public JSONObject mazeToJson(ArrayList<Rectangle> maze) {
		JSONObject JSONmaze = new JSONObject();
		JSONArray cells = new JSONArray();
		for (int i = 0; i < maze.size(); i++) {
			// cells.add(maze.get(i).getFill());
			if (maze.get(i).getFill().equals(Paint.valueOf("white"))) {
				cells.add("w");
			}
			else if (maze.get(i).getFill().equals(Paint.valueOf("black"))) {
				cells.add("b");
			}
			else if (maze.get(i).getFill().equals(Paint.valueOf("blue"))) {
				cells.add("s");
			}
			else if (maze.get(i).getFill().equals(Paint.valueOf("green"))) {
				cells.add("e");
			}
			else if (maze.get(i).getFill().equals(Paint.valueOf("red"))) {
				cells.add("e");
			}
		}
		JSONmaze.put("cells", cells);
		return JSONmaze;
	}
}
