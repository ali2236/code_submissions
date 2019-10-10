package easy;

import java.util.Scanner;

public class LifeUniverseEverything {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true){
            int number = scanner.nextInt();
            if (number==42) break;
            System.out.println(number);
        }
    }
}
