package Abilities;

public abstract class Ability implements IAbility {
	public String javascript;
	public String ability_name;

	public Ability(String name) {
		ability_name = name;
	}

	public String load() {
		ability_name = "test";
		return javascript;
	}

	public String get_name() {
		return ability_name;
	}
}
