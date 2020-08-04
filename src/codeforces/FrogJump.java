package codeforces;

import java.util.Scanner;

public class FrogJump {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-->0){
            String s = scanner.next();
            int n = s.length();
            int index = s.indexOf("R");
            int max = index + 1;
            while (true){
                int next = s.indexOf("R", index+1);
                if(next==-1) break;
                max = Math.max(max, next-index);
                index = next;
            }
            max = Math.max(max, n-index);
            System.out.println(max==0?n+1:max);
        }
    }
}
