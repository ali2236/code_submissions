package quera;

import java.util.Scanner;

public class Q10369 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int max = -1;
        int max_index = -1;
        for (int i = 0; i < n; i++) {
            int w = scanner.nextInt();
            if (w>max){
                max = w;
                max_index = i + 1;
            }
        }
            System.out.println(max_index);
    }
}
