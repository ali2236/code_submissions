package codeforces;

import java.util.Scanner;

public class ThreePairwiseMaximums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int z = scanner.nextInt();

            int max = -1, mid = 0, min = 1;
            if (x == y) {
                max = x;
                mid = z;
            } else if (x == z) {
                max = x;
                mid = y;
            } else if (y == z) {
                max = y;
                mid = x;
            }
            if(max < mid){
                System.out.println("NO");
                continue;
            }
            System.out.println("YES");
            System.out.println(String.format("%d %d %d", max, mid, min));
        }
    }
}
