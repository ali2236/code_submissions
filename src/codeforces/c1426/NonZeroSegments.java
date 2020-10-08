package codeforces.c1426;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class NonZeroSegments {
    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        int n = scanner.nextInt();
        List<Integer> a = new ArrayList<>();
        for(int i=0;i<n;i++) a.add(scanner.nextInt());
        // compress
        int sign = a.get(0);
        long total = 0;
        List<Long> b = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            int c = a.get(i);
            if(differentSigns(sign, c)){
                b.add(total);
                total = 0;
                sign = c;
            } else {
                total += c;
            }
        }
        b.add(total);
        int count = 0;
        for (int i = 0; i < b.size() - 1; i++) {
            if((b.get(i) + b.get(i+1))==0){
                count++;
            }
        }
        System.out.println(count);
    }

    private static boolean differentSigns(long a, long b){
        if(a>0 && b<0) return true;
        if(b>0 && a<0) return true;
        return false;
    }

    static class FastReader {

        private StringTokenizer st;
        private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        public String next() {
            while(st == null || !st.hasMoreTokens()) {
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
            } catch(IOException ex) {
                ex.printStackTrace();
                return null;
            }
        }

    }
}
