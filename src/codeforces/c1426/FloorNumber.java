package codeforces.c1426;

import java.util.Scanner;

public class FloorNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-->0){
            int n = scanner.nextInt();
            int x = scanner.nextInt();
            System.out.println(floor(n,x));
        }
    }

    private static long floor(final int n, final int x){
        if(n<=2) return 1;
        for (long floor = 2;true; floor++) {
            if((n>=(floor - 2)*x+3) && n<=((floor - 1)*x)+2) {
                return floor;
            }
        }
    }
}
