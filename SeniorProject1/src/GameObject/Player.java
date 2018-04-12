package GameObject;

import java.util.Hashtable;

import Abilities.*;

public class Player extends Character{
	public Player(Hashtable<String, Integer> stats, IAbility ability_a) {
		health = stats.get("health");
		mana = stats.get("mana");
		ability_one = ability_a;
	}
}
