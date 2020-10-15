package codeforces.c1328;

import java.util.Scanner;

public class Carousel {
    //1
    //9
    //1 2 2 2 1 3 3 3 1
    //
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            int k = 1;
            for (int i = 0; i < n; i++) {
                int type = scanner.nextInt();
                a[i] = type;
            }

            for (int i = 0; i < n - 1; i++) {
                int first = a[i];
                int second = a[i + 1];
            }

            System.out.println(k);

        }
    }
}
