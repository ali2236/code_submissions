package quera.javacup_final_7.football.ir.javacup.fb;

public class GoalEvent implements GameEvent {

	private final String team;
	private final String scorer;
	private final int goalTime;

	public GoalEvent(String team, String scorer, int goalTime) {
		this.team = team;
		this.scorer = scorer;
		this.goalTime = goalTime;
	}

	@Override
	public String getTeam() {
		return team;
	}

	@Override
	public String getPlayer() {
		return scorer;
	}

	@Override
	public int getEventTime() {
		return goalTime;
	}

}
