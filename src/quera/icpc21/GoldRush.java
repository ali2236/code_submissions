package quera.icpc21;

import java.util.Scanner;

public class GoldRush {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int c = scanner.nextInt();
        int n = scanner.nextInt();
        int[] price = new int[n];
        for(int i=0;i<n;i++) price[i] = scanner.nextInt();
        int gold = 0;
        for (int i = 0; i < n - 1; i++) {
            if(price[i+1] > price[i]){
                // buy
                gold += c / price[i];
                c = c % price[i];
            } else if(price[i+1] < price[i]){
                // sell
                c += gold * price[i];
                gold = 0;
            }
        }
        try {
            c += gold * price[n - 1];
        } catch (Exception e){}
        System.out.println(c);
    }
}
