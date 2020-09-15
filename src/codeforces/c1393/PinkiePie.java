package codeforces.c1393;

import java.util.Arrays;
import java.util.Scanner;

// url: https://codeforces.com/contest/1393/problem/C
public class PinkiePie {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-->0){
            int n = scanner.nextInt();
            int[] a = new int[n];
            for(int i=0;i<n;i++) a[i] = scanner.nextInt();
            System.out.println(Arrays.toString(solve(a, n)));
        }
    }

    private static int[] solve(int[] a, int n){
        int[] count = new int[n+1];
        for (int i = 0; i < n; i++) count[a[i]]++;
        Arrays.sort(count);
        return count;
    }
}
