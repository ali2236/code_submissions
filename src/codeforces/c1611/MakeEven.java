package codeforces.c1611;

import java.util.Scanner;

public class MakeEven {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-->0){
            String n = scanner.next();
            int last = Integer.parseInt(String.valueOf(n.charAt(n.length()-1)));
            int first = Integer.parseInt(String.valueOf(n.charAt(0)));
            String middle = n.length() > 2 ? n.substring(1, n.length()-1) : "";

            if(last % 2 == 0){
                System.out.println(0);
            } else if(first % 2 == 0){
                System.out.println(1);
            } else if (middle.matches("[2468]+")){
                System.out.println(2);
            } else {
                System.out.println(-1);
            }
        }
    }
}
