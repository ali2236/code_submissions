package codeforces.c1426;

import java.util.Scanner;

public class SymmetricMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            boolean sideSymmetric = false;

            // take input
            for (int i = 0; i < n; i++) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                int c = scanner.nextInt();
                int d = scanner.nextInt();
                if (b == c) {
                    sideSymmetric = true;
                }
            }

            if (m % 2 != 0) {
                System.out.println("NO");
            } else if ( sideSymmetric) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
