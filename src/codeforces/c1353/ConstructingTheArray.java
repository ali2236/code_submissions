package codeforces.c1353;

import java.util.Arrays;
import java.util.Scanner;

// unsolved
public class ConstructingTheArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            printArray(n);
        }
    }

    private static void printArray(int n) {
        Integer[] a = new Integer[n];
        Arrays.fill(a, 0);
        int i = 1;
        int l = 0, r = n - 1;
        while (i != n) {
            if (l - r + 1 % 2 == 0) {
                a[l + r] = i++;
            } else {
                a[(l + r) / 2] = i++;
            }
            Integer[] rn = range(a);
            l = rn[0];
            r = rn[1];
        }
    }

    private static Integer[] range(Integer[] a) {
        Integer l = -1;
        Integer r = -1;
        Integer l2 = -1;
        Integer r2 = -1;
        Integer last = -1;
        for (int i = 0; i < a.length; i++) {
            Integer current = a[i];
            if (current == 0 && last != 0) {
                if (l == -1) l = i;
                else l2 = i;
            } else if (current == 0 && last == 0) {
                if (l2 == -1) r = i;
                else r2 = i;
            } else if (current != 0 && last == 0) {
                if (l2 != -1) {
                    if (r2 - l2 > l - r) {
                        l = l2;
                        r = r2;
                    }
                }
            }
            last = current;
        }
        if (l - r > l2 - r2) {
            return new Integer[]{l, r};
        } else {
            return new Integer[]{l2, r2};
        }
    }
}
