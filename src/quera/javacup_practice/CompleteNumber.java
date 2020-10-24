package quera.javacup_practice;

public class CompleteNumber {
    public static void main(String[] args) {
        for (int i = 1; i <= 10_000; i++) {
            if(complete(i)){
                System.out.println(i);
            }
        }
    }

    private static boolean complete(int n){
        int sum = 0;
        for (int i = 1; i <= n/2; i++) {
            if(n%i==0){
                sum += i;
            }
        }
        return sum == n;
    }
}
