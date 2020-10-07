package icpc.c98_online;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

// consider loops
public class H {

    static List<Integer>[] adj;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new LinkedList<>();
        }
        for (int i = 0; i < m; i++) {
            int first = scanner.nextInt();
            int second = scanner.nextInt();
            adj[first].add(second);
        }
        System.out.println(maxDistance(a, b));
    }

    // dfs
    private static int maxDistance(int node, int end) {
        int max = 0;
        for (Integer child : adj[node]){
            if(child==end) max = Math.max(max,1);
            else max = Math.max(max, 1 + maxDistance(child, end));
        }
        return max;
    }
}
