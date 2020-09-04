package codeforces.c1409;

import java.util.Scanner;

public class DecreasetheSumofDigits {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-->0){
            long n = scanner.nextLong();
            int s = scanner.nextInt();
            System.out.println(solve(n,s));
        }
    }

    private static long solve(long n, int s){
        long moves = 0, digits = 1;
        while (sumOfDigits(n) > s){
            long r = (long) Math.pow(10, digits);
            long d = r - (n%r);
            moves += d;
            n += d;
            digits++;
        }
        return moves;
    }

    private static int sumOfDigits(long n){
        int sum = (int) (n%10);
        while (n>0){
            n = n/10;
            sum += n%10;
        }
        return sum;
    }
}
