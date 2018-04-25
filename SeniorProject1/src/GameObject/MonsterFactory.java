package GameObject;

public class MonsterFactory {
	public String difficulty = null;
	
	public Monster getMonster(int game_time) {
		MonsterBuilder spawn = new MonsterBuilder();
		if(game_time < 10) {
			difficulty = "common";
		}
		else if(game_time < 20 && game_time >= 10) {
			difficulty = "uncommon";
		}
		else if(game_time < 30 && game_time >= 20) {
			difficulty = "rare";
		}
		else if(game_time >= 30) {
			difficulty = "legendary";
		}
		return spawn.buildMonster(difficulty);
	}
}
