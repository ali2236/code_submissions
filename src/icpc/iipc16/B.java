package icpc.iipc16;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int fingers = scanner.nextInt();
        int hands = scanner.nextInt();
        int firstHand = scanner.nextInt();
        int secondHand = scanner.nextInt();


        int sum = firstHand + secondHand;
        if (sum <= fingers * hands) {
            System.out.println(sum);
        } else {
            String m = Integer.toString(sum, fingers + 1);
            m = m.substring(0, hands);
            int mr = Integer.parseInt(m, fingers + 1);
            System.out.println(mr % 10);
        }
    }
}
