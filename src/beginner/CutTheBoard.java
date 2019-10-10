package beginner;

import java.util.Scanner;

// CUTBOARD
public class CutTheBoard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-->0){
            int N = scanner.nextInt();
            int M = scanner.nextInt();
            System.out.println(cutBoard(N,M));
        }
        //System.out.println(cutBoard(3,3));
    }

    public static int cutBoard(int n,int m){
        return (n-1) * (m-1);
    }
}
