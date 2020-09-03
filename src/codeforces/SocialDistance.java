package codeforces;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SocialDistance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            String s = scanner.next();
            System.out.println(solve(s, n, k));
        }
    }

    private static int solve(String s, int n, int k) {
        int lastTableSaw = 0;
        int additionalTables = 0;
        for (int i = 0; i < n; i++) {
            if (tableAt(s,i)) {
                lastTableSaw = k;
                tablesSeen.remove(i);
            } else if (lastTableSaw == 0 && !tableInRange(s, n, k, i)) {
                additionalTables++;
                lastTableSaw = k;
            } else if (lastTableSaw > 0) {
                lastTableSaw--;
            }
        }
        return additionalTables;
    }

    final static Set<Integer> tablesSeen = new TreeSet<>();
    private static boolean tableInRange(String s, int n, int k, int from) {
        int max = Math.min(n, from + k + 1);
        for (Integer i : tablesSeen) {
            if(i>=from && i<max) return true;
        }
        for (int i = from; i < max; i++) {
            if (tableAt(s,i)) {
                tablesSeen.add(i);
                return true;
            }
        }
        return false;
    }

    static boolean tableAt(String s, int i){
        return s.charAt(i) == '1';
    }
}
