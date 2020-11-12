package quera.javacup_final_7.football.ir.javacup.fb.impl;

import ir.javacup.fb.*;

public class ChampionReporter implements GameReporter<TableRecord> {

	private final GameRepository repository;

	public ChampionReporter(GameRepository repository) {
		this.repository = repository;
	}

	@Override
	public TableRecord report() {
		LeagueTableReporter reporter = new LeagueTableReporter(repository);
		return reporter.report().get(0);
	}

}
