package GameObject;

import java.util.Hashtable;

import Abilities.*;

//Ectract player object out of this
public class PlayerBuilder {
	public Player execute(Hashtable<String, Integer> stats) {
		int health = stats.get("con");
		int mana = stats.get("int");
		stats.put("mana", mana);
		stats.put("health", health);
		IAbility ability_one = new TestAbility();
		IAbility ability_two;
		IAbility ability_three;
		return new Player(stats, ability_one);
	}
}
