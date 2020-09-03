package codeforces;

import java.util.Scanner;

public class ShortSubstrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-->0){
            String b = scanner.next();
            int n = b.length();
            for (int i = 0; i < n; i++) {
                if(i==n-1 || i%2==0){
                    System.out.print(b.charAt(i));
                }
            }
            System.out.println();
        }
    }
}
