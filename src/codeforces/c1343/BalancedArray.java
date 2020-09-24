package codeforces.c1343;

import java.util.Scanner;

public class BalancedArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            balancedArray(n / 2);
        }
    }

    private static void balancedArray(final long length) {
        long sum = ((length + 1) * length);
        if (length % 2 == 1) {
            System.out.println("NO");
        } else {
            System.out.println("YES");

            for (int i = 0; i < length; i++) {
                long num = (i + 1) * 2;
                System.out.print(num+" ");
            }

            for (int i = 0; i < length - 1; i++) {
                long num = (i * 2) + 1;
                System.out.print(num + " ");
                sum -= num;
            }
            System.out.print(sum);
            System.out.println();
        }
    }
}
