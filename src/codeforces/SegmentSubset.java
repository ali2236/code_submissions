package codeforces;

import java.util.Scanner;

public class SegmentSubset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-->0){
            int n = scanner.nextInt();
            Subset[] subsets = new Subset[n];
            for (int i = 0; i < n; i++) {
                int l = scanner.nextInt();
                int r = scanner.nextInt();
                subsets[i] = new Subset(l,r);
            }
            solve(subsets);
        }
    }

    public static void solve(Subset[] subsets){

    }
}

class Subset{
    final int l,r;

    Subset(int l, int r) {
        this.l = l;
        this.r = r;
    }
}
