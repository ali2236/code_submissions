package codechef.contests.batelion;

import java.util.Scanner;

public class C_ChefMaths {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while(T-->0){
            int input = scanner.nextInt();
            System.out.println(f(input));
        }
    }

    public static int f(int n){
        int num = (n % 1000000007);
        int sum = num;
        for (int i = 2; i <= n ; i++) {
            int _num = (int)(Math.pow(n-i+1,i)% 1000000007);
            sum *= _num;
        }
        return sum;
    }
}
