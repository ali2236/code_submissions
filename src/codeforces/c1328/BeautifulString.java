package codeforces.c1328;

import java.util.Scanner;

public class BeautifulString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-->0){
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            long pos1 = 1, pos2 = 2;
            for (long i = 1, j = 0; i < k+1; i += ++j) {
                long last = i + j;
                if(k>= i && k<=last){
                    pos1 = n - j - 1;
                    long p = last - k + 1;
                    pos2 = pos1 + p;
                    break;
                }
            }
            StringBuilder str = new StringBuilder();
            for (int i = 1; i <= n; i++) {
                if(i==pos1 || i==pos2) str.append('b');
                else str.append('a');
            }

            System.out.println(str.toString());
        }
    }
}
