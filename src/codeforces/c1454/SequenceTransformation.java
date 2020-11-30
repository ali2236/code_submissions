package codeforces.c1454;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SequenceTransformation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-->0){
            int n = scanner.nextInt();
            int[] a = new int[n];
            Map<Integer, Integer> count = new HashMap<>();
            for(int i=0;i<n;i++) {
                int m = scanner.nextInt();
                count.put(m, count.getOrDefault(m, 0) + 1);
                a[i] = m;
            }
            Map.Entry<Integer, Integer> entry = count.entrySet().stream().max(Comparator.comparingInt(Map.Entry::getValue)).get();
            int num = entry.getKey();
            int segments = 0;
            boolean ss = false;
            int last = num;
            for (int i = 0; i < n; i++) {
                last = a[i];
                if(last!=num && !ss){
                    segments++;
                    ss = true;
                } else if (last==num) {
                    ss = false;
                }
            }
            //if(last!=num) segments++;
            System.out.println(segments);
        }
    }
}
