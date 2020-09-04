package codeforces.c1409;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class YetAnotherArrayRestoration {

    public static void main(String[] args) {
        Scanner fr = new Scanner(System.in);
        int t = fr.nextInt();
        while (t-- > 0) {
            int n = fr.nextInt();
            int x = fr.nextInt();
            int y = fr.nextInt();
            solve(n, x, y);
        }
    }

    private static void solve(int n, int x, int y) {
        int maxd = y - x, d;
        Integer[] numbers = new Integer[n];
        numbers[n-1] = Integer.MAX_VALUE;
        for (int i = 1; i <= Math.min(maxd, n - 1); i++) {
            if (maxd%i!=0) continue;
            d = maxd/i;
           Integer[] nums = findRestoration(n,x,y,d);
           if(nums[n-1]<numbers[n-1]) numbers = nums;
        }
        printArray(numbers);
    }

    static Integer[] findRestoration(int n, int x, int y, int d) {
        Set<Integer> numbers = new TreeSet<>();
        for (int i = x; i <= y; i += d) numbers.add(i);
        for (int i = x; i > 0 && (n != numbers.size()); i -= d) numbers.add(i);
        for (int i = y;n != numbers.size(); i += d) numbers.add(i);
        return toArray(numbers, n);
    }

    static void printArray(Integer[] arr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer num : arr) stringBuilder.append(num).append(' ');
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        System.out.println(stringBuilder.toString());
    }

    static Integer[] toArray(Set<Integer> set, int n){
        Integer[] arr = new Integer[n];
        set.toArray(arr);
        return arr;
    }
}