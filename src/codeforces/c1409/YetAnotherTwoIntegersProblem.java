package codeforces.c1409;

import java.util.Scanner;

public class YetAnotherTwoIntegersProblem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-->0){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int d = Math.abs(a - b);
            int m = d/10 + (d%10==0? 0 : 1);
            System.out.println(m);
        }
    }
}
