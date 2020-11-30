package codeforces.c1454;

import java.util.*;

public class UniqueBidAuction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-->0){
            int n = scanner.nextInt();
            Auction[] a = new Auction[n];
            for(int i=0;i<n;i++) a[i] = new Auction(scanner.nextInt(), i+1);
            Set<Auction> tree = new TreeSet<>();
            Set<Integer> deleted = new HashSet<>();
            for (int i = 0; i < n; i++) {
                Auction m = a[i];
                if(deleted.contains(m.value)) continue;
                if(tree.contains(m)){
                   tree.remove(m);
                   deleted.add(m.value);
                   continue;
                } else {
                    tree.add(m);
                }
            }
            if(tree.iterator().hasNext()){
                System.out.println(tree.iterator().next().index);
            } else {
                System.out.println(-1);
            }
        }
    }

    static final class Auction implements Comparable<Auction>{
        final int value, index;

        Auction(int value, int index) {
            this.value = value;
            this.index = index;
        }

        public int getValue() {
            return value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Auction auction = (Auction) o;
            return value == auction.value;
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }

        @Override
        public int compareTo(Auction o) {
            return Integer.compare(value, o.getValue());
        }
    }
}
