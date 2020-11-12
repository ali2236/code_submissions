package quera.javacup_final_7.football.ir.javacup.fb;

public class PlayerGoals {

	private final String player;
	private final int goals;

	public PlayerGoals(String player, int goals) {
		this.player = player;
		this.goals = goals;
	}

	public String getPlayer() {
		return player;
	}

	public int getGoals() {
		return goals;
	}

	@Override
	public String toString() {
		return "PlayerGoals{" + "player='" + player + '\'' + ", goals=" + goals + '}';
	}
}
