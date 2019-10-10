package beginner;

import java.util.Scanner;

public class CoderLifeMatters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while(T-->0){
            int workDays = 0;
            boolean fun = true;
            for (int i = 1; i <= 30; i++) {
                boolean worked = scanner.nextInt() == 1;
                if (worked) workDays++;
                else workDays = 0;
                if (workDays>5){
                    fun = false;
                    scanner.nextLine();
                    break;
                }
            }
            System.out.println(fun?"#allcodersarefun":"#coderlifematters");
        }
    }
}
