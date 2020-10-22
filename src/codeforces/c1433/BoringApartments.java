package codeforces.c1433;

import java.util.Scanner;

public class BoringApartments {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-->0){
            String n = scanner.next();
            int len = n.length();
            int m = Integer.parseInt(n.substring(0, 1));
            int[] s = new int[]{0,1, 3, 6, 10};
            int b = s[4]*(m-1) + s[len];
            System.out.println(b);
        }
    }
}
