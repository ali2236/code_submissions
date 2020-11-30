package codeforces.c1454;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SpecialPermutation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-->0){
            int n = scanner.nextInt();
            int[] a = IntStream.range(1,n+1).toArray();
            for (int i = 0; i < n-1; i+=2) {
                int temp = a[i+1];
                a[i+1] = a[i];
                a[i] = temp;
            }
            if(n%2!=0){
                int temp = a[n-1];
                a[n-1] = a[n/2];
                a[n/2] = temp;
            }
                System.out.println(Arrays.stream(a).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
        }
    }
}
