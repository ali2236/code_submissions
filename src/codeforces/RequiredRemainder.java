package codeforces;

import java.util.Scanner;

public class RequiredRemainder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-->0){
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int n = scanner.nextInt();
            System.out.println(solve(x,y,n));
        }
    }

    private static int solve(int x, int y, int n){
        int ny = n%x;
        if(ny==y) return n;

        int yny = (y - ny);
        int k = (n - (yny>0?x:0)) + yny;

        return k;
    }
}
