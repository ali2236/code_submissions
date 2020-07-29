import java.util.Scanner;
import java.util.Stack;

class Solution1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String input = sc.next().trim();
            //Complete the code
            if (input.equals("")) {
                System.out.println(true);
            } else {
                Stack<Character> stack = new Stack<>();
                for (int j = 0; j < input.length(); j++) {
                    if (!stack.isEmpty() && stack.peek().equals(complement(input.charAt(j)))) {
                            stack.pop();
                    } else {
                        stack.push(input.charAt(j));
                    }
                }
                System.out.println(stack.isEmpty());
            }
        }
    }

    static Character complement(Character c) {
        if (c.equals(')')) return '(';
        if (c.equals(']')) return '[';
        if (c.equals('}')) return '{';
        else return c;
    }
}



