package quera.javacup_pre_7;

import java.util.Scanner;

public class keyboard {
    static boolean capslock = false, shiftDown = false;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder str = new StringBuilder();
        String[] words = scanner.nextLine().split(" ");
        for (String w : words) {
            if (w.equals("CAPSLOCK")) {
                capslock = !capslock;
                continue;
            } else if (w.equals("shift_down") || w.equals("shift_up")) {
                shiftDown = !shiftDown;
                continue;
            } else {
                char c = w.charAt(0);
                if (isChar(c)) {
                    str.append(character(w));
                } else if (isNumber(c)) {
                    str.append(number(w));
                } else {
                    str.append(misc(w));
                }
            }
            str.append(' ');
        }
        System.out.println(str);
    }

    private static boolean isChar(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    private static boolean isNumber(char c) {
        return (c >= '0' && c <= '9');
    }

    private static String character(String w) {
        return ((capslock && !shiftDown) || (!capslock && shiftDown)) ? w.toUpperCase() : w.toLowerCase();
    }

    private static String number(String w) {
        if (w.equals("1")) return shiftDown ? "!" : w;
        if (w.equals("2")) return shiftDown ? "@" : w;
        if (w.equals("3")) return shiftDown ? "#" : w;
        if (w.equals("4")) return shiftDown ? "$" : w;
        if (w.equals("5")) return shiftDown ? "%" : w;
        if (w.equals("6")) return shiftDown ? "^" : w;
        if (w.equals("7")) return shiftDown ? "&" : w;
        if (w.equals("8")) return shiftDown ? "*" : w;
        if (w.equals("9")) return shiftDown ? "(" : w;
        if (w.equals("0")) return shiftDown ? ")" : w;
        return w;
    }

    private static String misc(String w) {
        if (w.equals(",")) return shiftDown ? "<" : w;
        if (w.equals(".")) return shiftDown ? ">" : w;
        if (w.equals("/")) return shiftDown ? "?" : w;
        if (w.equals(";")) return shiftDown ? ":" : w;
        if (w.equals("'")) return shiftDown ? "\"" : w;
        if (w.equals("\\")) return shiftDown ? "|" : w;
        return w;
    }
}
