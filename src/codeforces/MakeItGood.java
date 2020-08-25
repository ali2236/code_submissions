package codeforces;

import java.util.Scanner;

public class MakeItGood {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = scanner.nextInt();
            System.out.println(solve(a));
        }
    }

    public static int solve(int[] a) {

        if (a.length == 1 || a.length == 2) return 0;

        int[] shib = new int[a.length - 1];

        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i+1]) shib[i] = 1;
            else if (a[i] == a[i + 1]) shib[i] = 0;
            else shib[i] = -1;
        }

        int j = a.length - 1;
        int i = shib.length - 1;

        while (i >= 0 && (shib[i] == 1 || shib[i] == 0)) {
            j--;
            i--;
        }

        while (i >= 0 && (shib[i] == -1 || shib[i] == 0)) {
            j--;
            i--;
        }

        return j;
    }
}
