package algorithms;




import tools.StopWatch;

import java.util.Arrays;
import java.util.Scanner;

// O(nloglogn)
public class SieveofEratosthenes {
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        stopWatch.start();
        prime = new boolean[n+1];
        sieve(n);
        //String primes = Arrays.toString(prime);
        System.out.println(stopWatch.stop());
        //System.out.println(primes);
    }

    static boolean[] prime;
    static void sieve(int n){
        Arrays.fill(prime,true);
        for (int i = 2; i*i <= n; i++) { // O(n)
            if (prime[i]){
                for (int j = i*i; j <= n; j+=i) { //O(log log n)
                    prime[j] = false;
                }
            }
        }
    }
}
