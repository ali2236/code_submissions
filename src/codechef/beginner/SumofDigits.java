package codechef.beginner;

import java.util.Scanner;

public class SumofDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-->0){
            char[] n = scanner.next().toCharArray();
            int total = 0;
            for (char i : n) total += Integer.valueOf(String.valueOf(i));
            System.out.println(total);
        }
    }
}
