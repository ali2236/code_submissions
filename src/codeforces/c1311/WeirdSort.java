package codeforces.c1311;

import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class WeirdSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-->0){
            int n = scanner.nextInt(), m = scanner.nextInt();
            int[] a = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
            Set<Integer> p = IntStream.range(0, m).map(i -> scanner.nextInt()).boxed().collect(Collectors.toSet());
            System.out.println(canSort(a, p) ? "YES" : "NO");
        }
    }

    private static boolean canSort(int[] a, Set<Integer> p){
        for (int i = 0; i < a.length - 1; i++) {
            if(a[i] > a[i+1]){
                if(p.contains(i+1)){
                    int temp = a[i];
                    a[i] = a[i+1];
                    a[i+1] = temp;
                } else {
                    return false;
                }
            }
        }
        for (int i = a.length-1; i > 0 ; i--) {
            if(a[i] < a[i-1]){
                if(p.contains(i)){
                    int temp = a[i];
                    a[i] = a[i-1];
                    a[i-1] = temp;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
