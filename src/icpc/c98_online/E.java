package icpc.c98_online;

import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class E {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        String[] park = new String[n];
        for (int i = 0; i < n; i++) {
            park[i] = scanner.next();
        }

        int[] meets = new int[m];
        for (int col = 0; col < m; col++) {
            for (int moves = 0; moves < n; moves++) {
                // check right for left
                if (col + moves < m) {
                    if (park[moves].charAt(col + moves) == 'L') meets[col]++;
                }
                // check left for right
                if (col - moves >= 0) {
                    if (park[moves].charAt(col - moves) == 'R') meets[col]++;
                }
                // check down for top
                if (moves + moves < n) {
                    if (park[moves + moves].charAt(col) == 'U') meets[col]++;
                }
            }
        }
        System.out.println(IntStream.of(meets).mapToObj(Integer::toString).collect(Collectors.joining(" ")));
    }
}
