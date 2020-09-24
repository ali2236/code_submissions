package codeforces.c1343;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AlternatingSubsequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = scanner.nextInt();
            solve(a, n);
        }
    }

    private static void solve(int[] a, final int n) {
        // compress
        List<Long> numbers = new ArrayList<>();
        long sign = a[0];
        long max = a[0];
        for (int i = 1; i < a.length; i++) {
            long c = a[i];
            if(differentSigns(c,sign)){
                numbers.add(max);
                max = c;
                sign = c;
            } else {
                max = Math.max(max, c);
            }
        }
        numbers.add(max);
        System.out.println(numbers.stream().reduce(Long::sum).get());
    }

    private static boolean differentSigns(long a, long b){
        if(a>0 && b<0) return true;
        if(b>0 && a<0) return true;
        return false;
    }
}
