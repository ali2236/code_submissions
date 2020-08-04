import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'passwordCracker' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING_ARRAY passwords
     *  2. STRING loginAttempt
     */

    public static String passwordCracker(List<String> passwords, String loginAttempt) {
        List<String> result = findCombination(loginAttempt, new LinkedList<String>(), passwords);
        if (result != null) {
            return concatList(result," ");
        }
        return "WRONG PASSWORD";
    }

    public static List<String> findCombination(String target, List<String> start, List<String> passwords){
        String startString = concatList(start,"");
        int l = startString.length();
        for (String password: passwords){
            boolean match = target.indexOf(password, l-1) == l;
            if(match){
                List<String> nextStart = new ArrayList<>(start);
                nextStart.add(password);
                if(concatList(nextStart,"").equals(target)){
                    return nextStart;
                } else {
                    return findCombination(target, nextStart, passwords);
                }
            }
        }
        return null;
    }

    public static String concatList(List<String> list, String seperator){
        if(list==null) return "";
        StringBuilder builder = new StringBuilder();
        int n = list.size();
        for (int i = 0; i < n; i++) {
            String s = list.get(i);
            builder.append(s);
            if(i!=n-1) builder.append(seperator);
        }
        return builder.toString();
    }

}

public class PasswordCracker {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<String> passwords = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .collect(toList());

                String loginAttempt = bufferedReader.readLine();

                String result = Result.passwordCracker(passwords, loginAttempt);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
