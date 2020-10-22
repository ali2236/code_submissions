package codeforces.c1433;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

// Unsolved
public class ZeroRemainderSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = scanner.nextInt();
            }
        }
        System.out.println(maxSum(a,n,m,k));
    }

    private static int maxSum(int[][] a, final int n, final int m, final int k) {
        int c = m/2;
        for (int i = 0; i < n; i++) Arrays.sort(a[i]);

        List<Integer> pd = new ArrayList<>();

        // maximum sum
        int[] maximumSums = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = m-1, cc = 0; j >= 0 && cc<c; j--, cc++) {
                maximumSums[i] += a[i][j];
            }
        }
        int maximumSum = IntStream.of(maximumSums).sum();

        // reduce if necessary
        int d = maximumSum % k;
        if(d==0) return maximumSum;
        int km = 0;
        return maximumSum - (d + k * km);
        // select in a way for d -> 0
       /* for (int i = 0; i < n; i++) {
            maximumSums[i];
        }*/
    }
}
