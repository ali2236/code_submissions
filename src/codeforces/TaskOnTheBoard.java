package codeforces;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Unsolved
// url:  https://codeforces.com/contest/1367/problem/D
public class TaskOnTheBoard {
    public static void main(String[] args) {
        //System.out.println((int)'a');//97
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        while (q-->0){
            String s = scanner.next();
            int m = scanner.nextInt();
            int[] b = new int[m];
            for (int i = 0; i < m; i++) b[i] = scanner.nextInt();
            System.out.println(solve(s,b));
        }
    }

    private static String solve2(String s, int[] b){
        int[] k = new int[s.length()];
        for (int i = 0; i < k.length; i++) {
            for (int j = i + 1; j < k.length; j++) {
                if(s.charAt(j) > s.charAt(i)) k[i] += Math.abs(i-j);
            }
        }

        int index = 0;
        char[] t = new char[b.length];
        int j= 0;
        for (int i = 0; i < b.length; i++) {
            int bi = b[i];
            for (int l = j; l < k.length; l++) {
                if(k[l]==bi){
                    j = l;
                    break;
                }
            }
            t[index++] = s.charAt(j);
        }
        return String.valueOf(t);
    }

    private static String solve(String s, int[] b){
        int[] charCount = new int[25];
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - (int)'a';
            charCount[c]++;
        }

        int[] charCodes = new int[25];
        Map<Integer, Character> charFromCode = new HashMap<>();
        update(charCodes, charCount, charFromCode);

        char[] t = new char[b.length];
        for (int i = 0; i < b.length; i++) {
            int bi = b[i];
            Character c = charFromCode.get(bi);
            if(c==null){
                // some character must be deleted
                int j = 0;
                for (; j < 25; j++) {
                    if(charCodes[j]>bi) break;
                }
                int d = charCodes[j] - bi;
                for (int k = j+1; k < 25; k++) {
                    if(charCount[k]>0) {
                        int md = Math.min(charCount[k], d);
                        charCount[k] -= md;
                        d -= md;
                    }
                    if(d==0) break;
                }
                update(charCodes, charCount, charFromCode);
                c = (char)(j + 'a');
            }
            t[i] = c;

            // update values
            charCount[c - 'a']--;
            update(charCodes, charCount, charFromCode);
        }

        return String.valueOf(t);
    }

    private static void update(int[] charCodes, int[] charCount, Map<Integer,Character> charFromCode){
        for (int i = 0; i < 25; i++) {
            for (int j = i+1; j < 25; j++) {
                charCodes[i] += charCount[j];
            }
            if(charCount[i]>0) charFromCode.put(charCodes[i], (char) (i+'a'));
        }
    }
}
