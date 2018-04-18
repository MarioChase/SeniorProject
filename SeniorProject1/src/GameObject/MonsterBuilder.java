package GameObject;

import java.util.Hashtable;
import java.util.Random;

import Abilities.*;

public class MonsterBuilder extends Character {
	public Hashtable<String, Integer> stats = new Hashtable<String, Integer>();
	public IAbility ability_a;
	public String difficulty;
	Random random = new Random();
	
	public void setStats(String monster_strength) {
	int monster_class = random.nextInt(4 - 0);
		System.out.print(monster_class);
		switch(monster_class) {
		//wizard
		case 0:
			stats.put("monster_class", 0);
			switch (monster_strength) {
			case "common":
				stats.put("str", 8);
				stats.put("dex", 10);
				stats.put("con", 8);
				stats.put("int", 12);
				stats.put("wis", 12);
				stats.put("chr", 10);
				break;
			case "uncommon":
				stats.put("str", 8);
				stats.put("dex", 10);
				stats.put("con", 8);
				stats.put("int", 16);
				stats.put("wis", 12);
				stats.put("chr", 12);
				break;
			case "rare":
				stats.put("str", 10);
				stats.put("dex", 10);
				stats.put("con", 8);
				stats.put("int", 18);
				stats.put("wis", 14);
				stats.put("chr", 14);
				break;
			case "legendary":
				stats.put("str", 12);
				stats.put("dex", 12);
				stats.put("con", 10);
				stats.put("int", 20);
				stats.put("wis", 16);
				stats.put("chr", 16);
				break;
			}
			break;
		//rogue
		case 1:
			stats.put("monster_class", 1);
			switch (monster_strength) {
			case "common":
				stats.put("str", 12);
				stats.put("dex", 12);
				stats.put("con", 10);
				stats.put("int", 10);
				stats.put("wis", 8);
				stats.put("chr", 8);
				break;
			case "uncommon":
				stats.put("str", 14);
				stats.put("dex", 16);
				stats.put("con", 10);
				stats.put("int", 10);
				stats.put("wis", 8);
				stats.put("chr", 8);
				break;
			case "rare":
				stats.put("str", 16);
				stats.put("dex", 18);
				stats.put("con", 12);
				stats.put("int", 12);
				stats.put("wis", 10);
				stats.put("chr", 10);
				break;
			case "legendary":
				stats.put("str", 16);
				stats.put("dex", 20);
				stats.put("con", 14);
				stats.put("int", 14);
				stats.put("wis", 12);
				stats.put("chr", 12);
				break;
			}
			break;
		//priest
		case 2:
			stats.put("monster_class", 2);
			switch (monster_strength) {
			case "common":
				stats.put("str", 12);
				stats.put("dex", 8);
				stats.put("con", 10);
				stats.put("int", 8);
				stats.put("wis", 12);
				stats.put("chr", 10);
				break;
			case "uncommon":
				stats.put("str", 14);
				stats.put("dex", 10);
				stats.put("con", 12);
				stats.put("int", 10);
				stats.put("wis", 14);
				stats.put("chr", 12);
				break;
			case "rare":
				stats.put("str", 14);
				stats.put("dex", 10);
				stats.put("con", 12);
				stats.put("int", 10);
				stats.put("wis", 18);
				stats.put("chr", 12);
				break;
			case "legendary":
				stats.put("str", 14);
				stats.put("dex", 12);
				stats.put("con", 14);
				stats.put("int", 10);
				stats.put("wis", 20);
				stats.put("chr", 14);
				break;
			}
			break;
		//barbarian
		case 3:
			stats.put("monster_class", 3);
			switch (monster_strength) {
			case "common":
				stats.put("str", 14);
				stats.put("dex", 10);
				stats.put("con", 14);
				stats.put("int", 6);
				stats.put("wis", 6);
				stats.put("chr", 6);
				break;
			case "uncommon":
				stats.put("str", 16);
				stats.put("dex", 12);
				stats.put("con", 16);
				stats.put("int", 6);
				stats.put("wis", 6);
				stats.put("chr", 6);
				break;
			case "rare":
				stats.put("str", 18);
				stats.put("dex", 12);
				stats.put("con", 18);
				stats.put("int", 8);
				stats.put("wis", 8);
				stats.put("chr", 8);
				break;
			case "legendary":
				stats.put("str", 22);
				stats.put("dex", 14);
				stats.put("con", 22);
				stats.put("int", 8);
				stats.put("wis", 8);
				stats.put("chr", 8);
				break;
			}
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
