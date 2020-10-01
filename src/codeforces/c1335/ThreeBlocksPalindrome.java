package codeforces.c1335;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;


// unsolved - URL: https://codeforces.com/contest/1335/problem/E1
public class ThreeBlocksPalindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] a = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
            System.out.println(blockLength(a));
        }
    }

    private static int blockLength(int[] a) {
        int max = 0;
        int[] distinct = Arrays.stream(a).distinct().toArray();
        for (int i = 0; i < distinct.length; i++) {
            for (int j = i; j < distinct.length; j++) {
                max = Math.max(max, subLength(a, distinct[i], distinct[j]));
            }
        }
        return max;
    }

    private static int subLength(int[] d, int a, int b) {
        d = Arrays.stream(d).filter(i -> i == a || i == b).toArray();
        int l = 0;
        int r = d.length - 1;
        int select = a;
        try {
            int length = 0;
            while (r >= l) {
                if (charEq(d[l], d[r], a, b)) {
                    length += l != r ? 2 : 1;
                    l++;
                    r--;
                } else {
                    if (charEq(d[l + 1], d[r], a, b)) l++;
                    else r--;
                }
            }
            return length;
        } catch (Exception e) {
            return 0;
        }
    }

    private static boolean charEq(int f, int s, int a, int b) {
        return s == f && (f == a || f == b);
    }
}