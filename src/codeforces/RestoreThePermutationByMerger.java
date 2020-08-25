package codeforces;

import java.util.*;

public class RestoreThePermutationByMerger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-->0){
            int n = scanner.nextInt();
            int[] p = new int[2*n];
            for (int i = 0; i < 2*n; i++) {
                p[i] = scanner.nextInt();
            }

            Collection<Integer> answer = solve(p);
            for (Integer i : answer) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    private static Collection<Integer> solve(int[] p){
        Set<Integer> set = new TreeSet<>();
        List<Integer> list = new ArrayList<>();
        for (int i : p) {
            boolean changed = set.add(i);
            if(changed){
                list.add(i);
            }
        }
        return list;
    }
}
