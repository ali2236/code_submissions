package codechef.beginner;

import java.math.BigInteger;
import java.util.Scanner;


public class EasyFibonacci {
    static int[] lasts = new int[60];
    public static void main(String[] args) {
        lasts[0] = 0; lasts[1] = 1;
        for (int i = 2; i < 60; i++) {
            lasts[i] = (lasts[i-1] + lasts[i-2]) % 10;
        }

        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-->0){
           long next = scanner.nextLong();
           int pow = BigInteger.valueOf(next).bitLength() - 1;
           long number = (long) Math.pow(2,pow);
            System.out.println(lasts[(int)((number - 1L)%60)]);
        }
    }
}