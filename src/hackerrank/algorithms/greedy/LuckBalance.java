package hackerrank.algorithms.greedy;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class LuckBalance {

    // Complete the luckBalance function below.
    static int luckBalance(int k, int[][] contests) {
        Arrays.sort(contests, (c1, c2) -> {
            int importance1 = c1[1];
            int importance2 = c2[1];

            if (importance1 != importance2) {
                return importance1 - importance2;
            } else {
                int luck1 = c1[0];
                int luck2 = c2[0];

                return luck1 - luck2;
            }
        });

        int luck = 0;
        for (int i = contests.length-1; i >= 0; i--) {
            if(k>0){
                k--;
                luck += contests[i][0];
            } else if (contests[i][1] == 0){
                luck += contests[i][0];
            } else {
                luck -= contests[i][0];
            }
        }
        return luck;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[][] contests = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] contestsRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int contestsItem = Integer.parseInt(contestsRowItems[j]);
                contests[i][j] = contestsItem;
            }
        }

        int result = luckBalance(k, contests);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}


