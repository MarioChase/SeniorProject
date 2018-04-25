package GameObject;

import java.util.Hashtable;

import Abilities.IAbility;

public class Monster extends Character{
	public int monster_class;
	public String monster_color;
	public Monster(Hashtable<String, Integer> stats, IAbility ability_a) {
		health = stats.get("con");
		mana = stats.get("int");
		monster_class = stats.get("monster_class");
		switch(stats.get("dif")) {
			case 0:
				monster_color = "#00FF00";
				break;
			case 1:
				monster_color = "#FFFF00";
				break;
			case 2:
				monster_color = "#FF7400";
				break;
			case 3:
				monster_color = "#FF0000";
				break;
		}
		ability_one = ability_a;
	}
}
