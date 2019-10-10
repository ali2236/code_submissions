package contests.batelion;

import java.util.Arrays;
import java.util.Scanner;

// Correct
public class A_Books {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while(T-->0){
            int N = scanner.nextInt();
            int[] A = new int[N];
            int[] B = new int[N];
            Arrays.fill(B,0);
            for (int i = 0; i < N; i++) {
                A[i] = scanner.nextInt();
            }
            for (int i = 0; i < N;) {
            int skip = 0;
            int count = 0;
                for (int j = i; j <N ; j++) {
                    if (A[j]==A[i]){
                        skip++;
                        continue;
                    }
                    count = N - j;
                    break;
                }
                for (int j = i; j < i + skip; j++) {
                    B[j] = count;
                }
                i += skip;
            }
            for (int i = 0; i < N; i++) {
                if (i==N-1) System.out.print(B[i] + "\n");
                else System.out.print(B[i] + " ");
            }
        }
    }
}
