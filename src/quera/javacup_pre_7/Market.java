package quera.javacup_pre_7;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Market {

    final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        solution();
    }

    private static void solution() {
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = scanner.nextInt();
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < a[i]; j++) {
                str.append('*');
            }
            System.out.println(str);
        }
    }

    private static void solution2(){
        StringBuilder str = new StringBuilder();
        IntStream.range(0, scanner.nextInt()).map(a -> scanner.nextInt()).forEach(i -> {
            IntStream.range(0, i).forEach(j -> str.append('*'));
            System.out.println(str);
        });

    }
}
