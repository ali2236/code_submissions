package codeforces.c1360;

import java.util.Arrays;
import java.util.Scanner;

public class HonestCoach {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-->0){
            int n = scanner.nextInt();
            int[] s = new int[n];
            for(int i=0;i<n;i++) s[i] = scanner.nextInt();
            Arrays.sort(s);
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < n - 1; i++) {
                min = Math.min(s[i+1] - s[i], min);
            }
            System.out.println(min);
        }
    }
}
