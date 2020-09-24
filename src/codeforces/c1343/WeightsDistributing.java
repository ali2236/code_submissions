package codeforces.c1343;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class WeightsDistributing {

    static List<Integer>[] edges;
    static int m;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-->0){
            int n = scanner.nextInt();
            m = scanner.nextInt();
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            int[] p = new int[m+1];
            for(int i=1;i<=m;i++) p[i] = scanner.nextInt();
            edges = new List[n+1];
            for (int i = 1; i <= n; i++) edges[i] = new LinkedList<>();
            for (int i = 0; i < m; i++) {
                int f = scanner.nextInt();
                int s = scanner.nextInt();
                edges[f].add(s);
                edges[s].add(f);
            }

            List<Integer> f = move(a,b, -1);
            f.remove((int)f.size()-1);
            f.addAll(move(b,c, -1));
            System.out.println(f);

        }
    }

    private static List<Integer> move(int start, int end, int p){
        for (int node : edges[start]) {
            if(node==end) {
                List<Integer> l = new ArrayList<>();
                l.add(start);
                l.add(end);
                return l;
            }
            else if(node!=p) {
                List<Integer> t = move(node, end, start);
                if(t!=null) {
                    t.add(0, start);
                    return t;
                }
            }
        }
        return null;
    }
}
