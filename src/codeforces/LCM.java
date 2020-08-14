package codeforces;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

// Unsolved
//
// Link: https://codeforces.com/contest/1389/problem/A
public class LCM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();

            int x = -1, y = -1;
            if (2 * l <= r) {
                outer:
                for (int i = l; i < r; i++) {
                    for (int j = i + 1; j <= r; j++) {
                        int lcm = lcm(i, j);
                        if (lcm >= l && lcm <= r) {
                            x = i;
                            y = j;
                            break outer;
                        }
                    }
                }
            } else {
                x = l;
                y = 2 * l;
            }
            System.out.println(x + " " + y);
        }
    }

    static int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    final static Map<Pair, Integer> _lcm = new HashMap<>();

    static int lcm(int a, int b) {
        return _lcm.computeIfAbsent(new Pair(a, b), (p) -> (p.a * p.b) / gcd(p.a, p.b));
    }


}

class Pair {
    final Integer a, b;

    Pair(Integer a, Integer b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return Objects.equals(a, pair.a) &&
                Objects.equals(b, pair.b);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }
}