package GameObject;

import java.util.Hashtable;

import Abilities.*;

//Ectract player object out of this
public class PlayerBuilder {
	public Player execute(Hashtable<String, Integer> stats, IAbility ability_a, IAbility ability_b, IAbility ability_c) {
		int health = stats.get("con");
		int mana = stats.get("int");
		stats.put("mana", mana);
		stats.put("health", health);
		IAbility ability_one = ability_a;
		IAbility ability_two = ability_b;
		IAbility ability_three = ability_c;
		return new Player(stats, ability_one, ability_two, ability_three);
	}
}
