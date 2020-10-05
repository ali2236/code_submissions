package icpc.c98_online;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String maxName = scanner.next();
        int maxAmount = scanner.nextInt();
        n--;
        while (n-->0){
            String name = scanner.next();
            int amount = scanner.nextInt();
            if(amount > maxAmount){
                maxAmount = amount;
                maxName = name;
            }
        }
        System.out.println(maxName);
    }
}
