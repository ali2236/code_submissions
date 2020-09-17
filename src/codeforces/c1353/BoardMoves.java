package codeforces.c1353;

import java.util.Scanner;

// unsolved
public class BoardMoves {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-->0){
            int n = scanner.nextInt();
            System.out.println(calculateMoves(n));
        }
    }

    private static long calculateMoves(long n){
        long cost = n/2;
        long lineCost = (((cost) * (cost+1))/2);
        long b = (n/2)-1;
        long len = (b * (b+1)) / 2;
        long corner =  (lineCost * (n/2)) + len;
        return (4 * lineCost) + 4 * corner;
    }
}
