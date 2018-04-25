package MiscObjects;

import java.util.ArrayList;

import org.json.simple.*;
import org.json.simple.parser.*;

import com.sun.prism.paint.Color;

import GameObject.Monster;
import GameObject.Player;
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
	
	public JSONObject playerToJson(Player player) {
		JSONObject JSONplayer = new JSONObject();
		JSONArray abilities = new JSONArray();
		
		JSONplayer.put("Health", player.health);
		JSONplayer.put("Mana", player.mana);
		JSONplayer.put("Stamina", player.stamina);
		
		JSONplayer.put("str_mod", player.str_mod);
		JSONplayer.put("dex_mod", player.dex_mod);
		JSONplayer.put("con_mod", player.con_mod);
		JSONplayer.put("int_mod", player.int_mod);
		
		JSONplayer.put("Ability1_Name", player.ability_one.get_name());
		JSONplayer.put("Ability2_Name", player.ability_two.get_name());
		JSONplayer.put("Ability3_Name", player.ability_three.get_name());
		
		
		return JSONplayer;
	}

	public JSONObject monsterToJson(Monster monster) {
		JSONObject JSONmonster = new JSONObject();
		JSONArray abilities = new JSONArray();
		JSONmonster.put("Health", monster.health);
		JSONmonster.put("Mana", monster.mana);
		JSONmonster.put("monster_class", monster.monster_class);
		JSONmonster.put("Color", monster.monster_color);
		//JSONmonster.put("Ability1_Name", monster.ability_one.get_name());
		
		return JSONmonster;
	}
}
