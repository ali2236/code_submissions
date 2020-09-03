import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Solution2 {

    private final FastReader fr = new FastReader();

    public static void main(String[] args) {
        new Solution2().solve();
    }

    private void solve() {
        int t = fr.nextInt();
        while (t-- > 0) {
            int n = fr.nextInt(), k = fr.nextInt();
            Map<Integer, Integer> map = new HashMap<>(n, 1.0f);
            for (int i = 0; i < n; i++) {
                int input = fr.nextInt();
                if (input % k != 0) {
                    int need = k - (input % k);
                    Integer prev = map.get(need);
                    map.put(need, prev == null ? 1 : prev + 1);
                }
            }
            System.out.println(solve(map, k));
        }
    }

    private long solve(Map<Integer, Integer> map, int k) {
        if (map.size() == 0) return 0;
        List<Pair> pairs = map.entrySet().stream().map((e) -> new Pair(e.getKey(), e.getValue())).collect(Collectors.toList());
        Pair max = Collections.max(pairs, Comparator.<Pair>comparingInt(a -> a.count).thenComparingInt(a -> a.need));
        return (max.need + 1) + ((max.count - 1) * (long) k);
    }

    private static class Pair {
        public final int need, count;

        public Pair(int need, int count) {
            this.need = need;
            this.count = count;
        }
    }

    private static class FastReader {
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

}