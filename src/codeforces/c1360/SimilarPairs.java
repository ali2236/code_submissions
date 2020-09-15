package codeforces.c1360;

import java.util.Arrays;
import java.util.Scanner;

public class SimilarPairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = scanner.nextInt();
            System.out.println(partitionExists(a, n) ? "YES" : "NO");
        }
    }

    private static boolean partitionExists(int[] a, int n) {
        Arrays.sort(a);
        int even = 0, odd = 0, d1 = 0, lastSeen = -10;
        for (int i = 0; i < n; i++) {
            int num = a[i];
            if (num % 2 == 0) even++;
            else odd++;
            if(num-lastSeen==1) d1++;
            lastSeen = num;
        }
        if(even%2==0 && odd%2==0){
            return true;
        } else if(even%2==0 || odd%2==0) {
            return false;
        }
        return d1 > 0;
    }
}
