package beginner;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//TODO: UNSolved
public class Event {

    static String impossible = "impossible";
    static String many = "many";
    static Map<String, Integer> converter = new HashMap<>();

    public static void main(String[] args) {

        converter.put("saturday", 1);
        converter.put("sunday", 2);
        converter.put("monday", 3);
        converter.put("tuesday", 4);
        converter.put("wednesday", 5);
        converter.put("thursday", 6);
        converter.put("friday", 7);

        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int S = converter.get(scanner.next());
            int E = converter.get(scanner.next());
            int L = scanner.nextInt();
            int R = scanner.nextInt();

            if (E<S) E+=7;

            int possibilities = 0;
            int expected = E - S + 1;
            int exact = -1;
            for (int i = 0; i<(R/7+1); i++) {
                if((expected+7*i)>=L && (expected+7*i)<=R)
                {
                    exact=expected+7*i;
                    possibilities++;
                }
            }



            if (possibilities == 1) System.out.println(expected);
            else if (possibilities == 0) System.out.println(impossible);
            else System.out.println(many);
        }
    }
}
