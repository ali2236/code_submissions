package quera;

// https://quera.ir/problemset/contest/3414/%D8%B3%D8%A4%D8%A7%D9%84-%D8%AF%D9%88-%D9%86%D9%82%D8%B7%D9%87-%D8%AE%D8%B7

import java.util.Scanner;

public class Q3414 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();
        String h = "Horizontal";
        String v = "Vertical";
        String t = "Try again";
        if(x1==x2) System.out.println(v);
        else if(y1==y2) System.out.println(h);
        else System.out.println(t);
    }
}
