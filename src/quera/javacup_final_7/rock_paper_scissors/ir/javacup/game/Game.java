package quera.javacup_final_7.rock_paper_scissors.ir.javacup.game;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class Game {

    final private Player player1, player2;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public GameResult run() {
        int s1 = 0, s2 = 0;
        while (s1 < 3 && s2 < 3) {
            CompletableFuture<PlayRound> p1 = player1.play();
            CompletableFuture<PlayRound> p2 = player2.play();
            PlayerHand h1 = null, h2 = null;
            long start = System.currentTimeMillis();
            long left = 1010;
            try {
                h1 = p1.get(left,TimeUnit.MILLISECONDS).getHand();
            } catch (Exception ignored) { }
            long passed = System.currentTimeMillis() - start;
            left -= passed;
            try {
                h2 = p2.get(left, TimeUnit.MILLISECONDS).getHand();
            } catch (Exception ignored) { }
            if(h1!=null && h2!=null){
                if (h1.equals(h2)) continue; // mosavi
                if (winner(h1, h2)) s1++;
                else s2++;
            }
            else if(h1==null && h2!=null) s2++;
            else if(h1 != null) s1++;
        }


        return new GameResult(s1 > s2 ? player1 : player2, String.format("%d-%d", s1, s2));
    }

    boolean winner(PlayerHand h1, PlayerHand h2) {
        if (h1.equals(PlayerHand.ROCK) && h2.equals(PlayerHand.SCISSORS)) return true;
        if (h1.equals(PlayerHand.PAPER) && h2.equals(PlayerHand.ROCK)) return true;
        return h1.equals(PlayerHand.SCISSORS) && h2.equals(PlayerHand.PAPER);
    }

}
