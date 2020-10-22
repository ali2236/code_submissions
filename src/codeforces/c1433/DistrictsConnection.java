package codeforces.c1433;

import java.util.Arrays;
import java.util.Scanner;

public class DistrictsConnection {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-->0){
            int n = scanner.nextInt();
            District[] a = new District[n];
            for(int i=0;i<n;i++) {
                int gang = scanner.nextInt();
                a[i] = new District(gang, i+1);
            }
            calculateConnections(a, n);
        }
    }

    private static void calculateConnections(District[] a, final int n){
        Arrays.sort(a);

        District r1 = a[0];
        District r2 = a[n-1];
        if(r1.gang == r2.gang){
            System.out.println("NO");
        } else {
            int ri = 0;
            Pair[] roads = new Pair[n-1];
            roads[ri++] = new Pair(r1.index, r2.index);

            for (int i = 1; i < n-1; i++) {
                District d = a[i];
                if(d.gang != r1.gang){
                    roads[ri++] = new Pair(r1.index, d.index);
                } else{
                    roads[ri++] = new Pair(r2.index, d.index);
                }
            }

            System.out.println("YES");
            for (int i = 0; i < ri; i++) {
                System.out.println(roads[i]);
            }
        }
    }

    static final class Pair {
        final int first, second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public String toString() {
            return first + " " + second;
        }
    }

    static final class District implements Comparable<District>{
        public final int gang, index;

        District(int gang, int index) {
            this.gang = gang;
            this.index = index;
        }

        @Override
        public int compareTo(District o) {
            return Integer.compare(gang, o.gang);
        }

    }
}
