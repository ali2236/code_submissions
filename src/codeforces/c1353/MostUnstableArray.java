package codeforces.c1353;

import java.util.Scanner;

public class MostUnstableArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-->0){
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            solve(n,m);
        }
    }

    private static void solve(int n, int m){
        if(n>2){
            System.out.println(m*2);
        } else if(n==2){
            System.out.println(m);
        } else {
            System.out.println(0);
        }
    }
}
