package GameObject;

import java.util.Hashtable;

import Abilities.*;

public class Player extends Character{
	public Player(Hashtable<String, Integer> stats, IAbility ability_a, IAbility ability_b, IAbility ability_c) {
		health = stats.get("health");
		mana = stats.get("mana");
		ability_one = ability_a;
		ability_two = ability_b;
		ability_three = ability_c;
	}
}
