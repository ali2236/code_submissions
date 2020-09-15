package codeforces.c1360;

import java.util.Scanner;

public class MinimalSquare {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-->0){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int side = Math.max(Math.min(a,b) * 2, Math.max(a,b));
            int area = side * side;
            System.out.println(area);
        }
    }
}
