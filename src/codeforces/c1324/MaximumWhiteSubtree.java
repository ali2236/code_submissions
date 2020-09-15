package codeforces.c1324;

import java.util.Scanner;

public class MaximumWhiteSubtree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] color = new int[n+1];
        for(int i=1;i<n+1;i++) color[i] = scanner.nextInt();
        int[][] adj = new int[n+1][2];
        for (int i = 1; i < n; i++) {
            int node = scanner.nextInt();
            if(adj[node][0]==0){
                adj[node][0] = scanner.nextInt();
            } else {
                adj[node][1] = scanner.nextInt();
            }
        }
        solve(color,adj);
    }

    private static void solve(int[] color, int[][] adj){

    }
}
