package codeforces;

import java.util.Arrays;
import java.util.Scanner;

public class RemoveSmallest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-->0){
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            Arrays.sort(a);
            int lastNum = a[0];

            boolean possible = true;
            for (int i = 1; i < n; i++) {
                if(Math.abs(a[i] - lastNum) <= 1) {
                    lastNum = a[i];
                } else {
                    possible = false;
                    break;
                }
            }
            System.out.println(possible ? "YES" : "NO");
        }
    }

}
