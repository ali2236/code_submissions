package codeforces.c1324;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PairOfTopics {

    static final FastReader fr = new FastReader();

    public static void main(String[] args) {
        int n = fr.nextInt();
        Integer[] a = new Integer[n];
        Integer[] b = new Integer[n];
        for (int i = 0; i < n; i++) a[i] = fr.nextInt();
        for (int i = 0; i < n; i++) b[i] = fr.nextInt();

        Integer[] f = new Integer[n];
        for (int i = 0; i < n; i++) f[i] = a[i] - b[i];

        System.out.println(calculatePairs(f, n));
    }

    private static long calculatePairs(Integer[] f, final int n) {
        Arrays.sort(f);
        long pairs = 0;
        int l = 0, r = n - 1;
        while (l < r) {
            if (f[l] + f[r] > 0) {
                pairs += (r - l);
                r--;
            } else {
                l++;
            }
        }
        return pairs;
    }

    static class FastReader {

        private StringTokenizer st;
        private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        public String next() {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(nextLine());
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public String nextLine() {
            try {
                return br.readLine();
            } catch (IOException ex) {
                ex.printStackTrace();
                return null;
            }
        }

    }

}
        /*for (int i = 0; i < n; i++) {
            if(f[i]<=0) continue;
            int pos = lowerBound(f,-f[i]+1);
            pairs += i - pos;
        }*/