package GameObject;

public class MonsterFactory {
	public String difficulty = null;
	
	public Monster getMonster(int game_time) {
		MonsterBuilder spawn = new MonsterBuilder();
		if(game_time < 30) {
			difficulty = "common";
		}
		else if(game_time < 180 && game_time >= 30) {
			difficulty = "uncommon";
		}
		else if(game_time < 360 && game_time >= 180) {
			difficulty = "rare";
		}
		else if(game_time < 720 && game_time >= 360) {
			difficulty = "legendary";
		}
		return spawn.buildMonster(difficulty);
	}
}
