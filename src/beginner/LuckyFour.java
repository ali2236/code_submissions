package beginner;

import java.util.Scanner;

//
public class LuckyFour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-->0){
            char[] number = scanner.next().toCharArray();
            int count = 0;
            for(char c : number){
                if (c=='4') count++;
            }
            System.out.println(count);
        }
    }
}
