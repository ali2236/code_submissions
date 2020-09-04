package codeforces.c1409;

import java.util.Scanner;

public class MinimumProduct {

    public static void main(String[] args) {
        new MinimumProduct().solve();
    }

    public void solve() {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
           int a = scanner.nextInt();
           int b = scanner.nextInt();
           int x = scanner.nextInt();
           int y = scanner.nextInt();
           int n = scanner.nextInt();
           int ma = a - x;
           int mb = b - y;
            System.out.println(Math.min(doA(a,b,n,ma,mb),doB(a,b,n,ma,mb)));
        }
    }

    long doA(int a, int b, int n, int ma, int mb) {
        int dec = Math.min(ma , n);
        a -= dec;
        n -= dec;

        dec = Math.min(mb, n);
        b -= dec;

        return (long) a * b;
    }


    long doB(int a, int b, int n, int ma, int mb) {
        int dec = Math.min(mb, n);
        b -= dec;
        n -= dec;

        dec = Math.min(ma , n);
        a -= dec;

        return (long) a * b;
    }
}