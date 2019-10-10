package beginner;

import java.util.Scanner;

public class MaxPower {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        String number = scanner.next().substring(0,T);
        int count = 0;
        for (int i = 0; i < T; i++) {
        char c = number.charAt(i);
            if (c=='1'){
                count = 0;
            } else {
                count += 1;
            }
        }
        System.out.println(count);
    }
}
