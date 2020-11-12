package icpc.iipc16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.BitSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class I {

    static Set<Integer>[] followers;
    static Set<Integer>[] following;


    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
        FastReader scanner = new FastReader();
        int n = scanner.nextInt();
        followers = new Set[n + 1];
        following = new Set[n + 1];
        for (int i = 0; i <= n; i++) {
            following[i] = new TreeSet<>();
        }

        for (int i = 1; i <= n; i++) {
            int l = scanner.nextInt();
            followers[i] = new TreeSet();
            for (int j = 0; j < l; j++) {
                int follower = scanner.nextInt();
                if (follower == i) continue;
                followers[i].add(follower);
                following[follower].add(i);
            }
        }

        // SIMPlify
        int deleted = 0;
        BitSet vis = new BitSet(n + 1);
        for (int i = 1; i <= n; i++) {
            int followersCount = followers[i].size();
            int followingCount = following[i].size();
            // middle
            if (followersCount == 1 && followingCount > 0) {
                    int follower = followers[i].iterator().next();
                    for (Integer followin : following[i]) {
                        followers[followin].add(follower);
                        followers[followin].remove(i);
                    }
                    following[follower].remove(i);
                    followers[i].clear();
                    following[i].clear();
                    vis.set(i);
                    deleted++;
                    // recursvly add children
            }
            // leaf
            if (followingCount > 0 && followersCount == 0) {
                int parent = following[i].iterator().next();
                followers[parent].remove(i);
                following[i].clear();
                vis.set(i);
                deleted++;
            }
        }

        int count = 0;
        int toBeVisited = n - deleted;

        // dfs
        while (toBeVisited > 0) {
            int node = vis.nextClearBit(1);
            int nv = dfs(node, vis);
            toBeVisited -= nv;
            count++;
        }
        System.out.println(count);
    }

    static int dfs(int node, BitSet vis) {
        if (vis.get(node)) return 0;
        int count = 1;
        vis.set(node);
        // visit parent
        for (Integer parent : following[node]) {
            count += dfs(parent, vis);
        }
        // visit followers
        for (Integer child : followers[node]) {
            count += dfs(child, vis);
        }
        return count;
    }

    static class FastReader {

        private StringTokenizer st;
        private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

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

/*
7
1 3
1 3
3 4 5 6
0
0
0
1 2
 */
/*
6
0
0
2 1 2
1 3
1 3
1 4
 */
/*
6
0
1 1
2 1 2
0
2 6 4
1 4
 */
/*
6
0
1 1
3 1 2 4
1 6
1 4
1 5
 1 */
/*
7
0
0
2 1 2
1 3
1 3
1 4
2 5 6
1 */
/*
13
0
0
2 1 2
1 3
1 3
1 4
2 5 6
0
0
0
0
1 11
1 11
6 */