package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class ZeroRemainderArray {

    final static FastReader fr = new FastReader();

    public static void main(String[] args) {
        int t = fr.nextInt();
        while (t-- > 0) {
            int n = fr.nextInt();
            int k = fr.nextInt();
            System.out.println(solve(n, k));
        }
    }

    private static BigInteger solve(int n, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int key = k - (fr.nextInt() % k);
            count.putIfAbsent(key, 0);
            count.put(key, count.get(key) + 1);
        }
        count.remove(0);
        count.remove(k);

        Pair2[] pairs = new Pair2[count.size()];
        int i = 0;
        for (Map.Entry<Integer, Integer> e : count.entrySet()) {
            pairs[i++] = new Pair2(e.getKey(), e.getValue());
        }

        Arrays.sort(pairs, (p1, p2) -> {
            int c1 = Integer.compare(p1.count, p2.count);
            if (c1 == 0) {
                return Integer.compare(p1.value, p2.value);
            }
            return c1;
        });

        if(pairs.length==0) return BigInteger.ZERO;
        Pair2 p = pairs[pairs.length-1];
        BigInteger r = BigInteger.valueOf(p.count - 1).multiply(BigInteger.valueOf(k)).add(BigInteger.valueOf(p.value + 1));

        return r;
    }
}

class Pair2 {
    final int value, count;

    Pair2(int value, int count) {
        this.value = value;
        this.count = count;
    }
}

class FastReader {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;

    public String nextLine() {
        try {
            return br.readLine();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public String next() {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(nextLine());
        }
        return st.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }
}

