package easy;

import java.util.Scanner;

public class CountSubstrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while(T-->0){
            int lenght = scanner.nextInt();
            char[] number = scanner.next().toCharArray();
            int ones = 0;
            for (char c : number){
                if (c=='1') ones++;
            }
            int substrings = ones + (((ones - 1) * ones) / 2);
            System.out.println(substrings);
        }
    }
}
