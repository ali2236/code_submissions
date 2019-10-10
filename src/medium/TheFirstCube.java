package medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TheFirstCube {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while(T-->0){
            int n = scanner.nextInt();
            long s = scanner.nextLong();
            n--;
            while (n-->0){
                s = (s % 1000000007) * (scanner.nextInt() % 1000000007);
            }
            sievePrimes();
            // number -> exponent
            Map<Integer,Integer> ai = new HashMap<>();
            long S = s;
            for (int i = 2; i <= prime.length-1 ; i++) {
                if (prime[i]){
                    int exponent = 0;
                    while (S % i == 0){
                        S = S / i;
                        exponent++;
                    }
                    if (exponent % 3>0){
                        ai.put(i,exponent % 3);
                    }
                }
            }
            ////////
            long num = 1;
            for (Integer factor : ai.keySet()){
                int exp = ai.get(factor);
                int needed = 3 - exp;
                num *= Math.pow(factor,needed);
            }
            System.out.println((num % 1000000007)* (s % 1000000007));
        }
    }

    final static boolean[] prime = new boolean[1000001];
    static void sievePrimes(){
        Arrays.fill(prime,true);
        int n = prime.length - 1;
        for(int p=2;p*p<=n;p++){
            if (prime[p]){
                for (int i = p*p; i <= n ; i+=p) {
                    prime[i] = false;
                }
            }
        }
    }
}
