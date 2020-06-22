package codechef.beginner;

import java.util.Scanner;

public class EnormousInputTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long k = scanner.nextLong();
        long count = 0;
        while (n-->0) if (scanner.nextLong()%k==0) count++;
        System.out.println(count);
    }
}
