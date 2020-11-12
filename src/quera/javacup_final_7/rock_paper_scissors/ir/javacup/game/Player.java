package quera.javacup_final_7.rock_paper_scissors.ir.javacup.game;

import java.util.concurrent.CompletableFuture;

public interface Player {
	int id();
	CompletableFuture<PlayRound> play();
}
