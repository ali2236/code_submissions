package contests.SeptemberMegaCookoff;

import java.util.Scanner;

public class TwoGroups {
    static String yes = "YES";
    static String no = "NO";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            int C = scanner.nextInt();
            boolean sumCanBeSplit = (A+B*2+C*3)%2==0;
            if (!sumCanBeSplit){
                System.out.println(no);
                continue;
            }
            C = C % 2 == 0 ? 0 : 1;
            if (C == 1) {
                if (A > 0 && B > 0) {
                    A--;
                    B--;
                    C--;
                } else if (A > 2) {
                    A -= 3;
                    C--;
                }
            }

            B = B % 2 == 0 ? 0 : 1;
            if (B == 1) {
                if (A > 1) {
                    A -= 2;
                    B--;
                }
            }

            A = A % 2 == 0 ? 0 : 1;

            boolean canNotBeSplit = B > 0 || C > 0 || A > 0;

            System.out.println(((!canNotBeSplit)&&sumCanBeSplit) ? yes : no);
        }
    }
}
