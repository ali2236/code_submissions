package codeforces.c1324;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            boolean possible = false;
            outer:
            for (int i = 0; i < n; i++) {
                for (int j = n - 1; j > i + 1; j--) {
                    if (a[j] == a[i]) {
                        possible = true;
                        break outer;
                    }
                }
            }
            System.out.println(possible?"YES":"NO");
        }
    }
}
