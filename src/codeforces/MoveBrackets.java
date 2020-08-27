package codeforces;

import java.util.Scanner;
import java.util.Stack;

public class MoveBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-->0){
            int n = scanner.nextInt();
            char[] brackets = scanner.next().toCharArray();
            System.out.println(minFix(brackets));
        }
    }

    private static int minFix(char[] brackets){
        Stack<Character> stk = new Stack<>();
        for (char c: brackets){
            if(stk.isEmpty()){
                stk.push(c);
            } else {
                if(stk.peek()=='(' && c == ')'){
                    stk.pop();
                } else {
                    stk.push(c);
                }
            }
        }
        return stk.size()/2;
    }
}
