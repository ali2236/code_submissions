package icpc.c98_online;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String str = scanner.next();
        Deque<Character> stk = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            Character c = str.charAt(i);
            if (stk.isEmpty()) {
                stk.push(c);
            } else if (stk.peek().equals(c)) {
                stk.pop();
            } else {
                stk.push(c);
            }
        }
        while (!stk.isEmpty()){
            System.out.print(stk.removeLast());
        }
    }
}
