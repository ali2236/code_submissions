package quera.javacup_final_7.football.ir.javacup.fb;

import java.util.Collections;
import java.util.List;

public class GameRepository {

	private final List<Game> games;

	public GameRepository(List<Game> games) {
		this.games = Collections.unmodifiableList(games);
	}

	public List<Game> getGames() {
		return games;
	}

}
