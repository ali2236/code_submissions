package codechef.contests.SeptemberMegaCookoff;

import java.util.Scanner;

public class PlayingWithMatches {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while(T-->0){
            int first = scanner.nextInt();
            int second = scanner.nextInt();
            int sum = first + second;
            char[] _sum = String.valueOf(sum).toCharArray();
            int matches = 0;
            for (char c : _sum){
                matches += numberOfMatches(c);
            }
            System.out.println(matches);
        }
    }

    static int numberOfMatches(char num){
        int sum = 0;
        if (num=='0') sum += 6;
        else if (num=='1') sum += 2;
        else if (num=='2') sum += 5;
        else if (num=='3') sum += 5;
        else if (num=='4') sum += 4;
        else if (num=='5') sum += 5;
        else if (num=='6') sum += 6;
        else if (num=='7') sum += 3;
        else if (num=='8') sum += 7;
        else if (num=='9') sum += 6;
        return sum;
    }
}
