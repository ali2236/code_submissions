package codeforces;

import java.util.Scanner;

public class BoatsCompetition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-->0){
            int n = scanner.nextInt();
            int[] w = new int[51];
            int min = Integer.MAX_VALUE;
            int max1 = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                int num = scanner.nextInt();
                if(num<min) min = num;
                if(num > max1) {
                    max1 = num;
                }
                w[num]++;
            }
            
            int[] s = new int[101];
            for (int i = min; i <= Math.min(max1*2, 101); i++) {
                for (int j = i-1, k = 1; j >= k; j--,k++) {
                    if(j>50 || k>50) continue;
                    if(j!=k){
                        int a = w[j];
                        int b = w[k];
                        s[i] += Math.min(a,b);
                    } else {
                        s[i] += w[j]>1 ? w[j]/2 : 0;
                    }
                }
            }

            int max = s[0];
            for (int i = 1; i < s.length; i++) {
                if(s[i]>max) max = s[i];
            }

            System.out.println(max);
        }
    }
}
