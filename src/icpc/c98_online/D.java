package icpc.c98_online;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

// unsolved
public class D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] goals = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                goals[i][j] = scanner.nextInt();
            }
        }
        // sort by
        // 1. most score
        // 2. most goals / def
        // 3. char
        Team[] teams = new Team[n];
        for (int i = 0; i < n; i++) {
            teams[i] = new Team(i);
        }
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                Team first = teams[i];
                Team second = teams[j];

                int itoj = goals[i][j];
                int jtoi = goals[j][i];

                first.goals += itoj;
                second.unGoals += itoj;

                second.goals += jtoi;
                first.unGoals += jtoi;

                if(itoj==jtoi){
                    first.score++;
                    second.score++;
                } else if(itoj > jtoi){
                    first.score += 3;
                } else {
                    second.score += 3;
                }
            }
        }

        Arrays.sort(teams, Comparator.reverseOrder());

        Arrays.stream(teams).forEach(t -> System.out.print((char) ('a' + t.id)));
    }

    static final class Team implements Comparable<Team> {
        final int id;
        public int score = 0;
        public int goals = 0;
        public int unGoals = 0;

        Team(int id) {
            this.id = id;
        }

        int getDiff(){
            return goals - unGoals;
        }

        @Override
        public int compareTo(Team o) {
            int scores = Integer.compare(this.score,o.score);
            if(scores!=0) return  scores;
            int diff = Integer.compare(this.getDiff(), o.getDiff());
            if(diff!=0) return diff;
            return Integer.compare(this.id, o.id);
        }
    }
}
