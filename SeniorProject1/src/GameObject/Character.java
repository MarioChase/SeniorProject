package GameObject;

import Abilities.IAbility;

public abstract class Character extends GameObject{
	public int health;
	public int mana;
	public int stamina;
	public int dex_mod;
	public int str_mod;
	public int int_mod;
	public int con_mod;
	public IAbility ability_one;
	public IAbility ability_two;
	public IAbility ability_three;
	public IAbility ability_four;
}
