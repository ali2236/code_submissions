import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    static int[] color;
    static List<Integer>[] adj;
    static int[] dp;

    public static void main(String[] args) {
        FastReader scanner = new FastReader();

        // input
        int n = scanner.nextInt();

        color = new int[n+1];
        for (int i = 1; i <= n; i++) color[i] = scanner.nextInt();

        adj = new List[n + 1];
        for (int i = 1; i <= n; i++) {

        }

        for (int i = 0; i < n; i++) {
            int parent = scanner.nextInt();
            int node = scanner.nextInt();
            adj[parent].add(node);
        }
        // calculate

        // print
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

