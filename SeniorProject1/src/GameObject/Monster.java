package GameObject;

import java.util.Hashtable;

import Abilities.IAbility;

public class Monster extends Character{
	public int monster_class;
	
	public Monster(Hashtable<String, Integer> stats, IAbility ability_a) {
		health = stats.get("con");
		mana = stats.get("int");
		monster_class = stats.get("monster_class");
		ability_one = ability_a;
	}
}
