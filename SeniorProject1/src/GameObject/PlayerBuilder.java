package GameObject;

import java.util.Hashtable;

import Abilities.*;

//Ectract player object out of this
public class PlayerBuilder {
	public Player execute(Hashtable<String, Integer> stats, IAbility ability_a, IAbility ability_b, IAbility ability_c) {
		int health = stats.get("con");
		int mana = stats.get("int");
		int stamina = stats.get("dex");
		int dex_mod = stats.get("dex") - 10;
		int str_mod = stats.get("str") - 10;
		int int_mod = stats.get("int") - 10;
		int con_mod = stats.get("con") - 10;
		stats.put("mana", mana);
		stats.put("health", health);
		stats.put("stamina", stamina);
		stats.put("dex_mod", dex_mod);
		stats.put("str_mod", str_mod);
		stats.put("int_mod", int_mod);
		stats.put("con_mod", con_mod);
		IAbility ability_one = ability_a;
		IAbility ability_two = ability_b;
		IAbility ability_three = ability_c;
		return new Player(stats, ability_one, ability_two, ability_three);
	}
}
