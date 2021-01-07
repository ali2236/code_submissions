package quera;

import java.util.Scanner;

public class Q64434 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        StringBuilder str = new StringBuilder();

        for (int y = 0; y < 3; y++) {
            for (int j = 0; j < n; j++) {
                for (int x = 0; x < 3; x++) {
                    for (int l = 0; l < m; l++) {
                        if (y % 2 == x % 2) {
                            str.append('X');
                        } else {
                            str.append('.');
                        }
                    }
                }
                str.append('\n');
            }
        }

        System.out.println(str);
    }
}
