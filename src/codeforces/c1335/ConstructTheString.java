package codeforces.c1335;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class ConstructTheString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-->0){
            int n = scanner.nextInt();
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.println(buildString(n,a,b));
        }
    }

    private static String buildString(int n, int length, int distinct){
        char[] str = new char[n];
        Set<Character> inUse = new TreeSet<>();
        // chars = 1..26
        int l = 0;
        int r = 0;
        char c = 'a';
        while (r<n){
            str[r] = c;
            inUse.add(c);
            if(inUse.size()<distinct){
                c++;
            }
            r++;
            if(r-l>=length){
                char last = str[l];
                l++;
                int count = 0;
                for (int i = l; i < r; i++) {
                    if(str[i]==last){
                        count++;
                    }
                }
                if(count==0){
                    inUse.remove(last);
                    if(inUse.size()<distinct){
                        c = last;
                    }
                }
            }
        }
        return String.valueOf(str);
    }
}
