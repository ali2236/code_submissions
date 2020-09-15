package codeforces.c1324;

import java.util.Scanner;

public class Tetris {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-->0){
            int n = scanner.nextInt();
            int[] cols = new int[n];
            for(int i=0;i<n;i++){
                cols[i] = scanner.nextInt();
            }
            for(int i=0;i<n;i++){
                cols[i] = cols[i] % 2;
            }

            int min = cols[0];
            int max = cols[0];
            for(int e: cols){
                if(e<min) min = e;
                else if (e>max) max = e;
            }

            boolean possible = min == max;
            System.out.println(possible?"YES":"NO");
        }
    }
}
