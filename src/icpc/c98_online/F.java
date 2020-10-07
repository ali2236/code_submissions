package icpc.c98_online;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

import static java.util.Map.Entry;

public class F {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Entry<Integer,Integer>[] a = new Entry[n];
        for(int i=0;i<n;i++) {
            a[i] = new AbstractMap.SimpleEntry<>(scanner.nextInt(), i);
        }
        Arrays.sort(a, Comparator.comparingInt(Entry::getKey));
        int max = 0;
        for (int i = 0; i < n; i++) {
            int d = Math.abs(a[i].getValue() - i);
            if(d>0) d++;
            max = Math.max(d, max);
        }

        System.out.println(n - max);
    }
}
