package codeforces.c1324;

import java.util.Scanner;

public class SleepingSchedule {

    static int n, h, l, r;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        h = scanner.nextInt();
        l = scanner.nextInt();
        r = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) a[i] = scanner.nextInt();
        dp = new int[n + 1][h + 1];
        for (int i = 0; i < n + 1; i++)
            for (int j = 0; j < h + 1; j++) dp[i][j] = -1;
        System.out.println(solve(0, 0));
    }

    static int[][] dp;
    private static int solve(int s, int t) {
        // is time good
        int goodTime = s != 0 && t >= l && t <= r ? 1 : 0;

        if (s == a.length) return goodTime;

        if (dp[s][t] != -1) return dp[s][t];

        // stay awake
        int awake = a[s];

        // go to sleep
        int a0 = dp[s + 1][(t + awake) % h] = solve(s + 1, (t + awake) % h);
        int a1 = dp[s + 1][(t + awake - 1) % h] = solve(s + 1, (t + awake - 1) % h);

        return Math.max(a0, a1) + goodTime;
    }
}
