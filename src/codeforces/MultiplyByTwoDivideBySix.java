package codeforces;

import java.util.Scanner;

public class MultiplyByTwoDivideBySix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-->0){
            int n = scanner.nextInt();
            System.out.println(solve(n));
        }
    }

    private static long solve(int n){

        // count factors of 3
        int factorsOf3 = 0;
        int nc = n;
        while ((nc%3)==0){
            factorsOf3++;
            nc /= 3;
        }

        // count factors of 2
        int factorsOf2 = 0;
        nc = n;
        while ((nc%2)==0){
            factorsOf2++;
            nc /= 2;
        }

        // factors of 2 can't be more than 3
        if(factorsOf2>factorsOf3) {
            return -1;
        }

        //calculate remainder and moves
        int moves = 0;
        long remainder = n;

        // multiply by two
        moves = factorsOf3 - factorsOf2;
        for (int i = 0; i < moves; i++) {
            remainder = remainder * 2;
        }
        moves += factorsOf3;
        for (int i = 0; i < factorsOf3; i++) {
            remainder = remainder / 6;
        }

        if(remainder!=1){
            return -1;
        }

        return moves;
    }
}
