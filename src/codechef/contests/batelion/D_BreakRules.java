package codechef.contests.batelion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class D_BreakRules {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while(T-->0){
            String input = scanner.next();
            List<Integer> all = getAllAnswers(input);
            System.out.println(Collections.max(all));
        }
    }

    public static List<Integer> getAllAnswers(String s){
        List<Integer> answers = new ArrayList<Integer>();
        boolean hasOprator = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c=='|' || c=='^' || c=='&'){
                hasOprator = true;
                List<Integer> left = getAllAnswers(s.substring(0,i));
                List<Integer> right = getAllAnswers(s.substring(i+1));
                for (Integer l : left){
                    for (Integer r : right){
                        answers.add(eval(c,l,r));
                    }
                }
            }
        }
        if (!hasOprator){
            answers.add(Integer.parseInt(s));
        }
        return  answers;
    }

    public static Integer eval(char oprator, Integer left, Integer right){
        if (oprator=='^') return left^right;
        else if (oprator=='|') return left|right;
        else return left&right;
    }
}
