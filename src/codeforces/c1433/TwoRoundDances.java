package codeforces.c1433;

import java.util.Scanner;

public class TwoRoundDances {
    public static void main(String[] args) {
        facts[0] = 1;
        facts[1] = 1;
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(calculateDances(n));
    }

    private static long calculateDances(int n){
        long ans = 1;
        for (int i = n-1; i > (n/2) ; i--) {
            ans *= i;
        }
        long tp = factorial ((n/2) - 1);
        ans *= tp;
        return ans;
    }

    private static long[] facts = new long[100];
    private static long factorial(int n){
        if(facts[n]==0) facts[n] = factorial(n - 1) * n;
        return facts[n];
    }
}
