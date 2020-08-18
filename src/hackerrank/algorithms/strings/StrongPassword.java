package hackerrank.algorithms.strings;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class StrongPassword {

    // Complete the minimumNumber function below.
    static int minimumNumber(int n, String password) {
        boolean lowerCaseLetter = false;
        boolean upperCaseLetter = false;
        boolean digit = false;
        boolean spacial = false;
        char[] numbers = "0123456789".toCharArray();
        char[] lower_case = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] upper_case = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        char[] special_characters = "!@#$%^&*()-+".toCharArray();
        for (char c: password.toCharArray()){
            if(!digit){
                digit = contains(numbers,c);
                if(digit) continue;
            }
            if(!lowerCaseLetter){
                lowerCaseLetter = contains(lower_case, c);
                if(lowerCaseLetter) continue;
            }
            if(!upperCaseLetter){
                upperCaseLetter = contains(upper_case, c);
                if(upperCaseLetter) continue;
            }
            if(!spacial){
                spacial = contains(special_characters, c);
                if(spacial) continue;
            }
        }
        int needed = 0;
        if(!lowerCaseLetter) needed++;
        if(!upperCaseLetter) needed++;
        if(!digit) needed++;
        if(!spacial) needed++;
        needed = Math.max(6 - password.length(), needed);
        return needed;
    }

    private static boolean contains(char[] array, char c){
        for (char ch : array){
            if(ch==c) return true;
        }
        return false;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String password = scanner.nextLine();

        int answer = minimumNumber(n, password);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

