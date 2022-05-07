//package quera.icpc21;

import java.util.Scanner;

public class Petrol {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt() + 60;

        if(n<=k){
            System.out.println(n*1500);
        } else {
            int sum = k*1500;
            n = n - k;
            sum += n * 3000;
            System.out.println(sum);
        }
    }
}
