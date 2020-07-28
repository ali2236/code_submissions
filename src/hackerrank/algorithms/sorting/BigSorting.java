package hackerrank.algorithms.sorting;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class BigSorting {

    static int compare(String a, String b) {
        int la = a.length();
        int lb = b.length();
        if (la != lb) {
            return la - lb;
        } else {
            for (int i = 0; i < la; i++) {
                int ac = a.charAt(i);
                int bc = b.charAt(i);
                if (ac != bc) {
                    return ac - bc;
                }
            }
            return 0;
        }
    }

    // Complete the bigSorting function below.
    static String[] bigSorting(String[] unsorted) {
        Arrays.sort(unsorted, BigSorting::compare);
        return unsorted;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] unsorted = new String[n];

        for (int i = 0; i < n; i++) {
            String unsortedItem = scanner.next();
            unsorted[i] = unsortedItem;
        }

        String[] result = bigSorting(unsorted);


        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(result[i]);

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }


        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
