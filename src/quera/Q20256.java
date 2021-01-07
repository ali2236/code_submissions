package quera;

import java.util.Scanner;

public class Q20256 {

    final static String khatar = "nakhor lite";
    final static String noKhatar = "rahat baash";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int g = 0, y = 0, r = 0;
        for (char c : s.toCharArray()){
            if(c=='G') g++;
            else if(c=='Y')y++;
            else r++;
        }
        boolean danger = false;
        if(r>=3) danger = true;
        if(r>=2 && y>= 2) danger = true;
        if(g==0) danger = true;
        System.out.println(danger ? khatar : noKhatar);
    }
}
