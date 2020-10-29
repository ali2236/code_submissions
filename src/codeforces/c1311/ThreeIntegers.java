package codeforces.c1311;

import java.util.Scanner;

// unsolved
public class ThreeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-->0){
            int a = scanner.nextInt(), b = scanner.nextInt(), c = scanner.nextInt();
            solve(a, b, c);
        }
    }
    // 1 5 10 15
    private static void solve(int a, int b, int c){
        // b % a == 0 && c % b == 0
        int count = 0;
        int d1 = b%a, d2 = c%b;
        if(d1!=0){
            count += d2;
            a += d2;
        }
        if(d2!=0){
            count += d2;
            c += d2;
        }
        System.out.println(count);
        System.out.printf("%d %d %d", a,b,c);
    }

}
