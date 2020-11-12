package quera.javacup_final_7.rock_paper_scissors.ir.javacup.game;

public class GameResult {

	private final Player winner;
	private final String result;

	public GameResult(Player winner, String result) {
		this.winner = winner;
		this.result = result;
	}

	public Player getWinner() {
		return winner;
	}

	public String getResult() {
		return result;
	}
}
