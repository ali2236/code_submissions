package codeforces;

import java.util.Scanner;

public class GiftsFixing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-->0) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            for (int i = 0; i < n; i++) {
                b[i] = scanner.nextInt();
            }

            int minA = arrayMin(a);
            int minB = arrayMin(b);

            long moves = 0;

            for (int i = 0; i < n; i++) {
                if (a[i] > minA && b[i] > minB) {
                    int dA = a[i] - minA;
                    int dB = b[i] - minB;
                    int min = Math.min(dA, dB);
                    moves += min;
                    a[i] -= min;
                    b[i] -= min;
                }
                if (a[i] > minA) {
                    int dA = a[i] - minA;
                    moves += dA;
                    a[i] -= dA;
                } else if (b[i] > minB) {
                    int dB = b[i] - minB;
                    moves += dB;
                    b[i] -= dB;
                }
            }

            System.out.println(moves);
        }
    }

    public static int arrayMin(int[] a) {
        int min = a[0];
        for (int i = 0; i < a.length; i++) {
            if (a[i] < min) min = a[i];
        }
        return min;
    }
}
