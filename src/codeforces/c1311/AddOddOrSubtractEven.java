package codeforces.c1311;

import java.util.Scanner;

public class AddOddOrSubtractEven {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-->0){
            int a = scanner.nextInt(), b = scanner.nextInt();
            int d = b - a;
            if(d==0) System.out.println(0);
            else if(Math.abs(d)%2==1) System.out.println(d > 0 ? 1 : 2);
            else if(Math.abs(d)%2==0) System.out.println(d > 0 ? 2 : 1);
            else throw new RuntimeException();
        }
    }
}
