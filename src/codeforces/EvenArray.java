package codeforces;

import java.util.Scanner;

public class EvenArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-->0){
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = scanner.nextInt();
            System.out.println(solve(a));
        }
    }

    private static int solve(int[] a){
        int i0 = 0, i1 = 0, a0 = 0, a1 = 0;
        int wrong = 0;
        for (int i = 0; i < a.length; i++) {
            int j = i % 2;
            if(j==0) i0++;
            else i1++;

            int k = a[i] % 2;
            if(k==0) a0++;
            else a1++;

            if(j!=k)  wrong++;
        }

        if(a0!=i0 || a1!=i1) return -1;
        return (wrong / 2) + wrong % 2 ;
    }
}
