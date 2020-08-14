package codeforces;

import java.util.*;

/*
 *  Link: https://codeforces.com/contest/1393/problem/B
 */
public class Applejack {

    final static Scanner scanner = new Scanner(System.in);
    final static Map<Integer, Integer> p = new HashMap<>();
    final static Set<Integer> set = new TreeSet<>();
    static int n;
    final static Set<Integer> fours = new TreeSet<>();
    final static Set<Integer> twos = new TreeSet<>();

    public static void main(String[] args) {

        // input
        n = scanner.nextInt();
        for (int i = 0; i < n; i++) add(scanner.nextInt());
        int q = scanner.nextInt();

        scanner.nextLine();
        // Process events
        while (q-- > 0) {
            processEvent();
            if (n < 8 || fours.isEmpty()) {
                System.out.println("NO");
            } else if (fours.size() > 1) {
                System.out.println("YES");
            } else if (twos.size() > 1) {
                System.out.println("YES");
            } else {
                int left = 0;
                for (Integer four : fours) {
                    int c = p.get(four) - 4;
                    if(c > left){
                        left = c;
                    }
                }
                if (left >= 4 || (left >= 2 && !twos.isEmpty())) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    public static void processEvent() {
        String[] event = scanner.nextLine().split(" ");
        int plank = Integer.parseInt(event[1]);
        if (event[0].equals("+")) {
            n++;
            add(plank);
        } else {
            n--;
            remove(plank);
        }
    }

    public static void add(int plank) {
        p.putIfAbsent(plank, 0);
        int count = p.get(plank) + 1;
        p.put(plank, count);
        set.add(plank);
        if(count==2){
          twos.add(plank);
        } else if(count==4){
            twos.remove(plank);
            fours.add(plank);
        }
    }

    public static void remove(int plank) {
        int count = p.get(plank) - 1;
        p.put(plank, count);
        if (count == 0) set.remove(plank);
         else if(count==1){
             twos.remove(plank);
        } else if (count==3){
             fours.remove(plank);
             twos.add(plank);
        }
    }
}