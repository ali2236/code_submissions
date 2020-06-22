package hackerrank.algorithms.dynamic;

import java.util.*;

public class CoinChange {

    public static void main(String[] args) {
        System.out.println(getWays(10, Arrays.asList(2L, 5L, 3L, 6L))); // 5
    }

    final static Map<Entry, Long> ways = new HashMap<>();

    public static long getWays(int n, List<Long> c) {
        if (n == 0) return 1;
        if (!ways.containsKey(new Entry(n, c))) {
            long count = 0;
            for (int i = 0; i < c.size(); i++) {
                Long num = c.get(i);
                if (num <= n) {
                    List<Long> subC = c.subList(i,c.size());
                    long _ways = getWays(n - num.intValue(), subC);
                    count += _ways;
                }
            }
            ways.put(new Entry(n, c), count);
        }
        return ways.get(new Entry(n, c));
    }
}

class Entry {
    final Integer num;
    long hs;

    Entry(Integer num, List<Long> c) {
        this.num = num;
        hs = c.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entry entry = (Entry) o;
        return hs == entry.hs &&
                Objects.equals(num, entry.num);
    }

    @Override
    public int hashCode() {
        return Objects.hash(num, hs);
    }
}
