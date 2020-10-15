package codeforces.c1328;

import java.util.Scanner;

public class TernaryXOR {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-->0){
            int n = scanner.nextInt();
            String x = scanner.next();

            StringBuilder str1 = new StringBuilder();
            StringBuilder str2 = new StringBuilder();

            boolean s1ib = false;
            for (int i = 0; i < x.length(); i++) {
                char c = x.charAt(i);
                if(c=='2'){
                    if(s1ib){
                        str1.append('0');
                        str2.append('2');
                    } else {
                        str1.append('1');
                        str2.append('1');
                    }
                } else if(c == '1'){
                    if(s1ib){
                        str1.append('0');
                        str2.append('1');
                    } else {
                        str1.append('1');
                        str2.append('0');
                        s1ib = true;
                    }
                } else {
                    str1.append('0');
                    str2.append('0');
                }
            }

            System.out.println(str1.toString());
            System.out.println(str2.toString());
        }
    }
}
