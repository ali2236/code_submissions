package codeforces.c1324;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class MaximumWhiteSubtree {

    static int[] color;
    static List<Integer>[] adj;
    static int[] dp;

    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        int n = scanner.nextInt();
        color = new int[n + 1];
        for (int i = 1; i < n + 1; i++) color[i] = scanner.nextInt();
        adj = new List[n + 1];
        for (int i = 0; i <= n; i++) adj[i] = new LinkedList<>();
        for (int i = 1; i < n; i++) {
            int node = scanner.nextInt();
            int child = scanner.nextInt();
            adj[node].add(child);
            adj[child].add(node);
        }
        solve(n);
    }


    private static void solve(int n) {
        dp = new int[n + 1];
        unmodifiedMaxWhiteSubTree(1, -1);
        modifiedMaxWhiteSubTree(1, -1);
        for (int i = 1; i <= n; i++) {
            System.out.print(dp[i] + " ");
        }
    }

    private static int unmodifiedMaxWhiteSubTree(int node, int parent) {
        for (int child : adj[node]) {
            if(child==parent) continue;
            dp[node] += Math.max(0, unmodifiedMaxWhiteSubTree(child, node));
        }
        dp[node] += color[node] == 1 ? 1 : -1;
        return dp[node];
    }

    private static void modifiedMaxWhiteSubTree(int node, int parent) {
        if (parent != -1) dp[node] += Math.max(0, dp[parent] - Math.max(dp[node], 0));
        for (int child : adj[node]) {
            if(child!=parent) modifiedMaxWhiteSubTree(child, node);
        }
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

