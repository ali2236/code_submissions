package codeforces.c1335;

import java.util.Scanner;

public class CandiesAndTwoSisters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-->0){
            long n = scanner.nextInt();
            System.out.println(n>2 ? ((n / 2) - (n % 2 == 0 ? 1 : 0)) : 0);
        }
    }
}
