import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    static final Scanner scanner = new Scanner(System.in);
    static final Map<Integer, Integer> numberPairs = new HashMap<>();
    static final Map<Integer, Integer> numberIndex = new HashMap<>();

    public static void main(String[] args) {
        int n = scanner.nextInt();
        int[] a = arrayInput(n);
        int[] b = arrayInput(n);

        int[] f = new int[n];
        for (int i = 0; i < n; i++) {
            f[i] = a[i] - b[i];
        }

        int pairs = 0;
        for (int i = n-2; i >= 0; i--) {
            numberPairs.putIfAbsent(f[i], 0);
            numberIndex.putIfAbsent(f[i], n);
            int limit = numberIndex.get(f[i]);
            for (int j = i + 1; j < limit; j++) {
                if (f[i] > -f[j]) {
                    numberPairs.put(f[i], numberPairs.get(f[i]) + 1);
                }
            }
            pairs += numberPairs.get(f[i]);
            numberIndex.put(f[i], i+1);
        }

        System.out.println(pairs);
    }

    static int[] arrayInput(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        return a;
    }
}

class SegmentTree {

}

class Node {
    final int min,max;


    Node(int min, int max) {
        this.min = min;
        this.max = max;
    }
}