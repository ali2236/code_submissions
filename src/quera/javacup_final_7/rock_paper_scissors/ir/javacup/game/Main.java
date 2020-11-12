package quera.javacup_final_7.rock_paper_scissors.ir.javacup.game;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static java.util.Arrays.asList;

public class Main {

	public static void main(String[] args) {
		runWithInstantPlayers();
		runWithDelayedPlayers();
	}

	private static void runWithInstantPlayers() {
		Player player1 = new SimplePlayer(1, asList(PlayerHand.PAPER, PlayerHand.ROCK, PlayerHand.ROCK, PlayerHand.SCISSORS));
		Player player2 = new SimplePlayer(2, asList(PlayerHand.ROCK, PlayerHand.PAPER, PlayerHand.SCISSORS, PlayerHand.PAPER));

		Game game = new Game(player1, player2);

		GameResult gameResult = game.run();
		System.out.println("#1 Winner: " + gameResult.getWinner());
		System.out.println("#1 Result: " + gameResult.getResult());
	}

	private static void runWithDelayedPlayers() {
		Player player1 = new DelayedPlayer(1, asList(PlayerHand.PAPER, PlayerHand.ROCK, PlayerHand.ROCK), 1100);
		Player player2 = new SimplePlayer(2, asList(PlayerHand.ROCK, PlayerHand.PAPER, PlayerHand.SCISSORS));

		Game game = new Game(player1, player2);
		GameResult gameResult = game.run();
		System.out.println("#2 Winner: " + gameResult.getWinner());
		System.out.println("#2 Result: " + gameResult.getResult());
	}

	private static class SimplePlayer implements Player {

		private final int id;
		private final List<PlayerHand> hands;
		private int roundIndex = 0;

		public SimplePlayer(int id, List<PlayerHand> hands) {
			this.id = id;
			this.hands = hands;
		}

		@Override
		public int id() {
			return id;
		}

		@Override
		public CompletableFuture<PlayRound> play() {
			return CompletableFuture.supplyAsync(() -> {
				beforeReturnPlayRound();
				PlayerHand hand = hands.get(roundIndex++);
				return new PlayRound(id, hand);
			});
		}

		protected void beforeReturnPlayRound() {
		}

		@Override
		public String toString() {
			return "Player[" + id + ']';
		}
	}

	private static class DelayedPlayer extends SimplePlayer {

		private final long delayInMillis;

		public DelayedPlayer(int id, List<PlayerHand> hands, long delayInMillis) {
			super(id, hands);
			this.delayInMillis = delayInMillis;
		}

		@Override
		protected void beforeReturnPlayRound() {
			try {
				Thread.sleep(delayInMillis);
			} catch (InterruptedException e) {
				// ignore
			}
		}

	}


}
