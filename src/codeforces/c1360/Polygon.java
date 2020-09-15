package codeforces.c1360;

import java.util.Scanner;

public class Polygon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            boolean[][] field = new boolean[n][n];

            for (int i = 0; i < n; i++) {
                String s = scanner.next();
                for (int j = 0; j < n; j++) {
                    boolean ball = s.charAt(j)=='1';
                    field[i][j] = ball;
                }
            }

            System.out.println(possible(field, n)?"YES":"NO");
        }
    }

    private static boolean possible(boolean[][] field, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(field[i][j]){
                    boolean step = (i<n-1? field[i+1][j] : true) || (j<n-1 ? field[i][j+1] : true);
                    if(!step){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
