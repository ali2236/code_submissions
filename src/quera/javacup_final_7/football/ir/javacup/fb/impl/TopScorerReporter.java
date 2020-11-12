package quera.javacup_final_7.football.ir.javacup.fb.impl;

import ir.javacup.fb.*;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopScorerReporter implements GameReporter<PlayerGoals> {

	private final GameRepository repository;

	public TopScorerReporter(GameRepository repository) {
		this.repository = repository;
	}

	@Override
	public PlayerGoals report() {
		List<Game> games = repository.getGames();
		if(games.isEmpty()) throw new IllegalStateException();

		Map<String, PlayerEntry> players = new HashMap<>();

		for (Game game: games){
			for (GameEvent event: game.getEvents()){
				if(event instanceof GoalEvent){
					String player = event.getPlayer();
					players.putIfAbsent(player, new PlayerEntry(player));
					PlayerEntry pe = players.get(player);
					pe.goals++;
				}
			}
		}

		PlayerEntry playerEntry = players.values().stream().sorted(Comparator.comparingInt(PlayerEntry::getGoals).reversed()).findFirst().get();
		PlayerGoals playerGoals = new PlayerGoals(playerEntry.name, playerEntry.getGoals());
		return playerGoals;
	}

	public static final class PlayerEntry {
		final public String name;
		public int goals = 0;

		public PlayerEntry(String name) {
			this.name = name;
		}

		public Integer getGoals(){
			return goals;
		}
	}


}
