package hackerrank.algorithms.dynamic;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class ModifiedFibonacci {

    // Complete the fibonacciModified function below.
    static BigInteger fibonacciModified(int t1, int t2, int n) {
        BigInteger[] a = new BigInteger[n+1];
        a[1] = BigInteger.valueOf(t1);
        a[2] = BigInteger.valueOf(t2);
        for(int i=3;i<=n;i++){
            a[i] = a[i-1].pow(2).add(a[i-2]);
        }
        return a[n];
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] t1T2n = scanner.nextLine().split(" ");

        int t1 = Integer.parseInt(t1T2n[0]);

        int t2 = Integer.parseInt(t1T2n[1]);

        int n = Integer.parseInt(t1T2n[2]);

        BigInteger result = fibonacciModified(t1, t2, n);

        bufferedWriter.write(result.toString());
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
