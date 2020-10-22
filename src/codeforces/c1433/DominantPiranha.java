package codeforces.c1433;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DominantPiranha {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-->0){
            int n = scanner.nextInt();
            int[] a = new int[n];
            for(int i=0;i<n;i++) a[i] = scanner.nextInt();
            System.out.println(findDominant(a, n));
        }
    }
    private static int findDominant(int[] a, final int n){
        int max = a[0];
        for (int i = 0; i < n; i++) max = Math.max(max, a[i]);

        List<Integer> maxIndexes = new ArrayList<>();
        for (int i = 0; i < n; i++) if (a[i] == max) maxIndexes.add(i);

        for(Integer index : maxIndexes){
            if(index != 0 && a[index-1] < max) return index + 1;
            if(index != n-1 && a[index+1] < max) return index + 1;
        }
        return -1;
    }
}
