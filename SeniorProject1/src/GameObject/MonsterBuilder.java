package GameObject;

import java.util.Hashtable;
import Abilities.*;

public class MonsterBuilder extends Character {
	public Hashtable<String, Integer> stats = new Hashtable<String, Integer>();
	public IAbility ability_a;
	public String difficulty;
		
	public void setStats(String monster_strength) {
		switch(monster_strength) {
		case "common":
			stats.put("str",10);
			stats.put("dex",10);
			stats.put("con",10);
			stats.put("int",10);
			stats.put("wis",10);
			stats.put("chr",10);
			break;
		case "uncommon" :
			stats.put("str",12);
			stats.put("dex",12);
			stats.put("con",12);
			stats.put("int",12);
			stats.put("wis",12);
			stats.put("chr",12);
			break;
		case "rare" :
			stats.put("str",14);
			stats.put("dex",14);
			stats.put("con",14);
			stats.put("int",14);
			stats.put("wis",14);
			stats.put("chr",14);
			break;
		case "legendary" :
			stats.put("str",18);
			stats.put("dex",18);
			stats.put("con",18);
			stats.put("int",18);
			stats.put("wis",18);
			stats.put("chr",18);
			break;
		}
	}

	public void setAbilityA(IAbility ability) {
		ability_a = ability;
	}

	public void setAbilityB(IAbility ability_b) {

	}

	public void setAbilityC(IAbility ability_c) {

	}

	public void setAbilityD(IAbility ability_d) {

	}

	public Monster buildMonster(String monster_strength) {
		difficulty = monster_strength;
		System.out.println(difficulty);
		setStats(difficulty);
		setAbilityA(new TestAbility());
		Monster monster = new Monster(stats, ability_a);
		return monster;
	}
}
