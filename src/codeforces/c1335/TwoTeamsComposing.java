package codeforces.c1335;

import java.util.Scanner;

public class TwoTeamsComposing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] a = new int[n + 1];
            for (int i = 0; i < n; i++) a[scanner.nextInt()]++;
            System.out.println(maxTeams(a));
        }
    }

    private static int maxTeams(int[] counts) {
        int maxCount = 0, distinct = 0;
        for (int i = 1; i < counts.length; i++) {
            int count = counts[i];
            if (count > 0) {
                distinct++;
                maxCount = Math.max(maxCount, count);
            }
        }
        if (maxCount - distinct > 0) return distinct;
        else return Math.min(maxCount, distinct - 1);
    }
}
