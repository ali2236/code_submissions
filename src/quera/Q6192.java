package quera;

import java.util.Scanner;

public class Q6192 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long a = scanner.nextLong();
        long b = scanner.nextLong();
        long c = scanner.nextLong();

        long d = scanner.nextLong();
        long e = scanner.nextLong();
        long f = scanner.nextLong();

        boolean canFit = (a >= d) && (b >= e) ||
                (a >= d) && (b >= f) ||
                (a >= e) && (b >= d) ||
                (a >= e) && (b >= f) ||
                (a >= f) && (b >= d) ||
                (a >= f) && (b >= e);

        System.out.println(canFit ? "zende mimuni" : "dari mimiri");
    }
}
