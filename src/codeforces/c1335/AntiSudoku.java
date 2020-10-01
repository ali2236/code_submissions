package codeforces.c1335;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AntiSudoku {

    static int[] jl = new int[]{0, 4, 8, 1, 5, 6, 2, 3, 7};
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int t = fr.nextInt();
        while(t-->0){
            final String[] board = new String[9];
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < 9; i++) board[i] = fr.next();
            for (int i = 0; i < 9; i++) {
                int sj = jl[i];
                char n1 = board[i].charAt(sj);
                char n = n1 == '1' ? '2' : '1';
                for (int j = 0; j < 9; j++) {
                    if(j==sj) str.append(n);
                    else str.append(board[i].charAt(j));
                }
                str.append('\n');
            }
            System.out.println(str.toString());
        }
    }



    static class FastReader {

        private StringTokenizer st;
        private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        public String next() {
            while(st == null || !st.hasMoreTokens()) {
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
            } catch(IOException ex) {
                ex.printStackTrace();
                return null;
            }
        }

    }
}
