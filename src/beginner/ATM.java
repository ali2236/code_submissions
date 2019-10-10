package beginner;

import java.util.Scanner;

// HS08TEST
public class ATM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W = scanner.nextInt();
        double I = scanner.nextDouble();
        if (W%5==0 && (W+0.50) <= I){
            I = (I - W) - 0.50;
        }
        System.out.printf("%.2f",I);
    }
}
