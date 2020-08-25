package codeforces;

import java.util.Scanner;

public class AGoodString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            char[] str = scanner.next().toCharArray();
            System.out.println(minimumChanges(str, 0, n - 1, 'a'));
        }
    }

    private static int minimumChanges(char[] str, int l, int r, char c) {
        if (r - l == 0) return c == str[l] ? 0 : 1;

        int mid = (r + l) / 2;

        // first half
        int changesLeft = changeCount(str, mid + 1, r, c) + minimumChanges(str, l, mid, (char) (c + 1));

        // second half
        int changesRight = changeCount(str, l, mid, c) + minimumChanges(str, mid + 1, r, (char) (c + 1));

        return Math.min(changesLeft, changesRight);
    }

    private static int changeCount(char[] str, int from, int to, int c) {

        int count = 0;
        for (int i = from; i <= to; i++) {
            char ch = str[i];
            if (ch == c) count++;
        }
        return (to - from + 1) - count;
    }
}