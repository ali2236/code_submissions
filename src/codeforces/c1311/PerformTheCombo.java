package codeforces.c1311;

import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PerformTheCombo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-->0){
            int n = scanner.nextInt(), m = scanner.nextInt();
            String s = scanner.next();
            int[] p = IntStream.range(0, m).map(i -> scanner.nextInt()).toArray();
            count(s, p);
        }
    }

    private static void count(String s, int[] p){
        int[] l = new int[26];
        int[] c = new int[s.length()];
        for (int i : p) c[i-1]++;
        for (int i = c.length-1, counter = 1; i >= 0 ; i--) {
            counter += c[i];
            l[(int) s.charAt(i) - 'a'] += counter;
        }
        System.out.println(IntStream.of(l).mapToObj(Integer::toString).collect(Collectors.joining(" ")));
        System.out.flush();
    }
}
