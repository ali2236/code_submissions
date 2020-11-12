package quera.javacup_final_7.football.ir.javacup.fb;

import ir.javacup.fb.impl.ChampionReporter;
import ir.javacup.fb.impl.LeagueTableReporter;
import ir.javacup.fb.impl.TopScorerReporter;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class Main {

	private static final String T1 = "team-1";
	private static final String T2 = "team-2";
	private static final String T3 = "team-3";

	private static final String P11 = "player-1-1";
	private static final String P12 = "player-1-2";
	private static final String P21 = "player-2-1";
	private static final String P31 = "player-3-1";

	public static void main(String[] args) {
		Game g12_31 = new Game(T1, T2, asList(goal(T1, P11), goal(T2, P21), goal(T1, P12), goal(T1, P11)));
		Game g31_11 = new Game(T3, T1, asList(goal(T1, P11), goal(T3, P31)));

		GameRepository repository = new GameRepository(asList(g12_31, g31_11));

		System.out.println("LeagueTableReporter:");
		LeagueTableReporter leagueTableReporter = new LeagueTableReporter(repository);
		print(leagueTableReporter.report());

		System.out.println("ChampionReporter:");
		ChampionReporter championReporter = new ChampionReporter(repository);
		System.out.println("\t" + championReporter.report());

		System.out.println("TopScorerReporter:");
		TopScorerReporter topScorerReporter = new TopScorerReporter(repository);
		System.out.println("\t" + topScorerReporter.report());
	}

	public static GoalEvent goal(String team, String scorer) {
		return new GoalEvent(team, scorer, generateTime());
	}

	private static final Random random = new Random();

	public static int generateTime() {
		return random.nextInt(91);
	}

	private static void print(List<TableRecord> table) {
		System.out.println(table.stream().map(x -> "\t" + x).collect(Collectors.joining("\n")));
	}
}
