package codeforces.c1343;

import java.util.Scanner;

public class Candies {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            System.out.println(candies(n));
        }
    }

    private static int candies(int n){
        for (int i = 3; i <= n; i += i+1) {
            if (n % i == 0) return n / i;
        }
        return -1;
    }
}
