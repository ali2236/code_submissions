package quera.javacup_final_7.football.ir.javacup.fb;

import java.util.Collections;
import java.util.List;

public class Game {

	private final String team1;
	private final String team2;
	private final List<GameEvent> events;

	public Game(String team1, String team2, List<GameEvent> events) {
		this.team1 = team1;
		this.team2 = team2;
		this.events = Collections.unmodifiableList(events);
	}

	public String getTeam1() {
		return team1;
	}

	public String getTeam2() {
		return team2;
	}

	public List<GameEvent> getEvents() {
		return events;
	}
}
