package GameObject;

import java.util.Hashtable;

import Abilities.IAbility;

public class Monster extends Character{
	
	public Monster(Hashtable<String, Integer> stats, IAbility ability_a) {
		health = stats.get("con");
		mana = stats.get("int");
		ability_one = ability_a;
	}
}
