package codeforces.c1426;

import java.util.Scanner;

public class IncreaseAndCopy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-->0){
            int n = scanner.nextInt();
            long moves = Integer.MAX_VALUE;
            // increments
            for (int inc = 0; inc <= Math.sqrt(n); inc++) {
                int j = 1 + inc;
                int d = (n/j)-1;
                if(n%j!=0) d++;
                moves = Math.min(moves, inc + d);
            }
            System.out.println(moves);
        }
    }
}
