package quera.javacup_final_7.rock_paper_scissors.ir.javacup.game;

public class PlayRound {

	private final int playerId;
	private final PlayerHand hand;

	public PlayRound(int playerId, PlayerHand hand) {
		this.playerId = playerId;
		this.hand = hand;
	}

	public int getPlayerId() {
		return playerId;
	}

	public PlayerHand getHand() {
		return hand;
	}

	@Override
	public String toString() {
		return "PlayRound{" + "playerId=" + playerId + ", hand=" + hand + '}';
	}

}
