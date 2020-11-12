package quera.javacup_final_7.football.ir.javacup.fb;

public class TableRecord {

	private final String team;
	private final int points;
	private final int goalDif;

	public TableRecord(String team, int points, int goalDif) {
		this.team = team;
		this.points = points;
		this.goalDif = goalDif;
	}

	public String getTeam() {
		return team;
	}

	public int getPoints() {
		return points;
	}

	public int getGoalDif() {
		return goalDif;
	}

	@Override
	public String toString() {
		return "TableRecord{" + "team='" + team + '\'' + ", points=" + points + ", goalDif=" + goalDif + '}';
	}
}
