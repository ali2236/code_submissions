package codeforces.c1353;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class TwoArraysAndSwaps {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-->0){
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            Integer[] a = new Integer[n];
            Integer[] b = new Integer[n];
            for (int i = 0; i < n; i++) a[i] = scanner.nextInt();
            for (int i = 0; i < n; i++) b[i] = scanner.nextInt();
            Arrays.sort(a);
            Arrays.sort(b);
            int la = 0;
            int rb = n-1;
            for (int i = 0; i < n && k > 0 && rb>=0 && la < n; i++) {
                if(b[rb] > a[la]){
                    a[la] = b[rb];
                    rb--;
                    la++;
                    k--;
                } else {
                    la++;
                }
            }
            System.out.println(Stream.of(a).reduce(Integer::sum).get());
        }
    }
}
