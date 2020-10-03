import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Training {


    static int[] color;
    static List<Integer>[] adj;
    static int[] dp;

    public static void main(String[] args) {
        FastReader scanner = new FastReader();

        ///
        /// Take Input
        ///

        int n = scanner.nextInt();

        color = new int[n + 1];
        for (int i = 1; i <= n; i++) color[i] = scanner.nextInt();

        adj = new List[n + 1];
        for (int i = 1; i <= n; i++) adj[i] = new LinkedList<>();

        for (int i = 1; i < n; i++) {
            int parent = scanner.nextInt();
            int node = scanner.nextInt();
            adj[parent].add(node);
            adj[node].add(parent);
        }

        dp = new int[n + 1];

        ///
        /// calculate
        ///

        unmodifiedMaxWhiteSubTree(1, -1);

        modifiedMaxWhiteSubTree(1, -1);

        ///
        /// print
        ///

        StringBuilder str = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            str.append(dp[i]);
            str.append(' ');
        }

        System.out.println(str.toString());
    }

    static int unmodifiedMaxWhiteSubTree(int node, int parent) {
        for (Integer child : adj[node]) {
            if (child == parent) continue;
            dp[node] += Math.max(0, unmodifiedMaxWhiteSubTree(child, node));
        }
        dp[node] += color[node] == 1 ? 1 : -1;
        return dp[node];
    }

    static void modifiedMaxWhiteSubTree(int node, int parent) {
        if (parent != -1) dp[node] += Math.max(0, dp[parent] - Math.max(0, dp[node]));
        for (Integer child : adj[node]) {
            if (child == parent) continue;
            modifiedMaxWhiteSubTree(child, node);
        }
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
