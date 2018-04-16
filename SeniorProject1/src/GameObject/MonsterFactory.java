package GameObject;

public class MonsterFactory {
	public String difficulty = null;
	
	public Monster getMonster(int game_time) {
		MonsterBuilder spawn = new MonsterBuilder();
		if(game_time < 60 * 1000) {
			difficulty = "common";
		}
		else if(game_time < 180 * 1000 && game_time >= 60 * 1000) {
			difficulty = "uncommon";
		}
		else if(game_time < 360 * 1000 && game_time >= 180 * 1000) {
			difficulty = "rare";
		}
		else if(game_time < 720 * 1000 && game_time >= 360 * 1000) {
			difficulty = "legendary";
		}
		return spawn.buildMonster(difficulty);
	}
}
