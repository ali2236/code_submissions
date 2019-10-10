package beginner;

import java.math.BigInteger;
import java.util.Scanner;

public class SmallFactorials {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n-->0){
            int a = scanner.nextInt();
            BigInteger f = factorial(a);
            System.out.println(f);
        }
    }

    public static BigInteger factorial(long n){
        if (n==0) return BigInteger.ONE;
        return BigInteger.valueOf(n).multiply(factorial(n-1));
    }

}
