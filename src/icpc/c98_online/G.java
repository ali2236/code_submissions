package icpc.c98_online;

import java.math.BigInteger;
import java.util.Scanner;

public class G {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-->0){
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            BigInteger factA = factorial(a);
            BigInteger factB = factorial(b);

            BigInteger n = factA.divide(factB);
            long factors = 0;
            BigInteger factor = BigInteger.valueOf(2);
            while (!n.equals(BigInteger.ONE)){
                if (n.mod(factor).equals(BigInteger.ZERO)){
                    n = n.divide(factor);
                    factors++;
                } else {
                    factor = factor.add(BigInteger.ONE);
                }
            }
            System.out.println(factors);
        }
    }

    private static BigInteger factorial(int i){
        BigInteger num = BigInteger.ONE;
        for (int j = 1; j <= i; j++) {
            num = num.multiply(BigInteger.valueOf(j));
        }
        return num;
    }
}
