package codeforces.c1360;

import java.util.Scanner;

public class BuyingShovels {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-->0){
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            System.out.println(shovelPackages(n,k));
        }
    }


    private static int shovelPackages(int n, int k){
        if(k>=n) return 1;
        int m = n;
        for (int i = 1; i*i <= n; i++) {
            if(n%i==0) {
                if(n/i<=k) return i;
                if(i<=k) m = Math.min(m, n/i);
            }
        }
        return m;
    }
}
