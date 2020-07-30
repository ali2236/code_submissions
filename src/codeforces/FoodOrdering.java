package codeforces;

import java.util.Scanner;
public class FoodOrdering {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.next());
        while (t-->0){
            int n = Integer.parseInt(scanner.next());
            int res = 0;
            while (n>9){
                res += (n/10) * 10;
                n = (n%10) + (n/10);
            }
            System.out.println(res+n);
        }
    }
}
