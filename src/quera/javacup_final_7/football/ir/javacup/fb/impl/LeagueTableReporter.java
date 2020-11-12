package quera.javacup_final_7.football.ir.javacup.fb.impl;

import ir.javacup.fb.*;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class LeagueTableReporter implements GameReporter<List<TableRecord>> {

    private final GameRepository repository;

    public LeagueTableReporter(GameRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<TableRecord> report() {
        List<Game> games = repository.getGames();
        if (games == null || games.isEmpty()) throw new IllegalStateException();
        Map<String, TeamEntry> teams = new HashMap<>();

        for (Game game : games) {
            String team1 = game.getTeam1();
            String team2 = game.getTeam2();
            int team1Goals = 0, team2Goals = 0;

            // count goals
            for (GameEvent event : game.getEvents()) {
                if (event instanceof GoalEvent) {
                    if (event.getTeam().equals(team1)) team1Goals++;
                    else team2Goals++;
                }
            }

            // create entries
            teams.putIfAbsent(team1, new TeamEntry(team1));
            teams.putIfAbsent(team2, new TeamEntry(team2));
            TeamEntry t1e = teams.get(team1);
            TeamEntry t2e = teams.get(team2);

            if (team1Goals > team2Goals) {
                t1e.points += 3;
            } else if (team1Goals < team2Goals) {
                t2e.points += 3;
            } else {
                t1e.points += 1;
                t2e.points += 1;
            }

            t1e.goals += team1Goals;
            t1e.antiGoal += team2Goals;
            t2e.goals += team2Goals;
            t2e.antiGoal += team1Goals;

        }

        List<TableRecord> records = teams
                .values()
                .stream()
                .map(t -> new TableRecord(t.name, t.points, t.getGoadDiffrence()))
                .sorted(Comparator.comparingInt(TableRecord::getPoints)
                        .thenComparingInt(TableRecord::getGoalDif)
                        .reversed())
                .collect(Collectors.toList());
        return records;
    }

    public static final class TeamEntry {
        final public String name;
        public int points = 0, goals = 0, antiGoal = 0;

        public TeamEntry(String name) {
            this.name = name;
        }

        public int getGoadDiffrence() {
            return goals - antiGoal;
        }
    }

}
