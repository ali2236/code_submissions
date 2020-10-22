package codeforces.c1433;

import java.util.Scanner;

public class YetAnotherBookshelf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-->0){
            int n = scanner.nextInt();
            int[] a = new int[n];
            for(int i=0;i<n;i++) a[i] = scanner.nextInt();
            System.out.println(groupUp(a, n));
        }
    }

    private static int groupUp(int[] a, final int n){
        int first = 0, last = n-1;
        for (int i = 0; i < n; i++) {
            if(a[first]!=1) first++;
            else break;
        }
        for (int i = n-1; i >= 0; i--) {
            if(a[last]!=1) last--;
            else break;
        }
        int moves = 0;
        for (int i = first; i <= last; i++) {
            if(a[i]==0) moves++;
        }
        return moves;
    }
}
